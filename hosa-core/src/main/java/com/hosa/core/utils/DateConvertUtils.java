package com.hosa.core.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.util.Assert;
/**
 * 日期转换类
 */
public class DateConvertUtils  extends DateUtils{
	
	public static final String DATE_TIME_FORMAT_STRING = "yyyy-MM-dd HH:mm:ss";
	private static final DateFormat[] ACCEPT_DATE_FORMATS = {  
        new SimpleDateFormat("dd/MM/yyyy"),  
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), 
        new SimpleDateFormat("yyyy-MM-dd HH:mm"), 
        new SimpleDateFormat("yyyy-MM-dd"),
        new SimpleDateFormat("yyyy/MM/dd") }; //支持转换的日期格式   
	  
	public static Date getCurrentDateTime() {
		java.util.Calendar calNow = java.util.Calendar.getInstance();
		java.util.Date dtNow = calNow.getTime();
		return dtNow;
	}
	
	public static java.util.Date parse(String dateString,String dateFormat) {
		return parse(dateString, dateFormat,java.util.Date.class);
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends java.util.Date> T parse(String dateString,String dateFormat,Class<T> targetResultType) {
		if(StringUtils.isEmpty(dateString))
			return null;
		DateFormat df = new SimpleDateFormat(dateFormat);
		try {
			long time = df.parse(dateString).getTime();
			java.util.Date t = targetResultType.getConstructor(long.class).newInstance(time);
			return (T)t;
		} catch (ParseException e) {
			String errorInfo = "cannot use dateformat:"+dateFormat+" parse datestring:"+dateString;
			throw new IllegalArgumentException(errorInfo,e);
		} catch (Exception e) {
			throw new IllegalArgumentException("error targetResultType:"+targetResultType.getName(),e);
		}
	}
	
	public static java.util.Date parse(java.util.Date date, String dateFormat) {
		String dateString = format(date, dateFormat);
		return parse(dateString, dateFormat,java.util.Date.class);
	}
	
	public static String format(java.util.Date date,String dateFormat) {
		 if(date == null)
			 return null;
		 return new SimpleDateFormat(dateFormat).format(date);
	}
	
	
    
    
    public static Date getMonthEnd(int year, int month) {
		StringBuffer sb = new StringBuffer(10);
		Date date;
		if (month < 12) {
			sb.append(Integer.toString(year));
			sb.append("-");
			sb.append(month + 1);
			sb.append("-1");
			date = parse(sb.toString(), "yyyy-MM-dd");
		} else {
			sb.append(Integer.toString(year + 1));
			sb.append("-1-1");
			date = parse(sb.toString(), "yyyy-MM-dd");
		}
		date.setTime(date.getTime() - 1);
		return date;
	}
    
    /**
	 * 获取月底
	 * @param when 要计算月底的日期
	 * @return 月底的Date对象。例如：2006-3-31 23:59:59.999
	 */
	public static Date getMonthEnd(Date when) {
		Assert.notNull(when, "date must not be null !");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(when);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		return getMonthEnd(year, month);
	}
	
	 /**
	  * 获取给定日期的年
	  * @param currentDateTime
	  * @return
	  */
	 public static int getYearOfDate(Date currentDateTime){ 
	       Calendar calendar = Calendar.getInstance();
	       
	        calendar.setTime(currentDateTime);
	        return calendar.get(Calendar.YEAR);
	   
	    }
	 
	 /**
	  * 获取给定日期的月
	  * @param currentDateTime
	  * @return
	  */
	 public static int getMonthOfDate(Date currentDateTime){ 
	       Calendar calendar = Calendar.getInstance();
	       
	        calendar.setTime(currentDateTime);
	        return calendar.get(Calendar.MONTH) +1;
	   
	    }
	 /**
	  * 获取给定日期的日
	  * @param currentDateTime
	  * @return
	  */
	 public static int getDayOfDate(Date currentDateTime){ 
	       Calendar calendar = Calendar.getInstance();
	       
	        calendar.setTime(currentDateTime);
	        return calendar.get(Calendar.DAY_OF_MONTH);
	   
	    }
	 /**
		 * 日期加法
		 * @param when 被计算的日期
		 * @param field the time field. 在Calendar中定义的常数，例如Calendar.DATE
		 * @param amount 加数
		 * @return 计算后的日期
		 */
		public static Date add(Date when, int field, int amount) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(when);
			calendar.add(field, amount);
			return calendar.getTime();
		}
		
		/**
		 * 计算给定的日期加上给定的天数。
		 * @param when 给定的日期
		 * @param amount 给定的天数
		 * @return 计算后的日期
		 */
		public static Date addDays(Date when, int amount) {
			return add(when, Calendar.DAY_OF_YEAR, amount);
		}

		/**
		 * 计算给定的日期加上给定的月数。
		 * @param when 给定的日期
		 * @param amount 给定的月数
		 * @return 计算后的日期
		 */
		public static Date addMonths(Date when, int amount) {
			return add(when, Calendar.MONTH, amount);
		}
		/**
		 * 一天的开始
		 * @param date
		 * @return
		 */
		public static Date getStartForDay(Date date){
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			return calendar.getTime();
		}
		/**
		 * 一天的结束
		 * @param date
		 * @return
		 */
		public static Date getEndForDay(Date date){
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.set(Calendar.HOUR_OF_DAY, 23);
			calendar.set(Calendar.MINUTE, 59);
			calendar.set(Calendar.SECOND, 59);
			calendar.set(Calendar.MILLISECOND, 999);
			return calendar.getTime();
		}
		
		/**
		 * 间隔的天数
		 * @param start
		 * @param end
		 * @return
		 */
		public static Integer intervalDayOfYear(Date start,Date end){
			Integer rnt = null;
			if(start!=null&&end!=null){
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(start);
				calendar.set(Calendar.HOUR_OF_DAY, 0);
				calendar.set(Calendar.MINUTE, 0);
				calendar.set(Calendar.SECOND, 0);
				calendar.set(Calendar.MILLISECOND, 0);
				
				long startTime = calendar.getTime().getTime();
				
				calendar = Calendar.getInstance();
				calendar.setTime(end);
				calendar.set(Calendar.HOUR_OF_DAY, 0);
				calendar.set(Calendar.MINUTE, 0);
				calendar.set(Calendar.SECOND, 0);
				calendar.set(Calendar.MILLISECOND, 0);
				calendar.add(Calendar.DAY_OF_YEAR, 1);
				long endTime = calendar.getTime().getTime();
				
				rnt = (int)(endTime-startTime)/(1000*60*60*24);
			}else{
				//如果有的活动没有结束时间，如注册有奖 
				rnt = 365;
			}
			
			return rnt;
		}
		/**
		 * 把数随机分到指定的数组中
		 * @param arrayLength
		 * @param num
		 * @return
		 */
		public static int[] randomDistribution(int arrayLength,int num){
			int[] arr = new int[arrayLength];
			//平均数
			int averageNum = num/arrayLength;
			//余数
			int remainder = num%arrayLength;
			
			for(int i=0;i<arrayLength;i++){
				arr[i] = averageNum;
			}
			if(arrayLength>1){
				java.util.Random r = new java.util.Random();
				
				
				if(arrayLength/2>remainder){
					while(remainder>0){
						int index = r.nextInt(arrayLength-1);
						if(arr[index]==averageNum){
							arr[index]+=1;
							remainder--;
						}
					}
				}else{
					for(int i=0;i<arrayLength;i++){
						arr[i] += 1;
					}
					while(arrayLength-remainder>0){
						int index = r.nextInt(arrayLength-1);
						if(arr[index]==averageNum+1){
							arr[index]-=1;
							remainder++;
						}
					}
				}
			}
			return arr;
		}
		/**
		 * 
		 * @param day
		 * @param startTime
		 * @param endTime
		 * @param num
		 * @return
		 */
		public static long[] randomTime(Date day,int startTime , int endTime , int num){
			if(num<=0){
				return null;
			}
			long[] arr = new long[num];
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(day);
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			
			calendar.add(Calendar.SECOND, startTime);
			
			java.util.Random r = new java.util.Random();
			int interval = (endTime-startTime)/num;
			//int start = r.nextInt(interval);
			
			//calendar.add(Calendar.SECOND, start);
			for(int i=0;i<arr.length;i++){
				arr[i] =  calendar.getTime().getTime()+r.nextInt(interval/2)*1000;
				calendar.add(Calendar.SECOND, interval);
			}
			
			return arr;
		}
		
		
    public static void main(String []args){
		 //System.out.println(addDays(getCurrentDateTime(), -1));
    	
    	int[] arr = randomDistribution(100,350);
    	long sum = 0;
    	for(int i=0;i<arr.length;i++){
    		sum +=arr[i];
    		System.out.println(arr[i]);
    	}
    	System.out.println("sum:"+sum);
    	
    	//开始抽奖时间
		//int startLotteryTime = 0;//秒
    	int startLotteryTime =  8*60*60+0*60+0;//8时0分0秒
		//结束抽奖时间
		int endLotteryTime =  17*60*60+59*60+59;//23时59分59秒
		
		long[] times = randomTime(new Date(),startLotteryTime,endLotteryTime,5000);
    	
    	for(int i=0;i<times.length;i++){
    		System.out.println(format(new Date(times[i]),"yyyy-MM-dd HH:mm:ss"));
    	}
    	
	 }
}
