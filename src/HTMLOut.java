import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.hp.gagawa.java.elements.*;


public class HTMLOut {
	
	
	public void start() throws IOException{
		FileWriter out = new FileWriter("/home/rachel/Documents/CS108/test.html");
		BufferedWriter writer = new BufferedWriter(out);
		
		String[] thingsToPutInTable = {"Are you changing it yet?", "This is the second <br>entry", "This " +
				"is the ...", "... and so on"
		};
		
		Html html = new Html();
		Head head = new Head();
		
		html.appendChild(head);
		
		Title title = new Title();
		title.appendChild(new Text("This is the thing that goes in the top bar"));
		head.appendChild(title);
		
		Body body = new Body();
		html.appendChild(body);
		
		H1 h1 = new H1();
		h1.appendChild(new Text("This is the large text that goes in the body of the webpage"));
		body.appendChild(h1);
		
		Table table = new Table();
		table.setTitle("Auto-generated table");
		table.setBorder("1");
		
		for (int i = 0; i < 4; i ++){
			
			Tr row = new Tr();
		
			for (String entry: thingsToPutInTable){
				Td thisEntry = new Td();
				thisEntry.appendChild(new Text(entry+"<br><br>"));
				row.appendChild(thisEntry);
			}
		table.appendChild(row);
		
		}
		
		body.appendChild(table);
		
		writer.write(html.write());
		writer.close();
	
	                
	System.out.print( html.write() );
	}
	

}
