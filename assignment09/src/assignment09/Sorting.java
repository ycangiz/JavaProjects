package assignment09;

import java.util.ArrayList;
import java.util.Collections;

public class Sorting {
	
	
	
	public static ArrayList<Integer> selection(ArrayList<Integer> list){
		if(list == null) return null;
		if (list.size() == 0) return new ArrayList<Integer>();
		Integer min = Collections.min(list);
		list.remove(min);
		ArrayList<Integer> countMin = new ArrayList<Integer>();
		countMin.add(min);
		countMin.addAll(selection(list));
		
		return countMin;
	}
	
	public static boolean inOrder(ArrayList<Integer> list){
		if(list==null || list.size()==0) return true;
		int flag=0;	
		for(int i=0; i<list.size()-1; i++){
			if(list.get(i)>list.get(i+1))	flag++;
		}
		if(flag==0) return true;
		return false;
	}
	
	private static ArrayList<Integer> less(ArrayList<Integer> list){
		ArrayList<Integer> returnList = new ArrayList<Integer>();
		for(int i : list){
			if(i<list.get(0)) returnList.add(i);
		}
		return returnList;
	}
	
	private static ArrayList<Integer> geq(ArrayList<Integer> list){
		ArrayList<Integer> returnList = new ArrayList<Integer>();
		for (int i : list){
			if(i>=list.get(0)) {
				if(i!=list.get(0)) returnList.add(i);
			}
		}
		return returnList;
	}
	
	public static ArrayList<Integer> qsort(ArrayList<Integer> list){
		
		if(list==null) return null;
		if(list.size()==0) return new ArrayList<Integer>();
		if(inOrder(list)){
			return new ArrayList<Integer>(list);
		}
		Integer pivot = new ArrayList<Integer>(list).get(0);
		
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp=qsort(less(list));
		temp.add(pivot);
		
		temp.addAll(qsort(geq(list)));
	
		return temp;
	}

}
