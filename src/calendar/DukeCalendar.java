package calendar;

import java.util.ArrayList;
import java.util.List;

import org.jdom.Element;
import org.joda.time.DateTime;

import events.Event;


public class DukeCalendar extends Calendar {

    public DukeCalendar(String typeOfCalendar) {
        super(typeOfCalendar);
    }

    public ArrayList<Event> createEvents(Element rootNode){
        List list = rootNode.getChildren("event");
        ArrayList<Event> dukeBasketballEvents = new ArrayList<Event>();
        for (int i = 0; i < list.size(); i++) {

            Element node = (Element) list.get(i);
            DateTime start= createDateTimeObject( node.getChild("start").getChildText("shortdate"), node.getChild("start").getChildText("time"));
            DateTime end= createDateTimeObject( node.getChild("start").getChildText("shortdate"), node.getChild("end").getChildText("time"));
            Event e = new Event (node.getChildText("summary"), start, end,  node.getChildText("link"));
            dukeBasketballEvents.add(e);

        }
        return dukeBasketballEvents;
    }
}
