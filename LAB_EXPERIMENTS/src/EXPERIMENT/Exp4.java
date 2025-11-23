package EXPERIMENT;
import java.util.Scanner;
import java.util.Arrays;
public class Exp4 {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("******MENU********");
		System.out.println("1.To check if an Array is Sorted");
		System.out.println("2.To find pairs with given difference");
		System.out.println("3.To find kth smallest elements in an Array");
		System.out.println("4.To find pair whose sum equals rest of array");
		System.out.println("5.Count possible traingles");
		System.out.println("6.Good Bye");
		System.out.println("Enter your choice");
		int n=sc.nextInt();
		switch(n) {
		case 1:
			checkSorted();
			break;
		case 2:
			findpairswithdiff();
			break;
		case 3:
			findkthsmallest();
			break;
		case 4:
			pairequalSum();
			break;
		case 5:
			countTriangle();
			break;
		case 6:
			System.out.println("Exiting....");
			break;
		default:
			System.out.println("Invalid Choice");
		}
	}
	public static int[] createArray() {
		System.out.println("Enter the no of element");
		int n=sc.nextInt();
		int a[]=new int[n];
		System.out.println("Enter the elemet");
		for(int i=0;i<n;i++) {
			a[i]=sc.nextInt();
		}
		return a;
	}
	public static void checkSorted() {
		int a[]=createArray();
		boolean asc=true,dsc=true;
		for(int i=0;i<a.length-1;i++) {
			if(a[i]>a[i+1]) {
				asc=false;
			}
			if(a[i]<a[i+1]) {
				dsc=false;
			}
		}
		if(asc) {
			System.out.println("Yes,ascending");
		}else if(dsc) {
			System.out.println("Yes,descending");
		}else {
			System.out.println("No");
		}
	}
	public static void findpairswithdiff() {
		int X[]=createArray();
		int Y[]=createArray();
		System.out.println("Enter the value");
		int v=sc.nextInt();
		for(int i=0;i<X.length;i++) {
			for(int j=0;j<Y.length;j++) {
				if(X[i]-Y[j]==v||Y[j]-X[i]==v) {
					System.out.println("("+X[i]+","+Y[j]+")");
				}
			}
		}
	}
	public static void findkthsmallest() {
		int a[]=createArray();
		System.out.println("Enter the value of k");
		int k=sc.nextInt();
		Arrays.sort(a);
		System.out.println("kth smallest element is"+a[k-1]);		
	}
	public static void pairequalSum() {
		int a[]=createArray();
		int t=0;
		for(int i=0;i<a.length;i++) {
			t+=a[i];
		}
		boolean found=false;
		for(int i=0;i<a.length;i++) {
			for(int j=i+1;j<a.length;j++) {
				if(a[i]+a[j]==t-a[i]-a[j]) {
					System.out.println("Pair"+a[i]+","+a[j]);
					found=true;
				}
			}
		}
		if (!found) {
			System.out.println("No such pair found");
		}
	}
	public static void countTriangle() {
		int a[]=createArray();
		Arrays.sort(a);
		int c=0;
		for(int i=a.length-1;i>=1;i--) {
			int l=0,r=i-1;
			while(l<r) {
				if(a[l]+a[r]>a[i]) {
					c+=(r-l);
					r--;
				}else {
					l++;
				}
			}
		}
		System.out.println("No of possible triangles"+c);
	}
}
