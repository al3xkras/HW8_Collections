package ua.alexkras;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;

public class NoDeletionLinkedList<E> extends AbstractList<E> implements Iterable<E>, Iterator<E> {
    private Node<E> nodeStart;
    private Node<E> nodeEnd;
    private Node<E> iterateNode;

    private int size;

    public NoDeletionLinkedList(Collection<E> collection){
        Node<E> prevNode;
        Node<E> currentNode = null;

        size = collection.size();

        for (E e: collection){
            if (nodeStart==null){
                nodeStart=new Node<>(null,e,null);
                currentNode=nodeStart;
                continue;
            }

            prevNode = currentNode;

            currentNode = new Node<>(prevNode,e,null);

            prevNode.next = currentNode;
        }

        nodeEnd = currentNode;

        iterateNode = nodeStart;
    }

    public void addFirst(E e){
        nodeStart= new Node<>(null ,e, nodeStart);
        size++;
    }

    public void addLast(E e){
        Node<E> newNodeEnd = new Node<>(nodeEnd,e,null);
        nodeEnd.next=newNodeEnd;
        nodeEnd=newNodeEnd;
        size++;
    }

    public E getFirst(){
        return nodeStart.item;
    }

    public E getLast(){
        return nodeEnd.item;
    }

    @Override
    public E get(int index){
        if (index<0 || index>=size){
            throw new IndexOutOfBoundsException();
        }

        this.iterateNode = nodeStart;
        for (int i=0; i<index; i++){
            this.next();
        }

        E out = this.next();

        this.iterateNode = nodeStart;

        return out;
    }

    @Override
    public Iterator<E> iterator() {
        if (!hasNext()) this.iterateNode=nodeStart;
        return this;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean hasNext() {
        return !(iterateNode==null);
    }

    @Override
    public E next() {

        E item = iterateNode.item;

        iterateNode = iterateNode.next;
        return item;
    }

    private static class Node<E>{
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next){
            this.item = element;
            this.prev = prev;
            this.next = next;
        }
    }


}
