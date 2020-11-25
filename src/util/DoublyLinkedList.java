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
public class DoublyLinkedList <Item> implements Iterable<Item> {
    Node first;
    Node last;
    int num;

    public DoublyLinkedList() {
        first = null;
        last = null;
        num = 0;
    }

    private class Node {

        Item item;
        Node next;
        Node previous;
    }

    public void addLast(Item item) {
        if (isEmpty()) {
            addFirst(item);
        } else {
            Node oldLast = last;
            last = new Node();
            last.item = item;
            oldLast.next = last;
            last.previous = oldLast;
            num++;
        }

    }

    public void addFirst(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        first.previous = null;
        if (isEmpty()) {
            last = first;
        }
        num++;
    }

    public void add(int index, Item item) {
        Node newNode = new Node();
        newNode.item = item;
        Node current = getNode(index);
        if (current == null) {
            return;
        }
        if (current.previous != null) {
            current.previous.next = newNode;
            newNode.previous = current.previous;
            current.previous = newNode;
            newNode.next = current;
            num++;
        } else {
            //index == 0
            addFirst(item);
            return;

        }

    }

    public Item get(int index) {
        return getNode(index).item;
    }

    public Item get(Item item) {
        return getNode(item).item;
    }

    private Node getNode(int index) {
        int contador = 0;
        Node current = first;
        while (contador < num) {
            if (contador == index) {
                return current;
            }
            current = current.next;
            contador++;
        }
        return null;
    }

    private Node getNode(Item item) {
        int contador = 0;
        Node current = first;
        while (contador < num) {
            if (current.item.equals(item)) {
                return current;
            }
            current = current.next;
            contador++;
        }
        return null;
    }

    public Item removeFirst() {
        Item item = first.item;
        if (first != last) {
            first = first.next;
            first.previous = null;
        } else {
            first = null;
        }
        num--;
        return item;
    }

    public Item removeLast() {
        Item item = last.item;
        if (first != last) {
            last = last.previous;
            last.next = null;
        } else {
            last = null;
        }
        num--;
        return item;
    }

    public Item remove(int index) {
        Node current = getNode(index);
        if (current == null) {
            return null;
        } else {
            Item item = current.item;
            if (current.previous != null) {
                current.previous.next = current.next;
            } else {
                return removeFirst();
            }
            if (current.next != null) {
                current.next.previous = current.previous;
            } else {
                return removeLast();
            }
            num--;
            return item;
        }
    }

    public Item remove(Item i) {
        Node current = getNode(i);
        if (current == null) {
            return null;
        } else {
            Item item = current.item;
            if (current.previous != null) {
                current.previous.next = current.next;
            } else {
                return removeFirst();
            }
            if (current.next != null) {
                current.next.previous = current.previous;
            } else {
                return removeLast();
            }
            num--;
            return item;
        }

    }

    public int indexOf(Item i) {
        int contador = 0;
        Node current = first;
        while (contador < num) {
            if (current.item.equals(i)) {
                return contador;
            }
            current = current.next;
            contador++;
        }
        return -1;
    }

    public Boolean isEmpty() {
        return num == 0;
    }

    public int size() {
        return num;
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedListIterator();

    }

    private class LinkedListIterator implements Iterator<Item> {

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
