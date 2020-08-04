import java.util.*;

class Heap {
    public int[] HeapArray; // stores non-negative keys
    private int lastIndex = -1; // index of last element in HeapArray

    public Heap() {
        HeapArray = null;
    }

    // create HeapArray from given array
    // heapArray size based on depth
    public void MakeHeap(int[] a, int depth) {
        int arSize = (int) (Math.pow(2, (depth + 1))) - 1;
        HeapArray = new int[arSize];
        Arrays.fill(HeapArray, -1);
        for (int i : a) {
            Add(i);
        }
    }

    // return root value and rebuild heap
    public int GetMax() {
        if (lastIndex == -1) return -1; // if heap is empty
        int res = HeapArray[0];
        int indexTemp = 0;
        HeapArray[indexTemp] = -1;
        HeapArray[indexTemp] = HeapArray[lastIndex];
        HeapArray[lastIndex] = -1;
        while (true) {
            int indexLeftChild = 2 * indexTemp + 1;
            int indexRightChild = 2 * indexTemp + 2;
            int indexMaxChild = HeapArray[indexLeftChild] > HeapArray[indexRightChild] ? indexLeftChild : indexRightChild;
            if (HeapArray[indexMaxChild] > HeapArray[indexTemp]) {
                int el = HeapArray[indexTemp];
                HeapArray[indexTemp] = HeapArray[indexMaxChild];
                HeapArray[indexMaxChild] = el;
                indexTemp = indexMaxChild;
            } else break;
        }
        return res;
    }

    // add key in heap
    public boolean Add(int key) {
        if (key < 0) return false;
        int indexKey = 0;
        int indexParent;
        for (; indexKey < HeapArray.length; indexKey++) {
            if (HeapArray[indexKey] == key) return true;
            if (HeapArray[indexKey] == -1) {
                HeapArray[indexKey] = key;
                lastIndex = indexKey;
                break;
            }
        }
        if (indexKey == HeapArray.length) {
            lastIndex = indexKey - 1;
            return false;
        }
        // find greater parent
        indexParent = (indexKey - 1) / 2;
        while (HeapArray[indexParent] < HeapArray[indexKey]) {
            HeapArray[indexKey] = HeapArray[indexParent];
            HeapArray[indexParent] = key;
            indexKey = indexParent;
            indexParent = (indexKey - 1) / 2;
        }
        return true;
    }
}