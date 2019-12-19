package assignment10;

import java.util.ArrayList;

public class BinaryT<T> {
	private T data;
	private BinaryT<T> left;
	private BinaryT<T> right;

	public BinaryT(T dat, BinaryT<T> lft, BinaryT<T> rft) {
		data = dat;
		left = lft;
		right= rft;
	}
	public ArrayList<T> bftravers(){
		ArrayList<BinaryT<T>> temp = new ArrayList<BinaryT<T>>();
		temp.add(this);
		return bftravers(temp);
		
	}
	private ArrayList<T> bftravers(ArrayList<BinaryT<T>> nodeQueue){
		
		if(nodeQueue!=null && nodeQueue.size()>0){
			ArrayList<T> retVal = new ArrayList<T>();
			
			retVal.add(nodeQueue.get(0).data);	
			BinaryT<T> element = nodeQueue.remove(0);
			
			if(element.left!=null){
				nodeQueue.add(element.left);
			}
			
			if(element.right!=null){
				nodeQueue.add(element.right);				
			}
			
			retVal.addAll(bftravers(nodeQueue));
			return retVal;
		}		
		return new ArrayList<T>();
	}

	public static void main(String[] args) {
		BinaryT<Integer> t7 = new BinaryT<>(7, null, null);
		BinaryT<Integer> t4 = new BinaryT<>(4, null, null);
		BinaryT<Integer> t0 = new BinaryT<>(0, null, null);
		BinaryT<Integer> t1 = new BinaryT<>(1, t7, null);
		BinaryT<Integer> t5 = new BinaryT<>(5, t4, t0);
		BinaryT<Integer> t3 = new BinaryT<>(3, t1, t5);
		System.out.println(t3.bftravers());
	}
}
