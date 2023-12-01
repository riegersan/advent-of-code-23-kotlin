fun main() {

    fun part1(input: List<String>): Int {
        val callibrations = input.map {
            val numbers = it.replace("[^0-9]".toRegex(), "")
            val number = numbers.first().toString() + numbers.last()
            number.toInt()
        }
        return callibrations.sum()
    }

    fun String.replaceDigits(): String {

        val replacements: MutableList<Pair<String, String>> = mutableListOf()
        replacements.add("one" to "o1e")
        replacements.add("two" to "t2o")
        replacements.add("three" to "th3ee")
        replacements.add("four" to "f4ur")
        replacements.add("five" to "f5ve")
        replacements.add("six" to "s6x")
        replacements.add("seven" to "se7en")
        replacements.add("eight" to "ei8ht")
        replacements.add("nine" to "n9ne")

        var result = this

        replacements.forEach { (l, r) -> result = result.replace(l, r) }
        return result
    }

    fun part2(input: List<String>): Int {
        val callibrations = input.map {
            val transform = it.replaceDigits()
            val numbers = transform.replace("[^0-9]".toRegex(), "")
            val number = numbers.first().toString() + numbers.last()
            number.toInt()
        }
        return callibrations.sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput1 = readInput("Day01_test")
    val testInput2 = readInput("Day01_test2")
    check(part1(testInput1) == 142)
    check(part2(testInput2) == 281)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
