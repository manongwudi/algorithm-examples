package com.wudimanong.algorithm;

/**
 * @author jiangqiao
 * @desc 指针法判断链表是否有环的问题
 */
public class LinkListCycleTest {

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        //指针2
        ListNode p1 = head;

        //指针2
        ListNode p2 = head.next;
        //结果
        ListNode resultNode = null;
        while (p2 != null && p2.next != null) {
            if (p1 == p2.next) {
                System.out.println("the cycle begins is ->" + p1.val);
                resultNode = p1;
                break;
            }
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return resultNode;
    }

    /**
     * 测试程序
     *
     * @param args
     */
    public static void main(String args[]) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        ListNode resultNode = detectCycle(node1);
        System.out.println("cycle begins is ->" + resultNode.val);
    }
}

/**
 * 链表节点定义
 */
class ListNode {

    /**
     * 当前值
     */
    int val;
    /**
     * next节点
     */
    ListNode next;

    /**
     * 构造方法
     *
     * @param val
     */
    ListNode(int val) {
        this.val = val;
    }

}