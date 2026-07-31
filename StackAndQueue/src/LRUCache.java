package StackAndQueue.src;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
        private static class Node {
            int key,val;

            Node next = null, prev = null;

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        Map<Integer, Node> map;
        int capacity;
        Node head, tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();

            head = new Node(-1, -1);
            tail = new Node(-1, -1);

            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (!map.containsKey(key))
                return -1;
            Node node = map.get(key);
            deleteNode(node);
            insertAfterHead(node);

            return node.val;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.val = value;
                deleteNode(node);
                insertAfterHead(node);
            }

            else {
                if (map.size() == capacity) {
                    Node node = tail.prev;
                    map.remove(node.key);
                    deleteNode(node);
                }

                Node node = new Node(key, value);
                map.put(key, node);
                insertAfterHead(node);
            }
        }

        private void insertAfterHead(Node node) {
            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;
        }

        private void deleteNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;

            node.next = node.prev = null;
        }

}
