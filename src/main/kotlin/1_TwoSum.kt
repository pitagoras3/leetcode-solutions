object TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val diffToIndex = mutableMapOf<Int, Int>()
        nums.forEachIndexed { index, i ->
            val diff = target - i
            diffToIndex[diff] = index
        }

        nums.forEachIndexed { index, i ->
            val maybeIndex = diffToIndex[i]
            if (maybeIndex != null && maybeIndex != index) {
                return intArrayOf(maybeIndex, index)
            }
        }

        throw Exception("Not found matching indices")
    }
}

