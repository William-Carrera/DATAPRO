package impl;

import java.util.Iterator;
import java.util.NoSuchElementException;

import adt.Set;

public class StrippedDownSet<E> implements Set<E> {

    private E[] internal;
    private int size;
    
    @SuppressWarnings("unchecked")
    public StrippedDownSet(int capacity) {
        internal = (E[]) new Object[capacity];
        size = 0;
    }
    

    public void add(E item) {
        assert size < internal.length;
        internal[size++] = item;
    }

    public boolean contains(E item) {
        boolean foundIt = false;
        for (int i = 0; !foundIt && i < size; i++)
            foundIt = internal[i].equals(item);
        return foundIt;
    }

    public void remove(E item) {
        throw new UnsupportedOperationException();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int i = 0;
            public boolean hasNext() {
                return i < size;
            }
            public E next() {
                if (! hasNext()) throw new NoSuchElementException();
                else return internal[i++];
            }
        };
    }
    
    @Override
    public String toString() {
        String toReturn = "{";
        for (int i = 0; i < size; i++) {
            toReturn += internal[i];
            if (i + 1 < size) toReturn += ", ";
        }
        toReturn += "}";
        return toReturn;
    }

}
