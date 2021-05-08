package com.arvindve.linkedlist;

import static com.arvindve.linkedlist.LinkedListHelper.buildList;
import static com.arvindve.linkedlist.LinkedListHelper.printList;

public class Reverse {
    public static void main(String[] args) {
        Node head = buildList(new int[] { 45, 55, 66, 77, 100 });

        printList(head);
        head = reverse(head);
        printList(head);
        printList(recursiveReverse(head));
    }

    static Node reverse(Node head) {
        Node tail = null;
        while (head != null) {
            Node next = head.next;
            head.next = tail;
            tail = head;
            head = next;
        }

        return tail;
    }

    static Node recursiveReverse(Node head) {
        if (head.next == null) {
            return head;
        }

        Node rest = recursiveReverse(head.next);
        head.next.next = head;
        head.next = null;

        return rest;
    }
}