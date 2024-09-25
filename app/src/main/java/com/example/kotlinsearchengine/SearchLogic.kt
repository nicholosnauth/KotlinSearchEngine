package com.example.kotlinsearchengine

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

//Define a function that takes a search query and returns a list of search results.
suspend fun performSearch(context: Context, query: String): List<String> {

    //Get an instance of the AppDatabase using the provided context.
    val database = AppDatabase.getDatabase(context)

    //Get a reference to the DocumentDao, which provides methods to interact with the documents table
    val documentDao = database.documentDao()

    //Perform the search query in the IO threat(best practice for database operations).
    val documents = withContext(Dispatchers.IO){
        //Execute the search query using the Dao
        documentDao.searchDocuments(query)
    }

    //Map the result t a list of document contents (i.e., the text of each focument).
    return documents.map {it.content}

}