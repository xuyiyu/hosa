package com.mexp.web.schedule;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class StatelessJob implements Job {

private static final Logger log = LoggerFactory.getLogger(StatelessJob.class);
	
	private ConfigurableApplicationContext ctx;
	
	@SuppressWarnings("unchecked")
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		try {
			ctx = (XmlWebApplicationContext) context.getScheduler().getContext().get("applicationContextKey");
			if(ctx != null) {
				JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
				String executeClass = jobDataMap.getString("_executeClass");
				if(executeClass == null && "".equals(executeClass)) {
					log.error("not found job execute class");
					return;
				}
				
				ScheduleJob job = (ScheduleJob) ctx.getBean(executeClass);
//				Map<String, ?> dataMap = new HashMap<String, Object>();
//				dataMap.putAll(jobDataMap);
				job.execute(jobDataMap);
			}
		} catch (SchedulerException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
