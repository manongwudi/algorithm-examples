package com.wudimanong.algorithm.leecode.linktable;


/**
 * @author jiangqiao
 * @desc 链表，删除相邻重复节点（例如abbb->a;abbbca->c;aba->aba）
 */
public class LinkTableDelNearByDuplicationNode {

    /**
     * 删除相邻重复节点
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplication(ListNode head) {
        if (head == null) {
            return null;
        }
        // 临时的头结点
        ListNode root = new ListNode();
        root.setNext(head);
        // 记录前驱结点
        ListNode prev = root;
        //记录当前节点
        ListNode currentNode = head;
        while (currentNode != null && currentNode.getNext() != null) {
            if (currentNode.getVal().equals(currentNode.getNext().getVal())) {
                //继续找下一个不同的值
                while ((currentNode.getNext() != null && currentNode.getNext().getVal().equals(currentNode.getVal()))) {
                    currentNode = currentNode.getNext();
                }
                //指向下一个节点，prev.next也可能是重复节点
                prev.setNext(currentNode.getNext());
            } else {
                prev.setNext(currentNode);
                prev = prev.getNext();
            }
            //当前节点指针下移
            currentNode = currentNode.getNext();
        }
        return root.getNext();
    }

    public static void main(String args[]) {
        ListNode node3 = new ListNode();
        node3.setVal("b");
        ListNode node2 = new ListNode();
        node2.setVal("b");
        node2.setNext(node3);
        ListNode node1 = new ListNode();
        node1.setVal("b");
        node1.setNext(node2);
        ListNode head = new ListNode();
        head.setVal("a");
        head.setNext(node1);
        ListNode resultNode = deleteDuplication(head);
    }
}

class ListNode {

    private String val;
    private ListNode next;

    public ListNode() {

    }

    public ListNode(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
