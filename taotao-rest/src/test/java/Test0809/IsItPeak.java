/**
 * 
 */
package Test0809;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

/**
 * @author 盼望
 * @date 2019年8月9日下午3:23:26
 */
@Service
public class IsItPeak {
	
	//判断是否是高峰期
	public boolean isItPeak(Date nowTime) throws Exception{

		String format = "HH:mm:ss";
		
		 Date AstartTime = new SimpleDateFormat(format).parse("07:30:00");
	     Date AendTime = new SimpleDateFormat(format).parse("09:00:59");
		 
	     Date PstartTime = new SimpleDateFormat(format).parse("17:00:00");
	     Date PendTime = new SimpleDateFormat(format).parse("18:30:59");
		
		 if (nowTime.getTime() == AstartTime.getTime()
	                || nowTime.getTime() == AendTime.getTime()
	                || nowTime.getTime() == PstartTime.getTime()
	    	        || nowTime.getTime() == PendTime.getTime()) {
	            return true;
	        }


	        Calendar date = Calendar.getInstance();
	        date.setTime(nowTime);

	        Calendar begin = Calendar.getInstance();
	        begin.setTime(AstartTime);

	        Calendar end = Calendar.getInstance();
	        end.setTime(AendTime);
	        
	        Calendar begin2 = Calendar.getInstance();
	        begin2.setTime(PstartTime);

	        Calendar end2 = Calendar.getInstance();
	        end2.setTime(PendTime);

	        
	        if ((date.after(begin) && date.before(end))||(date.after(begin2) && date.before(end2))) {
	            return true;
	        } else {
	            return false;
	        }
	        
	    }
	
	//判断是否在运行时段
	public boolean isStart(Date nowTime) throws Exception{
		
		 String format = "HH:mm:ss";
		
		 Date AstartTime = new SimpleDateFormat(format).parse("06:00:00");
	     Date AendTime = new SimpleDateFormat(format).parse("23:00:00");
	     
	     if (nowTime.getTime() == AstartTime.getTime()
	                || nowTime.getTime() == AendTime.getTime()) {
	            return false;
	        }
	     Calendar date = Calendar.getInstance();
	     date.setTime(nowTime);

	     Calendar begin = Calendar.getInstance();
	     begin.setTime(AstartTime);
	     
	     Calendar end = Calendar.getInstance();
	     end.setTime(AendTime);
	     
	     if (date.after(begin) && date.before(end)) {
	            return true;
	        } else {
	            return false;
	        }
	        
	}
	
	
	
}