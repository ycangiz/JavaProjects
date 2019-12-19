package assignment10;
/**
   This class demonstrates the tree class.
*/
public class TreeDemo
{
   public static void main(String[] args)
   {
      Tree t1 = new Tree("Anne");
      Tree t2 = new Tree("Peter");
      t1.addSubtree(t2);
      Tree t3 = new Tree("Zara");
      t1.addSubtree(t3);
      Tree t35 = new Tree("Jack");
      t1.addSubtree(t35);
      Tree t4 = new Tree("Savannah");
      t2.addSubtree(t4);
      Tree t5 = new Tree("Harrison");
      t2.addSubtree(t5);
      Tree t6 = new Tree("Cameron");
      t3.addSubtree(t6);
      Tree t7 = new Tree("Ellysa");
      t3.addSubtree(t7);
      Tree t8 = new Tree("Cane");
      t3.addSubtree(t8);
      Tree t9 = new Tree("Donald");
      t35.addSubtree(t9);
      Tree t10 = new Tree("Katrin");
      t35.addSubtree(t10);
      Tree t11 = new Tree("Alex");
      t35.addSubtree(t11);
      System.out.println("Size: " + t1.size());
      System.out.println(t1.bftravers());
   }
}
