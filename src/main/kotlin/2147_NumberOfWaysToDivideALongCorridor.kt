object NumberOfWaysToDivideALongCorridor {
    fun numberOfWays(corridor: String): Int {
        val normalizedCorridor = corridor.dropLastWhile { it == 'P' }
        var totalSeatCounter = 0
        var localSeatCounter = 0
        var totalCombinations = 1L
        var localCombinations = 1L
        val modulo = (1e9 + 7).toLong()

        normalizedCorridor.forEach {
            if (it == 'S') {
                totalSeatCounter++
                if (localSeatCounter == 2) {
                    totalCombinations *= localCombinations
                    totalCombinations %= modulo
                    localSeatCounter = 1
                    localCombinations = 1L
                } else {
                    localSeatCounter++
                }
            } else if (it == 'P') {
                if (localSeatCounter == 2) {
                    localCombinations++
                }
            }
        }

        return if (totalSeatCounter < 2 || totalSeatCounter % 2 != 0) return 0
        else totalCombinations.toInt()
    }
}