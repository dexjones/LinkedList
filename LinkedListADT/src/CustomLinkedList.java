import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomLinkedList<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> tail;
    private Node<T> curr;
    private int listSize;

    private static class Node<T> {
        T element;
        Node<T> next;

        Node(T element) {
            this.element = element;
            this.next = null;
        }
    }
    public CustomLinkedList() {
        head = tail = curr = null;
        listSize = 0;
    }
    //clear all elements
    public void clear() {
        head = tail = curr = null;
        listSize = 0;
    }
    // Insert newItem at current position
    public boolean insert(T newItem) {
        if (listSize == 0) {
            head = new Node<>(newItem);
            tail = head;
            curr = head;
        }
        else if (curr == head) {
            Node<T> temp = new Node<>(newItem);
            temp.next = head;
            head = temp;
            curr = head;
        }
        else if (curr == null) {
            return false;
        }
        else {
            Node<T> temp = head;
            while (temp.next != curr) {
                temp = temp.next;
            }
            temp.next = new Node<>(newItem);
            temp.next.next = curr;
            curr = temp.next;
        }
        listSize++;
        return true;
    }
    // Append newItem to the end of the list
    public boolean append(T newItem) {
        if (listSize == 0) {
            head = new Node<>(newItem);
            tail = head;
            curr = head;
        } else {
            tail.next = new Node<>(newItem);
            tail = tail.next;
        }
        listSize++;
        return true;
    }
    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }
    private class LinkedListIterator implements Iterator<Integer> {
        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int data = current.data;
            current = current.next;
            return data;
        }
    }

    // Other methods...
}

