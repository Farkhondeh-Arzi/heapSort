import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        String string = scanner.nextLine();
        String[] splitted = string.split(" ");

        for (String s : splitted) {
            arr.add(Integer.parseInt(s));
        }

        HeapSort sort = new HeapSort(arr);
        sort.sort();
        sort.printArray();
    }
}

class HeapSort {

    ArrayList<Integer> arr;

    public HeapSort(ArrayList<Integer> arr) {
        this.arr = arr;
    }

    public void sort() {
        int size = arr.size();

        for (int i = size / 2 - 1; i >= 0; i--) heapify(size, i);

        for (int i = size - 1; i > 0; i--) {
            Collections.swap(arr, 0, i);

            heapify(i, 0);
        }
    }

    void heapify(int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr.get(l) > arr.get(largest))
            largest = l;

        if (r < n && arr.get(r) > arr.get(largest))
            largest = r;

        if (largest != i) {
            Collections.swap(arr, i, largest);

            heapify(n, largest);
        }
    }

    void printArray() {
        System.out.print("[");
        for (int i = 0; i < arr.size(); i++) {
            if (i == arr.size() - 1) System.out.print(arr.get(i));
            else System.out.print(arr.get(i) + ", ");
        }
        System.out.println("]");
    }
}
