package assignment06;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class DecimalSeparatorFormatter implements NumberFormatter {
	public String format(int n){
		
		Locale locale  = new Locale("en", "UK");        //                                                        String pattern = "####,####.###";
		String pattern = "###,###.###";                 //															DecimalFormat decimalFormat = new DecimalFormat(pattern);
		DecimalFormat decimalFormat = (DecimalFormat)   //															String number = decimalFormat.format(n);
		        NumberFormat.getNumberInstance(locale); //   this is how you do it with ",".  Here is with "."-->     return number;
		decimalFormat.applyPattern(pattern);            //
                                                        //
		String format = decimalFormat.format(n);        //
		
		return format;
	}
	
}
