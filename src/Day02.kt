fun main() {

    fun part1(input: List<String>): Int {

        val red = 12
        val green = 13
        val blue = 14

        val validGames = input.stream().filter {game ->
            val draws = game.split(":")[1].split(";")
            draws.forEach { draw ->
                val colors = draw.split(",")
                colors.forEach{color ->
                    with(color){
                        when{
                            contains("red") ->  {
                                if(color.replace("[^0-9]".toRegex(), "").toInt() > red){
                                    return@filter false
                                }
                            }
                            contains("green") ->  {
                                if(color.replace("[^0-9]".toRegex(), "").toInt() > green){
                                    return@filter false
                                }
                            }
                            contains("blue") ->  {
                                if(color.replace("[^0-9]".toRegex(), "").toInt() > blue){
                                    return@filter false
                                }
                            }
                        }
                    }
                }
            }
            true
        }.toList().map { game ->
            game.split(":")[0].replace("[^0-9]".toRegex(), "").toInt()
        }

        return validGames.sum()
    }

    fun part2(input: List<String>): Int {

        val validGames = input.stream().map {game ->

            var red = 0
            var green = 0
            var blue = 0

            val draws = game.split(":")[1].split(";")
            draws.forEach { draw ->
                val colors = draw.split(",")
                colors.forEach{color ->
                    with(color){
                        when{
                            contains("red") ->  {
                                val redDrawValue = color.replace("[^0-9]".toRegex(), "").toInt()
                                if(redDrawValue > red){
                                    red = redDrawValue
                                }
                            }
                            contains("green") ->  {
                                val greenDrawValue = color.replace("[^0-9]".toRegex(), "").toInt()
                                if(greenDrawValue > green){
                                    green = greenDrawValue
                                }
                            }
                            contains("blue") ->  {
                                val blueDrawValue = color.replace("[^0-9]".toRegex(), "").toInt()
                                if(blueDrawValue > blue){
                                    blue = blueDrawValue
                                }
                            }
                        }
                    }
                }
            }

            red * green * blue

        }.toList()

        return validGames.sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput1 = readInput("Day02_test")
    val testInput2 = readInput("Day02_test2")
    check(part1(testInput1) == 8)
    check(part2(testInput2) == 2286)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
