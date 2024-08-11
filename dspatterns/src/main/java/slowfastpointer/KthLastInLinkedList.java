package slowfastpointer;

import linkedlist.LinkedList;
import linkedlist.ListNode;

public class KthLastInLinkedList<T> {
    public T findKthLast(LinkedList linkedList, int k) {
        ListNode head = linkedList.getHead();
        if (head == null) {
            return null;
        }
        int count = 0;
        ListNode<T> slow = head, fast = head;
        while (count < k && fast != null) {
            fast = fast.getNext();
            count++;
        }
        while (fast != null) {
            slow = slow.getNext();
            fast = fast.getNext();
        }
        return slow.getData();
    }

    public static void main(String[] args) {
        KthLastInLinkedList obj = new KthLastInLinkedList();
        LinkedList linkedList = new LinkedList();
        for (int i = 9; i >= 1; i--) {
            linkedList.addFirst(i);
        }
        linkedList.print();
        System.out.println(obj.findKthLast(linkedList, 2));
        System.out.println(obj.findKthLast(linkedList, 4));
        System.out.println(obj.findKthLast(linkedList, 6));

    }
}
