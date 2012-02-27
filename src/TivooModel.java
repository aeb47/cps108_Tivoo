import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom.input.SAXBuilder;
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.chrono.ISOChronology;

import calendar.*;

import events.Event;
import filter.DateFilter;
import filter.Filter;
import filter.WordFilter;
import html.WriteSummary;

public class TivooModel {

	private ArrayList<String> myFilterWords;
	final Chronology chrono = ISOChronology.getInstance();
	private DateTime myFilterStart;
    private DateTime myFilterEnd;
    private ArrayList<Event> myList;
    
    public TivooModel(){
    	myList = new ArrayList<Event>();
    }
    
	public void loadCalanderFile(String filename){
		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File(filename);
		
		///Need Way to Parse What kind of Calendar it is without requiring input
		String typeOfCalendar = "Duke Calendar";
		Calendar c = new DukeCalendar();
		if (typeOfCalendar.equals("Duke BasketBall Calendar")) {
			c = new DukeBasketBallCalendar();
		}
		ArrayList<Event> results = c.processCalendar(builder, xmlFile);
		
		myList.addAll(results);
	}
	
	public void createCalendar() throws IOException{
		WriteSummary writer = new WriteSummary();
		writer.write(myList);
	}
    
    //change what words to filter by here
	public void setFilterWords() {
		myFilterWords = new ArrayList<String>();
		myFilterWords.add("Duke");
	}
	
	//change the date filter here
	public void setFilterStartEnd() {
		myFilterStart = new DateTime(2011, 1, 1, 0, 0, 0, 0, chrono);
		myFilterEnd = new DateTime(2011, 12, 31, 23, 59, 0, 0, chrono);
	}
	
    public DateTime getMyFilterStart() {
        return myFilterStart;
    }
    public List<String> getMyFilterWords() {
        return myFilterWords;
    }
    public DateTime getMyFilterEnd() {
        return myFilterEnd;
    }
	
    /**
     * 
     * Filtering and Sorting Functions to be called through the GUI
     * 
     */
    
	public void filterByKeyWords(List<String> words) {
		WordFilter wordFilter = new WordFilter();
		myList = (ArrayList<Event>) wordFilter.filter(myList, words, true);
	}

	public void filterByKeyWord(String word){
		ArrayList<String> words = new ArrayList<String>();
		words.add(word);
		WordFilter wordFilter = new WordFilter();
		myList = (ArrayList<Event>) wordFilter.filter(myList, words, true);
	}
	
	public void filterByKeyWordsNegate(List<String> words) {
		WordFilter wordFilter = new WordFilter();
		myList = (ArrayList<Event>) wordFilter.filter(myList, words, false);
	}

	public void filterByKeyWordNegate(String word){
		ArrayList<String> words = new ArrayList<String>();
		words.add(word);
		WordFilter wordFilter = new WordFilter();
		myList = (ArrayList<Event>) wordFilter.filter(myList, words, false);
	}
	
	public void filterByDatesWithin(List<Event> events, DateTime start,DateTime end) {
		DateFilter dateFilter = new DateFilter();
		myList = (ArrayList<Event>) dateFilter.filter(events, start, end, true);
	}
	
	public void filterByDatesNotWithin(List<Event> events, DateTime start,DateTime end) {
		DateFilter dateFilter = new DateFilter();
		myList = (ArrayList<Event>) dateFilter.filter(events, start, end, false);
	}
	
	public void sortByName(){
		WordFilter wordFilter = new WordFilter();
		wordFilter.sortByName(myList);
	}
	
	public void sortByNameReverseOrder(){
		WordFilter wordFilter = new WordFilter();
		wordFilter.sortByNameReverseOrder(myList);
	}
	
	public void sortByStartTime(){
		WordFilter wordFilter = new WordFilter();
		wordFilter.sortByStartTime(myList);
	}
	
	public void sortByStartTimeReverseOrder(){
		WordFilter wordFilter = new WordFilter();
		wordFilter.sortByStartTimeReverseOrder(myList);
	}
	
	public void sortByEndTime(){
		WordFilter wordFilter = new WordFilter();
		wordFilter.sortByEndTime(myList);
	}
	
	public void sortByEndTimeReverseOrder(){
		WordFilter wordFilter = new WordFilter();
		wordFilter.sortByEndTimeReverseOrder(myList);
	}
}
