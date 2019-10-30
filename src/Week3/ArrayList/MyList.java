package Week3.ArrayList;

import java.util.*;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException("Capacity can not be negative");
        else elements = new Object[capacity];
    }

    private void ensureCapacity(int minCapacity) {
        int newSize = elements.length + minCapacity;
        elements = Arrays.copyOf(elements, newSize);
    }

    public void add(int index, E element) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index out of range");
        } else {
            if (size == elements.length) {
                ensureCapacity(1);
            }
            for (int i = size; i >= index; i--) {
                elements[i + 1] = elements[i];
            }
            elements[index] = element;
            size++;
        }
    }

    public E remove(int index) {
        E temp = (E) elements[index];
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index out of range");
        } else {
            for (int i = 0; i < size; i++) {
                if (i == index) {
                    for (int j = index; j < size - 1; j++) {
                        elements[j] = elements[j + 1];
                    }
                    size--;
                }
            }
        }
        return temp;
    }

    public int size() {
        return size;
    }

    public Object clone(){
        MyList<E> cloneList = new MyList<>();
        cloneList.elements = Arrays.copyOf(elements, elements.length);
        return cloneList;
    }

    public boolean contains(E o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(get(i)))
                return true;
        }
        return false;
    }

    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(get(i))) {
                return i;
            }
        }
        return -1;
    }

    public boolean add(E e) {
        add(size, e);
        return true;
    }

    public void clear() {
        size = 0;
    }

    public E get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        return (E) elements[i];
    }

}
