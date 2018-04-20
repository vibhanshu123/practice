import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Locale;


public abstract class DateOperations {
	
	public static void main(String[] args){
		
		Calendar cal=Calendar.getInstance();
		System.out.println(cal.getTime());
		//cal.roll(Calendar.DAY_OF_WEEK, 5);
		System.out.println(cal.getTime());
//		DateFormat df=DateFormat.getTimeInstance(DateFormat.FULL);
//		String s=df.format(cal.getTime());
//		System.out.println(s);
//		try {
//			System.out.println((df.parse(s)).toString());
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		Locale loc=new Locale("hi","IN");
		DateFormat df=DateFormat.getDateInstance(DateFormat.FULL, loc);
		
		System.out.println(df.format(cal.getTime()));
	}

}
