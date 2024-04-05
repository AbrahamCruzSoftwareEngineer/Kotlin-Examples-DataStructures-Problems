package com.example.kotlin_examples_datastructures_problems


/*
Given an encoded string, return its decoded string.
The encoding rule is: k[encoded_string], where the
encoded_string inside the square brackets is being
repeated exactly k times. Note that k is guaranteed
to be a positive integer.

You may assume that the input string is always valid;
there are no extra white spaces, square brackets are well-formed,
etc. Furthermore, you may assume that the original data does not
contain any digits and that digits are only for those repeat numbers, k.
For example, there will not be input like 3a or 2[4].
The test cases are generated so that the length of the
output will never exceed 105.



Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"

*/

fun decodeString(codedString: String): String {
    val stack = mutableListOf<String>()
    var currentNumber = 0

    if (codedString.isEmpty()) {
        return ""
    }

    for (char in codedString) {
        when {
            char.isDigit() -> currentNumber = currentNumber * 10 + (char - '0')
            char == '[' -> {
                stack.add(currentNumber.toString())
                stack.add(char.toString())
                currentNumber = 0
            }
            char == ']' -> {
                var tempStr = ""
                while (stack.last() != "[") {
                    tempStr = stack.removeAt(stack.size -1) + tempStr
                }
                stack.removeAt(stack.size-1)
                val repeat = stack.removeAt(stack.size - 1).toInt()
                var repeatString = tempStr.repeat(repeat)
                stack.add(repeatString)
            }
            else -> stack.add(char.toString())
        }
    }

    return stack.joinToString("")
}

fun main() {
    println(decodeString("3[a]2[bc]"))
    println(decodeString("3[a2[c]]"))
    println(decodeString("2[abc]3[cd]ef"))
    println(decodeString("2abc]3cd]ef"))
}