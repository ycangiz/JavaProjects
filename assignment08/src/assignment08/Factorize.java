package assignment08;

import java.util.ArrayList;
import java.util.Arrays;
import java.awt.geom.Point2D;

public class Factorize {
	
	
	
	static ArrayList<Integer> factors(int n){
	 ArrayList<Integer> temp = new ArrayList<Integer>();
		return factorsHelper(n,2,temp);
	 }
	
	static ArrayList<Integer> factorsHelper(int n, int i, ArrayList<Integer> temp){
		 if(n<0) throw new IllegalArgumentException("Please enter positive number");
		
		 if(i>n) return temp;
		 
		 if (n==0 || n==1) return new ArrayList<Integer>();
		 if(n==2) return new ArrayList<Integer>(2);
			
		 if (n % i == 0) temp.add(i);
			
		 factorsHelper(n, i + 1, temp);
		 return temp;
	 }
	
	static String strBinary;
	static String binary(int n){
   
        if(n < 2){
            strBinary = "" + n;
            return strBinary;
        }
        else{
            if(n != 0){
                binary(n/2);
                strBinary += ""+n%2;
            }
        }
        return strBinary;
    } 
	
	public static String reverse(String text){
			
			if (text==null || text.length() <= 1) return text;
		    return reverse(text.substring(1)) + text.charAt(0);
	}
	
	public static int indexOf(String text, String str){
		return indexOf(0,text,str);
	}
	
	public static int indexOf(int count, String text, String str){
		
		boolean found;
		found = text.contains(str);
		if(!found) return -1;
		
		 if(text.startsWith(str)) return count;
		 
		 return indexOf(count+1,text.substring(1),str);
		
	}
	
	public static double area (Point2D.Double[] pts){
		
		
		if(pts.length==3){
			return Math.abs(pts[0].getX()*pts[1].getY()+pts[1].getX()*pts[pts.length-1].getY()+pts[pts.length-1].getX()*pts[0].getY()
					-pts[0].getY()*pts[1].getX()-pts[1].getY()*pts[pts.length-1].getX()-pts[pts.length-1].getY()*pts[0].getX())/2;
		}
		else return area(Arrays.copyOfRange(pts, 1, pts.length));
	}

}

