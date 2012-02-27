import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.hp.gagawa.java.elements.*;

public class HTMLOut {

	public void start() throws IOException {
		FileWriter out = new FileWriter("test.html");
		BufferedWriter writer = new BufferedWriter(out);

		Html html = new Html();
		Head head = new Head();

		html.appendChild(head);

		Title title = new Title();
		title.appendChild(new Text("Athletics Calendar"));
		head.appendChild(title);

		Body body = new Body();
		html.appendChild(body);

		H1 h1 = new H1();
		h1.appendChild(new Text("Duke Home Games"));
		body.appendChild(h1);

		Table table = new Table();
		table.setTitle("Auto-generated table");
		table.setBorder("1");

		List<String> dukeGames = new ReadXMLFileJDOM().read();

		for (String entry : dukeGames) {

			Tr row = new Tr();

			Td thisEntry = new Td();
			thisEntry.appendChild(new Text(entry + "<br><br>"));
			row.appendChild(thisEntry);

			table.appendChild(row);

		}

		body.appendChild(table);

		writer.write(html.write());
		writer.close();
	}

}
