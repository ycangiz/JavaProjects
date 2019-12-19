package assignment04;

import java.util.ArrayList;

public class ArrayPractice {
	/**
	 * Determines if an array's elements are in non-decreasing order.
	 * The array {1, 2, 2, 3, 4} is in non-decreasing order while
	 * the array {1, 3, 4, 2, 5} is not in non-decreasing order as 2 < 4.
	 * A null or empty array is by default in non-decreasing order.
	 * @param array the array to inspect
	 * @return true  if the array's elements are in non-decreasing order,
	 *               or the array is null or empty
	 *         false otherwise
	 */
	public static boolean isNonDecreasing(ArrayList<Integer> array) {
		if(array==null || array.size()==0) return true;
		for(int i=0; i<array.size()-1; i++){
			if(array.get(i)<=array.get(i+1)) continue;
			else return false;
		}
		return true;
	}

	/**
	 * Determines if an array's elements are in strictly increasing order.
	 * The array {1, 2, 3, 4, 5} is in increasing order while
	 * the array {1, 2, 2, 4, 5} is not in increasing order as 2 == 2.
	 * A null or empty array is by default in increasing order.
	 * @param array the array to inspect
	 * @return true  if the array's elements are in increasing order,
	 *               or the array is null or empty
	 *         false otherwise
	 */
	public static boolean isIncreasing(ArrayList<Integer> array) {
		if(array==null || array.size()==0) return true;
		for(int i=0; i<array.size()-1; i++){
			if(array.get(i)<array.get(i+1)) continue;
			else return false;
		}
		return true;
	}

	/**
	 * Computes the reverse an array.
	 * The reverse of a null array is null.
	 * The reverse of an empty array is the empty array.
	 * Do NOT use reverseInPlace in the implementation of reverse
	 * @param array the array whose elements are to be reversed
	 * @return an array holding the contents of array in reverse order
	 */
	public static ArrayList<Integer> reverse(ArrayList<Integer> array) {
		if(array==null || array.size()==0) return array;
		else{
			ArrayList<Integer> revArr=new ArrayList<>(array.size());
			for(int i=0; i<array.size(); i++){
				revArr.add(i,array.get(array.size()-1-i));
			}
			return revArr;
		}
	}

	/**
	 * Computes an array that is all the elements of arr1 in the order they appear,
	 * followed by the elements of arr2 in the order they appear.
	 * An empty array should contribute no elements to the concatenated
	 * array.
	 * e.g. concatenate({6, 3, 8}, {10, 1, 7}) should return {6, 3, 8, 10, 1, 7}
	 * @param arr1 the first array
	 * @param arr2 the second array
	 * @return an array that is all the elements of arr1 in order,
	 *         followed by the elements of arr2 in order.
	 * @throws IllegalArgumentException if arr1 or arr2 is null
	 */
	public static ArrayList<Integer> concatenate(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
		if(arr1==null || arr2==null) throw new IllegalArgumentException("Not enter any null array\n"
				+ " you can make \"39th line in ArrayTester\" command line again to continue testing.");
		ArrayList<Integer> retArr= new ArrayList<Integer>(arr1.size()+arr2.size());
		for(int i=0; i<arr1.size(); i++){
			retArr.add(i,arr1.get(i));
		}
		for(int i=arr1.size(); i<(arr1.size()+arr2.size()); i++){
				retArr.add(i,arr2.get(i-arr1.size()));
		}
		return retArr;
	}
	/**
	 * Computes an array that is all the elements of arr1 in the order they appear,
	 * followed by the elements of arr2 in the reverse order they appear
	 * An empty array should contribute no elements to the resulting
	 * array.
	 * e.g. endToEnd({6, 3, 8}, {10, 1, 7}) should return {6, 3, 8, 7, 1, 10}
	 * HINT: this method can use other methods in this class to assist it.
	 *       ideally, this method is one short line of code.
	 * @param arr1 the first array
	 * @param arr2 the second array
	 * @return an array that is all the elements of arr1 in order,
	 * followed by the elements of arr2 in reverse order
	 * @throws IllegalArgumentException if arr1 or arr2 is null
	 */
	public static ArrayList<Integer> endToEnd(ArrayList<Integer> arr1, ArrayList<Integer>arr2) {
		if(arr1==null || arr2==null) throw new IllegalArgumentException("Error: arrays can not be null");
		else{
			reverseInPlace(arr2);
			ArrayList<Integer> retArr= new ArrayList<Integer>(arr1.size()+arr2.size());
			for(int i=0; i<arr1.size(); i++){
				retArr.add(i,arr1.get(i));
			}
			for(int i=arr1.size(); i<arr1.size()+arr2.size(); i++){
				retArr.add(i,arr2.get(i-arr1.size()));
			}
			return retArr;
		}
	}

	/**
	 * Reverses the given array in-place.
	 * Zero credit if another array is made.
	 * The reverse of a null array is null.
	 * The reverse of an empty array is the empty array.
	 * Do NOT use reverse in the implementation of reverseInPlace
	 * HINT: since we cannot make another array, we will have to swap certain
	 *       elements one-by-one.
	 * @param array the array to reverse
	 */
	public static void reverseInPlace(ArrayList<Integer> array) {
		if(array!=null && array.size()!=0){
			for(int i=0; i<(array.size())/2; i++){
				int temp=array.get(i);
				array.add(i,array.get(array.size()-1-i));
				array.add(array.size()-1-i,temp);
			}
		}
	}
}

