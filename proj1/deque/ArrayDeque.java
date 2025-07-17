package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private T[] items;
    private int size;
    private int front;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        front = 0;
    }

    private void resize(int capacity) {
        T[] temp = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            int oldindex = (front + i) % items.length;
            temp[i] = items[oldindex];
        }
        items = temp;
        front = 0;
    }

    public void addFirst(T x) {
        if (size == items.length) {
            resize(2 * size);
        }
        int newfront = (front - 1 + items.length) % items.length;
        front = newfront;
        items[newfront] = x;
        size++;
    }

    public void addLast(T x) {
        if (size == items.length) {
            resize(2 * size);
        }
        int newlast = (front + size) % items.length;
        items[newlast] = x;
        size++;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            int index = (i + front) % items.length;
            if (i == size - 1) {
                System.out.print(items[index]);
            } else {
                System.out.print(items[index] + " ");
            }
        }
        System.out.println();
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T temp = items[front];
        items[front] = null;
        front = (front + 1) % items.length;
        size--;
        if (size < items.length / 4 && size > 8) {
            resize(items.length / 2);
        }
        return temp;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T temp = items[(front + size - 1) % items.length];
        items[(front + size - 1) % items.length] = null;
        size--;
        if (size < items.length / 4 && size > 8) {
            resize(items.length / 2);
        }
        return temp;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        int pos = (front + index) % items.length;
        return items[pos];
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
        for (int i = 0; i < this.size(); i++) {
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

    private T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return getRecursiveHelper(front, index);
    }

    private T getRecursiveHelper(int cur, int step) {
        if (step == 0) {
            return items[cur];
        }
        return getRecursiveHelper((cur + 1) % items.length, step - 1);
    }

    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    private class ArrayDequeIterator implements Iterator<T> {
        private int currentIndex = 0;

        public boolean hasNext() {
            return currentIndex < size;
        }

        public T next() {
            T item = get(currentIndex);
            currentIndex++;
            return item;
        }
    }
}
