package com.example.fifa.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fifa.domain.model.PlayerModel
import com.example.fifa.domain.usecases.GetPlayerDetailUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PlayerDetailViewModel(
    val getPlayerDetailUseCase: GetPlayerDetailUseCase
): ViewModel() {

    val _player = MutableLiveData<PlayerModel>()
    val player: LiveData<PlayerModel> get() = _player

    fun getPlayer(idPlayer: Int) {
        try {
            viewModelScope.launch {
                var result = withContext(Dispatchers.IO) {
                    getPlayerDetailUseCase.invoke(idPlayer)
                }
                _player.value = result
            }
        } catch (t: Throwable){

        }

    }
}