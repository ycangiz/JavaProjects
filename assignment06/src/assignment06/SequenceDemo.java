package assignment06;

public class SequenceDemo{
   public static void main(String[] args){
	   
	  System.out.println("SquareSequence.java test. With LastDigitDistribution.");
      LastDigitDistribution dist1 = new LastDigitDistribution();
      dist1.process(new SquareSequence(), 1000);
      dist1.display();
      System.out.println();

      System.out.println("RandomSequence.java test. With LastDigitDistribution.");
      LastDigitDistribution dist2 = new LastDigitDistribution();
      dist2.process(new RandomSequence(), 1000);
      dist2.display();
      System.out.println();
      
      System.out.println("PrimeSequence.java test. 100 prime number should have been printed.");
      PrimeSequence prime = new PrimeSequence();

      int count = 2;
      int primeNum = 0;

      while (primeNum < 100) {
          if (prime.isPrime(count)){
              primeNum++;

              System.out.printf(count + " ");
          }
          count++;
       }System.out.println("\n");
       
       System.out.println("FirstDigitDistribution.java test. With SquareSequence.java. int valuesToProcess adjusted to 10 "
       		+ "due to easy observation");
       FirstDigitDistribution dist3 = new FirstDigitDistribution();
       dist3.process(new SquareSequence(), 10);
       dist3.display();
       System.out.println();
   }
}

