package com.example.fifa.presentation.playerslist

import android.util.Log
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

class PlayerListViewModel(
    private val getPlayersListUseCase: GetPlayersListUseCase
) :ViewModel() {

    private var _playerslist = MutableLiveData<List<PlayerModel>>()
    val playersList: LiveData<List<PlayerModel>> get() = _playerslist


    private var _playerslistAux = MutableLiveData<List<PlayerModel>>()
    val playersListAux: LiveData<List<PlayerModel>> get() = _playerslistAux

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
                val result = withContext(Dispatchers.IO) {
                    getPlayersListUseCase.invoke(idTeam)
                }
                _playerslist.value = result
            }
            catch(t: Throwable) {
            }
        }
    }

    fun filterListBySearch(namePlayer: String) {
        _playerslistAux.value = _playerslist.value?.filter {
            it.name == namePlayer
        }
        _playerslist.value = _playerslistAux.value

        Log.w("Reduciendo Lista", "Nueva lista: ${_playerslist.value}")
    }
}