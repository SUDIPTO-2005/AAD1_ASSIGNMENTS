package EXPERIMENT;
import java.util.Scanner;
import java.util.Arrays;
public class Exp5 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("**** HEAP OPERATIONS MENU ****");
            System.out.println("1. Check Min-Priority Queue");
            System.out.println("2. Increase Key in Max Heap");
            System.out.println("3. Find Kth Largest Element");
            System.out.println("4. Heap Sort");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    int[] arr1 = {1, 3, 2, 7, 4, 6, 5, 8};
                    System.out.println("Array: " + Arrays.toString(arr1));
                    if (isMinHeap(arr1, arr1.length))
                        System.out.println("YES, It is a Min-Priority Queue");
                    else
                        System.out.println("NO, It is not a Min-Priority Queue");
                    break;

                case 2:
                    int[] heap = {8, 5, 7, 4, 1, 6, 3, 2};
                    buildMaxHeap(heap, heap.length);
                    System.out.println("Max Heap: " + Arrays.toString(heap));
                    System.out.print("Enter index to increase key: ");
                    int idx = sc.nextInt();
                    System.out.print("Enter new key value: ");
                    int key = sc.nextInt();
                    increaseKey(heap, idx, key);
                    System.out.println("Updated Heap: " + Arrays.toString(heap));
                    break;

                case 3:
                    int[] arr3 = {12, 3, 5, 7, 19, 4};
                    System.out.print("Enter k: ");
                    int k = sc.nextInt();
                    int kth = findKthLargest(arr3, k);
                    System.out.println(k + "th largest element is: " + kth);
                    break;

                case 4:
                    int[] arr4 = {4, 10, 3, 5, 1};
                    System.out.println("Before Sorting: " + Arrays.toString(arr4));
                    heapSort(arr4);
                    System.out.println("After Heap Sort: " + Arrays.toString(arr4));
                    break;

                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again!");
            }

        } while (choice != 5);
    }
    public static boolean isMinHeap(int[] arr, int n) {
        for (int i = 0; i <= (n - 2) / 2; i++) {
            if (arr[i] > arr[2 * i + 1]) 
            	return false;
            if (2 * i + 2 < n && arr[i] > arr[2 * i + 2]) 
            	return false;
        }
        return true;
    }

    public static void increaseKey(int[] heap, int i, int newKey) {
        if (newKey < heap[i]) {
            System.out.println("New key is smaller than current key.");
            return;
        }
        heap[i] = newKey;
        while (i > 0 && heap[parent(i)] < heap[i]) {
            int temp = heap[i];
            heap[i] = heap[parent(i)];
            heap[parent(i)] = temp;
            i = parent(i);
        }
    }

    private static int parent(int i) {
        return (i - 1) / 2;
    }

    public static void buildMaxHeap(int[] arr, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    public static void heapify(int[] arr, int n, int i) {
        int l = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[l]) 
        	l = left;
        if (right < n && arr[right] > arr[l]) 
        	l = right;

        if (l != i) {
            int temp = arr[i];
            arr[i] = arr[l];
            arr[l] = temp;
            heapify(arr, n, l);
        }
    }

    public static int findKthLargest(int[] arr, int k) {
        buildMaxHeap(arr, arr.length);
        int size = arr.length;

        for (int i = 1; i < k; i++) {
            arr[0] = arr[size - 1];
            size--;
            heapify(arr, size, 0);
        }
        return arr[0];
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;
        buildMaxHeap(arr, n);
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    
}


