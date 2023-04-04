package ThreadsExmp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateEx {
    public static void main(String[] args) {
        Date date=new Date();
        Date dts=new Date((2000-1900),11,23);
        System.out.println("Today's date: "+date);
        System.out.println("Date entered: "+dts);

        System.out.println("\nComparing today and d: "+date.compareTo(dts));
        System.out.println("Today is After d: "+date.after(dts)+", Today is Before d: "+date.before(dts));
        System.out.println("Current Time: "+ date.getTime());
        /*System.out.println(" Time: "+ date.getTimezoneOffset());
        System.out.println("Day: "+date.getDate());
        System.out.println("Month: "+date.getMonth());
        System.out.println("Year: "+d.getYear());*/
        System.out.println("\nToString: "+dts.toString());
        Date d=new Date("November 2 2001");
        System.out.println("String: "+d);
        System.out.println("Instant: "+d.toInstant());
        System.out.println("\nDate Format Using SimpleDateFormat: \n");

        String str;
        SimpleDateFormat formatter;
        Date dt=new Date();
        formatter = new SimpleDateFormat("G EEE yyyy/MM/dd HH:mm:ss");
         str= formatter.format(dt);
        System.out.println("loc Week Date Time(rail): \n"+str);
        formatter = new SimpleDateFormat("hh:mm:ss yyyy/MM/dd");
        str = formatter.format(dt);
        System.out.println("Time(norm) Date: \n"+str);
        formatter = new SimpleDateFormat("hh:mm:ss dd/MM/yyyy EEE");
        str = formatter.format(dt);
        System.out.println("Time(norm) Date Week: \n"+str);
        formatter= new SimpleDateFormat("EEE, dd MM yyyy HH:mm:ss");
        str = formatter.format(dt);
        System.out.println("Week Date Time(rail): \n"+str);
        formatter= new SimpleDateFormat("E, dd MM yyyy HH:mm:ss Z");
        str = formatter.format(dt);
        System.out.println("Week Date Time(rail) ..: \n"+str);

        System.out.println("\nDate Format Using DateFormat: \n");

        DateFormat df;
        df=DateFormat.getDateInstance(DateFormat.LONG, Locale.UK);
        System.out.println("United Kingdom: "+df.format(dt));
        df=DateFormat.getDateInstance(DateFormat.SHORT, Locale.UK);
        System.out.println("United Kingdom: "+df.format(dt));
        df=DateFormat.getDateInstance(DateFormat.FULL, Locale.UK);
        System.out.println("United Kingdom: "+df.format(dt));
        df=DateFormat.getDateInstance(DateFormat.LONG, Locale.US);
        System.out.println("United States: "+df.format(dt));
        df=DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);
        System.out.println("United States: "+df.format(dt));
        df=DateFormat.getDateInstance(DateFormat.FULL, Locale.US);
        System.out.println("United States: "+df.format(dt));
    }
}
