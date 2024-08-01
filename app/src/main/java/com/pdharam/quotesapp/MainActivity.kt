package com.pdharam.quotesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.pdharam.quotesapp.screens.QuoteDetailsScreen
import com.pdharam.quotesapp.screens.QuoteListScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        CoroutineScope(Dispatchers.IO).launch {
            delay(10000)
            DataManager.loadAssetFromFile(applicationContext)
        }
        setContent {
            App()
        }
    }

    @Composable
    fun App() {
        if (DataManager.isDataLoaded.value) {
            if (DataManager.isCurrentPage.value == Pages.LISTING) {
                QuoteListScreen(data = DataManager.data) {
                    DataManager.switchPage(it)
                }
            } else {
                DataManager.currentQuote?.let { QuoteDetailsScreen(it) }
            }

        } else {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize(1f))
            {
                Text(text = "Loading...", style = MaterialTheme.typography.headlineLarge)
            }
        }
    }

}

enum class Pages {
    LISTING,
    DETAILS;
}

