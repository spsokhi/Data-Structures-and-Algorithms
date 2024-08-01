package LinkedList.Implementation;

public class CircularSingly {

    public static class Node {
        public int value;
        public Node next;
    }

    public static class CircularSinglyLinkedList {
        public Node head;
        public Node tail;
        public int size;

        public Node createCSLL(int nodeValue) {
            head = new Node();
            Node node = new Node();
            node.value = nodeValue;
            node.next = node;
            head = node;
            tail = node;
            size = 1;
            return head;
        }
        //  Insertion Method
        public void insertCSLL(int nodeValue, int location) {
            Node node = new Node();
            node.value = nodeValue;
            if (head == null) {
                createCSLL(nodeValue);
                return;
            } else if (location == 0) {
                node.next = head;
                head = node;
                tail.next = head;
            } else if (location >= size) {
                tail.next = node;
                tail = node;
                tail.next = head;
            } else {
                Node tempNode = head;
                int index = 0;
                while (index < location-1) {
                    tempNode = tempNode.next;
                    index++;
                }
                node.next = tempNode.next;
                tempNode.next = node;
            }
            size++;
        }

        // Traversal Method
        public void traverseCSLL() {
            if (head != null) {
                Node tempNode = head;
                for (int i=0; i<size; i++) {
                    System.out.print(tempNode.value);
                    if (i != size-1) {
                        System.out.print(" -> ");
                    }
                    tempNode = tempNode.next;
                }
                System.out.println("\n");
            } else {
                System.out.println("\nCSLL does not exist!");
            }
        }

        // Search Method

        public boolean searchNode(int nodeValue) {
            if (head != null) {
                Node tempNode = head;
                for(int i =0; i<size; i++) {
                    if (tempNode.value == nodeValue) {
                        System.out.print("Found node at location: " + i);
                        return true;
                    }
                    tempNode = tempNode.next;
                }
            }
            System.out.println("Node not found! ");
            return false;
        }

        // Delete Method

        public void deleteNode(int location) {
            if (head == null) {
                System.out.println("The CSLL does not exist! ");
                return;
            } else if (location == 0) {
                head = head.next;
                tail.next = head;
                size--;
                if (size == 0) {
                    tail = null;
                    head.next = null;
                    head = null;
                }
            } else if (location >= size) {
                Node tempNode = head;
                for (int i =0; i<size-1; i++) {
                    tempNode = tempNode.next;
                }
                if (tempNode == head) {
                    head.next = null;
                    tail = head = null;
                    size--;
                    return;
                }
                tempNode.next = head;
                tail = tempNode;
                size--;
            } else {
                Node tempNode = head;
                for (int i=0; i < location-1; i++) {
                    tempNode = tempNode.next;
                }
                tempNode.next = tempNode.next.next;
                size--;
            }
        }

        // Delete CSLL
        public void deleteCSLL() {
            if (head == null) {
                System.out.println("The CSLL does not exist!");
            } else {
                head = null;
                tail.next = null;
                tail = null;
                System.out.println("The CSLL has been deleted!");
            }
        }

        public static void main(String[] args) {
            CircularSinglyLinkedList csll = new CircularSinglyLinkedList();
            csll.createCSLL(5);
            csll.insertCSLL(4, 0);
            csll.insertCSLL(6, 8);
            csll.insertCSLL(7, 1);
            csll.traverseCSLL();
            csll.deleteCSLL();
            csll.traverseCSLL();

        }
    }
}