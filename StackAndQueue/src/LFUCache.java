package StackAndQueue.src;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    private static class Node {
        int key;
        int value;
        int freq;

        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    private static class DoublyLinkedList {

        Node head;
        Node tail;
        int size;

        DoublyLinkedList() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);

            head.next = tail;
            tail.prev = head;
        }

        void addFirst(Node node) {

            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;

            size++;
        }

        void remove(Node node) {

            node.prev.next = node.next;
            node.next.prev = node.prev;

            size--;
        }

        Node removeLast() {

            if (size == 0)
                return null;

            Node node = tail.prev;
            remove(node);

            return node;
        }

        boolean isEmpty() {
            return size == 0;
        }
    }

    private final int capacity;
    private int minFreq;

    private final Map<Integer, Node> nodeMap;
    private final Map<Integer, DoublyLinkedList> freqMap;

    public LFUCache(int capacity) {

        this.capacity = capacity;

        nodeMap = new HashMap<>();
        freqMap = new HashMap<>();

        minFreq = 0;
    }

    public int get(int key) {

        if (!nodeMap.containsKey(key))
            return -1;

        Node node = nodeMap.get(key);

        updateFrequency(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (capacity == 0)
            return;

        if (nodeMap.containsKey(key)) {

            Node node = nodeMap.get(key);

            node.value = value;

            updateFrequency(node);

            return;
        }

        if (nodeMap.size() == capacity) {

            DoublyLinkedList list = freqMap.get(minFreq);

            Node remove = list.removeLast();

            nodeMap.remove(remove.key);
        }

        Node node = new Node(key, value);

        nodeMap.put(key, node);

        freqMap.computeIfAbsent(1, k -> new DoublyLinkedList())
                .addFirst(node);

        minFreq = 1;
    }

    private void updateFrequency(Node node) {

        int oldFreq = node.freq;

        DoublyLinkedList oldList = freqMap.get(oldFreq);

        oldList.remove(node);

        if (oldFreq == minFreq && oldList.isEmpty())
            minFreq++;

        node.freq++;

        freqMap.computeIfAbsent(node.freq,
                        k -> new DoublyLinkedList())
                .addFirst(node);
    }
}