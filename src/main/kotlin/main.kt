fun main() {
    val input = getResourceAsText("/input.txt")

    println("Power consumption is [${BinaryDiagnostics.calculatePowerConsumption(input)}].")
    println("Life support rating is [${BinaryDiagnostics.calculateLifeSupportRating(input)}].")
}

fun getResourceAsText(path: String): String {
    return object {}.javaClass.getResource(path).readText()
}