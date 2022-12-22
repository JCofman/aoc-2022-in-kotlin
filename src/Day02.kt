object PointConstants {
    const val DRAW_SCORE = 3;
    const val LOOSE_SCORE = 0;
    const val WIN_SCORE = 6;
}

fun main() {
    fun solvePart1(input: List<String>): Int {
        var points = 0;

        input.forEach {
            when (it) {
                "A X" -> points += 1 + PointConstants.DRAW_SCORE
                "A Y" -> points += 2 + PointConstants.WIN_SCORE
                "A Z" -> points += 3 + PointConstants.LOOSE_SCORE
                "B X" -> points += 1 + PointConstants.LOOSE_SCORE
                "B Y" -> points += 2 + PointConstants.DRAW_SCORE
                "B Z" -> points += 3 + PointConstants.WIN_SCORE
                "C X" -> points += 1 + PointConstants.WIN_SCORE
                "C Y" -> points += 2 + PointConstants.LOOSE_SCORE
                "C Z" -> points += 3 + PointConstants.DRAW_SCORE
            }
        }
        return points
    }

    fun solvePart2(input: List<String>): Int {
        var points = 0;
        input.forEach {
            when (it) {
                "A X" -> points += 3 + PointConstants.LOOSE_SCORE
                "A Y" -> points += 1 + PointConstants.DRAW_SCORE
                "A Z" -> points += 2 + PointConstants.WIN_SCORE
                "B X" -> points += 1 + PointConstants.LOOSE_SCORE
                "B Y" -> points += 2 + PointConstants.DRAW_SCORE
                "B Z" -> points += 3 + PointConstants.WIN_SCORE
                "C X" -> points += 2 + PointConstants.LOOSE_SCORE
                "C Y" -> points += 3 + PointConstants.DRAW_SCORE
                "C Z" -> points += 1 + PointConstants.WIN_SCORE
            }
        }
        return points
    }

    fun part1(input: List<String>): Int {
        return solvePart1(input)
    }

    fun part2(input: List<String>): Int {
        return solvePart2(input)
    }

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}

