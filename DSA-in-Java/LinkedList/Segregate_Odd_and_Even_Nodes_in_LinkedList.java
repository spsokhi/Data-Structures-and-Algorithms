package LinkedList;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Segregate_Odd_and_Even_Nodes_in_LinkedList {

    // Node class represents a node in a linked list
    static class Node {
        // Data stored in the node
        int data;
        // Pointer to the next node in the list
        Node next;

        // Constructor with both data
        // and next node as parameters
        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        // Constructor with only data as
        // a parameter, sets next to null
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Method 1 : Brute Force (Using ArrayList)
    // Time Complexity : O(2N) ~ O(N) for traversing
    // Space Complexity : O(N) for using ArrayList Data Structure
    static Node segregateToOddEven(Node head) {
        Node temp = head;;
        ArrayList<Integer> list = new ArrayList<Integer>();

        while (temp != null && temp.next != null) {
            list.add(temp.data);
            temp = temp.next.next;
        }
        if (temp != null) list.add(temp.data);

        temp = head.next;
        while (temp != null && temp.next != null) {
            list.add(temp.data);
            temp = temp.next.next;
        }
        if (temp != null) list.add(temp.data);

        int i=0;
        temp = head;
        while (temp != null) {
            temp.data = list.get(i);
            i++;
            temp = temp.next;
        }
        return head;
    }

    // Method 2 : Optimal Solution (Using Odd Even Solution)
    // Time Complexity : O(N/2) + O(N/2) ~ O(N) for traversing
    static Node segregateToOddEven1(Node head) {
        if (head == null || head.next == null) return head;

        Node odd = head;
        Node even = head.next;
        Node evenHead = even; // Save the head of the even list to connect later

        // Loop to rearrange nodes into odd and even lists
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead; // Connect odd list with even list
        return head;
    }

    // Function to print the linked list
    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Main Function
    public static void main(String[] args) {
        // Creating the linked list
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        System.out.println("Original list:");
        printList(head);

        // Segregating odd and even nodes
        head = segregateToOddEven1(head);

        System.out.println("List after segregation:");
        printList(head);
    }
}

// Output :
/*
Original list:
1 2 3 4 5 6
List after segregation:
1 3 5 2 4 6
 */

// Approach : Brute Force
/*
1. Store even and odd linked list values in arraylist
2. After that, traverse the arraylist and linked list and replacing the value of linked list data with
arraylist data
 */

// Approach : Optimal Solution
/*
1. Changing the link for the odd index
2. Changing the link for the even index
 */

// Striver (Video Explanation) : https://www.youtube.com/watch?v=qf6qp7GzD5Q