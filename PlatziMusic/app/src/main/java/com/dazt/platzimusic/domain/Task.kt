package com.dazt.platzimusic.domain

data class Task(
    val id: String,
    val title: String,
    val description: String? = null,
    val isDone: Boolean = false,
    val category: Category? = null
) {
}