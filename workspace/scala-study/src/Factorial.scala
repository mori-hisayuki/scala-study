import scala.math.BigInt

object Factorial extends App {
    def factorial(i: BigInt, result: BigInt): BigInt = if (i==0) result else factorial(i-1, i*result)
    println(factorial(10000, 1))
}
