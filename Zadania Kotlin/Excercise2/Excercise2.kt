package Excercise2

/**
 * Practice
 * Exercise 2
 * You have a list of “green” numbers and a list of “red” numbers. Complete the code to print how many numbers there are in total.
 * fun main() {
 *     val greenNumbers = listOf(1, 4, 23)
 *     val redNumbers = listOf(17, 2)
 * // Write your code here
 * }
 */

fun main() {
    val greenNumbers = listOf(1, 4, 23)
    val redNumbers = listOf(17, 2)
    val totalCount = greenNumbers.count() + redNumbers.count()
    println(totalCount)
}



