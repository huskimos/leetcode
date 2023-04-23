/**
 * create by yangliu on 2023/4/23
 * package name :
 */
class Solution24 : Solution() {
    override fun solve() {
        printLinkedList(swapPairs(createLinkedList(intArrayOf(1,2,3,4,5))))
    }

    private fun swapPairs(head: ListNode?): ListNode? {
        head ?: return null
        return head.next?.let {
            val third = swapPairs(it.next)
            it.next = head
            head.next = third
            it
        } ?:  head
    }

    override fun link(): String {
        return "https://leetcode.com/problems/swap-nodes-in-pairs/"
    }

    override fun title(): String {
        return "Swap Nodes in Pairs"
    }

    override fun description(): String {
        return "两两交换链表节点"
    }

    override fun thinking(): String {
        return "递归是比较简单的解决方法"
    }
}