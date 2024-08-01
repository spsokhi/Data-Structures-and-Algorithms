package LinkedList.ImplementationV2;

public class DoublyLinkedList {

    private Node head;

    /**
     * Inserts a new node with the given value at the beginning of the list.
     * @param val The value to insert.
     */
    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
        head = node;
    }

    /**
     * Displays the list in both forward and reverse order.
     */
    public void display() {
        Node node = head;
        Node last = null;
        while (node != null) {
            System.out.print(node.val + " -> ");
            last = node;
            node = node.next;
        }
        System.out.println("END");

        System.out.println("Print in reverse");
        while (last != null) {
            System.out.print(last.val + " -> ");
            last = last.prev;
        }
        System.out.println("START");
    }

    /**
     * Inserts a new node with the given value at the end of the list.
     * @param val The value to insert.
     */
    public void insertLast(int val) {
        Node node = new Node(val);
        Node last = head;

        node.next = null;

        if (head == null) {
            node.prev = null;
            head = node;
            return;
        }

        while (last.next != null) {
            last = last.next;
        }

        last.next = node;
        node.prev = last;
    }

    /**
     * Finds the first node with the given value in the list.
     * @param value The value to find.
     * @return The node with the given value, or null if not found.
     */
    public Node find(int value) {
        Node node = head;
        while (node != null) {
            if (node.val == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    /**
     * Inserts a new node with the given value after the first node with the specified value.
     * @param after The value after which to insert the new node.
     * @param val The value of the new node to insert.
     */
    public void insertAfter(int after, int val) {
        Node p = find(after);

        if (p == null) {
            System.out.println("Node with value " + after + " does not exist.");
            return;
        }

        Node node = new Node(val);
        node.next = p.next;
        p.next = node;
        node.prev = p;
        if (node.next != null) {
            node.next.prev = node;
        }
    }

    /**
     * Node class represents an element in the doubly linked list.
     */
    private class Node {
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
}
