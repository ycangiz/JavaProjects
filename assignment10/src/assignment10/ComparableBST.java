package assignment10;

import java.util.ArrayList;
import java.util.List;


/**
 * A class to implement the Binary Search Tree data structure.
 * The structure is generic in the type of Objects it contains.
 * @param <T> the type of the contained elements this structure is to hold
 */
public class ComparableBST<T extends Comparable<? super T>> {
   
    private T data;
    private ComparableBST<T> left;
    private ComparableBST<T> right;

    /**
     * Constructs an empty BST with a Comparator
     * @param comp the Comparator to use to impose an ordering on instances of T
     */
    public ComparableBST(T data) { // THIS IS THE ONLY CONSTRUCTOR
		this.data = data;
	}

   
    /**
     * Inserts an element into this BST
     * @param element the element to insert into this BST
     */
    public void insert(T element) {
        // TODO
    	if(data==null) data=element;
    	else{
    	if(element.compareTo(data)<0){
    		if(left==null) left=new ComparableBST<T>(element);
    		else left.insert(element);
    	};
    	if(element.compareTo(data)>0){
    		if(right==null) right=new ComparableBST<T>(element);
    		else right.insert(element);
    	};
    	}
    	
    }

    /**
     * Searchs for a given element in this BST
     * @param element the element to search this BST for
     * @return the element in this BST matching the given element, if found,
     *         otherwise null if the given element is not in this BST
     */
    public T find(T element) {
        // TODO
    	if(data==null) return null;
    	else{
    		if(element.compareTo(data)<0){
        		if(left==null) return null;
        		else return left.find(element);
        	};
        	if(element.compareTo(data)>0){
        		if(right==null) return null;
        		else return right.find(element);
        	};
    		if(element.compareTo(data)==0){
    			return element;
    		}
    		}
    		
    	return null;
    }

    /**
     * Gathers all the elements of this BST in order
     * @return a List holding the elements in this BST in order
     */
    public List<T> getElements() {
        List<T> list = new ArrayList<>();
        // TODO
        if(data==null) return list;
    	else{
    		if(left!=null){
        		
        		list.addAll( left.getElements());
        	}list.add(data);
        	if(right!=null){
        		
        		list.addAll(right.getElements()); 
        	}
    	}
        return list;
    }		
        
        
    

    /**
     * Pretty prints the contents of this BST in a horizontal tree-like fashion
     */
    public void prettyPrint() {
        prettyPrint(0);
    }

    private void prettyPrint(int indentLevel) {
        // TODO
        // similar to printInOrder from assignment09,
        // but print `indentLevel` amount of spaces before printing data on its own line
        // you may use a for loop to print `indentLevel` amount of spaces
    	
    	if(left!=null){ left.prettyPrint(indentLevel+1);}
    	for(int i=0; i<indentLevel; i++) System.out.print(" "); System.out.println(data); 
    	if(right!=null){ right.prettyPrint(indentLevel+1);}
        // each time you recurse, you add to indentLevel
    	
    }
    
    public ArrayList<T> bftravers(){
		ArrayList<ComparableBST<T>> temp = new ArrayList<ComparableBST<T>>();
		temp.add(this);
		return bftravers(temp);
		
	}
	private ArrayList<T> bftravers(ArrayList<ComparableBST<T>> nodeQueue){
		
		if(nodeQueue!=null && nodeQueue.size()>0){
			ArrayList<T> retVal = new ArrayList<T>();
			
			retVal.add(nodeQueue.get(0).data);	
			ComparableBST<T> element = nodeQueue.remove(0);
			
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
	
	public int height() { return height(this); }
	
	public int height(ComparableBST<T> tr) { 
		if(tr==null) return 0;
		else return 1+Math.max(height(tr.left), height(tr.right));
	}
	
	public boolean heightBalanced(){
		if(this.data==null || (Math.abs(this.height(left)-this.height(right))<=1 && (this.left==null || this.left.heightBalanced()) && (this.right==null || this.right.heightBalanced()))) return true;
		
		return false;
	}

    /**
     * A main method supplied for any debugging needs
     */
    public static void main(String[] args) {
        // Up to you how you use this main method, feel free to change it
        
        ComparableBST<Integer> tree = new ComparableBST<>(3);
        
        tree.insert(8);
        tree.insert(1);
        tree.insert(0);
        tree.insert(3);
        tree.insert(9);
        tree.insert(4);
        tree.prettyPrint();
    }
    
}

