package impl;

import java.util.Iterator;
import adt.Map;
import adt.List;

/**
 * MapList
 * 
 * An implementation of List that uses a Map as its
 * underlying implementation.
 * 
 * CSCI 345, Wheaton College
 * Spring 2016
 * @param <E> The base-type of the list
 */
public class MapList<E> implements List<E> {

    /**
     * The internal representation (can be any 
     * implementation of map).
     */
    private Map<Integer, E> internal;
    
    /**
     * Keeps track of the size of the array
     */
    int size;
    
    /**
     * Constructor that is given the internal representation.
     * From a software development perspective, that's a bad idea
     * (breaks encapsulation), but for the purpose of this project 
     * it allows us to parameterize this class by what implementation
     * of Map we use. (Maybe in a future version we'll use 
     * reflection instead).
     */
    public MapList() {
        this.internal = new ArrayMap<Integer,E>();
        size =0;
    }
    
    /**
     * Return an iterator over this collection (remove() is
     * unsupported, nor is concurrent modification checked).
     */
    public Iterator<E> iterator() {
         return new Iterator<E>() {
        	int index =0;
			@Override
			public boolean hasNext() {
				return index<size;
			}

			@Override
			public E next() {
				return internal.get(index++);
				
			}
        	 
         };
    }

    /**
     * Append the specified element to the end of this list.
     * This increases the size by one.
     * @param element The element to be appended
     */
    public void add(E element) {
    	internal.put(size,element);
    	size++;
    }

    /**
     * Replace the element at the specified position in this list
     * with the specified element. If the index is invalid, an 
     * IndexOutOfBoundsException is thrown.
     * @param index The index of the element to return
     * @param element The element at the specified position
     */
    public void set(int index, E element) {
    	if(index>=size || index<0)
    		throw new IndexOutOfBoundsException();
    	internal.remove(index);
    	internal.put(index,element);
    }

    /**
     * Retrieve the element at the specified position in this list.
     * If the index is invalid, an IndexOutOfBoundsException is thrown.
     * @param index The index of the element to return
     * @return The element at the specified position
     */
    public E get(int index) {
    	if(index>=size || index<0)
    		throw new IndexOutOfBoundsException();
    	return internal.get(index);
    }


    /**
     * Insert a new item at the specified position, shifting the
     * item already at the position and everything after it over
     * one position. If the index is equal to the length of the list,
     * then this is equivalent to the add method. If the index is 
     * negative or is greater than the length, an IndexOutOfBoundsException 
     * is thrown.
     * @param index The index into which to insert the element
     * @param element The element which to insert
     */
    public void insert(int index, E element) {
    	if(index==size) {
    		this.add(element);
    		return;
    	}else if(index>size || index<0)
    		throw new IndexOutOfBoundsException();
    	E temp1 = internal.get(index);
    	E temp2;
    	internal.remove(index);
    	internal.put(index, element);
    	for(int i = index+1;i<size;i++) {
    		temp2 = internal.get(i);
    		internal.remove(i);;
    		internal.put(i, temp1);
    		temp1=temp2;
    	}
    	if(temp1!=null) {
    		this.add(temp1);
    	}
    }

    /**
     * Remove (and return) the element at the specified position.
     * This reduces the size of the list by one and, if necessary,
     * shifts other elements over. If the index is invalid, an 
     * IndexOutOfBoundsException is thrown.
     * @param index The index of the element to remove
     * @return The item removed
     */
   public E remove(int index) {
	   if(index>=size || index<0) {
		   	throw new IndexOutOfBoundsException();
	   }
	   E toReturn = internal.get(index);
	   for(int i=index;i<size-1;i++) {
		   internal.remove(i);
		   internal.put(i, internal.get(i+1));
	   }
	   internal.remove(--size);
	   return toReturn;
   }

   /**
    * Return the number of elements in this list.
    * @return The number of elements in this list.
    */
    public int size() {
         return size;
    }
    
    @Override
    public String toString() {
    	String toReturn = "[";
        boolean prefix = false;
    	for (E item : this) {
            if (prefix)
                toReturn += ", ";
    		toReturn += item;
            prefix = true;
    	}
    	return toReturn +"]";
    }
    
    	


}
