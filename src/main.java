import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.jdom.input.SAXBuilder;
import org.joda.time.DateTime;

import process.Parser;

import calendar.*;

import events.Event;
import html.WriteEvents;

public class main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		Parser parser = new Parser();
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
        events = c.processCalendar(builder, xmlFile);
        parser.setKeyWord("Duke");
        events = parser.getEventsWithKeyWord(events);
		WriteEvents writer = new WriteEvents();
		writer.write(events);
	}

}
