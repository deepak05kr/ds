package linkedlist;

public class LinkedList<T> {
    private ListNode head;

    public LinkedList() {
        this.head = null;
    }

    public void addFirst(T data) {
        ListNode node = new ListNode(data);
        if (this.head == null) {
            this.head = node;
            return;
        }
        node.setNext(this.head);
        this.head = node;
    }

    public ListNode getHead() {
        return head;
    }

    public void setHead(ListNode head) {
        this.head = head;
    }
    public void print(){
        ListNode curr = this.head;
        while (curr!=null){
            System.out.print(curr.getData()+" ");
            curr = curr.getNext();
        }
        System.out.println();
    }
}
