package calendar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jdom.Element;

import org.joda.time.DateTime;



import events.Event;


public class DukeBasketBallCalendar extends Calendar {


    @Override
    public HashMap<String, String> generateMap(Element node) {
        HashMap<String, String> details= new HashMap<String, String> ();
        details.put("name", getName(node));
   //     details.put("start time", getStartTime(node));
  //      details.put("end time", getEndTime(node));
  //      details.put("date", getDate(node));
        details.put("url", getURL(node));
        details.put("location", getLocation(node));

        return details;
        
       
    }
    @Override
    public List createXMLList(Element rootNode) {
        List list = rootNode.getChildren("Calendar");
        return list;
    }
    @Override
    public Event createEvent(Element node) {
        Event e= new Event(generateMap(node), getStartTimeObject(node), getEndTimeObject(node));
        return e;
    }

    @Override
    public String getName(Element node) {
        return node.getChildText("Subject");
    }
    
    public String getStartTime(Element node) {
        return node.getChildText("StartTime");
    }
    
    public String getEndTime(Element node) {
        return node.getChildText("EndTime");
    }
    
    public String getDate(Element node) {
        return node.getChildText("StartDate");
    }
   
    public DateTime getStartTimeObject(Element node) {
        return createDateTimeObject(getDate(node), getStartTime(node));
    }

    public DateTime getEndTimeObject(Element node) {
        return createDateTimeObject(getDate(node), getEndTime(node));
    }
    @Override
    public String getURL(Element node) {
        String url= node.getChildText("Description");
        String url2= url.substring(url.indexOf(':')+2);
        return url2;
    }
    
    public String getLocation(Element node) {
        return node.getChildText("Location");
    }
   

}
