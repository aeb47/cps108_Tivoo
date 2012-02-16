package old;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class ReadXMLFileJDOM {
	public ArrayList<String> read() {

		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File("google.xml");
		ArrayList<String> subjects = new ArrayList<String>();
		ArrayList<String> locations = new ArrayList<String>();
		try {
			Document document = (Document) builder.build(xmlFile);
			Element rootNode = document.getRootElement();
			List list = rootNode.getChildren("Calendar");
			for (int i = 0; i < list.size(); i++) {
				Element node = (Element) list.get(i);
				subjects.add(node.getChildText("Subject"));
				locations.add(node.getChildText("Location"));
			}
		} catch (IOException io) {
			System.out.println(io.getMessage());
		} catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		}
		ArrayList<String> homeGames = new ArrayList<String>();
		for (int i = 0; i < locations.size(); i++) {
			if (locations.get(i).equals("Cameron Indoor Stadium")) {
				homeGames.add(subjects.get(i));
			}
		}
		return homeGames;
	}
}