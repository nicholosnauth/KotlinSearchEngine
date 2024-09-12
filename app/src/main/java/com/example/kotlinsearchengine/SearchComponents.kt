package com.example.kotlinsearchengine

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SearchBar(query: String, onQueryChanged: (String)-> Unit){
TextField(
    value = query, 
    onValueChange = onQueryChanged,
    label = { Text("Search") },
    modifier = Modifier.fillMaxWidth()
    
    )    
}


@Composable
fun SearchResults(results: List<String>){
    LazyColumn {
        items(results){result ->
            Text(text = result, modifier = Modifier.padding(8.dp))
        }
    }
}