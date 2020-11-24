/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Iterator;

/**
 *
 * @author AVILAN MORENO
 */
public class QueueLL<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int num;

    public QueueLL() {
        first = null;
        last = null;
        num = 0;
    }

    private class Node {

        Item item;
        Node next;
    }

    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        num++;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }

        num--;
        return item;

    }

    public int size() {
        return num;
    }

    public Boolean isEmpty() {
        return first == null;
    }

    @Override
    public Iterator<Item> iterator() {
        return new QueueLLIterator();
    }

    private class QueueLLIterator implements Iterator<Item> {

        Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

    }

}
