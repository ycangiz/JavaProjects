package lab06;

import lab06.OneInt;

public class TwoInts
extends OneInt {
    private int two;

    public TwoInts(int n, int n2) {
        super(n);
        this.two = n2;
    }

    public int sum() {
        return super.sum() + this.two;
    }

    public String toString() {
        return "(" + super.toString() + "," + this.two + ")";
    }
}