package com.example.kotlinsearchengine

fun performSearch(query: String): List<String> {
    val documents = listOf(
        Document(1, "Learn Kotlin with Jetpack Compose"),
        Document(2, "Building a search engine in Kotlin"),
        Document(3, "Advanced Kotlin programming language")
    )

    return documents.filter { it.content.contains(query, ignoreCase = true) }
        .map{it.content}
}