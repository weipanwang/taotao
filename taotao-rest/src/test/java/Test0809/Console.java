/**
 * 
 */
package Test0809;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.springframework.stereotype.Service;
/**
 * @author 盼望
 * @date 2019年8月9日下午3:10:13
 */
@Service
public class Console {
	

	
	@Test
	public void console() throws Exception{
		
		 Subway subway = new Subway();
	     IsItPeak isItPeak = new IsItPeak();
	     
	     //设定当前时间
	     /*String format = "HH:mm:ss";
	     Date nowTime = new SimpleDateFormat(format).parse("08:01:00");
	     SimpleDateFormat df = new SimpleDateFormat(format);
	     System.out.println("设置的时间为："+df.format(nowTime));*/
	     
	     //获取当前系统时间
	     SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
	     Date nowTime = df.parse(df.format(new Date()));
	     System.out.println("当前系统时间为："+df.format(new Date()));
	     
	     //判断当前是否在运行时段
	    if(isItPeak.isStart(nowTime)) {
	    	java.util.List<Line> list = subway.subway(isItPeak.isItPeak(nowTime));
			 for (Line theSubway : list) {
			    	System.out.println(theSubway.getTheSubway()); 
			    	System.out.println("发车间隔："+theSubway.getIntervalTime()+"分钟"); 
			    	System.out.println("运行一趟时间："+theSubway.getSingleTime()+"分钟");
			    	if(theSubway.isPeak()) {
			    		System.out.println("目前是"+theSubway.getGao());
			    		System.out.println(theSubway.getTheSubway()+theSubway.getGao()+"需要"+theSubway.getTotal()+"趟车");
			    	}else {
			    		System.out.println("目前是"+theSubway.getXian());
			    		System.out.println(theSubway.getTheSubway()+theSubway.getXian()+"需要"+theSubway.getTotal()+"趟车");
			    	}
			    	System.out.println("===========");  
				}
		
	    	
	    }else {
	    	System.out.println("当前时间地铁已经停运！");
	    	}
		 
	}
}