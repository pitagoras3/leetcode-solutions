object AddTwoNumbers {
    /**
     * Example:
     * var li = ListNode(5)
     * var v = li.`val`
     * Definition for singly-linked list.
     * class ListNode(var `val`: Int) {
     *     var next: ListNode? = null
     * }
     */
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? = recAddTwoNumbers(l1, l2)

    private fun recAddTwoNumbers(l1: ListNode?, l2: ListNode?, tenths: Int? = null): ListNode? =
        when {
            l1 == null && l2 == null -> bothNodesAreNull(tenths)
            l1 != null && l2 == null -> oneOfTheNodesIsNotNull(tenths, l1)
            l1 == null && l2 != null -> oneOfTheNodesIsNotNull(tenths, l2)
            l1 != null && l2 != null -> bothNodesAreNotNull(l1, l2, tenths)
            else -> throw Exception("Not possible branch")
        }

    private fun bothNodesAreNotNull(l1: ListNode, l2: ListNode, tenths: Int?): ListNode {
        val (newTenths, rest) = tenthsToRest(l1.`val` + l2.`val` + (tenths ?: 0))
        return ListNode(rest).apply {
            next = recAddTwoNumbers(l1.next, l2.next, newTenths)
        }
    }

    private fun oneOfTheNodesIsNotNull(tenths: Int?, listNode: ListNode) =
        if (tenths == null) listNode
        else {
            val (newTenths, rest) = tenthsToRest(listNode.`val` + tenths)
            ListNode(rest).apply {
                next = recAddTwoNumbers(listNode.next, null, newTenths)
            }
        }

    private fun bothNodesAreNull(tenths: Int?) = if (tenths == null || tenths == 0) null else ListNode(tenths)

    private fun tenthsToRest(number: Int): Pair<Int, Int> =
        if (number >= 10) number / 10 to number % 10
        else 0 to number

    data class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}
