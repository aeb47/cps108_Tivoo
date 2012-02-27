
package events;

import java.util.Collections;
import java.util.Map;
import java.util.Comparator;


import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.chrono.ISOChronology;

import com.hp.gagawa.java.elements.Br;
import com.hp.gagawa.java.elements.Div;
import com.hp.gagawa.java.elements.Text;

public class Event {

    private Map<String, String> eventDetails;
    private DateTime myStart, myEnd;
    private boolean myDisplay;

    // STILL NECESSARY?
    private String[] dayArray = { "Monday", "Tuesday", "Wednesday", "Thursday",
            "Friday", "Saturday", "Sunday" };

    public Event(Map<String, String> details, DateTime startTime, DateTime endTime) {
        myStart = startTime;
        myEnd = endTime;
        myDisplay = true;
        eventDetails=details; 
    }

    public String getName() {
        if(eventDetails.containsKey("name")){
            return eventDetails.get("name");
        }
        return null;
    }

    public String getDescription() {
        if(eventDetails.containsKey("description")){
            return eventDetails.get("description");
        }
        return null;
    }

    public DateTime getStart() {
        return myStart;
    }

    public DateTime getEnd() {
        return myEnd;
    }

    public boolean getDisplay() {
        return myDisplay;
    }

    public void setDisplay(boolean display) {
        myDisplay = display;
    }

    // displays only if event hasn't already been removed
    public void toggleDisplay() {
        myDisplay &= true;
    }

    // OLD METHODS - NECESSARY WITH NEW SET-UP???

    public String getURL() {
        if(eventDetails.containsKey("url")){
            return eventDetails.get("url");
        }
        return null;
    }

    public String getDayOfWeek() {
        int dayNum = myStart.getDayOfWeek();
        return dayArray[dayNum - 1];
    }

    public boolean containsKeyWord(String word) {
    	for(String value: eventDetails.keySet()){
    		if(value.toLowerCase().contains(word.toLowerCase())){
    			return true;
    		}
    	}
    	return false;     	
    }

    public Interval getTimeInterval() {
        return new Interval(myStart, myEnd);
    }

    public boolean hasTimeConflict(Interval otherEventInterval) {
        return getTimeInterval().overlaps(otherEventInterval);
    }

    public boolean isWithinInterval(DateTime start, DateTime end) {
        if (getStart().isAfter(start)
                && getEnd().isBefore(end)) return true;
        return false;
    }

    public String getAddress(){
        if(eventDetails.containsKey("address")){
            return eventDetails.get("address");
        }
        return null;
    }

    public String getSubAddress(){
        if(eventDetails.containsKey("subaddress")){
            return eventDetails.get("subaddress");
        }
        return null;
    }

    public String getLocation(){
        if(eventDetails.containsKey("location")){
            return eventDetails.get("location");
        }
        return null;
    }

    public Div writeDetailsForEvent() {
        Div details = new Div();
        if(eventDetails.containsKey("description")){
            details.appendChild(new Text("Description: " + getDescription()));
            details.appendChild(new Br()); details.appendChild(new Br());
        }
        if(eventDetails.containsKey("address")&& eventDetails.containsKey("subaddress")){
            details.appendChild(writeAddresses(getAddress(), getSubAddress()));
        }
        else if(eventDetails.containsKey("address")){
            details.appendChild(writeAddresses(getAddress()));
        }
        return details;
    }

    private Text writeAddresses(String address){
        return new Text("Location: " + address);
    }
    private Text writeAddresses(String address, String subaddress) {
        return new Text("Location: " + address + "<br>" + subaddress);
    }


    public enum eventSortingType{
        sortByName(new Comparator<Event>() {
            public int compare(Event event1, Event event2) {
    	        return event1.getName().compareTo(event2.getName());
            }
        }),
        
        sortByStartTime(new Comparator<Event>() {
           public int compare(Event event1, Event event2) {
              return event1.getStart().compareTo(event2.getStart());
           }
        }),

        sortByEndTime(new Comparator<Event>() {
           public int compare(Event event1, Event event2) {
              return event1.getEnd().compareTo(event2.getEnd());
           }
        });
        
        private Comparator<Event> eventComparator;

        private eventSortingType(Comparator<Event> comparator){
        	eventComparator = comparator;
        }
        
        public Comparator<Event> normalOrder() {
            return eventComparator;
         }
        
        public Comparator<Event> reverseOrder() {
           return Collections.reverseOrder(eventComparator);
        }
     }
}
