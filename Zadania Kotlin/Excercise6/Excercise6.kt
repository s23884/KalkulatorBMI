package Excercise6

/**
 * Rewrite the circleArea function from the previous exercise as a single-expression function.
 * import kotlin.math.PI
 * // Write your code here
 * fun main() {
 * println(circleArea(2))
 * }
 *
 */

import kotlin.math.PI
fun circleArea(radius: Int): Double = PI * radius * radius
fun main() {
    println(circleArea(2))
} // 12.566370614359172 }