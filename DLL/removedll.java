import java.util.*;

public class removedll {
    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    static Node head; // Global static head
    static Node tail; // Global static tail

    static class Dll {

        public void addToback(int data) {
            Node newnode = new Node(data);
            if (head == null) {
                head = newnode;
                tail = newnode;
            } else {
                tail.next = newnode; // Use tail for the back
                newnode.prev = tail;
                tail = newnode;
            }
        }

        public void addToFront(int data) {
            Node newnode = new Node(data);
            if (head == null) {
                head = newnode;
                tail = newnode;
            } else {
                head.prev = newnode;
                newnode.next = head;
                head = newnode;
            }
        }

        public void printList() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + "->");
                temp = temp.next;
            }
            System.out.print("null");
        }

        public void removeHead(Node head) {
            if (head == null) {
                System.out.println("removed head is null");
                return;
            }
            if (head.next == null) {
                System.out.println("removed head is " + head.data + " and now it is null");
                removedll.head = null; // Reset global head
                removedll.tail = null; // Reset global tail
                return;
            }
            Node temp = head.next;
            temp.prev = null;
            removedll.head.next = null;
            removedll.head = temp;
        }

        public void removetail(Node head) {
            if (head == null) {
                System.out.println("removed tail is null");
                return;
            }
            if (head.next == null) {
                System.out.println("removed tail is " + head.data + " and now it is null");
                removedll.head = null; // Reset global head
                removedll.tail = null; // Reset global tail
                return;
            }
            Node temp = tail.prev; // Use tail for direct access
            temp.next = null;
            removedll.tail.prev = null;
            removedll.tail = temp;
        }

        public Node removekthnode(Node head, int index) {
            int count = 0;
            Node temp = head;

            while (temp != null) {
                count++;
                if (count == index) {
                    break;
                }
                temp = temp.next;
            }

            if (temp == null) {
                System.out.println("Index out of bounds.");
                return head;
            }

            Node prevv = temp.prev;
            Node nextt = temp.next;

            if (prevv == null && nextt == null) {
                return null; // Single node case
            } else if (prevv == null) {
                removeHead(head);
                return null;
            } else if (nextt == null) {
                removetail(head);
                return null;
            } else {
                prevv.next = nextt;
                nextt.prev = prevv;
                temp.prev = null;
                temp.next = null;
            }

            return head;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements:");
        int n = sc.nextInt();

        int[] arr = new int[n];
        Dll d = new Dll();

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < arr.length; i++) {
            //d.addToFront(arr[i]);
            d.addToback(arr[i]);
        }

        d.removeHead(head);
        d.removetail(head);
        System.out.println("Enter index to remove:");
        int index = sc.nextInt();
        d.removekthnode(head, index);

        System.out.println("Final List:");
        d.printList();

        sc.close();
    }
}
