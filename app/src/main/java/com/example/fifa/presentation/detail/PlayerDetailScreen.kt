package com.example.fifa.presentation.detail

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.fifa.R
import com.example.fifa.domain.model.PlayerModel
import org.koin.androidx.compose.koinViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PlayerDetailScreen(
    playerId: Int,
    onClick:(Int) -> Unit,
    playerDetailViewModel: PlayerDetailViewModel = koinViewModel()
){
    val myPlayer = playerDetailViewModel.player.observeAsState().value

    playerDetailViewModel.getPlayer(playerId)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    myPlayer?.name
                },
                navigationIcon = {
                    IconButton(
                        onClick = { myPlayer?.club?.let { onClick(it) } }
                    ) {
                        Icon(Icons.Filled.ArrowBack, null)
                    }
                    Icons.Filled.ArrowBack
                }
            )
        }
    ) {
        Row() {
            AsyncImage(
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape),
                placeholder = painterResource(id = R.drawable.pedri),
                error = painterResource(id = R.drawable.pedri),
                model = ImageRequest.Builder(LocalContext.current)
                    .build(), contentDescription = ""
            )
            Column() {
                Row() {
                    Text(text = "Jugador: ${myPlayer?.name}")
                }
                Row() {
                    Text(text = "Club: ${myPlayer?.club}")
                }
                Row {
                    Text(text = "Liga: ${myPlayer?.league}")
                }
            }
        }
    }

}

@Preview
@Composable
fun PreviewDetail() {
    PlayerDetailScreen(playerId = 43,
        onClick = {

    }

    )
}