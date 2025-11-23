package EXPERIMENT;

import java.util.Scanner;
public class Exp3 {

	    public static void selectionSort(int[] arr) {
	        for (int i = 0; i < arr.length; i++) {
	            int minIdx = i;
	            for (int j = i + 1; j < arr.length; j++) {
	                if (arr[j] < arr[minIdx]) {
	                    minIdx = j;
	                }
	            }
	            int temp = arr[i];
	            arr[i] = arr[minIdx];
	            arr[minIdx] = temp;
	        }
	        printArray(arr);
	    }

	    public static void arrayReduction(int[] arr) {
	        int[] copy = arr.clone();
	        int n = copy.length;
	        boolean[] visited = new boolean[n];

	        while (true) {
	            int min = Integer.MAX_VALUE;
	            int count = 0;

	            for (int i = 0; i < n; i++) {
	                if (!visited[i] && copy[i] > 0 && copy[i] < min) {
	                    min = copy[i];
	                }
	            }

	            if (min == Integer.MAX_VALUE) break;

	            for (int i = 0; i < n; i++) {
	                if (!visited[i] && copy[i] > 0) {
	                    copy[i] -= min;
	                    count++;
	                    if (copy[i] == 0) visited[i] = true;
	                }
	            }

	            System.out.println(count);
	        }
	    }

	    public static void mergeSortedArrays(int[] a, int[] b) {
	        int[] merged = new int[a.length + b.length];
	        for (int i = 0; i < a.length; i++) merged[i] = a[i];
	        for (int i = 0; i < b.length; i++) merged[a.length + i] = b[i];
	        selectionSort(merged);
	    }


	    public static boolean checkReverse(int[] arr) {
	        int n = arr.length;
	        int i = 0;

	        while (i < n - 1 && arr[i] <= arr[i + 1]) i++;
	        if (i == n - 1) return true;

	        int j = i;
	        while (j < n - 1 && arr[j] >= arr[j + 1]) j++;

	        reverse(arr, i, j);
	        boolean sorted = isSorted(arr);
	        reverse(arr, i, j);
	        return sorted;
	    }

	    private static void reverse(int[] arr, int i, int j) {
	        while (i < j) {
	            int temp = arr[i];
	            arr[i++] = arr[j];
	            arr[j--] = temp;
	        }
	    }

	    private static boolean isSorted(int[] arr) {
	        for (int i = 0; i < arr.length - 1; i++) {
	            if (arr[i] > arr[i + 1]) return false;
	        }
	        return true;
	    }

	    public static Integer firstRepeated(int[] arr) {
	        for (int i = 0; i < arr.length; i++) {
	            for (int j = i + 1; j < arr.length; j++) {
	                if (arr[i] == arr[j]) return arr[i];
	            }
	        }
	        return null;
	    }

	    public static void printDuplicates(int[] arr) {
	        boolean[] printed = new boolean[arr.length];
	        for (int i = 0; i < arr.length; i++) {
	            if (printed[i]) continue;
	            boolean isDuplicate = false;
	            for (int j = i + 1; j < arr.length; j++) {
	                if (arr[i] == arr[j]) {
	                    isDuplicate = true;
	                    printed[j] = true;
	                }
	            }
	            if (isDuplicate) {
	                System.out.println("Duplicate: " + arr[i]);
	            }
	        }
	    }

	    public static int findMissing(int[] arr) {
	        int n = arr.length + 1;
	        int total = n * (n + 1) / 2;
	        for (int value : arr) total -= value;
	        return total;
	    }

