package LinkedList.ImplementationV2;

public class CircularLinkedList {

    private Node head;
    private Node tail;

    public CircularLinkedList() {
        this.head = null;
        this.tail = null;
    }

    /**
     * Inserts a new node with the given value into the circular linked list.
     * @param val The value to insert.
     */
    public void insert(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            tail = node;
            node.next = head; // Point to itself to maintain circular property
        } else {
            tail.next = node;
            node.next = head;
            tail = node;
        }
    }

    /**
     * Displays the list starting from the head.
     */
    public void display() {
        Node node = head;
        if (head != null) {
            do {
                System.out.print(node.val + " -> ");
                node = node.next;
            } while (node != head);
        }
        System.out.println("HEAD");
    }

    /**
     * Deletes the first occurrence of a node with the specified value from the list.
     * @param val The value to delete.
     */
    public void delete(int val) {
        Node node = head;

        if (node == null) {
            return;
        }

        // If the list has only one node
        if (head == tail && head.val == val) {
            head = null;
            tail = null;
            return;
        }

        // If the node to be deleted is the head
        if (node.val == val) {
            head = head.next;
            tail.next = head;
            return;
        }

        // Search for the node to be deleted
        do {
            Node nextNode = node.next;
            if (nextNode.val == val) {
                node.next = nextNode.next;
                if (nextNode == tail) {
                    tail = node; // Update tail if the deleted node was the last node
                }
                break;
            }
            node = node.next;
        } while (node != head);
    }

    /**
     * Node class represents an element in the circular linked list.
     */
    private class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
