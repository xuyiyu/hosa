package com.hosa.web.schedule;

import java.util.Map;

public interface ScheduleJob {

	public void execute(Map<String, Object> dataMap) throws Exception;
}
