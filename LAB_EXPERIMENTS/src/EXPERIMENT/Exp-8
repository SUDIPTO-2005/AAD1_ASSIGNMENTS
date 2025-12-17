package EXP;
import java.util.Scanner;

public class Exp8 {

    static class ArrayQueue {
        int[] q;
        int front = -1, rear = -1, size;

        ArrayQueue(int size) {
            this.size = size;
            q = new int[size];
        }

        void enqueue(int x) {
            if (rear == size - 1) {
                System.out.println("Queue Overflow");
                return;
            }
            if (front == -1) front = 0;
            q[++rear] = x;
            System.out.println("Inserted: " + x);
        }

        void dequeue() {
            if (front == -1 || front > rear) {
                System.out.println("Queue Underflow");
                return;
            }
            System.out.println("Deleted: " + q[front++]);
        }

        void display() {
            if (front == -1 || front > rear) {
                System.out.println("Queue Empty");
                return;
            }
            for (int i = front; i <= rear; i++)
                System.out.print(q[i] + " ");
            System.out.println();
        }
    }

    static class LinkedQueue {

        class Node {
            int data;
            Node next;
            Node(int d) { 
            	data = d;
            }
        }

        Node front = null, rear = null;

        void enqueue(int x) {
            Node n = new Node(x);
            if (rear == null)
                front = rear = n;
            else {
                rear.next = n;
                rear = n;
            }
            System.out.println("Inserted: " + x);
        }

        void dequeue() {
            if (front == null) {
                System.out.println("Queue Empty");
                return;
            }
            System.out.println("Deleted: " + front.data);
            front = front.next;
            if (front == null) rear = null;
        }

        void display() {
            if (front == null) {
                System.out.println("Queue Empty");
                return;
            }
            Node t = front;
            while (t != null) {
                System.out.print(t.data + " ");
                t = t.next;
            }
            System.out.println();
        }
    }

    static class StackArray {
        int[] s;
        int top = -1;

        StackArray(int n) {
            s = new int[n];
        }

        void push(int x) { 
        	s[++top] = x; 
        	}
        int pop() { 
        	return s[top--]; 
        	}
        boolean isEmpty() { 
        	return top == -1;
        	}
        void display() {
            for (int i = top; i >= 0; i--)
                System.out.print(s[i] + " ");
            System.out.println();
        }
    }

    static class SimpleQueue {
        int[] q;
        int front = 0, rear = -1;

        SimpleQueue(int n) {
            q = new int[n];
        }

        void enqueue(int x) { 
        	q[++rear] = x; 
        }
        int dequeue() {
        	return q[front++];
        }
        boolean isEmpty() { 
        	return front > rear;
        	}
    }

    static void reverseStack(StackArray st) {
        SimpleQueue q = new SimpleQueue(st.top + 1);

        while (!st.isEmpty())
            q.enqueue(st.pop());

        while (!q.isEmpty())
            st.push(q.dequeue());
    }

    static void slidingWindowMax(int[] a, int k) {
        int n = a.length;
        int[] dq = new int[n];
        int front = 0, rear = -1;

        for (int i = 0; i < n; i++) {

            if (front <= rear && dq[front] <= i - k)
                front++;

            while (front <= rear && a[dq[rear]] < a[i])
                rear--;

            dq[++rear] = i;

            if (i >= k - 1)
                System.out.print(a[dq[front]] + " ");
        }
        System.out.println();
    }

    static int josephus(int n, int k) {
        int[] people = new int[n];
        for (int i = 0; i < n; i++)
            people[i] = i + 1;

        int alive = n, index = 0;

        while (alive > 1) {
            index = (index + k - 1) % alive;

            for (int i = index; i < alive - 1; i++)
                people[i] = people[i + 1];

            alive--;
        }
        return people[0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n===== MAIN MENU =====");
        System.out.println("1. Queue Operatio using Array");
        System.out.println("2. Queue Operation using Linked List");
        System.out.println("3. Reverse Stack using Queue");
        System.out.println("4. Sliding Window Maximum");
        System.out.println("5. Josephus Problem");
        System.out.println("6. Exit");   
        while (true) {   
        	System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            switch (ch) {

                case 1:
//                    System.out.print("Enter size: ");
                    ArrayQueue aq = new ArrayQueue(10);
                    System.out.println("1.Enqueue");
                    System.out.println("2.Dequeue");
                    System.out.println("3.Display");
                    System.out.println("4.Back to Main Menu");
                    while (true) {
                    	System.out.print("Enter choice for ArrayQueue: ");
                        int c = sc.nextInt();
                        if(c==4) {
                        	break;
                        }
                        switch (c) {
                        case 1:
                            aq.enqueue(sc.nextInt());
                            break;
                        case 2:
                            aq.dequeue();
                            break;
                        case 3:
                            aq.display();
                            break;
                        default:
                            System.out.println("Enter a valid choice");
                    }
                }
                 break;

                case 2:
                    LinkedQueue lq = new LinkedQueue();
                    System.out.println("1.Enqueue");
                    System.out.println("2.Dequeue");
                    System.out.println("3.Display");
                    System.out.println("4.Back to Main Menu");
                    while (true) {
                    	System.out.print("Enter choice for LinkedQueue: ");
                        int c = sc.nextInt();
                        if(c==4) {
                        	break;
                        }
                        switch (c) {
                        case 1:
                            lq.enqueue(sc.nextInt());
                            break;
                        case 2:
                            lq.dequeue();
                            break;
                        case 3:
                            lq.display();
                            break;
                        default:
                            System.out.println("Enter a valid choice");
                    }
                    }
                    break;
                case 3:
                    System.out.print("Enter stack size: ");
                    StackArray st = new StackArray(sc.nextInt());
                    System.out.print("Enter elements: ");
                    for (int i = 0; i <= st.s.length - 1; i++)
                        st.push(sc.nextInt());
                    System.out.println("Before Reverse Stack");
                    st.display();
                    reverseStack(st);
                    System.out.print("Reversed Stack: ");
                    st.display();
                    break;

                case 4:
                    System.out.print("Enter array size: ");
                    int n = sc.nextInt();
                    int[] a = new int[n];
                    System.out.println("Enter the elements");
                    for (int i = 0; i < n; i++)
                        a[i] = sc.nextInt();
                    System.out.print("Enter window size k: ");
                    slidingWindowMax(a, sc.nextInt());
                    break;

                case 5:
                    System.out.print("Enter players: ");
                    int p = sc.nextInt();
                    System.out.print("Enter step k: ");
                    System.out.println("Winner: " + josephus(p, sc.nextInt()));
                    break;

                case 6:
                    System.out.println("Exiting.....");
                    return;
                default:
                	System.out.println("Invalid Choice!Enter a valid choice");
            }
        }
    }
}