	    public static void minMaxDiff(int[] arr) {
	        int[] sorted = arr.clone();
	        selectionSort(sorted);

	        int minDiff = Integer.MAX_VALUE, maxDiff = Integer.MIN_VALUE;
	        int minA = 0, minB = 0, maxA = 0, maxB = 0;

	        for (int i = 0; i < sorted.length - 1; i++) {
	            int diff = sorted[i + 1] - sorted[i];
	            if (diff < minDiff) {
	                minDiff = diff;
	                minA = sorted[i];
	                minB = sorted[i + 1];
	            }
	            if (diff > maxDiff) {
	                maxDiff = diff;
	                maxA = sorted[i];
	                maxB = sorted[i + 1];
	            }
	        }

	        System.out.println("Min Diff Pair: (" + minA + ", " + minB + ")");
	        System.out.println("Max Diff Pair: (" + maxA + ", " + maxB + ")");
	    }

	    public static int mostFrequent(int[] arr) {
	        int maxCount = 0, result = arr[0];

	        for (int i = 0; i < arr.length; i++) {
	            int count = 1;
	            for (int j = i + 1; j < arr.length; j++) {
	                if (arr[j] == arr[i]) count++;
	            }
	            if (count > maxCount) {
	                maxCount = count;
	                result = arr[i];
	            }
	        }

	        return result;
	    }

	    public static int sumOfDistinct(int[] arr) {
	        int sum = 0;
	        for (int i = 0; i < arr.length; i++) {
	            boolean isDuplicate = false;
	            for (int j = 0; j < i; j++) {
	                if (arr[i] == arr[j]) {
	                    isDuplicate = true;
	                    break;
	                }
	            }
	            if (!isDuplicate) sum += arr[i];
	        }
	        return sum;
	    }

	    public static void printArray(int[] arr) {
	        System.out.print("Array: ");
	        for (int i : arr) System.out.print(i + " ");
	        System.out.println();
	    }

	    public static int[] readArray(Scanner sc) {
	        System.out.print("Enter number of elements: ");
	        int n = sc.nextInt();
	        int[] arr = new int[n];
	        System.out.println("Enter " + n + " integers:");
	        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
	        return arr;
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int choice;

	        do {
	            System.out.println("\n==== MENU ====");
	            System.out.println("1. Selection Sort");
	            System.out.println("2. Array Reduction");
	            System.out.println("3. Merge Two Sorted Arrays");
	            System.out.println("4. Check Reverse to Sort");
	            System.out.println("5. First Repeated Element");
	            System.out.println("6. Print Duplicates");
	            System.out.println("7. Find Missing Number");
	            System.out.println("8. Min/Max Difference Pair");
	            System.out.println("9. Most Frequent Element");
	            System.out.println("10. Sum of Distinct Elements");
	            System.out.println("0. Exit");
	            System.out.print("Enter your choice: ");
	            choice = sc.nextInt();
	            while(true) {
	            switch (choice) {
	                case 1:
	                    selectionSort(readArray(sc));
	                    break;
	                case 2:
	                    arrayReduction(readArray(sc));
	                    break;
	                case 3:
	                    System.out.println("Enter first sorted array:");
	                    int[] a = readArray(sc);
	                    System.out.println("Enter second sorted array:");
	                    int[] b = readArray(sc);
	                    mergeSortedArrays(a, b);
	                    break;
	                case 4:
	                    System.out.println("Can be sorted by reverse? " + checkReverse(readArray(sc)));
	                    break;
	                case 5:
	                    Integer repeated = firstRepeated(readArray(sc));
	                    System.out.println("First Repeated Element: " + (repeated != null ? repeated : "None"));
	                    break;
	                case 6:
	                    printDuplicates(readArray(sc));
	                    break;
	                case 7:
	                    System.out.println("Missing Number: " + findMissing(readArray(sc)));
	                    break;
	                case 8:
	                    minMaxDiff(readArray(sc));
	                    break;
	                case 9:
	                    System.out.println("Most Frequent Element: " + mostFrequent(readArray(sc)));
	                    break;
	                case 10:
	                    System.out.println("Sum of Distinct Elements: " + sumOfDistinct(readArray(sc)));
	                    break;
	                case 0:
	                    System.out.println("Exiting...");
	                    break;
	                default:
	                    System.out.println("Invalid choice! Try");
	            }
	        }
	            
	   }
	        while (choice != 0);
}
}

	    