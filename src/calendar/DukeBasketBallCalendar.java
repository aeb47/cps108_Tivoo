package calendar;

import java.util.ArrayList;
import java.util.List;

import org.jdom.Element;
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.chrono.ISOChronology;

import events.Event;


public class DukeBasketBallCalendar extends Calendar {

    public DukeBasketBallCalendar(String typeOfCalendar) {
        super(typeOfCalendar);
    }
    public ArrayList<Event> createEvents(Element rootNode) {
        List list = rootNode.getChildren("Calendar");
        ArrayList<Event> dukeBasketballEvents = new ArrayList<Event>();
        for (int i = 0; i < list.size(); i++) {

            Element node = (Element) list.get(i);
            System.out.println(node.getChildText("Subject"));
            DateTime start= createDateTimeObject( node.getChildText("StartDate"), node.getChildText("StartTime"));
            DateTime end= createDateTimeObject( node.getChildText("StartDate"), node.getChildText("EndTime"));
            Event e= new Event(node.getChildText("Subject"), start, end, getDukeBasketballURL(node) );
            dukeBasketballEvents.add(e);

        }
        return dukeBasketballEvents;
    }
    private String getDukeBasketballURL(Element node) {
        String url= node.getChildText("Description");
        String url2= url.substring(url.indexOf(':')+2);
        return url2;
    }
    
  
}
