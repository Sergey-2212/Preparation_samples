package lesson2;

import lombok.EqualsAndHashCode;

import java.util.Collection;
import java.util.NoSuchElementException;

@EqualsAndHashCode
public class MyLinkedList<T> implements Collection<T> {

    private transient int size;
    private Node <T> first;
    private Node <T> last;

    public MyLinkedList() {
        first = new Node<>(null, null, null);
        last = new Node<>(first, null, null);
        first.next = last;
        last.previous = first;
        size = 0;
    }




    @EqualsAndHashCode
    private static class Node <T> {
        private Node previous;
        private T value;
        private Node next;

        private Node(Node previous, T value, Node next) {

        }

    }

    private class Iterator<T> implements java.util.Iterator<T> {
        private Node<T> lastReturned;
        private Node<T> nextIterable;
        private int nextIndex;

        public Iterator() {
            lastReturned = null;
            nextIndex = 0;
        }


        public boolean hasNext() {
            return nextIndex < size;
        }

        public T next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            if(lastReturned == null) {
                lastReturned = (Node<T>) first;
                nextIterable = first.next;
                nextIndex++;
                return lastReturned.value;
            }

            Node<T> l = lastReturned.next;
            lastReturned = l;
            nextIterable = l.next;
            nextIndex++;
            return lastReturned.value;
        }


    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            for (Node<T> x = first; x != null; x = x.next) {
                if (x.value == null) {
                      return true;
                }
            }
        } else {
            for (Node<T> x = first; x != null; x = x.next) {
                if (o.equals(x.value)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>();
    }

    @Override
    public Object[] toArray() {
        Object[] list = new Object[size];
        Iterator<T> it = new Iterator<>();
        int index = 0;
        while(it.hasNext()) {
            list[index] = it.next();
            index++;
        }
        return list;
    }

    public boolean add(T o) {

       if(first.value == null) {
           first.value = o;
           size++;
           return true;
       }

       if(last.value == null) {
            last.value = o;
            size++;
            return true;
       }

       Node<T> l = last;
       Node<T> added = new Node(last, o, null);
       l.next = added;
       last = added;
       size++;
       return true;

    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (Node<T> x = first; x != null; x = x.next) {
                if (x.value == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<T> x = first; x != null; x = x.next) {
                if (o.equals(x.value)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    private void unlink(Node<T> x) {
        x.previous.next = x.next;
        x.next.previous = x.previous;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {
        first.value = null;
        first.next = last;
        last.value = null;
        last.previous = first;
        size = 0;

    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
