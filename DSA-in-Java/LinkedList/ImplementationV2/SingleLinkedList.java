package LinkedList.ImplementationV2;

public class SingleLinkedList {

    // Head Pointer
    Node head;

    // Size of Linked List
    int size;

    // Node Class
    static class Node {
        int data;      // the data value
        Node next;      // the reference to the next Node in the linked list

        // Constructors
        Node(int data, Node next) {
            this.data = data;  // Initialize data with the provided value
            this.next = next;  // Initialize next with the provided reference
        }
        Node(int data) {
            this.data = data;  // Initialize data with the provided value
            this.next = null;   // Initialize next as null since it's the end of the list
        }
    }

    // Insertion (Insert a value at a specified location)
    void insert(int data, int location) {
        if(location > size || location < 0) {
            System.out.println("Invalid Index value");
            return;
        }

        Node node = new Node(data);

        if (location == 0) {
            node.next = head;
            head = node;
        } else {
            Node prev = head;
            for (int i = 0; i < location - 1; i++) {
                prev = prev.next;
            }
            node.next = prev.next;
            prev.next = node;
        }
        size++;
    }

    // Traversal
    void printList() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("null");
        System.out.println("Size: " + size);
    }

    // Length of a Linked List
    int lengthOfLinkedList() {
        if (head == null) {
            System.out.println("List is Empty");
            return 0;
        }

        Node currNode = head;
        int count = 0;
        while (currNode != null) {
            currNode = currNode.next;
            count++;
        }
        return count;
    }

    // Deletion (Delete a value at a specified location)
    void deletion(int location) {
        if (location < 0 || location >= size) {
            System.out.println("Invalid Index value");
            return;
        }

        if (location == 0) {
            head = head.next;
        } else {
            Node prev = head;
            for (int i = 0; i < location - 1; i++) {
                prev = prev.next;
            }
            if (prev.next != null) {
                prev.next = prev.next.next;
            }
        }
        size--;
    }

    // Searching (Searching for a value)
    int search(int value) {
        Node currNode = head;
        int index = 0;
        while (currNode != null) {
            if (currNode.data == value) {
                return index;
            }
            currNode = currNode.next;
            index++;
        }
        return -1; // Value not found
    }

    // Delete Entire Liked List
    public void deleteEntireList(){
        head = null;
        System.out.println("deleted successfully");
    }

    // Main Function
    public static void main(String[] args) {
        // Creating a object of Linked List Class
        SingleLinkedList list = new SingleLinkedList();
        list.insert(80, 0);
        list.insert(90, 1);
        list.insert(100, 2);
        list.insert(70, 3);
        list.printList();
        list.deletion(2);
        int res = list.search(90);
        System.out.println(res);
        System.out.println("Length of Linked List: " + list.lengthOfLinkedList());
    }
}

// Anuj Bhaiya (Video Explanation) : https://www.youtube.com/watch?v=4tU7d0TTiZQ&t
// Apna College (Video Explanation) : https://www.youtube.com/watch?v=oAja8-Ulz6o&t
// Apna College Docs : https://docs.google.com/document/d/1ysYfkEEdeCRf1j8nGRvLCuPpEtN58Z51iMzgXB7pYIE/edit