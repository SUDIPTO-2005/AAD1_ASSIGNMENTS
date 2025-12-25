package EXPERIMENT;
import java.util.Scanner;

class Node {
    int d;
    Node l, r;

    Node(int d) {
        this.d = d;
        l = r = null;
    }
}

public class Exp9 {

    static Node rt = null;
    static Scanner sc = new Scanner(System.in);

    static Node arrTree(int a[], int i, int n) {
        if (i >= n)
            return null;

        Node t = new Node(a[i]);
        t.l = arrTree(a, 2 * i + 1, n);
        t.r = arrTree(a, 2 * i + 2, n);
        return t;
    }

    static Node ins(Node rt, int d) {
        if (rt == null)
            return new Node(d);

        Node a[] = new Node[50];
        int f = 0, r = 0;
        a[r++] = rt;

        while (f < r) {
            Node t = a[f++];

            if (t.l == null) {
                t.l = new Node(d);
                break;
            } else
                a[r++] = t.l;

            if (t.r == null) {
                t.r = new Node(d);
                break;
            } else
                a[r++] = t.r;
        }
        return rt;
    }

    static void pre(Node rt) {
        if (rt != null) {
            System.out.print(rt.d + " ");
            pre(rt.l);
            pre(rt.r);
        }
    }

    static void in(Node rt) {
        if (rt != null) {
            in(rt.l);
            System.out.print(rt.d + " ");
            in(rt.r);
        }
    }

    static void post(Node rt) {
        if (rt != null) {
            post(rt.l);
            post(rt.r);
            System.out.print(rt.d + " ");
        }
    }

    static int leaf(Node rt) {
        if (rt == null)
            return 0;
        if (rt.l == null && rt.r == null)
            return 1;
        return leaf(rt.l) + leaf(rt.r);
    }

    static int max(Node rt) {
        if (rt == null)
            return -9999;

        int m = rt.d;
        int lm = max(rt.l);
        int rm = max(rt.r);

        if (lm > m)
            m = lm;
        if (rm > m)
            m = rm;

        return m;
    }
    static void path(Node rt, int p[], int len) {
        if (rt == null)
            return;

        p[len] = rt.d;
        len++;

        if (rt.l == null && rt.r == null) {
            for (int i = 0; i < len; i++)
                System.out.print(p[i] + " ");
            System.out.println();
        } else {
            path(rt.l, p, len);
            path(rt.r, p, len);
        }   
    }


    public static void main(String[] args) {
       
        System.out.println("1.Create Binary Tree using Array");
        System.out.println("2.Create Binary Tree using Linked List");
        System.out.println("3.Traversals of Binary Tree");
        System.out.println("4.All paths from root to leaf node");
        System.out.println("5.Count Leaf Nodes of Binary Tree");
        System.out.println("6.Find Max Value of Binary Tree");
        System.out.println("7.Exit");
        while(true) {
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter size: ");
                    int n = sc.nextInt();
                    int a[] = new int[n];
                    System.out.println("Enter elements:");
                    for (int i = 0; i < n; i++)
                        a[i] = sc.nextInt();
                    rt = arrTree(a, 0, n);
                    System.out.println("Tree created using array");
                    break;

                case 2:
                    System.out.print("Enter number of nodes: ");
                    int m = sc.nextInt();
                    rt = null;
                    System.out.println("Enter elements:");
                    for (int i = 0; i < m; i++)
                        rt = ins(rt, sc.nextInt());
                    System.out.println("Tree created using linked list");
                    break;

                case 3:
                    int c;
                    do {
                        System.out.println("1.Preorder");
                        System.out.println("2.Inorder");
                        System.out.println("3.Postorder");
                        System.out.println("4.Back to Main Menu");
                        c = sc.nextInt();

                        if (c == 1) pre(rt);
                        else if (c == 2) in(rt);
                        else if (c == 3) post(rt);

                        System.out.println();
                    } while (c != 0);
                    break;
                case 4:
                	System.out.println("Root to Leaf Paths:");
                    int p[] = new int[50];
                    path(rt, p, 0);
                    break;

                case 5:
                    System.out.println("Leaf nodes: " + leaf(rt));
                    break;

                case 6:
                    System.out.println("Max value: " + max(rt));
                    break;
                case 7:
                	System.out.println("Exiting.....");
                default:
                	System.out.println("Invalid Choice");
            }
        } 
    }
}

