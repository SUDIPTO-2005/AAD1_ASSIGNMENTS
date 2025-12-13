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
		if (s.isempty() || s.arr[s.t] <= x) {
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
		System.out.println("1.Array Stack Operation");
		System.out.println("2.Linkedlist Stack Operation");
		System.out.println("3.Insert Sorted(Array)");
		System.out.println("4.Sort Stack(Array)");
		System.out.println("5.Insert Bottom(Stack)");
		System.out.println("6.Reverse Stack(Array)");
		System.out.println("7.Exit");
		while(true) {
			System.out.println("Enter your choice:");
			int ch=sc.nextInt();
			switch(ch) {
			case 1:
				System.out.println("Array Stack Menu:-");
				System.out.println("1.PUSH");
				System.out.println("2.POP");
				System.out.println("3.DISPLAY");
				System.out.println("4.Back to Main Menu");
				while(true) {
					System.out.println("Enter your choice for Array Stack Operation");
					int c=sc.nextInt();
					if (c==4)
						break;	
					switch(c) {
					case 1:
						System.out.println("Value");
						as.push(sc.nextInt());
						break;
					case 2:
						System.out.println("Popped Value:"+as.pop());
						break;
					case 3:
						System.out.println("Array Stack:");
						as.display();
						break;
					default:
						System.out.println("Invalid Choice");			
					}
				}
				break;
			case 2:	
				System.out.println("LinkedList Stack Menu:-");
				System.out.println("1.PUSH");
				System.out.println("2.POP");
				System.out.println("3.DISPLAY");
				System.out.println("4.Back to Main Menu");
				while(true) {
					System.out.println("Enter your choice for LinkedList Stack Operation");
					int d=sc.nextInt();
					if (d==4) 
						break;
					switch(d) {
					case 1:
						System.out.println("Value");
						ls.push(sc.nextInt());
						break;
					case 2:
						System.out.println("Popped Value:"+ls.pop());
						break;
					case 3:
						System.out.println("LinkedList Stack:");
						ls.display();
						break;
					default:
						System.out.println("Invalid Choice");			
					}
				}
				break;
			case 3:
				System.out.println("Before Insert Sorted:");
				as.display();
				System.out.println("Value:-");
				fun.insSort(as,sc.nextInt());
				System.out.println("After Insert Sorted:");
				as.display();
				break;
			case 4:
				System.out.println("Before Sort:");
				as.display();
				fun.sort(as);
				System.out.println("After Sort:");
				as.display();
				break;
			case 5:
				System.out.println("Before Insert Bottom:");
				as.display();
				System.out.println("Value:-");
				fun.insBot(as,sc.nextInt());
				System.out.println("After Insert Bottom:");
				as.display();
				break;
			case 6:
				System.out.println("Before Reverse:");
				as.display();
				fun.rev(as);
				System.out.println("Before Reverse:");
				as.display();
				break;
			case 7:
				System.out.println("Exiting.....");
				break;
			default:
				System.out.println("Invalid Choice");
			}
		}
	}
}
