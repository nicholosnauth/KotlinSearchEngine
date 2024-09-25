package com.example.kotlinsearchengine

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

//The @Dao annotation tells Room that this interface defines database operations
@Dao
interface DocumentDao{
    //@Query is used to define a custom SQL query
    //This query searches for documents where the content contains the search string
    @Query("SELECT * FROM documents WHERE content LIKE '%' || :query || '%'")
            suspend fun searchDocuments(query: String): List<Document>
    //@Insert is used to insert one or more documents into the table
            @Insert
            suspend fun insertDocuments(vararg documents: Document)



}