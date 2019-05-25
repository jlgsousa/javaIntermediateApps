package converter.xml;

import java.util.BitSet;
import java.util.List;

public class AllSubsetsInAset {

    public static void main(String[] args) {
        int[] array = {1,2,3,4};

        printAllSubsets(array);
    }

    private static void printTreeLeaves(int[] array, List<Integer> node, int n) {
        if (n == array.length) {
            printNode(node);
            node.add(array[n-1]);
            printNode(node);
        } else {
            printTreeLeaves(array, node, n+1);
            node.add(array[n-1]);
            printTreeLeaves(array, node, n+1);
        }
    }

    private static void printNode(List<Integer> node) {
        for (Integer i : node) {
            System.out.print(i);
        }
        System.out.println();
    }

    private static void printAllSubsets(int[] arr) {
        boolean[] counter = new boolean[arr.length];
        BitSet bitSet = new BitSet(arr.length);

        while (true) {
            printCounter(arr, bitSet);

            // Increment counter
//            int i = 0;
//            while (i < counter.length && counter[i]) {
//                counter[i++] = false;
//            }

            int index = 0;
            for (int j = 0; j < arr.length; j++) {
                if (bitSet.get(j)) {
                    bitSet.set(j, false);
                    index = j + 1;
                } else {
                    break;
                }
            }

            if (index == counter.length) {
                break;
            }

            bitSet.set(index);
        }
    }

    private static void printCounter(int[] arr, BitSet bitSet) {

        for (int i = 0; i < bitSet.size(); i++) {
            if (bitSet.get(i))
                System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
