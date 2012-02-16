package calendar;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import events.Event;

public class ReadXMLFile {


    public static void main(String[] args) {

        SAXBuilder builder = new SAXBuilder();
        //Enter File here... either dukecal.xml or DukeBasketBall.xml
        File xmlFile = new File("dukecal.xml");
        //Enter type here... either Duke BasketBall Calendar or Duke Calendar
        String typeOfCalendar= "Duke Calendar";
        //Enter filter word here
        String filterWord= "word";
        Calendar c= new DukeCalendar(typeOfCalendar);
        if(typeOfCalendar.equals("Duke BasketBall Calendar")){
            c= new DukeBasketBallCalendar( typeOfCalendar);
        }
        ArrayList <Event> events = new ArrayList<Event> ();
        events= c.processCalendar(builder, xmlFile);
        
    }
}

