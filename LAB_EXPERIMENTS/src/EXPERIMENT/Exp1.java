package EXPERIMENT;
import java.util.Scanner;
public class Exp1 {
public static int sum(int[] arr) {
	int sum=0;
	for(int i=0;i<arr.length;i++)
		sum=sum+arr[i];
	return sum;
}
public static int fact(int n) {
	int pro=1;
	if(n==0)
		return 1;
	for(int i=1;i<=n;i++)
		pro=pro*i;
	return pro;
}
public static int fibo(int n) {
	int a=0,b=1,c=0;
	for(int i=1;i<n;i++) {
	c=a+b;
	a=b;
	b=c;
	}
	return c;
}
public static int linear(int[] arr,int key) {
	int ind=-1;
	for (int i=0;i<arr.length;i++) {
		if(arr[i]==key)
			ind=i;
	}
	return ind;
}
public static int bin(int[] arr2,int ele) {
	int l=0;
	int h=arr2.length-1;
	while(l<=h) {
		int mid=(l+h)/2;
		if(arr2[mid]==ele) {
			return mid;		
		}
		if(arr2[mid]<ele) {
			l=mid+1;
			h=h;
		}
		else if(arr2[mid]>ele){
			h=mid-1;
		l=l;
		}
	}
		return -1;	
}
	public static void main(String[] args) {
		System.out.println("*****MENU*****");
		System.out.println("1->SUM OF N NO.S");
		System.out.println("2->FACTORIL OF A NUMBER");
		System.out.println("3->GENERATE NTH FIBONACII NUMBER");
		System.out.println("4->LINEAR SEARCH");
		System.out.println("5->BINARY SEARCH");
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		switch(a) {
		case 1:System.out.println("enter size of a array");
		int n=sc.nextInt();
		int arr[]=new int[n];
			System.out.println("enter the values ");
			for(int i=0;i<n;i++)
				arr[i]=sc.nextInt();
			System.out.println("sum of  numbers of an array="+sum(arr));
			break;
		case 2:System.out.println("enter value of n to find the factorial");
		int N=sc.nextInt();
		System.out.println("factorial of "+N+" ="+fact(N));
		break;
		case 3:
			System.out.println("enter value of n:");
			int v=sc.nextInt();
			System.out.println("nth fibonacii number="+fibo(v));
			break;
		case 4:
			System.out.println("input size of a array");
			int C=sc.nextInt();
			int arr1[]=new int[C];
				System.out.println("enter the values ");
				for(int i=0;i<C;i++)
					arr1[i]=sc.nextInt();
				System.out.println("enter element u want to sarch");
				int key=sc.nextInt();
				System.out.println("element present in index number->"+linear(arr1,key));
				break;
		case 5:System.out.println("input size of an array");
		int f=sc.nextInt();
		int arr2[]=new int[f];
			System.out.println("enter the values in sorted form ");
			for(int i=0;i<f;i++)
				arr2[i]=sc.nextInt();
			System.out.println("enter element u want to sarch");
			int ele=sc.nextInt();
			System.out.println("element present at->"+bin(arr2,ele));
		}
	}
}
