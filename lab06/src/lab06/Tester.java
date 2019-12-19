package lab06;

import java.util.ArrayList;
import java.util.Arrays;
import lab06.Child;
import lab06.OneInt;
import lab06.Parent;
import lab06.Partitioner;
import lab06.TwoInts;
import lab06.Zipper;

public class Tester {
    public static void main(String[] arrstring) {
        Tester.testInts();
        Tester.testPartitioner();
        Tester.testZipper();
    }

    public static void testInts() {
        OneInt oneInt = new OneInt(5);
        OneInt oneInt2 = new OneInt(3);
        TwoInts twoInts = new TwoInts(29, 5);
        TwoInts twoInts2 = new TwoInts(2, 4);
        ArrayList<OneInt> arrayList = new ArrayList<OneInt>();
        arrayList.add((OneInt)oneInt);
        arrayList.add((OneInt)oneInt2);
        arrayList.add((OneInt)twoInts);
        arrayList.add((OneInt)twoInts2);
        System.out.println("expected 48, got " + OneInt.sumAll(arrayList));
    }

    public static void testPartitioner() {
        Partitioner partitioner = new Partitioner();
        Parent[] arrparent = new Parent[]{new Parent(), new Parent(), new Child(), new Parent(), new Child()};
        partitioner.partition(arrparent);
        Object[] arrobject = partitioner.getParents();
        Object[] arrobject2 = partitioner.getChildren();
        System.out.println("Parents: " + Arrays.toString(arrobject));
        System.out.println("Children: " + Arrays.toString(arrobject2));
    }

    public static void testZipper() {
        int[] arrn = Zipper.zip((int[])new int[]{1, 3, 5, 7}, (int[])new int[]{2, 4, 6, 8});
        System.out.println("Expecting {1, 2, 3, 4, 5, 6, 7, 8}");
        System.out.println("Received " + Arrays.toString(arrn));
    }
}
