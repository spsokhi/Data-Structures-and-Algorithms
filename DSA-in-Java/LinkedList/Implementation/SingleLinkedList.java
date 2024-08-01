package LinkedList.Implementation;

public class SingleLinkedList {

    // properties of node class
    public static class Node {
        public int value;     // value (type)
        public Node next;     // reference (type)
    }

    public static class SinglyLinkedList {
        public Node head;     // Return type Node because both head and tail point to the node
        public Node tail;
        public int size;

        // Create Singly Linked List
        //  Return type Node because (always return a head reference)
        public Node createSinglyLinkedList(int nodeValue) {
//            initialize head with the type of node
//            head = new Node();
//            create an instance of this node class here

            // create blank node
            Node node = new Node();
            // assign value
            node.value = nodeValue;
            // assign reference to null
            node.next = null;
            // link head & tail with these nodes
            head = node;
            tail = node;
            size = 1;
            return head;
        }

        // Inserting In Singly Linked List
        public void insertInLinkedList(int nodeValue, int location) {
            Node node = new Node(); // create a node
            node.value = nodeValue; //  which takes a node value
            if (head == null) {
                createSinglyLinkedList(nodeValue);
                return;
            } else if (location == 0) {
                node.next = head;   // if we created ,then we are going to check location parameter
                head = node;        // it means going to reference the first node then we change
                // the head reference to point this node over here
            } else if (location >= size) {
                node.next = null;
                tail.next = node;
                tail = node;
            } else {
                Node tempNode = head;
                int index = 0;
                while (index < location - 1) {
                    tempNode = tempNode.next; //tempNode is set to tempNode.next because each time we are going to next node
                    index++;
                }
                Node nextNode = tempNode.next;
                tempNode.next = node;
                node.next = nextNode;
            }
            size++;
        }

        // Traversing in Singly Linked List
        public void traverse() {
            if (head == null) {
                System.out.println("SLL does not exist");
            } else {
                Node tempNode = head;
                for (int i = 0; i < size; i++) {
                    System.out.print(tempNode.value);
                    if (i != size - 1) {
                        System.out.print("-->");
                    }
                    tempNode = tempNode.next;
                }
            }
            System.out.println("\n");
        }

        // Searching in Singly Linked List
        public boolean searchValue(int nodeValue) {
            if (head != null) {
                Node tempNode = head;
                for (int i = 0; i < size; i++) {
                    if (tempNode.value == nodeValue) {
                        System.out.print("Node Found ! at location: " + i + "\n");
                        return true;
                    }
                    tempNode = tempNode.next;
                }

            }
            System.out.println("Node Not Found! ");
            return false;
        }


        // Deletion in Singly Linked List
        public void deleteNode(int location) {
            if (head == null) {
                System.out.println("Sll does not exist");
                return;
            } else if (location == 0) {
                // more than one element
                // head.next reference point ot the second node
                head = head.next;
                size--;
                if (size == 0) {             // only one element, tail and head points to null
                    tail = null;
                }
            } else if (location >= size) {     // deletion at ending
                Node tempNode = head;
                for (int i = 0; i < size - 1; i++) {
                    tempNode = tempNode.next;
                }
                if (tempNode == head)           // only one element
                {
                    tail = null;
                    head = null;
                    size--;
                    return;
                }
                tempNode.next = null;           // more than one element
                tail = tempNode;
                size--;
            } else {
                Node tempNode = head;
                for (int i = 0; i < location - 1; i++) {
                    tempNode = tempNode.next;
                }
                tempNode.next = tempNode.next.next;
                size--;
            }
        }

        // All Single list deleted
        public void deleteSLL() {
            head = null;
            tail = null;
            System.out.println("deleted successfully");
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList sLL = new SinglyLinkedList();

        // Create Singly Linked List
        sLL.createSinglyLinkedList(1);

        // Inserting In Singly Linked List
        sLL.insertInLinkedList(10, 0);
//            sLL.insertInLinkedList(6, 0);
        sLL.insertInLinkedList(7, 3);
        sLL.insertInLinkedList(8, 4);
        sLL.insertInLinkedList(90, 1);

        System.out.println(sLL.head.value);
        System.out.println(sLL.tail.value);

        // Traversing in Singly Linked List
        sLL.traverse();

        // Searching in Singly Linked List
        sLL.searchValue(1);

        // Deletion in Singly Linked List
        sLL.deleteNode(1);

        // All Single list deleted
        sLL.deleteSLL();
    }
}
