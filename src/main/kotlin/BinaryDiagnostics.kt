object BinaryDiagnostics {
    fun calculatePowerConsumption(input: String): Int {
        var bits = IntArray(0)
        var noLines = 0
        input.trim().lines().map { it.trim() }.forEach { line ->
            noLines++
            if (bits.isEmpty()) {
                bits = IntArray(line.length) { 0 }
            } else if (bits.size != line.length) throw RuntimeException("Unexpected binary number length!")
            line.toCharArray().withIndex().forEach { (index, value) ->
                bits[index] += value.digitToInt(2)
            }
        }
        val gammaRate =
            String(bits.map { bitCount -> if (isMostCommonBit(bitCount, noLines)) '1' else '0' }.toCharArray()).toInt(2)
        val epsilonRate =
            String(bits.map { bitCount -> if (isMostCommonBit(bitCount, noLines)) '0' else '1' }.toCharArray()).toInt(2)
        return gammaRate * epsilonRate
    }

    fun calculateLifeSupportRating(input: String): Int {
        var candidates = input.trim().lines().map { it.trim() }
        var index = 0
        while (candidates.size > 1) {
            val valuesWithOne = candidates.filter { it[index] == '1' }
            candidates = if (valuesWithOne.size >= candidates.size - valuesWithOne.size) {
                valuesWithOne
            } else {
                candidates.minus(valuesWithOne.toSet())
            }
            index++
        }
        val oxygenGeneratorRating = candidates.first()

        candidates = input.trim().lines().map { it.trim() }
        index = 0
        while (candidates.size > 1) {
            val valuesWithOne = candidates.filter { it[index] == '1' }
            candidates = if (valuesWithOne.size < candidates.size - valuesWithOne.size) {
                valuesWithOne
            } else {
                candidates.minus(valuesWithOne.toSet())
            }
            index++
        }
        val co2ScrubberRating = candidates.first()

        return oxygenGeneratorRating.toInt(2) * co2ScrubberRating.toInt(2)
    }

    private fun isMostCommonBit(bitCount: Int, noLines: Int): Boolean {
        if (noLines % 2 == 0 && bitCount == noLines / 2) {
            throw RuntimeException("Cannot determine most common bit!")
        }
        return bitCount > noLines / 2
    }

}