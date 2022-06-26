import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.ints.shouldBeExactly

class Test_1248_NumberOfNiceSubarrays : StringSpec({

    val example1 = row(intArrayOf(1,1,2,1,1), 3, 2)
    val example2 = row(intArrayOf(2,4,6), 1, 0)
    val example3 = row(intArrayOf(2,2,2,1,2,2,1,2,2,2), 2, 16)

    "should count number of nice subarrays" {
        forAll(example1, example2, example3) { array, oddNumbers, numberOfNiceSubarrays ->
            NumberOfNiceSubarrays.numberOfSubarrays(array, oddNumbers) shouldBeExactly numberOfNiceSubarrays
        }
    }
})
