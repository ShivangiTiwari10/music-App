package com.example.musicapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SongListModel:ViewModel() {


    private val _todoList = mutableStateListOf<songList>()
    var errorMessage: String by mutableStateOf("")
    val todoList: List<songList>
        get() = _todoList

    fun getPlayList(apiKey: String) {
        viewModelScope.launch {
            val apiService = APIService.getInstance(apiKey)
            try {
                _todoList.clear()
                _todoList.addAll(apiService.getTodos())
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}