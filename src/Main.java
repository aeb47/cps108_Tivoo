import java.io.IOException;


public class Main {
	public static void main(String[] args) throws IOException{
		TivooModel myModel = new TivooModel();
		myModel.loadCalanderFile("dukecal.xml");
		myModel.createCalendar();
	}
}