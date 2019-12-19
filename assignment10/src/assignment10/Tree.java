package assignment10;
import java.util.List;
import java.util.ArrayList;

/**
   A tree in which each node has an arbitrary number of children.
 * @param <T>
*/
public class Tree
{
   private Node root;

   class Node
   {
      public Object data;
      public List<Node> children;

      /**
         Computes the size of the subtree whose root is this node.
         @return the number of nodes in the subtree
      */
      public int size()
      {
         int sum = 0;
         for (Node child : children) { sum = sum + child.size(); }
         return 1 + sum;
      }
   }

   /**
      Constructs an empty tree.
   */
   public Tree()
   {
      root = null;
   }

   /**
      Constructs a tree with one node and no children.
      @param rootData the data for the root
   */
   public Tree(Object rootData)
   {
      root = new Node();
      root.data = rootData;
      root.children = new ArrayList<>();
   }

   /**
      Adds a subtree as the last child of the root.
   */
   public void addSubtree(Tree subtree)
   {
      root.children.add(subtree.root);
   }

   /**
      Computes the size of this tree.
      @return the number of nodes in the tree
   */
   public int size() 
   {
      if (root == null) { return 0; }
      else { return root.size(); }
   }

   // Additional methods will be added in later sections.
   public ArrayList<Object> bftravers(){
		ArrayList<Node> temp = new ArrayList<Node>();
		temp.add(this.root);
		return bftravers(temp);
		
	}
	private ArrayList<Object> bftravers(ArrayList<Node> nodeQueue){
		
		if(nodeQueue!=null && nodeQueue.size()>0){
			ArrayList<Object> retVal = new ArrayList<Object>();
		
			if(root.size()>0){
				retVal.add(nodeQueue.get(0).data);	
				Node element = nodeQueue.remove(0);
				
				if(element.children!=null){
					for(Node child: element.children){
						nodeQueue.add(child);
					}
				}
				retVal.addAll(bftravers(nodeQueue));				
				return retVal;
			};
		}		
		return new ArrayList<Object>();
	}
}
