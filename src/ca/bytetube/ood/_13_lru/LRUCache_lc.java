package ca.bytetube.ood._13_lru;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/lru-cache/
 *
 * @author dall.
 */
public class LRUCache_lc {
    private HashMap<Integer, Node> cache;
    private Node head, tail;
    private int capacity;


    public LRUCache_lc(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    //HashMap中查找
    //1.如果key存在：在链表中删除该节点，插入到head之后,返回该节点所对应的值
    //2.如果key不存在：return -1；
    public int get(int key) {
        if (!cache.containsKey(key)) return -1;

        Node node = cache.get(key);
        remove(node);
        addNodeToHead(node);
        return node.value;
    }

    private void addNodeToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    //1.如果key已存在：更新value，删除现有节点，并将其移动到head
    //2.如果key不存在：
    //2.1capacity满了：删除tail.prev(lru node),插入新节点到head之后
    //2.2capacity没满：插入新节点到head之后
    //dummyNode
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            remove(node);
            addNodeToHead(node);
        } else {
            if (cache.size() >= capacity) {
                Node lru = tail.prev;
                remove(lru);
                cache.remove(lru.key);
            }

            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addNodeToHead(newNode);

        }

    }

    private class Node {
        int key, value;
        Node prev, next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
