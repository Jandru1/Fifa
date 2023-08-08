package com.example.fifa.presentation.detail

import android.annotation.SuppressLint
import android.graphics.Paint.Align
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.fifa.R
import com.example.fifa.data.remote.TOKEN
import com.example.fifa.domain.model.PlayerModel
import com.example.fifa.navigation.Screen
import com.example.fifa.ui.theme.globalPadding
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
                    myPlayer?.name?.let { 
                        Text(
                            text = it,
                            color = Color.White
                        )
                    }
                    
                },
                navigationIcon = {
                    IconButton(
                        { myPlayer?.club?.let { onClick(it) } }
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
                painter = painterResource(R.drawable.fondofutbol),
                contentDescription = "pedri",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds,
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth()
                .padding(30.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    modifier = Modifier
                        .size(300.dp),
                    placeholder = painterResource(id = R.drawable.loading_icon),
                    error = painterResource(id = R.drawable.loading_icon),
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://futdb.app/api/players/${playerId}/image")
                        .setHeader("X-AUTH-TOKEN", "$TOKEN")
                        .build(), contentDescription = ""
                )
            }

            Spacer(
                modifier = Modifier
                    .size(20.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Column() {
                    Row(
                    ) {
                        Text(
                            modifier = Modifier
                                .background(Color.White, CircleShape)
                                .border(1.dp, Color.Black, CircleShape)
                                .width(200.dp),
                            text = "${myPlayer?.name}",
                            textAlign = TextAlign.Center,
                        )
                    }
                    Spacer(
                        modifier = Modifier
                            .size(8.dp)
                    )
                    Row() {
                        Text(
                            modifier = Modifier
                                .background(Color.White, CircleShape)
                                .border(1.dp, Color.Black, CircleShape)
                                .width(200.dp),
                            text = "${myPlayer?.club}:",
                            textAlign = TextAlign.Center,
                        )
                    }
                    Spacer(
                        modifier = Modifier
                            .size(8.dp)
                    )
                    Row {
                        Text(
                            modifier = Modifier
                                .background(Color.White, CircleShape)
                                .border(1.dp, Color.Black, CircleShape)
                                .width(200.dp),
                            text = "${myPlayer?.id}:",
                            textAlign = TextAlign.Center,
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewDetail() {
    PlayerDetailScreen(
        playerId = 43,
        onClick = {

    }

    )
}