package com.wudimanong.algorithm;

import java.util.HashMap;

/**
 * @author jiangqiao
 * @desc LRU算法的实现
 */
public class LRU {

    /**
     * 定义节点数据结构
     */
    static class Node {

        //键
        private String key;
        //值
        private String value;

        //前驱节点
        private Node pre;
        //后继节点
        private Node next;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * 头节点
     */
    private Node head;

    /**
     * 尾节点
     */
    private Node end;

    /**
     * 缓存存储上限
     */
    private int limit;

    private HashMap<String, Node> hashMap;

    public LRU(int limit) {
        this.limit = limit;
        hashMap = new HashMap<String, Node>();
    }

    /**
     * 加入缓存
     *
     * @param key
     * @param value
     */
    public void put(String key, String value) {
        Node node = hashMap.get(key);
        if (node == null) {
            //如果key不存在，插入key-value
            if (hashMap.size() >= limit) {
                String oldKey = removeNode(head);
                hashMap.remove(oldKey);
            }
            node = new Node(key, value);
            addNode(node);
            hashMap.put(key, node);
        } else {
            //如果key存在，刷新key-value
            node.value = value;
            refreshNode(node);
        }
    }

    /**
     * 刷新被访问的节点位置
     *
     * @param node
     */
    public void refreshNode(Node node) {
        if (node == end) {
            return;
        }
        //移除节点
        removeNode(node);
        //重新插入节点
        addNode(node);

    }

    /**
     * 尾部插入节点
     *
     * @param node
     */
    public void addNode(Node node) {
        if (end != null) {
            end.next = node;
            node.pre = end;
            node.next = null;
        }
        end = node;
        if (head == null) {
            head = node;
        }
    }

    public void remove(String key) {
        Node node = hashMap.get(key);
        removeNode(node);
        hashMap.remove(key);
    }

    public String removeNode(Node node) {
        if (node == end) {
            //移除尾部节点
            end = end.pre;
        } else if (node == head) {
            //移除头节点
            head = head.next;
        } else {
            //移除中间节点
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        return node.key;
    }

    public String get(String key) {
        Node node = hashMap.get(key);
        if (node == null) {
            return null;
        }
        refreshNode(node);
        return node.value;
    }

    /**
     * 测试代码
     */
    public static void main(String[] args) {
        LRU lruCache = new LRU(5);
        lruCache.put("001", "用户信息1");
        lruCache.put("002", "用户信息2");
        lruCache.put("003", "用户信息3");
        lruCache.put("004", "用户信息4");
        lruCache.put("005", "用户信息5");
        System.out.println(lruCache.get("002"));
        lruCache.put("004", "用户信息4更新");
        lruCache.put("006", "用户信息6");

        System.out.println(lruCache.get("001"));
        System.out.println(lruCache.get("006"));
    }
}
