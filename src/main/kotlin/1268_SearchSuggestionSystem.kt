object SearchSuggestionSystem {
    fun suggestedProducts(products: Array<String>, searchWord: String): List<List<String>> =
        searchWord.toCharArray().fold(
            Triple(
                mutableListOf<List<String>>(),
                products.sortedArray(),
                ""
            )
        ) { (result: List<List<String>>, sortedLimitedProducts: Array<String>, processedFirstCharacters: String), currentCharacter ->
            val firstCharacters = processedFirstCharacters + currentCharacter
            val matching = sortedLimitedProducts.filter { it.startsWith(firstCharacters) }.toTypedArray()
            val top3: List<String> = matching.take(3)
            result.add(top3)

            Triple(result, matching, firstCharacters)
        }.first
}
