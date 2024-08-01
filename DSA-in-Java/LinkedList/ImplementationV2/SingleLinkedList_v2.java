package LinkedList.ImplementationV2;

public class SingleLinkedList_v2 {

    private Node head; // Head of the list
    private Node tail; // Tail of the list
    private int size;  // Size of the list

    // Constructor to initialize the list
    public SingleLinkedList_v2() {
        this.size = 0;
    }

    // Method to insert a node at the beginning of the list
    public void insertAtFirst(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    // Method to insert a node at the end of the list
    public void insertAtLast(int data) {
        if (tail == null) {
            insertAtFirst(data); // If the list is empty, insert as the first element
            return;
        }
        Node node = new Node(data);
        tail.next = node;
        tail = node;
        size++;
    }

    // Method to insert a node at a specified position
    public void insertAtSpecifiedPosition(int data, int location) {
        if (location == 0) {
            insertAtFirst(data); // Insert at the start if location is 0
            return;
        }
        if (location == size) {
            insertAtLast(data); // Insert at the end if location is equal to size
            return;
        }

        Node prev = head;
        for (int i = 0; i < location - 1; i++) {
            prev = prev.next; // Traverse to the node before the specified location
        }

        Node node = new Node(data, prev.next); // Insert the new node
        prev.next = node;
        size++;
    }

    // Method to delete the first node of the list
    public int deleteAtFirst() {
        int data = head.data;
        head = head.next;
        if (head == null) {
            tail = null; // If the list becomes empty, set tail to null
        }
        size--;
        return data;
    }

    // Method to delete the last node of the list
    public int deleteAtLast() {
        if (size <= 1) {
            return deleteAtFirst(); // If the list has 1 or no elements, delete the first node
        }

        Node secondLast = get(size - 2); // Get the second last node
        int data = tail.data;
        tail = secondLast;
        tail.next = null; // Set the next of the last node to null
        size--;
        return data;
    }

    // Method to delete a node at a specified position
    public int deleteAtSpecifiedPosition(int data, int location) {
        if (location == 0) {
            return deleteAtFirst(); // Delete the first node if location is 0
        }
        if (location == size - 1) {
            return deleteAtLast(); // Delete the last node if location is the last index
        }

        Node prev = head;
        for (int i = 0; i < location - 1; i++) {
            prev = prev.next; // Traverse to the node before the specified location
        }
        if (prev.next != null) {
            prev.next = prev.next.next; // Remove the node from the list
        }
        size--;
        return data;
    }

    // Method to search for a value in the list
    int search(int value) {
        Node currNode = head;
        int index = 0;
        while (currNode != null) {
            if (currNode.data == value) {
                return index; // Return the index if value is found
            }
            currNode = currNode.next;
            index++;
        }
        return -1; // Value not found, return -1
    }

    // Method to get a node at a specific index
    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    // Method to print the list
    public void printList() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " -> "); // Print each node's data
            currNode = currNode.next;
        }
        System.out.println("null"); // Indicate the end of the list
        System.out.println("Size: " + size); // Print the size of the list
    }

    // Inner Node class representing the structure of each node
    private class Node {
        private int data; // Data of the node
        private Node next; // Reference to the next node

        // Constructor for node with data
        public Node(int data) {
            this.data = data;
        }

        // Constructor for node with data and next node reference
        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    // Main method to demonstrate the functionality of NodeList
    public static void main(String[] args) {
        SingleLinkedList_v2 list = new SingleLinkedList_v2();
        list.insertAtFirst(10);
        list.insertAtSpecifiedPosition(20, 1);
        list.insertAtSpecifiedPosition(30, 2);
        list.insertAtLast(40);
        list.printList();
        System.out.println(list.deleteAtFirst());
        list.printList();
    }
}
