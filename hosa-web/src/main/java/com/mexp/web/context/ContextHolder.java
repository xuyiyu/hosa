package com.mexp.web.context;



public class ContextHolder {

	private static final ThreadLocal<Context> contextHolder = new ThreadLocal<Context>(); 

	public static void set(Context context) { 
		  contextHolder.set(context); 
		} 

		public static Context get() { 
			Context context = contextHolder.get();
			if(context==null){
				context = new Context(-1L);
				contextHolder.set(context);
			}
		  return  context; 
		} 

		public static void clearDbType() { 
		  contextHolder.remove(); 
		}
}
