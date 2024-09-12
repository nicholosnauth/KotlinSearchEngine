package com.example.kotlinsearchengine

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "documents")
data class Document(
    @PrimaryKey val id: Int,
    val content: String){

}