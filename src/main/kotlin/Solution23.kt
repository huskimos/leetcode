import java.util.*

/**
 * create by yangliu on 2023/4/23
 * package name :
 */
class Solution23 : Solution() {
    override fun solve() {
        printLinkedList(mergeKLists(arrayOf(
            createLinkedList(intArrayOf(1,4,5)),
            createLinkedList(intArrayOf(1,3,4)),
            createLinkedList(intArrayOf(2,6)),
        )))
    }


    private fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val dummy = ListNode(-1)
        var tail = dummy
        // 注意，优先队列里面不允许插入null
        val heap = PriorityQueue<ListNode> { o1, o2 -> o1.`val` - o2.`val` }
        for (head in lists) {
            head?.let { heap.add(it) }
        }
        while (heap.peek() != null) {
            val current = heap.poll()!!
            val next = current.next
            tail.next = current
            tail = current
            current.next = null
            next?.let { heap.add(it) }
        }
        return dummy.next
    }

    override fun link(): String {
        return "https://leetcode.com/problems/merge-k-sorted-lists/"
    }

    override fun title(): String {
        return "Merge k Sorted Lists"
    }

    override fun description(): String {
        return "合并k个有序的链表"
    }

    override fun thinking(): String {
        return """
            难点在于怎么最快找出当前最小的节点，使用最小堆
        """.trimIndent()
    }
}