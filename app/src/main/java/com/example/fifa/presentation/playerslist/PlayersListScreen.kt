package com.example.fifa.presentation.playerslist

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.fifa.R
import com.example.fifa.data.remote.TOKEN
import com.example.fifa.domain.model.PlayerModel
import com.example.fifa.presentation.teamlist.ShowTeamItem
import com.example.fifa.ui.theme.globalPadding
import org.koin.androidx.compose.koinViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PlayersListScreen(
    idTeam: Int,
    onClick:(PlayerModel) -> Unit,
    onClickScaffold:() -> Unit,
    playerListViewModel: PlayerListViewModel = koinViewModel(),

) {
    val state = playerListViewModel.playersList.observeAsState()
    val myList = state.value

    playerListViewModel.GetMyPlayers(idTeam)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    AsyncImage(
                        modifier = Modifier
                            .size(50.dp),
                        placeholder = painterResource(id = R.drawable.loading_icon),
                        error = painterResource(id = R.drawable.loading_icon),
                        model = ImageRequest.Builder(LocalContext.current)
                            .data("https://futdb.app/api/clubs/${idTeam}/image")
                            .setHeader("X-AUTH-TOKEN", "$TOKEN")
                            .build(), contentDescription = ""
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = { onClickScaffold() }
                    ) {
                        Icon(Icons.Filled.ArrowBack, null)
                    }
                    Icons.Filled.ArrowBack
                }
            )
        }
    ) {
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
                item?.let { team ->
                    ShowPlayerItem(team) { onClick(team) }
                }
            }
        }
    }
}