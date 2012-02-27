package filter;

import java.util.Collections;
import java.util.List;

import events.*;

public abstract class Filter {
	
	public List<Event> filter(List<Event> lists) {
		return lists;
	}
	
	public void sortByName(List<Event> lists){
		Collections.sort(lists, Event.eventSortingType.sortByName.normalOrder());
	}
	
	public void sortByNameReverseOrder(List<Event> lists){
		Collections.sort(lists, Event.eventSortingType.sortByName.reverseOrder());
	}
	
	public void sortByStartTime(List<Event> lists){
		Collections.sort(lists, Event.eventSortingType.sortByStartTime.normalOrder()); 
	}
	
	public void sortByStartTimeReverseOrder(List<Event> lists){
		Collections.sort(lists, Event.eventSortingType.sortByStartTime.reverseOrder());
	}
	
	public void sortByEndTime(List<Event> lists){
		Collections.sort(lists, Event.eventSortingType.sortByEndTime.normalOrder()); 
	}
	
	public void sortByEndTimeReverseOrder(List<Event> lists){
		Collections.sort(lists, Event.eventSortingType.sortByEndTime.reverseOrder()); 
	}
}
