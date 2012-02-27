package filter;

import java.util.List;

import org.joda.time.DateTime;
import events.Event;

public class DateFilter extends Filter {
	public List<Event> filter(List<Event> events, DateTime start, DateTime end, boolean hasOrNot){
		for (Event event: events){
			boolean withinTimeFrame = event.getStart().isAfter(start)   
					&& event.getEnd().isBefore(end);
			if(hasOrNot){
				if(withinTimeFrame) event.toggleDisplay();
				else event.setDisplay(false); 
			}else{
				if(!withinTimeFrame) event.toggleDisplay();
				else event.setDisplay(false); 
				}
			}
		return events;
	}	
}
