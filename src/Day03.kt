fun parseInput(rawInput: String) = rawInput

val alphabetScore = mapOf(
    'a' to 1,
    'b' to 2,
    'c' to 3,
    'd' to 4,
    'e' to 5,
    'f' to 6,
    'g' to 7,
    'h' to 8,
    'i' to 9,
    'j' to 10,
    'k' to 11,
    'l' to 12,
    'm' to 13,
    'n' to 14,
    'o' to 15,
    'p' to 16,
    'q' to 17,
    'r' to 18,
    's' to 19,
    't' to 20,
    'u' to 21,
    'v' to 22,
    'w' to 23,
    'x' to 24,
    'y' to 25,
    'z' to 26,
    'A' to 27,
    'B' to 28,
    'C' to 29,
    'D' to 30,
    'E' to 31,
    'F' to 32,
    'G' to 33,
    'H' to 34,
    'I' to 35,
    'J' to 36,
    'K' to 37,
    'L' to 38,
    'M' to 39,
    'N' to 40,
    'O' to 41,
    'P' to 42,
    'Q' to 43,
    'R' to 44,
    'S' to 45,
    'T' to 46,
    'U' to 47,
    'V' to 48,
    'W' to 49,
    'X' to 50,
    'Y' to 51,
    'Z' to 52
)


fun main() {
    fun solvePart1(input: List<String>): Int {
        val twoPartsSplitted = input.map { str ->
            val half = str.length / 2
            listOf(str.slice(0 until half), str.slice(half until str.length))
        }
        var score = 0
        // 2. find the char in both strings
        twoPartsSplitted.forEachIndexed { idx, item ->
            val alreadySeen: MutableMap<Char, Char> = mutableMapOf()
            item[0].forEach { char ->
                alreadySeen[char] = char
            }
            // 3. calculate score
            var escape = false;
            item[1].forEachIndexed { i, char ->
                if (alreadySeen[char] != null && escape == false) {
                    score += alphabetScore[char] ?: 0
                    escape = true;
                    return@forEachIndexed
                }
            }
        }
        return score
    }

    fun solvePart2(input: List<String>): Int {
        fun parseAndSplitString(rawInput: String): List<List<String>> {
            val input = parseInput(rawInput)
            val lines = input.split("\n")
            val substrings = mutableListOf<List<String>>()
            while (lines.isNotEmpty()) {
                substrings.add(lines.splice(0, 3).map { it })
            }
            return substrings
        }

        fun calculateScore(substrings: List<List<String>>, alphabetScore: Map<String, Int>): Int {
            val commonChars = mutableListOf<String>()
            for (i in 0 until substrings.size) {
                val commonChar = setOf(
                    substrings[i].reduce { acc, cur ->
                        acc.split("").filter { cur.contains(it) }.joinToString("")
                    }
                ).first()
                commonChars.add(commonChar)
            }

            var score = 0
            commonChars.forEach {
                score += alphabetScore[it] ?: 0
            }
            return score
        }
    }

    fun part1(input: List<String>): Int {
        return solvePart1(input)
    }

    fun part2(input: List<String>): Int {
        return solvePart2(input)
    }

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}

