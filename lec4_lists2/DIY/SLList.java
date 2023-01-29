package lec4_lists2.DIY;

/** This is a fill in the blanks version of the SLList class
 *  in case you want to try to figure out how to write it yourself.
 */
public class SLList {
    private static class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
        public String toString() {
            if (next == null) { return Integer.toString(item); }
            StringBuilder sb = new StringBuilder();
            sb.append(item);
            sb.append("->");
            sb.append(next);
            return sb.toString();
        }
    }
    /*The first item (if it exists) is sentinel.next*/
    private IntNode sentinel;
    private int size;

    public SLList() {
        sentinel = new IntNode(0, null);
        size = 0;
    }

    public SLList(int x) {
        sentinel = new IntNode(0, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    public SLList(int[] array) {
        sentinel = new IntNode(0, null);
        for (int e : array) {
            addLast(e);
        }
    }
    /** Adds an item to the front of the list. */
    public void addFirst(int x) {
        size++;
        sentinel.next = new IntNode(x, sentinel.next);
    }

    /** Retrieves the front item from the list. */
    public int getFirst() {
        return sentinel.next.item;
    }

    /** Adds an item to the end of the list. */
    public void addLast(int x) {
        IntNode p = sentinel;
        while (p.next != null) {
            p = p.next;
        }
        size++;
        p.next = new IntNode(x, null);
    }

    public int size() {
        return size;
    }

    public void deleteFirst() {
        sentinel.next = sentinel.next.next;
    }

    public String toString() { return sentinel.next.toString(); }

    public static void main(String[] args) {
        /* Creates a list of one integer, namely 10 */
        SLList L = new SLList(new int[]{1, 5, 9});
        /*L.addFirst(1);
        L.addLast(2);
        L.addFirst(3);
        L.addFirst(4);
        L.deleteFirst();*/
        System.out.println(L);
        System.out.println(L.size());
    }
}

