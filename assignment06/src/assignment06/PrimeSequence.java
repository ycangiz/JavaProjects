package assignment06;

public class PrimeSequence implements Sequence{



public boolean isPrime(int x){
    for (int i = 2; i <= Math.sqrt(x); i++){
        if (x % i == 0){
            return false;
        }
    }
    return true;
}

public int next()
{
	return 0;
}
}

