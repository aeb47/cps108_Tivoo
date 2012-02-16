package html;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import old.ReadXMLFileJDOM;

import com.hp.gagawa.java.elements.A;
import com.hp.gagawa.java.elements.Body;
import com.hp.gagawa.java.elements.Br;
import com.hp.gagawa.java.elements.H1;
import com.hp.gagawa.java.elements.Head;
import com.hp.gagawa.java.elements.Html;
import com.hp.gagawa.java.elements.Table;
import com.hp.gagawa.java.elements.Td;
import com.hp.gagawa.java.elements.Text;
import com.hp.gagawa.java.elements.Title;
import com.hp.gagawa.java.elements.Tr;

import events.Event;

public class DetailPage {
	
	private Event event;
	
	public DetailPage(Event event) throws IOException{
		this.event = event;
		write();
	}
	
	private void write() throws IOException{

		FileWriter out = new FileWriter(getURL());
		BufferedWriter writer = new BufferedWriter(out);

		Html html = new Html();
		Head head = new Head();

		html.appendChild(head);

		Title title = new Title();
		title.appendChild(new Text(event.getName()));
		head.appendChild(title);

		Body body = new Body();
		html.appendChild(body);

		H1 h1 = new H1();
		h1.appendChild(new Text(event.getName() + ":  Details"));
		body.appendChild(h1);
		
		body.appendChild(new Text("<br><br>"));
		body.appendChild(new Text("Date: " + event.getStartDateTime()));
		body.appendChild(new Br());
		body.appendChild(new Text("End time: " + event.getEndDateTime()));
		body.appendChild(new Br());
		A link = new A().setHref(event.getURL()).appendChild(new Text(event.getURL()));
		body.appendChild(new Text("Original URL: "));
		body.appendChild(link);
		
		writer.write(html.write());
		writer.close();
	}
	
	private String getFilename(){
		int eventHash = event.getName().hashCode();
		return Integer.toString(eventHash);
	}
	
	public String getURL(){
		return getFilename() + ".html";
	}

}
