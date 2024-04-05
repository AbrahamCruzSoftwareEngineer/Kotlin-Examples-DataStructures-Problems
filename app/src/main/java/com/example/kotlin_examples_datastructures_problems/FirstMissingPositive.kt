package com.example.kotlin_examples_datastructures_problems

class FirstMissingPositive {
    fun firstMissingPositive(nums: IntArray): Int {
        println("Given array: ${nums.joinToString(", ")} Fixed array: ${nums.filter { it > 0 }.toSet().toIntArray().sortedArray().joinToString(", ")}")
        val sortedArray =
            nums.filter { it > 0 }  //Filter all the negatives and 0
            .toSet()                //take away repeated numbers
            .toIntArray()           //convert back to IntArray
            .sortedArray()          //sort the array with the correct numbers left
        for (i in 1..sortedArray.size) {
            if (i!= sortedArray[i-1]) {
                return i
            } else if (i == sortedArray.size) {
                return sortedArray.size + 1
            }
        }
        return if (sortedArray.isNotEmpty()) {sortedArray[0] } else 1
    }
}

fun main() {
    //Test Cases
    val missingPositive = FirstMissingPositive()
    val testOfArrayOfNumbers1 = intArrayOf(-1,-2,0,11,1,4,2,5,6)
    val testOfArrayOfNumbers2 = intArrayOf(1,2,4)
    val testOfArrayOfNumbers3 = intArrayOf(4,5,6)
    val testOfArrayOfNumbers4 = intArrayOf(-1,-2,4,5,6)
    val testOfArrayOfNumbers5 = intArrayOf(-1,-2,0,1,2)
    val testOfArrayOfNumbers6 = intArrayOf(1)
    val testOfArrayOfNumbers7 = intArrayOf(0)
    val testOfArrayOfNumbers8 = intArrayOf(0,2,2,1,1)

    println("First missing positive: ${missingPositive.firstMissingPositive(testOfArrayOfNumbers1)}")
    println("First missing positive: ${missingPositive.firstMissingPositive(testOfArrayOfNumbers2)}")
    println("First missing positive: ${missingPositive.firstMissingPositive(testOfArrayOfNumbers3)}")
    println("First missing positive: ${missingPositive.firstMissingPositive(testOfArrayOfNumbers4)}")
    println("First missing positive: ${missingPositive.firstMissingPositive(testOfArrayOfNumbers5)}")
    println("First missing positive: ${missingPositive.firstMissingPositive(testOfArrayOfNumbers6)}")
    println("First missing positive: ${missingPositive.firstMissingPositive(testOfArrayOfNumbers7)}")
    println("First missing positive: ${missingPositive.firstMissingPositive(testOfArrayOfNumbers8)}")
}