package html;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import events.Event;

import com.hp.gagawa.java.elements.A;
import com.hp.gagawa.java.elements.Body;
import com.hp.gagawa.java.elements.Head;
import com.hp.gagawa.java.elements.Html;
import com.hp.gagawa.java.elements.Td;
import com.hp.gagawa.java.elements.Text;
import com.hp.gagawa.java.elements.Title;
import com.hp.gagawa.java.elements.Tr;

public class WriteEvent {
	
	public void write(ArrayList<Event> events) throws IOException{
		FileWriter out = new FileWriter("test.html");
		BufferedWriter writer = new BufferedWriter(out);

		Html html = new Html();
		Head head = new Head();

		html.appendChild(head);

		Title title = new Title();
		title.appendChild(new Text("Calendar"));
		head.appendChild(title);
		
		Body body = new Body();
		html.appendChild(body);
		
		Tr row = new Tr();
		
		for (Event event: events){
			row.appendChild(writeCell(event));
		}
		
		body.appendChild(row);
		
		writer.write(html.write());
		writer.close();
		
	}
	
	private Td writeCell(Event event){
		Td newCell = new Td();
		A link = new A();
		link.setTitle(event.getName()).setHref(event.getURL());
		newCell.appendChild(link);
		link.appendChild(new Text(event.getName() + "<br>"));
		newCell.appendChild(new Text("Start time: " + event.getStart()));
		newCell.appendChild(new Text("End time: "+event.getEnd()));
		return newCell;
	}

}
