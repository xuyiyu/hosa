package com.mexp.web.schedule;

import java.text.ParseException;
import java.util.Date;
import java.util.Map;

import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.quartz.impl.triggers.SimpleTriggerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class QuartzManager {
	
	@Autowired
	@Qualifier("quartzScheduler")
	private Scheduler quartzScheduler;
	
	
	public static String DEFAULT_JOB_GROUP_NAME = "JOB_GROUP_NAME";
	public static String DEFAULT_TRIGGER_GROUP_NAME = "TRIGGER_GROUP_NAME";

	public void addSimpleJob(String jobName, String executeClass, Date startTime, Map<String, Object> dataMap) throws SchedulerException{
		Class<? extends Job> clazz = StatelessJob.class;
		
		addSimpleJob(jobName, executeClass, DEFAULT_JOB_GROUP_NAME, jobName, DEFAULT_TRIGGER_GROUP_NAME, clazz, startTime, null, 0, 1L, dataMap);
	}
	
	public void addSimpleJob(String jobName, String executeClass, Date startTime, Map<String, Object> dataMap, Boolean isStateful) throws SchedulerException {
		Class<? extends Job> clazz = StatelessJob.class;
		if(isStateful) {
			clazz = StatefulJob.class;
		} 
		addSimpleJob(jobName, executeClass, DEFAULT_JOB_GROUP_NAME, jobName, DEFAULT_TRIGGER_GROUP_NAME, clazz, startTime, null, 0, 1L, dataMap);
	}
	
	public void addSimpleJob(String jobName, String executeClass, Class<? extends Job> jobClass, Date startTime, Date endTime, Integer repeatCount, Long repeatInterval, Map<String, Object> dataMap) throws SchedulerException {
		addSimpleJob(jobName, executeClass, DEFAULT_JOB_GROUP_NAME, jobName, DEFAULT_TRIGGER_GROUP_NAME, jobClass, startTime, null, 0, 1L, dataMap);
	}
	
	/**
	 * 添加一般任务
	 * @param jobName					任务名称
	 * @param executeClass				任务执行业务类
	 * @param jobGroupName				任务组名称
	 * @param triggerName				触发器名称
	 * @param triggerGroupName			触发器组名称
	 * @param jobClass					任务执行类
	 * @param startTime					任务开始时间
	 * @param endTime					任务结束时间， 如果不为空重复次数失效
	 * @param repeatCount				重复次数
	 * @param repeatInterval			重复间隔
	 * @param dataMap					任务数据
	 * @throws SchedulerException
	 */
	public void addSimpleJob(String jobName, String executeClass, String jobGroupName, String triggerName,
            String triggerGroupName, Class<? extends Job> jobClass, Date startTime, Date endTime, Integer repeatCount, Long repeatInterval, Map<String, Object> dataMap) throws SchedulerException {
		JobDetailImpl jobDetail = new JobDetailImpl();
		jobDetail.setName(jobName);
		jobDetail.setGroup(jobGroupName);
		jobDetail.setJobClass(jobClass);
		JobDataMap jobDataMap = new JobDataMap();
		if(dataMap != null) {
			jobDataMap.putAll(dataMap);
		}
		jobDataMap.put("_executeClass", executeClass);
		jobDetail.setJobDataMap(jobDataMap);
		
		SimpleTriggerImpl simpleTrigger = new SimpleTriggerImpl();
		simpleTrigger.setName(triggerName);
		simpleTrigger.setGroup(triggerGroupName);
		simpleTrigger.setStartTime(startTime);
		simpleTrigger.setRepeatCount(repeatCount);
		simpleTrigger.setRepeatInterval(repeatInterval);
		
		if(endTime != null) {
			simpleTrigger.setEndTime(endTime);
		}
		
		quartzScheduler.scheduleJob(jobDetail, simpleTrigger);
	}
	
	public void updateSimpleJobTime(String jobName, Date startTime) throws SchedulerException  {
		updateSimpleJobTime(jobName, startTime, null, null, null);
	}
	
	public void updateSimpleJobTime(String jobName, Date startTime, Date endTime, Integer repeatCount, Long repeatInterval) throws SchedulerException {
		updateSimpleJobTime(jobName, DEFAULT_TRIGGER_GROUP_NAME, startTime, endTime, repeatCount, repeatInterval);
	}
	
	/**
	 * 修改一般任务
	 * @param triggerName			触发器名称
	 * @param triggerGroupName		触发器组名称
	 * @param startTime				开始时间
	 * @param endTime				结束时间， 如果不为空重复次数失效
	 * @param repeatCount			重复次数
	 * @param repeatInterval		重复间隔
	 * @throws SchedulerException	
	 */
	public void updateSimpleJobTime(String triggerName, String triggerGroupName, Date startTime, Date endTime, Integer repeatCount, Long repeatInterval) throws SchedulerException{
		Trigger trigger =  quartzScheduler.getTrigger(new TriggerKey(triggerName, triggerGroupName));
	    if(trigger != null){
//	    	   quartzScheduler.pauseTrigger(triggerName, triggerGroupName);
	    	   SimpleTriggerImpl  t = (SimpleTriggerImpl)trigger;
	           //修改时间
	           t.setStartTime(startTime);
	           if(endTime != null) {
	        	   t.setEndTime(endTime);
	           }
	           if(repeatCount != null) {
	        	   t.setRepeatCount(repeatCount);
	           }
	           if(repeatInterval != null) {
	        	   if(repeatInterval < 1) {
	        		   repeatInterval = 1L;
	        	   }
	        	   t.setRepeatInterval(repeatInterval);
	           }
	           quartzScheduler.rescheduleJob(new TriggerKey(triggerName, triggerGroupName), t);
	           //重启触发器
//	           quartzScheduler.resumeTrigger(triggerName,triggerGroupName);
	       }
	}

	
	
	public void addCronleJob(String jobName, String executeClass, String timeExpression, Map<String, Object> dataMap) throws SchedulerException, ParseException{
		Class<? extends Job> clazz = StatelessJob.class;
		
		addCronleJob(jobName, executeClass, DEFAULT_JOB_GROUP_NAME, jobName, DEFAULT_TRIGGER_GROUP_NAME, clazz, timeExpression, dataMap);
	}
	
	public void addCronleJob(String jobName, String executeClass, String timeExpression, Map<String, Object> dataMap, Boolean isStateful) throws SchedulerException, ParseException {
		Class<? extends Job> clazz = StatelessJob.class;
		if(isStateful) {
			clazz = StatefulJob.class;
		} 
		addCronleJob(jobName, executeClass, DEFAULT_JOB_GROUP_NAME, jobName, DEFAULT_TRIGGER_GROUP_NAME, clazz, timeExpression, dataMap);
	}
	
	public void addCronleJob(String jobName, String executeClass, Class<? extends Job> jobClass, String timeExpression, Map<String, Object> dataMap) throws SchedulerException, ParseException{
		addCronleJob(jobName, executeClass, DEFAULT_JOB_GROUP_NAME, jobName, DEFAULT_TRIGGER_GROUP_NAME, jobClass, timeExpression, dataMap);
	}
	
	/**
	 * 添加表达式任务
	 * @param jobName					任务名称
	 * @param executeClass				任务执行业务类
	 * @param jobGroupName				任务组名称
	 * @param triggerName				触发器名称
	 * @param triggerGroupName			触发器组名称
	 * @param jobClass					任务执行类
	 * @param timeExpression			时间表达式
	 * @param dataMap					任务数据
	 * @throws SchedulerException
	 * @throws ParseException
	 */
	public void addCronleJob(String jobName, String executeClass, String jobGroupName, String triggerName,
            String triggerGroupName, Class<? extends Job> jobClass, String timeExpression, Map<String, Object> dataMap) throws SchedulerException, ParseException {
		JobDetailImpl jobDetail = new JobDetailImpl();
		jobDetail.setName(jobName);
		jobDetail.setGroup(jobGroupName);
		jobDetail.setJobClass(jobClass);
		JobDataMap jobDataMap = new JobDataMap();
		if(dataMap != null) {
			jobDataMap.putAll(dataMap);
		}
		jobDataMap.put("_executeClass", executeClass);
		jobDetail.setJobDataMap(jobDataMap);
		
		CronTriggerImpl cronTrigger = new CronTriggerImpl();
		cronTrigger.setName(triggerName);
		cronTrigger.setGroup(triggerGroupName);
		cronTrigger.setCronExpression(timeExpression);
	
		quartzScheduler.scheduleJob(jobDetail, cronTrigger);
	}
	
	public void updateCronJobTime(String jobName, String timeExpression) throws SchedulerException, ParseException {
		updateCronJobTime(jobName, DEFAULT_TRIGGER_GROUP_NAME, timeExpression);
	}
	
	/**
	 * 修改表达式任务
	 * @param triggerName			触发器名称
	 * @param triggerGroupName		触发器组名称
	 * @param timeExpression		时间表达式
	 * @throws SchedulerException
	 * @throws ParseException
	 */
	public void updateCronJobTime(String triggerName, String triggerGroupName, String timeExpression) throws SchedulerException, ParseException {
		Trigger trigger =  quartzScheduler.getTrigger(new TriggerKey(triggerName, triggerGroupName));
		
	       if(trigger != null){
	    	   CronTriggerImpl  t = (CronTriggerImpl)trigger;
	           //修改时间
	           t.setCronExpression(timeExpression);
//	           t.setNextFireTime(new Date(1387355400000L));
	           quartzScheduler.rescheduleJob(new TriggerKey(triggerName, triggerGroupName), t);
	           //重启触发器
//	           quartzScheduler.resumeTrigger(triggerName,triggerGroupName);
	       }
	}
	
	
	public Boolean isExistJob(String jobName ,String jobGroupName) throws SchedulerException, ParseException{
		JobDetail jobDetail = quartzScheduler.getJobDetail(new JobKey(jobName, jobGroupName));
		
		if(jobDetail!=null){
			return true;
		}else{
			return false;
		}
		
	}
	
	
	public void removeJob(String jobName) throws SchedulerException {
		removeJob(jobName, DEFAULT_JOB_GROUP_NAME, jobName, DEFAULT_TRIGGER_GROUP_NAME);
	}
	
	public void removeJob(String jobName,String jobGroupName) throws SchedulerException{
		removeJob(jobName, jobGroupName, jobName, DEFAULT_TRIGGER_GROUP_NAME);
	}
	
	
	/**
	 * 删除任务
	 * @param jobName				任务名称
	 * @param jobGroupName			任务组名称
	 * @param triggerName			触发器名称
	 * @param triggerGroupName		触发器组名称
	 * @throws SchedulerException
	 */
	public void removeJob(String jobName, String jobGroupName, String triggerName, String triggerGroupName) throws SchedulerException{
		quartzScheduler.pauseTrigger(new TriggerKey(triggerName, triggerGroupName));//停止触发器
		quartzScheduler.unscheduleJob(new TriggerKey(triggerName, triggerGroupName));//移除触发器
		quartzScheduler.deleteJob(new JobKey(jobName, jobGroupName));//删除任务
	}

	public Scheduler getQuartzScheduler() {
		return quartzScheduler;
	}

	public void setQuartzScheduler(Scheduler quartzScheduler) {
		this.quartzScheduler = quartzScheduler;
	}

	public void addCronJob(String jobName, String executeClass, String jobGroupName,
			String triggerName, String triggerGroupName, Class jobClass,
			Date startTime, String cronExpression, JobDataMap dataMap) {
		try {
			JobDetailImpl jobDetail = new JobDetailImpl();
			jobDetail.setName(jobName);
			jobDetail.setGroup(jobGroupName);
			jobDetail.setJobClass(jobClass);
			JobDataMap jobDataMap = new JobDataMap();
			if(dataMap != null) {
				jobDataMap.putAll(dataMap);
			}
			jobDataMap.put("_executeClass", executeClass);
			jobDetail.setJobDataMap(jobDataMap);
			CronTriggerImpl cronTrigger = new CronTriggerImpl(triggerName,triggerGroupName, cronExpression);
			cronTrigger.setStartTime(startTime);
			
			quartzScheduler.scheduleJob(jobDetail, cronTrigger);
		}catch(Exception e){
			e.printStackTrace();
		};
		
	}

	
	/**
	 * 删除原有的trigger，在重新添加
	 * @param triggerName
	 * @param triggerGroupName
	 * @param jobName
	 * @param jobGroupName
	 * @param startTime
	 * @param endTime
	 * @param repeatCount
	 * @param repeatInterval
	 * @throws SchedulerException
	 */
	public void schedulerNewTrigger(String triggerName,String triggerGroupName,String jobName,String jobGroupName,Date startTime,Date endTime,int repeatCount,long repeatInterval) throws SchedulerException {
		Trigger trigger =  new SimpleTriggerImpl(triggerName, triggerGroupName, jobName, jobGroupName, startTime, endTime, repeatCount, repeatInterval);
		quartzScheduler.rescheduleJob(new TriggerKey(triggerName, triggerGroupName), trigger);
		
		
	}
	
	public void pauseTrigger(String triggerName,String triggerGroupName) throws SchedulerException{
		quartzScheduler.pauseTrigger(new TriggerKey(triggerName, triggerGroupName));
	}
	public void resumeTrigger(String triggerName,String triggerGroupName) throws SchedulerException{
		quartzScheduler.resumeTrigger(new TriggerKey(triggerName, triggerGroupName));
	}
	
	
	public void schedulerNewTrigger(String triggerName,String triggerGroupName,String jobName,String jobGroupName,Date startTime) throws SchedulerException{
		schedulerNewTrigger(triggerName, triggerGroupName, jobName, jobGroupName, startTime, null, 50, 10000L);
	}

}
