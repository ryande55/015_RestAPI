package com.example.databaseapi.ui.kontak.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.databaseapi.model.Kontak
import com.example.databaseapi.repositori.KontakRepositori
import kotlinx.coroutines.launch

class InsertViewModel (private val kontakRepositori: KontakRepositori) : ViewModel(){
    var insertKontakState by mutableStateOf(InsertUiState())
        private set

    fun updateInsertKontakState(insertUiEvent: InsertUiEvent){
        insertKontakState = InsertUiState(insertUiEvent = insertUiEvent)
    }

    suspend fun insertKontak(){
        viewModelScope.launch{
            try {
                kontakRepositori.insertkontak(insertKontakState.insertUiEvent.toKontak())
            } catch (e: Exception){
                e.printStackTrace()
            }

        }
    }

}
data class InsertUiState(
    val insertUiEvent: InsertUiEvent = InsertUiEvent()
)


