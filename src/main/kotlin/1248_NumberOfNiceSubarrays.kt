object NumberOfNiceSubarrays {
    fun numberOfSubarrays(nums: IntArray, k: Int): Int {
        val oddIndices = mutableListOf<Int>()
        var leftPaddings = 0
        var middlePaddings = 0
        var rightPaddings = 0
        var numberOfSolutions = 0
        nums.forEachIndexed { index, i ->
            if (oddIndices.size != k) {
                if (i % 2 != 0) oddIndices.add(index)
                else if (oddIndices.size == 0) leftPaddings += 1
                else middlePaddings += 1
            } else {
                if (i % 2 == 0) rightPaddings += 1
                else {
                    oddIndices.add(index)
                    numberOfSolutions += recalculateNumberOfSolutions(leftPaddings, rightPaddings)
                    leftPaddings = (oddIndices[1] - oddIndices[0] - 1)
                    middlePaddings = rightPaddings
                    rightPaddings = 0
                    oddIndices.removeAt(0)
                }
            }
        }
        if (oddIndices.size == k) numberOfSolutions += recalculateNumberOfSolutions(leftPaddings, rightPaddings)
        return numberOfSolutions
    }

    private fun recalculateNumberOfSolutions(leftPaddings: Int, rightPaddings: Int): Int = (leftPaddings + 1) * (rightPaddings + 1)
}
