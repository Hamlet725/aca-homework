package old;

import java.util.HashMap;

class MyLinkedList {
    private Node head;

    public MyLinkedList() {

    }

    public int get(int index) {
        if (index == 0) {
            return head.getData();
        }
        int i = 0;
        Node current = head;
        while (current.next != null) {
            current = current.next;
            int result = current.getData();
            if (i == index - 1) {
                return result;
            }
            i++;
        }
        return -1;
    }

    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
    }

    public void addAtTail(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = new Node(val);
            return;
        }
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = node;
        node.next = null;
    }

    public void addAtIndex(int index, int val) {
        Node node = new Node(val);
        if (index == 0) {
            node.next = head;
            head = node;
            return;
        }
        boolean bool = true;
        int i = 0;
        Node cur = head;
        while (cur.next != null) {
            if (i == index) {
                node.next = cur;
                bool = false;
                break;
            }
            cur = cur.next;
            i++;
        }
        if (bool) {
            node.next = cur;
        }
        i = 0;
        Node current = head;
        while (current.next != null) {
            if (i == index - 1) {
                current.next = node;
                return;
            }
            current = current.next;
            i++;
        }
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = node;
            node.next = null;

    }

    public void deleteAtIndex(int index) {
        if (index == 0) {
            if (head.next == null) {
                head = null;
                return;
            }
            Node node = head.next.next;
            head = head.next;
            head.next = node;
            return;
        }
        int i = 0;
        Node current = head;
        Node ele = current;
        while (current.next != null) {
            if (i == index - 1) {
                ele = current;
                if (current.next.next == null) {
                    current.next = null;
                    return;
                }
                break;
            }
            current = current.next;
            i++;
        }
        i = 0;
        current = head;
        while (current.next != null) {
            if (i == index) {
                ele.next = current.next;
                return;
            }
            current = current.next;
            i++;
        }
    }

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public int getData() {
            return data;
        }
    }
}