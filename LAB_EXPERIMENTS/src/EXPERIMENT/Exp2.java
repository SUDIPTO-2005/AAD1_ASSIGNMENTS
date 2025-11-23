package EXPERIMENT;

import java.util.Scanner;
import java.util.Arrays;

public class Exp2 {

    public static int sum(int[] arr) {
        return sumRecursive(arr, arr.length - 1);
    }
    
    private static int sumRecursive(int[] arr, int index) {
        if (index < 0) {
            return 0; 
        }
        return arr[index] + sumRecursive(arr, index - 1);
    }
    
    public static long fact(int n) {
        if (n == 0 || n == 1)
            return 1;
        return n * fact(n - 1);
    }

    public static int fibo(int n) {
        if (n <= 1)
            return n;
        return fibo(n - 1) + fibo(n - 2);
    }

    public static int linear(int[] arr, int key) {
        return linearRecursive(arr, key, 0);
    }
    
    private static int linearRecursive(int[] arr, int key, int index) {
        if (index >= arr.length) {
            return -1;
        }
        if (arr[index] == key) {
            return index;
        }
        return linearRecursive(arr, key, index + 1);
    }

    public static int bin(int[] arr2, int ele) {
        return binRecursive(arr2, ele, 0, arr2.length - 1);
    }
    
    private static int binRecursive(int[] arr, int ele, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (arr[mid] == ele) {
            return mid;
        } 
        if (arr[mid] < ele) {
            return binRecursive(arr, ele, mid + 1, high);
        } 
        return binRecursive(arr, ele, low, mid - 1);
    }
    
    private static final char[] HEX_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String decimalToHex(int decimal) {
        if (decimal == 0) {
            return ""; 
        }
        int remainder = decimal % 16;
        return decimalToHex(decimal / 16) + HEX_CHARS[remainder];
    }
   
    public static void towerOfHanoi(int n, int from_rod, int to_rod, int aux_rod) {
        if (n == 0) {
            return;
        }
        if (n == 1) {
            System.out.println("Move disk 1 from rod " + from_rod + " to rod " + to_rod);
            return;
        }
        towerOfHanoi(n - 1, from_rod, aux_rod, to_rod);
        System.out.println("Move disk " + n + " from rod " + from_rod + " to rod " + to_rod);
        towerOfHanoi(n - 1, aux_rod, to_rod, from_rod);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a; 
            
            while (true) {
                System.out.println("\n********** RECURSIVE MENU (EXP-02) **********");
                System.out.println("1-> SUM OF ARRAY NUMBERS (Recursive)"); 
                System.out.println("2-> FACTORIAL OF A NUMBER (Recursive)");
                System.out.println("3-> GENERATE NTH FIBONACII NUMBER (Recursive)");
                System.out.println("4-> LINEAR SEARCH (Recursive)");
                System.out.println("5-> BINARY SEARCH (Recursive)");
                System.out.println("6-> DECIMAL TO HEXADECIMAL (Recursive)");
                System.out.println("7-> TOWER OF HANOI (Recursive)");
                System.out.println("8-> EXIT");
                System.out.print("Enter your choice: ");
                
                if (!sc.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number.");
                    sc.next();
                    continue;
                }
                a = sc.nextInt();
                
                System.out.println("--------------------------------------------------");

                if (a == 8) { 
                    System.out.println("Exiting program. Goodbye!");
                    break;      
                }

                switch(a) {
                    case 1:
                    	System.out.println("enter size of a array");
                		int n=sc.nextInt();
                		int arr[]=new int[n];
                			System.out.println("enter the values ");
                			for(int i=0;i<n;i++)
                				arr[i]=sc.nextInt();
                			System.out.println("sum of  numbers of an array="+sum(arr));
                			break;

                    case 2:
                        System.out.print("Enter value of N to find the factorial: ");
                        int NFact = sc.nextInt();
                        if (NFact < 0) {
                            System.out.println("Factorial is not defined for negative numbers.");
                        } else {
                            System.out.println("Factorial of " + NFact + " = " + fact(NFact));
                        }
                        break;
                    case 3:
                        System.out.print("Enter value of N for Fibonacci (Nth term): ");
                        int NFibo = sc.nextInt();
                        if (NFibo < 0) {
                            System.out.println("Fibonacci sequence index must be non-negative.");
                        } else {
                            System.out.println(NFibo + "th Fibonacci number = " + fibo(NFibo));
                        }
                        break;
                    case 4:
                        System.out.print("Input size of array: ");
                        int C = sc.nextInt();
                        int arr1[] = new int[C];
                        System.out.println("Enter the values:");
                        for(int i = 0; i < C; i++)
                            arr1[i] = sc.nextInt();
                        System.out.print("Enter element you want to search: ");
                        int key = sc.nextInt();
                        int linearResult = linear(arr1, key);
                        System.out.println("Array: " + Arrays.toString(arr1));
                        System.out.println("Element present at index -> " + linearResult + (linearResult == -1 ? " (Not Found)" : ""));
                        break;
                    case 5:
                        System.out.print("Input size of an array: ");
                        int f = sc.nextInt();
                        int arr2[] = new int[f];
                        System.out.println("Enter the values in SORTED form:");
                        for(int i = 0; i < f; i++)
                            arr2[i] = sc.nextInt();
                        System.out.print("Enter element you want to search: ");
                        int ele = sc.nextInt();
                        int binResult = bin(arr2, ele);
                        System.out.println("Array: " + Arrays.toString(arr2));
                        System.out.println("Element present at index -> " + binResult + (binResult == -1 ? " (Not Found)" : ""));
                        break;
                    case 6:
                        System.out.print("Enter a non-negative decimal integer: ");
                        int decimal = sc.nextInt();
                        if (decimal < 0) {
                            System.out.println("Input must be non-negative.");
                        } else if (decimal == 0) {
                            System.out.println("Decimal 0 in Hexadecimal is: 0");
                        } else {
                            String hexResult = decimalToHex(decimal);
                            System.out.println("Decimal " + decimal + " in Hexadecimal is: " + hexResult);
                        }
                        break;
                    case 7:
                        System.out.print("Enter the number of disks (N) for Tower of Hanoi: ");
                        int nDisks = sc.nextInt();
                        if (nDisks < 1) {
                             System.out.println("Number of disks must be 1 or more.");
                             break;
                        }
                        System.out.println("\nSteps to move " + nDisks + " disks from Rod 1 (Source) to Rod 3 (Destination):");
                        towerOfHanoi(nDisks, 1, 3, 2);
                        break;
                    default:
                        System.out.println("Invalid choice. Please select an option between 1 and 8.");
                }
            } 
        }
    }