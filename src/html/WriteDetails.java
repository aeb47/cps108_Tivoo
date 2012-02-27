package html;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.hp.gagawa.java.elements.A;
import com.hp.gagawa.java.elements.Body;
import com.hp.gagawa.java.elements.Br;
import com.hp.gagawa.java.elements.Div;
import com.hp.gagawa.java.elements.H1;
import com.hp.gagawa.java.elements.Head;
import com.hp.gagawa.java.elements.Html;
import com.hp.gagawa.java.elements.Text;

import events.Event;

public class WriteDetails {
	
	Event event;
	String[][] types;
	
	public WriteDetails(Event event) throws IOException{
		this.event = event;
	}
	
	public void write() throws IOException{
		FileWriter out = new FileWriter(getURL());
		BufferedWriter writer = new BufferedWriter(out);
		Html html = initialize(event.getName());
		Body body = writeContents();
		body.appendChild(new Br()); body.appendChild(new Br());
		body.appendChild(new Footer().writeFooter());
		html.appendChild(body);
		writer.write(html.write());
		writer.close();
		
	}
	
	protected String getURL(){
		String toHash = event.getName() + event.getStart();
		int eventHash = toHash.hashCode();
		return Integer.toString(eventHash) + ".html";
	}
	
	public Body writeContents(){
		Body body = new Body();
		body.appendChild(new H1().appendChild(new Text(event.getName())));
		body.appendChild(new Br());
		
		body.appendChild(new Text("Start time: " + event.getStart().toDate()));
		body.appendChild(new Br()); body.appendChild(new Br());
		body.appendChild(new Text("End time: " + event.getEnd().toDate()));
		body.appendChild(new Br()); body.appendChild(new Br());
		A link = new A().setHref(event.getURL()).appendChild(new Text(event.getURL()));
		body.appendChild(new Text("Original URL: "));
		body.appendChild(link);
		body.appendChild(new Br()); body.appendChild(new Br());
		
		Div details = event.writeDetailsForEvent();
		
		body.appendChild(details);
		
		return body;
	}
	
	public Html initialize(String title){
		Html html = new Html();
		Head head = new Head();
		return html;
	}

}
