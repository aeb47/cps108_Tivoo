package html;

import com.hp.gagawa.java.elements.Div;
import com.hp.gagawa.java.elements.Text;

public class Footer {
	
	public Div writeFooter(){
		Div div = new Div();
		Div contents = new Div();
		contents.setCSSClass("row-footer")
			.appendChild(new Div().setCSSClass("span8")
					.appendChild(new Text("Created by Rachel Harris, Tori Reynolds, " +
							"Ben Mozneter, Andrew Bentley"))
			);
			contents.appendChild(new Div().setCSSClass("span4")
					.appendChild(new Text("Tivoo Project"))
			);
		div.setCSSClass("container").appendChild(contents);
		return div;
	}

}
