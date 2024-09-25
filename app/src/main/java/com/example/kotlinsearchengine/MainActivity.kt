package com.example.kotlinsearchengine

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.example.kotlinsearchengine.ui.theme.KotlinSearchEngineTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinSearchEngineTheme {
                // A surface container using the 'background color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background){
                    SearchScreen(this)
                }
            }

        }
    }
}

@Composable
fun SearchScreen(context: Context){
    var query by remember { mutableStateOf("") }
    var results by remember { mutableStateOf(emptyList<String>()) }

    Column (modifier = Modifier.padding(16.dp)){

        SearchBar(query = query, onQueryChanged = { newQuery ->

                query = newQuery
            (context as ComponentActivity).lifecycleScope.launch {
                results = performSearch(context, newQuery)
            }

        })
        Spacer(modifier = Modifier.height(16.dp))

        SearchResults(results = results)
    }
}