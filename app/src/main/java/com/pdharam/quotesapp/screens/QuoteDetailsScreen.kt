package com.pdharam.quotesapp.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.pdharam.quotesapp.DataManager
import com.pdharam.quotesapp.R
import com.pdharam.quotesapp.model.Quote


@Composable
fun QuoteDetailsScreen(quote: Quote) {
    BackHandler {
        DataManager.switchPage(null)
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize(1F)
            .background(
                Brush.sweepGradient(
                    colors = listOf(
                        Color(0xFFffffff),
                        Color(0xFFE3E3E3)
                    )
                )
            )
    ) {
        Card(elevation = CardDefaults.cardElevation(4.dp), modifier = Modifier.padding(32.dp)) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(16.dp, 24.dp)
            ) {
                Image(
                    imageVector = Icons.Filled.MailOutline,
                    contentDescription = "Quote",
                    modifier = Modifier.size(80.dp)
                )
                Text(
                    text = quote.text,
                    style = MaterialTheme.typography.headlineSmall,
                    fontFamily = FontFamily(Font(R.font.montserrat_regular))
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "― ${quote.author}",
                    style = MaterialTheme.typography.bodyLarge,
                    fontFamily = FontFamily(Font(R.font.montserrat_regular))
                )

            }

        }

    }

}