package com.arvindve.linkedlist;

import static com.arvindve.linkedlist.LinkedListHelper.buildList;
import static com.arvindve.linkedlist.LinkedListHelper.printList;

public class FrontBackSplit {
    public static void main(String[] args) {
        Node head1 = buildList(new int[] { 3, 4, 5, 6, 7 });
        // Node head2 = buildList(new int[] { 10, 20, 30 });

        printList(head1);
        // printList(head2);
        Node front = null;
        Node back = null;
        FrontBackResult r = frontBackSplit(head1, front, back);
        printList(r.front);
        printList(r.back);
    }

    static FrontBackResult frontBackSplit(Node head, Node front, Node back) {
        front = back = head;
        while (front != null && front.next != null) {
            front = front.next.next;
            back = back.next;
        }

        front = head;
        Node last = back;
        back = back.next;
        last.next = null;
        return new FrontBackResult(front, back);
    }

    static class FrontBackResult {
        Node front;
        Node back;

        FrontBackResult(Node front, Node back) {
            this.front = front;
            this.back = back;
        }
    }
}