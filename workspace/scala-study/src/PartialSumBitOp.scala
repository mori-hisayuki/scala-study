object PartialSumBitOp extends App {
    val numberList: Seq[Int] =Seq(1, 10, 49, 3, 8, 13, 7, 23, 60, -500, 42, 599, 45, -23, 1, 10, 49, 3, 8, 13)
    val numberListLength: Int = numberList.length
    val resultSum: Int = 444

    var isMatch = false
    var bitsCounter = 0
    val ~max = ~(-1 << numberListLength)

    println(max)
    println(numberListLength)
    for(i <- numberListLength to 0 by -1 ) { if ((max & (1 << i)) != 0) print("1") else print("0") }
    println

    while(!isMatch && bitsCounter <= max ) {
        var sum = 0
        for (i <- 0 to (numberListLength - 1)) {
            val mask = 1 << i
            val masked = bitsCounter & mask
            if (masked != 0) sum = sum + numberList(i)
        }
        if (sum == resultSum) {
            isMatch = true
        } else {
            bitsCounter = bitsCounter + 1
        }
    }

    println(bitsCounter)
    if(isMatch) {
        var result: Seq[Int] = Seq()
        for(i <- 0 to numberListLength) {
            val mask = 1 << i
            val masked = bitsCounter & mask
            if (masked != 0) result = result :+ numberList(i)
        }
         println(s"Yes ${result}")
    } else {
        println("No")
    }

}
