package com.example.fifa.presentation.teamlist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fifa.domain.model.ItemModel
import com.example.fifa.domain.model.PhotoTeamModel
import com.example.fifa.domain.usecases.GetTeamUrlUseCase
import com.example.fifa.domain.usecases.GetTeamsListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TeamListViewModel (
    private val getTeamsListUseCase: GetTeamsListUseCase,
    private val getTeamUrlUseCase: GetTeamUrlUseCase,
): ViewModel() {

    private val _teamList = MutableLiveData<List<ItemModel>>()
    val teamList: LiveData<List<ItemModel>> get() = _teamList

    private val _teamImage = MutableLiveData<PhotoTeamModel>()
    val teamImage: LiveData<PhotoTeamModel> get() = _teamImage

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            try {
                val result = withContext(Dispatchers.IO) {
                    getTeamsListUseCase.invoke()
                }
                _teamList.value = result
            } catch (t: Throwable) {
                }
        }
    }

    fun getUrl(teamId: Int) {
        viewModelScope.launch {
            try{
                val result = withContext(Dispatchers.IO){
                    getTeamUrlUseCase.invoke(teamId)
                }
                _teamImage.value = result

                } catch (t: Throwable) {
            }
        }
    }
}