package LinkedList;

public class Remove_Nth_Node_from_the_End_of_LinkedList {

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
    // Time Complexity: O(L)+O(L-N), We are calculating the length of the linked list and then iterating up to the
    // (L-N)th node of the linked list, where L is the total length of the list.
    // Space Complexity:  O(1), as we have not used any extra space.

    // Function to delete the Nth node
    // from the end of the linked list
    public static Node DeleteNthNodefromEnd(Node head, int N) {
        if (head == null) {
            return null;
        }
        int cnt = 0;
        Node temp = head;

        // Count the number of nodes in the linked list
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }

        // If N equals the total number of nodes, delete the head
        if (cnt == N) {
            Node newhead = head.next;
            head = null;
            return newhead;
        }

        // Calculate the position of the node to delete (res)
        int res = cnt - N;
        temp = head;

        // Traverse to the node just before the one to delete
        while (temp != null) {
            res--;
            if (res == 0) {
                break;
            }
            temp = temp.next;
        }

        // Delete the Nth node from the end
        Node delNode = temp.next;
        temp.next = temp.next.next;
        delNode = null;
        return head;
    }


    // Method 2 : Optimal Solution
    // Time Complexity: O(N) since the fast pointer will traverse the entire linked list,
    // where N is the length of the linked list.
    // Space Complexity: O(1), as we have not used any extra space.

    // Function to delete the Nth node from the end of the linked list
    public static Node DeleteNthNodefromEnd1(Node head, int N) {
        // Create two pointers, fast and slow
        Node fast = head;
        Node slow = head;

        // Move the fast pointer N nodes ahead
        for (int i = 0; i < N; i++)
            fast = fast.next;

        // If fast becomes null, the Nth node from the end is the head
        if (fast == null)
            return head.next;

        // Move both pointers until fast reaches the end
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Delete the Nth node from the end
        Node delNode = slow.next;
        slow.next = slow.next.next;
        delNode = null;
        return head;
    }

    // Function to print the linked list
    public static void printLL(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    // Main Function
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int N = 5;
        Node head = new Node(arr[0]);
        head.next = new Node(arr[1]);
        head.next.next = new Node(arr[2]);
        head.next.next.next = new Node(arr[3]);
        head.next.next.next.next = new Node(arr[4]);

        // Delete the Nth node from
        // the end and print the modified linked list
        head = DeleteNthNodefromEnd1(head, N);
        printLL(head);
    }
}

// Output: 1 2 4 5

// Approach : Brute Force
/*
Algorithm / Intuition
The simplest way to delete the Nth node from the end is to delete the (L-N+1)th node from the start of the linked list,
where L is the total length of the linked list.

Therefore, this problem can be broken down into two sub-problems:

1. The first part involves the calculation of the length of the linked list.
2. The second part involves the deletion of the (L-N+1)th node from the start of the linked list.

There are two edge cases to consider:

1. If N equals 1, this means we have to delete the tail of the linked list.
2. If N equals the length of the linked list, we have to delete the head of the linked list.

Algorithm
Initialize a temp pointer that will be used to traverse the list.

2. Create a cnt variable and initialize it to 0. Traverse the linked list, and at each node, increment cnt. Finally,
when the pointer reaches NULL, return cnt, which contains the total length of the linked list.

3. Now, after knowing the length of the linked list, the first sub-problem is solved. To solve the second sub-problem,
we will follow the steps that we used to delete the Kth node of the linked list.

4. To delete the (L-N+1)th node of the linked list, create a new temp pointer to the head. Initialize a variable
(res) to L-N, and start iterating the linked list while decrementing res at each node. Once res equals 0, we know
that temp will be pointing to the (L-N)th node, therefore, stop the traversal.

5. To create a new link, point the (L-N)th node to the (L-N+2)th node of the linked list, effectively
skipping the (L-N+1)th node.

6. Finally, free up the memory being occupied by the (L-N+1)th node, thus deleting this node.
 */

// Approach : Optimal Solution
/*
Algorithm / Intuition
The brute force, in the worst case, has a time complexity of O(2*L), where L is the length of the linked list.
Therefore, it is not the most efficient algorithm, as we are traversing the entire list twice.

To enhance efficiency, we will involve two pointers, a fast pointer and a slow pointer. The fast-moving pointer
will initially be exactly N nodes ahead of the slow-moving pointer. After which, both of them will move one step at
a time. When the fast pointer reaches the last node, i.e., the L-th node, the slow is guaranteed to be at the (L-N)-th node, where L is the total length of the linked list.

Algorithm

1. Initialize two pointers, `slow` and `fast`, to the head of the linked list. Initially, only fast will move till it
crosses N nodes, after which both of the pointers will move simultaneously.

2. Traverse the linked list till the fast pointer reaches the last node, that is, the Lth Node, at this stage,
the slow pointer is guaranteed to be at the (L-N)th node.

3. Point this slow pointer to the (L-N+2)th node, effectively skipping the Nth node from the end or the
(L-N+1)th node from the start.
 */