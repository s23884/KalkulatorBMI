package Excercise4

/**
 * Exercise 4
 * You have a list of words. Use for and if to print only the words that start with the letter l.
 * Hint
 * Use the .startsWith() function for String type.
 * fun main() {
 * val words = listOf("dinosaur", "limousine", "magazine", "language")
 * // Write your code here
 * }
 *
 */

fun main() {
    val words = listOf("dinosaur", "limousine", "magazine", "language")
    for (w in words) { if (w.startsWith("l")) println(w) }
}

