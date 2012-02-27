package calendar;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.chrono.ISOChronology;

import events.Event;

public abstract class Calendar {

    public Calendar() {

    }

    public ArrayList<Event> processCalendar(SAXBuilder builder, File xmlFile){
        ArrayList<Event> events = new ArrayList<Event>(); 
        try {

            Document document = (Document) builder.build(xmlFile);
            Element rootNode = document.getRootElement();
            events= createListOfEvents(rootNode);


        } catch (IOException io) {
            System.out.println(io.getMessage());
        } catch (JDOMException jdomex) {
            System.out.println(jdomex.getMessage());
        }

        return events;
    }

    public ArrayList<Event> createListOfEvents(Element rootNode){
       ArrayList<Event> events= new ArrayList<Event>();
        List list = createXMLList(rootNode); 
        for (int i = 0; i < list.size(); i++) {
            Element node = (Element) list.get(i);   
            Event e = createEvent(node);
            events.add(e);

        }
        return events;
    }

    public DateTime createDateTimeObject(String date, String time){
        String[] dateArray = date.split("/");
        String[] timeArray = time.split(":");
        String[] amPM = timeArray[timeArray.length-1].split(" ");
        timeArray[1] = amPM[0];
        Chronology chrono = ISOChronology.getInstance();
        int month = Integer.parseInt(dateArray[0]);
        int day = Integer.parseInt(dateArray[1]);
        int year = Integer.parseInt(dateArray[2]);
        int hour = Integer.parseInt(timeArray[0]);
        if(amPM[1].toLowerCase().equals("pm")&& hour!=12){
            hour+=12;
        }
        int minute = Integer.parseInt(timeArray[1]);
        DateTime dt = new DateTime(year, month, day, hour, minute, 0, 0, chrono);
        return dt;

    }
    
    public abstract List createXMLList(Element rootNode);
    public abstract Event createEvent(Element node);
    public abstract HashMap<String, String> generateMap(Element node);
    public abstract String getName(Element node);
    public abstract String getStartTime(Element node);
    public abstract String getEndTime(Element node);
    public abstract String getDate(Element node);
    public abstract String getURL(Element node);

}
