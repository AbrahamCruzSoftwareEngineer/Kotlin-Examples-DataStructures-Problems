package com.example.kotlin_examples_datastructures_problems

class MedianBetweenTwoArrays {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        if(nums1.isEmpty() && nums2.isEmpty()) {
            return 0.0
        }
        val sortedIntArray = (nums1 + nums2).sortedArray()
        val result = if (sortedIntArray.size % 2 == 0) {
            (sortedIntArray[sortedIntArray.size/2] + sortedIntArray[(sortedIntArray.size/2)-1])/2.toDouble()
        } else {
            sortedIntArray[(sortedIntArray.size/2+0.5).toInt()].toDouble()
        }
        return result
    }
}

fun main() {
    val median = MedianBetweenTwoArrays()
    //Test 1
    val caseOneIntArrayOne: IntArray = intArrayOf(1,2)
    val caseOneIntArrayTwo: IntArray = intArrayOf(3,4)
    println("result: " + median.findMedianSortedArrays(caseOneIntArrayOne, caseOneIntArrayTwo))
    //Test 2
    val caseTwoIntArrayOne: IntArray = intArrayOf(1,3)
    val caseTwoIntArrayTwo: IntArray = intArrayOf(2)
    println("result: " + median.findMedianSortedArrays(caseTwoIntArrayOne, caseTwoIntArrayTwo))
    //Test 3
    val case3IntArrayOne: IntArray = intArrayOf()
    val case3IntArrayTwo: IntArray = intArrayOf()
    println("result: " + median.findMedianSortedArrays(case3IntArrayOne, case3IntArrayTwo))
    //Test 4
    val case4IntArrayOne: IntArray = intArrayOf(1,2,3,10,15)
    val case4IntArrayTwo: IntArray = intArrayOf()
    println("result: " + median.findMedianSortedArrays(case4IntArrayOne, case4IntArrayTwo))


}