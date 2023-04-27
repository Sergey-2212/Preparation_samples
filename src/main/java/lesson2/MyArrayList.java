package lesson2;

import java.util.*;

public class MyArrayList<T> implements Collection<T> {

    private static final int EMPTY_CAPACITY = 0;
    private Object[] data;
    private int size;

    public MyArrayList() {
        data = new Object[EMPTY_CAPACITY];
        size = 0;
    }

    public MyArrayList(int initialCapacity) {
        rangeCheck(initialCapacity);
        if(initialCapacity == 0) {
           new MyArrayList();
        } else {
            data = new Object[initialCapacity];
            size = initialCapacity;
        }
    }

    private void rangeCheck(int index) {
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    public T get (int index) {
        rangeCheck(index);
        return (T) data[index];
    }

    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size();
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
            for (int i = 0; i < size; i++) {
                if (data[i] == null) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(data[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    private class Iterator<E> implements java.util.Iterator<E> {

        int lastReturnedElementIndex;

        @Override
        public boolean hasNext() {
            return lastReturnedElementIndex < size - 1;
        }

        @Override
        public E next() {
            lastReturnedElementIndex++;
            return (E) data[lastReturnedElementIndex];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>();
    }

    @Override
    public Object[] toArray() {
        if(size == 0) {
            return new Object[0];
        } else {
            return trimToSize();
        }
    }

    private Object[] trimToSize() {
        if(data.length == size) {
            return data;
        } else {
            return Arrays.copyOf(data, data.length);
        }
    }

    private void grow() {
        if (size == EMPTY_CAPACITY) {
            data = new Object[10];
        } else if(size < Integer.MAX_VALUE) {
            int newCapacity = size + (size >> 1);

          Object[] newData =  Arrays.copyOfRange(data, 0, size -1);
          data = newData;
        }
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return a;
    }

    @Override
    public boolean add(T t) {
        if(size == data.length -1 || size == 0) {
            grow();
        }

        if(size == Integer.MAX_VALUE) {
            throw new IndexOutOfBoundsException("Maximum capacity is reached");
        }

        data[size] = t;
        size++;
        return false;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (data[i] == null) {
                    final int newSize;
                    newSize = size - 1;
                    System.arraycopy(data, i + 1, data, i, newSize - i);
                    data[size = newSize] = null;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(data[i])) {
                    final int newSize;
                    newSize = size - 1;
                    System.arraycopy(data, i + 1, data, i, newSize - i);
                    data[size = newSize] = null;
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        data = new Object[EMPTY_CAPACITY];
    }
}


