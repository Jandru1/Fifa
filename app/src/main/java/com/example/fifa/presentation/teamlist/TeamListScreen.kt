package com.example.fifa.presentation.teamlist

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.fifa.R
import com.example.fifa.ui.theme.globalPadding
import org.koin.androidx.compose.koinViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TeamListScreen(
    onClick:(Int) -> Unit,
    teamListViewModel: TeamListViewModel = koinViewModel(),
    ) {

    val state = teamListViewModel.teamList.observeAsState()
    val myList = state.value


    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Image(
            painter = painterResource(R.drawable.pedrigavi),
            contentDescription = "pedri",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
    }

    LazyColumn(
        modifier = Modifier.padding(
            vertical = globalPadding
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        items(myList?.size ?: 0) { i ->
            Log.w("EQUIPOS FUERA", "${myList?.get(i)}")
            val item = myList?.get(i)
            item?.let { equipo ->
                Log.w("EQUIPOS DENTRO", "el nombre es $equipo")
                ShowTeamItem(equipo, { onClick(item.id) })
            }
        }
    }
}