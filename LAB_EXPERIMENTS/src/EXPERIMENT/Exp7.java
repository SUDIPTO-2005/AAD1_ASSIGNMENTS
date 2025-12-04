package EXPERIMENT;
import java.util.Scanner;
class Astack{
	int t=-1;
	int n;
	int arr[];
	Astack(int n){
		this.n=n;
		arr=new int[n];
	}
	boolean isempty() {
		return t==-1;
	}
	boolean isfull() {
		return t==n-1;
	}
	void push(int x) {
		if (isfull()) {
			System.out.println("Stack Overflow");
		}else {
			arr[++t]=x;
		}
	}
	int pop() {
		if (isempty()) {
			System.out.println("Stack Underflow");
			return -1;
		}else {
			return arr[t--];
		}
	}
	void display() {
		if(isempty()) {
			System.out.println("Stack is Empty");
			return;
		}else {
			for(int i=0;i<=t;i++) {
				System.out.print(arr[i]);
				System.out.println();
			}
		}
	}
}
class Node{
	int data;
	Node next;
	Node(int data){
		this.data=data;
	}
}
class Lstack {
	Node top=null;
	boolean isempty() {
		return top==null;
	}
	void push(int x) {
		Node p=new Node(x);
		p.next=top;
		top=p;
	}
	int pop() {
		if  (isempty()) {
			System.out.println("Stack Underflow");
			return -1;
		}else {
			int x=top.data;
			top=top.next;
			return x;
		}
	}
	void display() {
		if(isempty()) {
			System.out.println("Stack Underflow");
			return;
		}else {
			Node p=top;
			System.out.println("Stack:");
			while(p!=null) {
				System.out.print(p.data+"-->");
				p=p.next;
			}
			System.out.println();
		}
	}
	
}
class fun{
	static void insSort(Astack s,int x) {
		if (s.isempty()) {
			s.push(x);
			return;
		}
		int y=s.pop();
		insSort(s,x);
		s.push(y);
	}
	static void sort(Astack s) {
		if (s.isempty()) {
			return;
		}else {
			int x=s.pop();
			sort(s);
			insSort(s,x);
		}
	}
	static void insBot(Astack s,int x) {
		if(s.isempty()) {
			s.push(x);
			return;
		}else {
			int y=s.pop();
			insBot(s,x);
			s.push(y);
		}
	}
	static void rev(Astack s) {
		if(s.isempty()) {
			return;
		}else {
			int x=s.pop();
			rev(s);
			insBot(s,x);
		}
	}
}

public class Exp7 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Astack as=new Astack(50);
		Lstack ls=new Lstack();
		System.out.println("******************************");
		System.out.println("         MENU                 ");
		System.out.println("******************************");
		System.out.println("1.Push into Array Stack");
		System.out.println("2.Pop into Array Stack");
		System.out.println("3.Display the Array Stack");
		System.out.println("4.Push into Linkedlist Stack");
		System.out.println("5.Pop into Linkedlist Stack");
		System.out.println("6.Display into Linkedlist Stack");
		System.out.println("7.Insert Sorted(Array)");
		System.out.println("8.Sort Stack(Array");
		System.out.println("9.Insert Bottom(Stack)");
		System.out.println("10.Reverse Stack(Array)");
		System.out.println("11.Exit");
		while(true) {
			System.out.println("Enter your choice");
			int ch=sc.nextInt();
			switch(ch) {
			case 1:
				System.out.print("Value:-");
				as.push(sc.nextInt());
				break;
			case 2:
				System.out.println("Popped value is"+as.pop());
				break;
			case 3:
				System.out.println("Values in Array Stack are:-");
				as.display();
				break;
			case 4:
				System.out.println("Value:-");
				ls.push(sc.nextInt());
				break;
			case 5:
				System.out.println("Popped value is"+ls.pop());
				break;
			case 6:
				System.out.println("Values in Linkedlist Stack are:-");
				ls.display();
				break;
			case 7:
				System.out.println("Value:-");
				fun.insSort(as,sc.nextInt());
				break;
			case 8:
				fun.sort(as);
				System.out.println("Sorted");
				break;
			case 9:
				System.out.println("Value:-");
				fun.insBot(as,sc.nextInt());
				break;
			case 10:
				fun.rev(as);
				System.out.println("Reversed");
				break;
			case 11:
				System.out.println("Exiting.....");
				break;
			default:
				System.out.println("Invalid Choice");
			}
		}
	}
}
