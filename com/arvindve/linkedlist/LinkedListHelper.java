package com.arvindve.linkedlist;

public class LinkedListHelper {
    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }

        System.out.println();
    }

    static Node buildList(int[] data) {
        Node head = null;
        Node curr = null;

        for (int i = 0; i < data.length; i++) {
            Node node = new Node(data[i], null);

            if (head == null) {
                head = curr = node;
            } else {
                curr.next = node;
                curr = curr.next;
            }
        }
        return head;
    }
}