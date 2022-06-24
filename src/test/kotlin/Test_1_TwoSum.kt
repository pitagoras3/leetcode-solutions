import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder

class Test_1_TwoSum : StringSpec({

    val example1 = row(intArrayOf(2, 7, 11, 15), 9, intArrayOf(0, 1))
    val example2 = row(intArrayOf(3, 2, 4), 6, intArrayOf(1, 2))
    val example3 = row(intArrayOf(3, 3), 6, intArrayOf(0, 1))

    "should return indices that sum up to result" {
        forAll(example1, example2, example3) { array, target, expectedOutput ->
            TwoSum.twoSum(array, target).toList() shouldContainExactlyInAnyOrder expectedOutput.toList()
        }
    }
})
