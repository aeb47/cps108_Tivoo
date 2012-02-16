package calendar;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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

    private String type;
    
    public Calendar(String typeOfCalendar) {
       type=typeOfCalendar;
    }
    
    public ArrayList<Event> processCalendar(SAXBuilder builder, File xmlFile){
        ArrayList<Event> events = new ArrayList<Event>(); 
        try {

            Document document = (Document) builder.build(xmlFile);
            Element rootNode = document.getRootElement();
           events= createEvents(rootNode);
            

        } catch (IOException io) {
            System.out.println(io.getMessage());
        } catch (JDOMException jdomex) {
            System.out.println(jdomex.getMessage());
        }

        return events;
    }
    
    public abstract ArrayList<Event> createEvents(Element rootNode);
    
    public DateTime createDateTimeObject(String date, String time){
        String[] dateArray = date.split("/");
        String[] timeArray = time.split(":");
        Chronology chrono = ISOChronology.getInstance();
        int month = Integer.parseInt(dateArray[0]);
        int day = Integer.parseInt(dateArray[1]);
        int year = Integer.parseInt(dateArray[2]);
        int hour = Integer.parseInt(timeArray[0]);
        int minute = Integer.parseInt(dateArray[1]);
        DateTime dt = new DateTime(year, month, day, hour, minute, 0, 0, chrono);
        return dt;
    }

   
    
}
