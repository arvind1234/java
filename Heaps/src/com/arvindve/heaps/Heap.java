package com.arvindve.heaps;

public class Heap {
    int[] data;
    int size;

    public Heap() {
        data = new int[100];
        size = 0;
    }

    private int getParentIndex(int childIndex) {
        return ((childIndex - 1) / 2);
    }

    private int getLeftChildIndex(int parentIndex) {
        return parentIndex * 2 + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return parentIndex * 2 + 2;
    }

    private int getParentValue(int childIndex) {
        int parentIndex = getParentIndex(childIndex);
        return data[parentIndex];
    }

    private int getLeftChildValue(int parentIndex) {
        int leftChildIndex = getLeftChildIndex(parentIndex);
        return data[leftChildIndex];
    }

    private int getRightChildValue(int parentIndex) {
        int rightChildIndex = getRightChildIndex(parentIndex);
        return data[rightChildIndex];
    }

    private void insert(int n) {
        data[size] = n;
        size++;
        heapifyUp();
    }

    private void swap(int a, int b) {
        if (a >= 0 && a < size && b >= 0 && b < size) {
            int temp = data[a];
            data[a] = data[b];
            data[b] = temp;
        }
    }

    private void heapifyUp() {
        int i = size - 1;

        while(true) {
            int parentIndex = getParentIndex(i);
            if (parentIndex < 0) {
                break;
            }

            int parentValue = data[parentIndex];
            if (parentValue <= data[i]) {
                break;
            } else {
                swap(parentIndex, i);
                i = parentIndex;
            }
        }
    }

    private int pop() throws Exception {
        if (size <= 0) {
            throw new Exception("No data to pop");
        }

        int result = data[0];
        data[0] = data[--size];
        heapifyDown();
        return result;
    }

    private void heapifyDown() {
        int i = 0;
        while(true) {
            int leftChildIndex = getLeftChildIndex(i);
            int rightChildIndex = getRightChildIndex(i);

            if (leftChildIndex >= size && rightChildIndex >= size) {
                break;
            }

            int minIndex = data[leftChildIndex] < data[rightChildIndex] ? leftChildIndex : rightChildIndex; 

            if(data[i] < data[minIndex]) {
                break;
            }

            swap(i, minIndex);
            i = minIndex;
        }
    }

    private void printHeap() {
        String result = "";
        for (int i = 0; i < size; i++) {
            result += data[i] + ", ";
        }

        System.out.println(result);
    }

    public static void main(String[] args) {
        Heap h = new Heap();
        for (int i = 5; i > -1; i--) {
            h.insert(i);
            // h.printHeap();
        }

        h.printHeap();

        for (int i = 0; i < 7; i++) {
            try {
                System.out.println("Popped element: " + h.pop());
                h.printHeap();
            } catch (Exception e) {
                System.out.println("Heap is out of data");
            }
        }
    }

}
