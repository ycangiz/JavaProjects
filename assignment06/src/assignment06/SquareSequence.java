package assignment06;

public class SquareSequence implements Sequence
{
   private int n;

   public int next()
   {
      return n * n++; 
   }
}
