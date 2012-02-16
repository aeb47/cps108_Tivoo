package events;




import org.joda.time.DateTime;




public class Event {




    private String myName;
    private DateTime start;
    private DateTime end;
    private String myUrl;
    private String[] dayArray = {"Monday", "Tuesday", "Wednesday",
"Thursday","Friday", "Saturday","Sunday"};








    public Event(String name, DateTime startTime, DateTime endTime, String url){
        this.myName = name;
        this.start = startTime;
        this.end= endTime;
        this.myUrl = url;




    }




    public String getName(){
        return myName;
    }




    public String getURL(){
        return myUrl;
    }




    public DateTime getStartDateTime(){
        return start;
    }
    public DateTime getEndDateTime(){
        return end;




    }




    public String getDayOfWeek(){
    	int dayNum = this.start.getDayOfWeek();
    	return dayArray[dayNum-1];
    }

    public double getEpochTime(String time){
        return 0.0;
    }
}