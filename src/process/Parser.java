package process;

import java.util.ArrayList;

import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.chrono.ISOChronology;

import events.*;

public class Parser {
	
	private String word = "word";
	
	private Chronology chrono = ISOChronology.getInstance();
	//private DateTime startTime = new DateTime(year, month, day, hour, minute, 0, 0, chrono);
	private DateTime startTime = new DateTime(2012, 1, 1, 0, 0, 0, 0, chrono);
	private DateTime endTime = new DateTime(2012, 1, 31, 23, 59, 0, 0, chrono);

	
	public ArrayList<Event> getMatchingEvents(ArrayList<Event> eventsList){
		ArrayList<Event> matchingEventList = new ArrayList<Event>();
		for(Event event: eventsList){
			if(event.getStartDateTime().compareTo(startTime) >= 0  
					&& event.getStartDateTime().compareTo(endTime) < 0) {
				matchingEventList.add(event);
			}
		}
		return matchingEventList;
	}	
	
	public ArrayList<Event> getEventsWithKeyWord(ArrayList<Event> eventsList){
		ArrayList<Event> filteredEventList = new ArrayList<Event>();
		for(Event event: eventsList){
			if(event.getName().contains(word)){
				filteredEventList.add(event);
			}
		}
		return filteredEventList;
	}
	
	public void setKeyWord(String newKeyWord){
		this.word = newKeyWord;
	}
	
	public void setStartingDateTime(DateTime start){
		this.startTime = start;
	}
	
	public void setEndingDateTime(DateTime end){
		this.endTime = end;
	}
}
