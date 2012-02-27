package calendar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jdom.Element;
import org.joda.time.DateTime;


import events.Event;


public class TVCalendar extends Calendar {

    public List createXMLList(Element rootNode) {
        List list = rootNode.getChildren("tv");
        return list;
    }
    
    @Override
    public Event createEvent(Element node) {
        Event e = new Event (generateMap(node), getStartTimeObject(node), getEndTimeObject(node));
        return e;
    }
    
    @Override
    public HashMap<String, String> generateMap(Element node) {
        HashMap<String, String> details= new HashMap<String, String> ();
        details.put("name", getName(node));
   //     details.put("start time", getStartTime(node));
  //      details.put("end time", getEndTime(node));
  //      details.put("date", getDate(node));
        details.put("url", getURL(node));
        details.put("description", getDescription(node));
        details.put("address", getAddress(node));
        details.put("subaddress", getSubaddress(node));
        return details;
        
       
    }
    
    public DateTime getStartTimeObject(Element node){
       return createDateTimeObject(getDate(node), getStartTime(node));
    }
    
    public DateTime getEndTimeObject(Element node){
        return createDateTimeObject(getDate(node), getEndTime(node));
     }
   
    
    public String getSubaddress(Element node){
        return node.getChild("location").getChildText("subaddress");
    }
    
    public String getAddress(Element node){
        return node.getChild("location").getChildText("address");
    }

    @Override
    public String getName(Element node) {
        return node.getChildText("summary");
    }

    @Override
    public String getStartTime(Element node) {
       return node.getChild("start").getChildText("time"); 
    }

    @Override
    public String getEndTime(Element node) {
       return node.getChild("end").getChildText("time");
    }
    
    public String getDate(Element node){
        Element start = node.getChild("start");
        return start.getChildText("month") + "/" + start.getChildText("day") + "/" + start.getChildText("year") ;
        
    }

    @Override
    public String getURL(Element node) {
        return node.getChildText("link");
    }
    
    public String getDescription(Element node){
        return node.getChildText("description");
    }
}

