package filter;

import java.util.List;

import events.Event;

public class WordFilter extends Filter {

	// filters events by keywords - only events with keywords in their titles
	// will display
	public List<Event> filter(List<Event> events, List<String> words, boolean hasOrNot) {
		for (Event event : events) {
			for (String word : words) {
				boolean hasWord = event.containsKeyWord(word.toLowerCase());
				if (hasOrNot) {
					if (hasWord) event.toggleDisplay();
					else event.setDisplay(false);
				} 
				else {
					if (hasWord) event.setDisplay(false);
					else event.toggleDisplay();
				}
			}
		}
		return events;	
	}
}
