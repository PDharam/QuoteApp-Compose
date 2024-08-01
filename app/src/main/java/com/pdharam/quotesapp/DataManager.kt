package com.pdharam.quotesapp

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.google.gson.Gson
import com.pdharam.quotesapp.model.Quote

object DataManager {
    var data = emptyArray<Quote>()
    var currentQuote: Quote? = null;
    var isDataLoaded = mutableStateOf(false)
    var isCurrentPage = mutableStateOf(Pages.LISTING)
    fun loadAssetFromFile(context: Context) {
        val inputStream = context.assets.open("quotes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<Quote>::class.java)
        isDataLoaded.value = true
    }

    fun switchPage(quote: Quote?) {
        if (isCurrentPage.value == Pages.LISTING) {
            currentQuote = quote;
            isCurrentPage.value = Pages.DETAILS
        } else {
            isCurrentPage.value = Pages.LISTING
        }
    }
}