package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {
    private class ItemNode {
        private T item;
        private ItemNode next;
        private ItemNode pre;

        ItemNode(T i, ItemNode next1, ItemNode pre1) {
            item = i;
            next = next1;
            pre = pre1;
        }
    }

    private ItemNode sentFront;
    private int size;
    private ItemNode sentBack;

    public LinkedListDeque() {
        sentFront = new ItemNode(null, null, null);
        sentBack = new ItemNode(null, null, null);
        sentFront.next = sentBack;
        sentBack.pre = sentFront;
        size = 0;
    }

    public void addFirst(T x) {
        ItemNode sentFrontNext = sentFront.next;
        ItemNode insertion = new ItemNode(x, sentFrontNext, sentFront);
        sentFront.next = insertion;
        sentFrontNext.pre = insertion;
        size = size + 1;
    }

    public void addLast(T x) {
        size = size + 1;
        ItemNode sentBackPre = sentBack.pre;
        ItemNode insertion = new ItemNode(x, sentBack, sentBackPre);
        sentBack.pre = insertion;
        sentBackPre.next = insertion;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        ItemNode p = sentFront.next;
        while (p != null) {
            if (p.next == null) {
                System.out.print(p.item);
            } else {
                System.out.print(p.item + " ");
            }
            p = p.next;
        }
        System.out.println();
    }

    public T removeFirst() {
        if (sentFront.next == sentBack && sentBack.pre == sentFront) {
            return null;
        }
        ItemNode p = sentFront.next;
        p.next.pre = sentFront;
        sentFront.next = p.next;
        p.next = null;
        p.pre = null;
        size--;
        return p.item;
    }

    public T removeLast() {
        if (sentFront.next == sentBack && sentBack.pre == sentFront) {
            return null;
        }
        ItemNode p = sentBack.pre;
        p.pre.next = sentBack;
        sentBack.pre = p.pre;
        p.next = null;
        p.pre = null;
        size--;
        return p.item;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        ItemNode p = sentFront.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.item;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Deque)) {
            return false;
        }
        Deque<?> other = (Deque<?>) o;
        if (this.size() != other.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            T thisItem = this.get(i);
            Object otherItem = other.get(i);
            if (thisItem == null) {
                if (otherItem != null) {
                    return false;
                }
            } else {
                if (!thisItem.equals(otherItem)) {
                    return false;
                }
            }
        }
        return true;
    }

    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return getRecursiveHelper(sentFront.next, index);
    }

    private T getRecursiveHelper(ItemNode node, int index) {
        if (index == 0) {
            return node.item;
        }
        return getRecursiveHelper(node.next, index - 1);
    }

    public Iterator<T> iterator() {
        return new LinkedListDequeIterator();
    }

    private class LinkedListDequeIterator implements Iterator<T> {
        private ItemNode current = sentFront.next;

        public boolean hasNext() {
            return current != sentBack;
        }

        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }
    }
}
