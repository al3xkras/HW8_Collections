package ua.alexkras;

import java.util.Collection;
import java.util.Iterator;

public class NoDeletionArrayList<E> implements  Iterable<E>, NoDeletionList<E> {
    private static final int initialSize = 2;
    private int endIndex = 0;
    private E[] values;

    public NoDeletionArrayList(Collection<E> collection){
        values = (E[]) new Object[initialSize];
        this.addAll(collection);
    }

    public NoDeletionArrayList(){
        values = (E[]) new Object[initialSize];
    }

    @Override
    public boolean add(E e) {
        if (endIndex<values.length) {
            //O(1)
            values[endIndex++] = e;
            return true;
        }

        //O(n)
        E[] tmp = values;

        try {
            values = (E[]) new Object[tmp.length * 2];
        } catch (ClassCastException ex){
            return false;
        }
        System.arraycopy(tmp, 0, values, 0, tmp.length);

        values[endIndex++] = e;
        return true;
    }

    @Override
    public void addAll(Collection<E> collection){
        for (E e: collection){
            this.add(e);
        }
    }

    @Override
    public E get(int index) {
        return values[index];
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public void update(int index, E e) {
        values[index] = e;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<>(values);
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("NoDeletionArrayList: [ ");
        for (int i=0; i<endIndex;i++){
            str.append(values[i]);
            str.append(", ");
        }
        str.append("]");
        return str.toString();
    }
}
