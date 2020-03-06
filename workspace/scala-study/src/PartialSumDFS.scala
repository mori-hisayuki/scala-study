object PartialSumDFS extends App {
    val numberList: Seq[Int] = Seq(1, 10, 49, 3, 8, 13, 7, 23, 60, -500, 42, 599, 45, -23, 1, 10, 49, 3 , 8, 13)
    val numberListLength: Int = numberList.length
    val resultSum: Int = 444

    def isMatchAndResult(index: Int, partial: Seq[Int]): (Boolean, Seq[Int]) = {
        if (index == numberListLength) {
            return if (partial.sum == resultSum) (true, partial) else (false, Seq())
        }
        val (isMatchNotAdd, resultNotAdd) = isMatchAndResult(index + 1, partial)
        if (isMatchNotAdd) return (isMatchNotAdd, resultNotAdd)
        isMatchAndResult(index + 1, partial :+ numberList(index))
    }

    val (isMatch, result) = isMatchAndResult(0, Seq())
    if (isMatch) println (s"Yes ${result}") else println("No")
}
