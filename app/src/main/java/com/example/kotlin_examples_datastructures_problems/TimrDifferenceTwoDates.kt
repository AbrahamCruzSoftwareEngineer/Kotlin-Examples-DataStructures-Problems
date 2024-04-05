package com.example.kotlin_examples_datastructures_problems

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Duration
import java.time.LocalDateTime

@RequiresApi(Build.VERSION_CODES.O)
private val startTime = LocalDateTime.now()

@RequiresApi(Build.VERSION_CODES.O)
private val endTime = LocalDateTime.now()
    .plusYears(2)
    .plusMonths(3)
    .plusDays(15)
    .plusHours(5)
    .plusMinutes(15)
    .plusSeconds(5)

@RequiresApi(Build.VERSION_CODES.O)
private fun calculateTimeDifference(startTime: LocalDateTime, endTime: LocalDateTime): String {
    return try {
        val duration = Duration.between(startTime, endTime)

        val years = duration.toDays() / 365
        val months = (duration.toDays() % 365) / 30
        val days = duration.toDays() % 30
        val hours = duration.toHours() % 24
        val minutes = duration.toMinutes() % 60
        val seconds = duration.seconds % 60

        return "$years years, $months months, $days days, $hours hours, $minutes minutes, and $seconds seconds"
    } catch (e: Exception) {
        e.printStackTrace()
        "Error calculating time difference:  ${e.printStackTrace()}"
    }
}


@RequiresApi(Build.VERSION_CODES.O)
fun main() {
    val difference = calculateTimeDifference(startTime, endTime)
    println(difference)
}