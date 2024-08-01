package LinkedList;

public class Delete_the_Middle_Node_in_the_LinkedList {

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

    // Method 1 : Brute Force
    // Time Complexity: O(N + N/2) The loop traverses the entire linked list once to count the total number of nodes
    // then the loop iterates halfway through the linked list to reach the middle node. Hence, the time complexity is
    // O(N + N/2) ~ O(N).
    // Space Complexity : O(1) The algorithm uses a constant amount of extra space regardless of the size of the input
    // (linked list). It doesn't use any additional data structures in proportion to the input size. Thus,
    // the space complexity is O(1) (constant space).

    // Function to delete the
    // middle node of a linked list
    static Node deleteMiddle(Node head) {
        // Initialize a temporary node
        // to traverse the linked list
        Node temp = head;

        // Variable to hold the number
        // of nodes in the linked list
        int n = 0;

        // Loop to count the number of
        // nodes in the linked list
        while (temp != null) {
            n++;
            temp = temp.next;
        }

        // Calculate the index of the middle node
        int res = n / 2;

        // Reset the temporary node to
        // the beginning of the linked list
        temp = head;

        // Loop to find the
        // middle node to delete
        while (temp != null) {

            res--;

            // If the middle node is found
            if (res == 0) {

                // Create a pointer
                // to the middle node
                Node middle = temp.next;

                // Adjust pointers to
                // skip the middle node
                temp.next = temp.next.next;

                // No need to explicitly free memory in Java,
                // as it's managed by the garbage collector

                // Exit the loop after
                // deleting the middle node
                break;
            }
            // Move to the next node
            // in the linked list
            temp = temp.next;
        }
        // Return the head of the
        // modified linked list
        return head;
    }

    // Method 2 : Optimal Solution
    // Time Complexity: O(N/2) The algorithm traverses the linked list using the Tortoise and Hare approach.
    // The code increments both 'slow' and 'fast' pointers at different rates, effectively covering about half the
    // list before reaching the midpoint, hence the time complexity of the algorithm is O(N/2) ~ O(N).
    // Space Complexity: O(1) The algorithm uses a constant amount of extra space regardless of the size of the input
    // (linked list). It doesn't use any additional data structures in proportion to the input size. Thus, the space
    // complexity is O(1) (constant space).

    // Function to delete the
    // middle node of a linked list
    static Node deleteMiddle1(Node head) {
        // If the list is empty or has only one node,
        // return null as there is no middle node to delete
        if (head == null || head.next == null) {
            return null;
        }

        // Initialize slow and fast pointers
        Node slow = head;
        Node fast = head;
        Node prev = null;

        // Move 'fast' pointer twice as fast as 'slow'
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Delete the middle node by skipping it
        if (prev.next != null) {
            prev.next = slow.next;
        }
        return head;
    }

    // Print the Linked List
    static void printLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Main Function
    public static void main(String[] args) {
        Delete_the_Middle_Node_in_the_LinkedList list = new Delete_the_Middle_Node_in_the_LinkedList();

        // Creating a sample linked list:
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Display the original linked list
        System.out.print("Original Linked List: ");
        printLL(head);

        // Deleting the middle node
        head = list.deleteMiddle1(head);

        // Displaying the updated linked list
        System.out.print("Updated Linked List: ");
        printLL(head);
    }
}

// Output: Original Linked List: 1 2 3 4 5 Updated Linked List: 1 2 4 5

// Approach : Brute Force
/*
Algorithm / Intuition
Using the brute force approach, the middle node of a linked list can be determined by traversing the entire linked list
initially to find the total number of nodes, denoted as `n`. Then we reset the temporary node `temp` to the head of the
linked list and proceed to traverse to the node positioned at index `[n/2]`, which represents either the middle node in
an odd-lengthed list or the node just before the middle node in an even-lengthed linked list.

Algorithm:

Step 1: Traverse the linked list to count the number of nodes and store the length as `n`. Calculate the index of the
middle node by dividing the total number of nodes by 2.

Step 2: Traverse the linked list again while keeping track of the node count to reach the middle node.

Step 3: Once reaching the middle node, delete it by setting the next pointer of the previous node directly to the node
after the middle node. Free the memory allocated to the middle node.
 */

// Approach : Optimal Solution
/*
Algorithm / Intuition
The previous method requires the traversal of the linked list twice. To enhance efficiency, the Tortoise and Hare
Algorithm is introduced as an optimization where the middle node can be found in just one traversal.

The 'slow' pointer advances one node at a time while the 'fast' pointer moves two nodes at a time. By doing so, when
the 'fast' pointer reaches the end of the list, the 'slow' pointer will be at the middle node.

Since we require `slow` to reach the node before the middle node, we give `fast` a head start!

Algorithm
Step 1: Check if the list is empty or contains only one node. If so, no middle node exists to delete, return NULL.
Initialise 'slow' and 'fast' pointers at the head of the list.

Move ‘fast’ two nodes ahead for the initial position as we have to reach the node previous to the middle node via slow.

Step 2: Move the 'fast' pointer two nodes ahead and the 'slow' pointer one node ahead in each iteration. Continue this
process until the 'fast' pointer reaches the end of the list.

Step 3: Once the 'fast' pointer reaches the end, the 'slow' pointer will be at the middle node. Delete the middle
node by skipping it from the linked list.

Step 4: Return the head of the modified linked list.
 */