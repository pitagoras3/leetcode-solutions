import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.collections.shouldContainExactly

class Test_1268_SearchSuggestionSystem : StringSpec({

    val example1 = row(
        arrayOf("mobile", "mouse", "moneypot", "monitor", "mousepad"),
        "mouse",
        listOf(
            listOf("mobile", "moneypot", "monitor"),
            listOf("mobile", "moneypot", "monitor"),
            listOf("mouse", "mousepad"),
            listOf("mouse", "mousepad"),
            listOf("mouse", "mousepad")
        )
    )

    val example2 = row(
        arrayOf("havana"),
        "havana",
        listOf(
            listOf("havana"),
            listOf("havana"),
            listOf("havana"),
            listOf("havana"),
            listOf("havana"),
            listOf("havana")
        )
    )

    val example3 = row(
        arrayOf("bags", "baggage", "banner", "box", "cloths"),
        "bags",
        listOf(
            listOf("baggage", "bags", "banner"),
            listOf("baggage", "bags", "banner"),
            listOf("baggage", "bags"),
            listOf("bags")
        )
    )

    "should correctly suggest products" {
        forAll(example1, example2, example3) { products, searchWord, expectedOutput ->
            SearchSuggestionSystem.suggestedProducts(products, searchWord) shouldContainExactly expectedOutput
        }
    }
})
