package lab10;

import java.util.Comparator;

public class Bonus<T> extends BinarySearchTree<T> {
	 
	public Bonus(Comparator<T> comp) {
		super(comp);
	}

	public static void main(String[] args){
		Comparator<String> strComp = (i, j) -> i.length() - j.length(); // lambda expression
        BinarySearchTree<String> tree = new BinarySearchTree<>(strComp);
        tree.insert("abcde");
        tree.insert("acdegfh");
        tree.insert("abcdefg");
        tree.insert("abcdef");
        tree.insert("abc");
        tree.insert("abcde");
        tree.insert("abcd");
        tree.prettyPrint();
	}
	
}
