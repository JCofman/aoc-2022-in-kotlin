fun main() {

    fun parse(input: List<String>, n: Int): Int {
        val listOfElfs: MutableList<Int> = mutableListOf()
        var calories = 0;
        input.forEach {
            if (it.isEmpty()) {
                listOfElfs.add(calories)
                calories = 0
            } else {
                calories += it.toInt()
            }
        }
        return listOfElfs.sortedDescending().take(n).sum()

    }

    fun part1(input: List<String>): Int {
        return parse(input, 1)
    }

    fun part2(input: List<String>): Int {
        return parse(input, 3)
    }

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
