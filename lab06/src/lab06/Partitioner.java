package lab06;

import lab06.Child;
import lab06.Parent;

public class Partitioner {
    private Parent[] parents;
    private Child[] children;

    public Parent[] getParents() {
        return this.parents;
    }

    public Child[] getChildren() {
        return this.children;
    }

    public void partition(Parent[] arrparent) {
        int n;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        for (n = 0; n < arrparent.length; ++n) {
            if (arrparent[n].isChild()) {
                ++n2;
                continue;
            }
            ++n3;
        }
        this.parents = new Parent[n3];
        this.children = new Child[n2];
        for (n = 0; n < arrparent.length; ++n) {
            if (arrparent[n].isChild()) {
                this.children[n4++] = (Child)arrparent[n];
                continue;
            }
            this.parents[n5++] = arrparent[n];
        }
    }
}