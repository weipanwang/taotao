/**
 * 
 */
package Test0809;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * @author 盼望
 * @date 2019年8月9日下午3:21:01
 */
@Service
public class Subway {
	
	
		
	public List<Line> subway(boolean peak) {
		
		ArrayList<Line> list = new ArrayList<Line>();
		
		if(peak) {
			Line line1 = new Line();
			line1.setTheSubway("一号线");
			line1.setSingleTime(60);
			line1.setIntervalTime(3);
			line1.setPeak(true);
			line1.setTotal(((line1.getSingleTime()/line1.getIntervalTime())*2)+2);
			
			Line line2 = new Line();
			line2.setTheSubway("二号线");
			line2.setSingleTime(90);
			line2.setIntervalTime(3);
			line2.setPeak(true);
			line2.setTotal(((line2.getSingleTime()/line2.getIntervalTime())*2)+2);
			
			Line line3 = new Line();
			line3.setTheSubway("三号线");
			line3.setSingleTime(120);
			line3.setIntervalTime(3);
			line3.setPeak(true);
			line3.setTotal(((line3.getSingleTime()/line3.getIntervalTime())*2)+2);
			
			list.add(line1);
			list.add(line2);
			list.add(line3);
			
			
			return list;
			
		}else {
			Line line1 = new Line();
			line1.setTheSubway("一号线");
			line1.setSingleTime(60);
			line1.setIntervalTime(5);
			line1.setPeak(false);
			line1.setTotal(((line1.getSingleTime()/line1.getIntervalTime())*2)+2);
			
			Line line2 = new Line();
			line2.setTheSubway("二号线");
			line2.setSingleTime(90);
			line2.setIntervalTime(5);
			line2.setPeak(false);
			line2.setTotal(((line2.getSingleTime()/line2.getIntervalTime())*2)+2);
			
			Line line3 = new Line();
			line3.setTheSubway("三号线");
			line3.setSingleTime(120);
			line3.setIntervalTime(5);
			line3.setPeak(false);
			line3.setTotal(((line3.getSingleTime()/line3.getIntervalTime())*2)+2);
			
			list.add(line1);
			list.add(line2);
			list.add(line3);
			
			return list;
		}
		
	}
}
