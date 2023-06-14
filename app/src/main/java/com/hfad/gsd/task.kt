package com.hfad.gsd

data class Task(
    val id: String,
    val name: String,
    val locationType: String,
    val notificationTime: Long,
    var isComplete: Boolean
)
