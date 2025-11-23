package EXPERIMENT;
import java.util.*;
class SinglyLinkedList {
    class Node {
        int data;
        Node next;
        Node(int d) { data = d; }
    }

    Node head;

    void insert(int x) {
        Node n = new Node(x);
        if (head == null) head = n;
        else {
            Node t = head;
            while (t.next != null) t = t.next;
            t.next = n;
        }
        System.out.println(x + " inserted into SLL.");
    }

    void delete(int x) {
        if (head == null) {
            System.out.println("SLL is empty.");
            return;
        }
        if (head.data == x) {
            head = head.next;
            System.out.println(x + " deleted from SLL.");
            return;
        }
        Node t = head;
        while (t.next != null && t.next.data != x) {
        	t = t.next;
        }
        if (t.next != null) {
            t.next = t.next.next;
            System.out.println(x + " deleted from SLL.");
        } else System.out.println(x + " not found in SLL.");
    }

    boolean search(int x) {
        Node t = head;
        while (t != null) {
            if (t.data == x) return true;
            t = t.next;
        }
        return false;
    }

    void sortedInsert(int x) {
        Node n = new Node(x);
        if (head == null || head.data >= x) {
            n.next = head;
            head = n;
        } else {
            Node t = head;
            while (t.next != null && t.next.data < x) t = t.next;
            n.next = t.next;
            t.next = n;
        }
        System.out.println(x + " inserted into SLL in sorted order.");
    }

    void printReverse(Node t) {
        if (t == null) return;
        printReverse(t.next);
        System.out.print(t.data + " ");
    }

    void display() {
        if (head == null) {
            System.out.println("SLL is empty.");
            return;
        }
        Node t = head;
        System.out.print("SLL: ");
        while (t != null) {
            System.out.print(t.data + " -> ");
            t = t.next;
        }
        System.out.println("null");
    }
}

class DoublyLinkedList {
    class Node {
        int data;
        Node next, prev;
        Node(int d) { data = d; }
    }

    Node head;

    void insert(int x) {
        Node n = new Node(x);
        if (head == null) head = n;
        else {
            Node t = head;
            while (t.next != null) t = t.next;
            t.next = n;
            n.prev = t;
        }
        System.out.println(x + " inserted into DLL.");
    }

    void delete(int x) {
        if (head == null) {
            System.out.println("DLL is empty.");
            return;
        }
        Node t = head;
        while (t != null && t.data != x) t = t.next;
        if (t == null) {
            System.out.println(x + " not found in DLL.");
            return;
        }
        if (t.prev != null) t.prev.next = t.next;
        else head = t.next;
        if (t.next != null) t.next.prev = t.prev;
        System.out.println(x + " deleted from DLL.");
    }

    boolean search(int x) {
        Node t = head;
        while (t != null) {
            if (t.data == x) return true;
            t = t.next;
        }
        return false;
    }

    void reverse() {
        Node curr = head, temp = null;
        while (curr != null) {
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;
        }
        if (temp != null) head = temp.prev;
        System.out.println("DLL reversed.");
    }

    void display() {
        if (head == null) {
            System.out.println("DLL is empty.");
            return;
        }
        Node t = head;
        System.out.print("DLL: ");
        while (t != null) {
            System.out.print(t.data + " <-> ");
            t = t.next;
        }
        System.out.println("null");
    }
}

class Graph {
    int v;
    ArrayList<ArrayList<Integer>> adj;

    Graph(int v) {
        this.v = v;
        adj = new ArrayList<>();
        for (int i = 0; i < v; i++)
            adj.add(new ArrayList<>());
    }

    static Graph fromMatrix(int[][] mat) {
        int n = mat.length;
        Graph g = new Graph(n);
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (mat[i][j] == 1)
                    g.adj.get(i).add(j);
        return g;
    }

    void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
        System.out.println("Edge added between " + u + " and " + v);
    }

    void display() {
        if (v == 0) {
            System.out.println("Graph is empty.");
            return;
        }
        System.out.println("Graph adjacency list:");
        for (int i = 0; i < v; i++)
            System.out.println(i + " -> " + adj.get(i));
    }
}

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SinglyLinkedList sll = new SinglyLinkedList();
        DoublyLinkedList dll = new DoublyLinkedList();
        Graph graph = null;

        System.out.println("=========== MAIN MENU ===========");
        System.out.println("1  Insert into Singly Linked List");
        System.out.println("2  Delete from Singly Linked List");
        System.out.println("3  Search in Singly Linked List");
        System.out.println("4  Sorted Insert in Singly Linked List");
        System.out.println("5  Print Singly Linked List in Reverse");
        System.out.println("6  Display Singly Linked List");
        System.out.println("7  Insert into Doubly Linked List");
        System.out.println("8  Delete from Doubly Linked List");
        System.out.println("9  Search in Doubly Linked List");
        System.out.println("10 Reverse Doubly Linked List");
        System.out.println("11 Display Doubly Linked List");
        System.out.println("12 Create Graph from Adjacency Matrix");
        System.out.println("13 Add Edge to Graph");
        System.out.println("14 Display Graph");
        System.out.println("0  Exit");
        System.out.println("================================");

        while (true) {
            System.out.print("\nEnter your choice: ");
            int ch = sc.nextInt();
            System.out.println();

            switch (ch) {
                case 1:
                    System.out.print("Enter element to insert in SLL: ");
                    sll.insert(sc.nextInt());
                    break;
                case 2:
                    System.out.print("Enter element to delete from SLL: ");
                    sll.delete(sc.nextInt());
                    break;
                case 3:
                    System.out.print("Enter element to search in SLL: ");
                    System.out.println(sll.search(sc.nextInt()) ? "Found" : "Not Found");
                    break;
                case 4:
                    System.out.print("Enter element for sorted insert in SLL: ");
                    sll.sortedInsert(sc.nextInt());
                    break;
                case 5:
                    System.out.print("SLL in reverse: ");
                    sll.printReverse(sll.head);
                    System.out.println();
                    break;
                case 6:
                    sll.display();
                    break;

                case 7:
                    System.out.print("Enter element to insert in DLL: ");
                    dll.insert(sc.nextInt());
                    break;
                case 8:
                    System.out.print("Enter element to delete from DLL: ");
                    dll.delete(sc.nextInt());
                    break;
                case 9:
                    System.out.print("Enter element to search in DLL: ");
                    System.out.println(dll.search(sc.nextInt()) ? "Found" : "Not Found");
                    break;
                case 10:
                    dll.reverse();
                    break;
                case 11:
                    dll.display();
                    break;

                case 12:
                    System.out.print("Enter number of vertices: ");
                    int n = sc.nextInt();
                    int[][] matrix = new int[n][n];
                    System.out.println("Enter adjacency matrix row by row (space-separated):");
                    for (int i = 0; i < n; i++)
                        for (int j = 0; j < n; j++)
                            matrix[i][j] = sc.nextInt();
                    graph = Graph.fromMatrix(matrix);
                    System.out.println("Graph created successfully.");
                    break;
                case 13:
                    if (graph == null) {
                        System.out.println("Create a graph first!");
                        break;
                    }
                    System.out.print("Enter edge vertices (u v): ");
                    int u = sc.nextInt();
                    int v = sc.nextInt();
                    graph.addEdge(u, v);
                    break;
                case 14:
                    if (graph == null) System.out.println("Graph not created yet!");
                    else graph.display();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
