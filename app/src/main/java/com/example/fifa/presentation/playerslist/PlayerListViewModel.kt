package com.example.fifa.presentation.playerslist

import android.util.Log
import androidx.compose.ui.text.toLowerCase
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.fifa.domain.model.PlayerModel
import com.example.fifa.domain.usecases.GetPlayersListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.Collator

class PlayerListViewModel(
    private val getPlayersListUseCase: GetPlayersListUseCase
) :ViewModel() {

    private val _playerslist = MutableLiveData<List<PlayerModel>>()
    val playersList: LiveData<List<PlayerModel>> get() = _playerslist


    private var _playerslistAux = MutableLiveData<List<PlayerModel>>()
    val playersListAux: LiveData<List<PlayerModel>> get() = _playerslistAux

    var AllPlayersOfTeam = mutableListOf<PlayerModel>()

    init {
       // getData()
    }

/*    private fun getData() {
        viewModelScope.launch {
            try {
                val result = withContext(Dispatchers.IO) {
                    getPlayersListUseCase.invoke()
                }
                _playerslist.value = result
            }
            catch(t: Throwable) {
            }
        }
    }
    */
    fun GetMyPlayers(idTeam: Int) {
        viewModelScope.launch {
            try {
                _playerslist.value = null
                val result = withContext(Dispatchers.IO) {
                    getPlayersListUseCase.invoke(idTeam)
                }
                _playerslist.value = result
                AllPlayersOfTeam = result as MutableList<PlayerModel>
            }
            catch(t: Throwable) {
            }
        }
    }

    fun filterListById(idPlayer: Int) {

        _playerslistAux.value = AllPlayersOfTeam?.filter {
            it.id == idPlayer
        }
        _playerslist.value = _playerslistAux.value?.toList()

    }

    fun filterListByName(namePlayer: String) {

        _playerslistAux.value = AllPlayersOfTeam?.filter {
            val name1 = it.name.lowercase().unaccent()
            val name2 = namePlayer.lowercase().unaccent()
            name1.contains(name2, true)

        }
        _playerslist.value = _playerslistAux.value?.toList()

    }
}