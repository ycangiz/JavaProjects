package lab06;

import java.util.ArrayList;

public class OneInt {
    private int one;

    public OneInt(int n) {
        this.one = n;
    }

    public int sum() {
        return this.one;
    }

    public String toString() {
        return "" + this.one;
    }

    public static int sumAll(ArrayList<OneInt> arrayList) {
        int n = 0;
        if (arrayList == null) {
            return -1;
        }
        if (arrayList.size() <= 0) {
            return 0;
        }
        for (int i = 0; i < arrayList.size(); ++i) {
            if (arrayList.get(i) == null) continue;
            n += arrayList.get(i).sum();
        }
        return n;
    }
}