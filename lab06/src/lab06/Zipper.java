package lab06;

public class Zipper {
    public static int[] zip(int[] arrn, int[] arrn2) {
        if (arrn == null || arrn2 == null || arrn.length != arrn2.length) {
            throw new IllegalArgumentException("bad input");
        }
        if (arrn.length == 0) {
            return arrn;
        }
        int[] arrn3 = new int[arrn.length + arrn2.length];
        int n = 0;
        for (int i = 0; i < arrn.length; i++) {
                arrn3[n] = arrn[i];
                arrn3[++n] = arrn2[i];
                n++;
               
        }
        return arrn3;
    }
}