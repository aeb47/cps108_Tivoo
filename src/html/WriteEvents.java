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
import com.hp.gagawa.java.elements.Table;
import com.hp.gagawa.java.elements.Td;
import com.hp.gagawa.java.elements.Text;
import com.hp.gagawa.java.elements.Title;
import com.hp.gagawa.java.elements.Tr;

public class WriteEvents {

	String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", 
			"Friday", "Saturday"};
	ArrayList<Tr> daysOfWeekList = makeArrayOfLength(7);
	
	public void write(ArrayList<Event> events) throws IOException{
		FileWriter out = new FileWriter("summary.html");
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
			int dayIndex = getDayIndex(event.getDayOfWeek());
			if (daysOfWeekList.get(dayIndex) == null){
				row = new Tr();
				daysOfWeekList.remove(dayIndex);
				daysOfWeekList.add(dayIndex, row);
				row.appendChild(new Td().appendChild(new Text(daysOfWeek[dayIndex])));
			}
			daysOfWeekList.get(dayIndex).appendChild(writeCell(event));
		}
		
		Table table = writeTable(daysOfWeekList);
		body.appendChild(table);
		
		writer.write(html.write());
		writer.close();
		
	}
	
	private Td writeCell(Event event) throws IOException{
		DetailPage currentPage = new DetailPage(event);
		Td newCell = new Td();
		A link = new A();
		link.setTitle(event.getName()).setHref(currentPage.getURL());
		newCell.appendChild(link);
		link.appendChild(new Text(event.getName() + "<br>"));
		newCell.appendChild(new Text("Start time: " + event.getStartDateTime().toDate() + "<br>"));
		newCell.appendChild(new Text("End time: " + event.getEndDateTime().toDate()));
		return newCell;
	}
	
	private int getDayIndex(String thisDay){
		for (int i = 0; i < 7; i ++){
			if (daysOfWeek[i].equals(thisDay))
				return i;
		}
		return 0;
	}
	
	private Table writeTable(ArrayList<Tr> days){
		Table table = new Table();
		for (int i = 0; i < days.size(); i ++){
			Tr row = days.get(i);
			if (row == null){
				row = new Tr();
				row.appendChild(new Td().appendChild(new Text(daysOfWeek[i])));
			}
			table.appendChild(row);
		}
		return table;
	}
	
	private ArrayList<Tr> makeArrayOfLength(int length){
		ArrayList<Tr> list = new ArrayList<Tr>();
		for (int i = 0; i < length; i ++){
			list.add(null);
		}
		return list;
	}

}
