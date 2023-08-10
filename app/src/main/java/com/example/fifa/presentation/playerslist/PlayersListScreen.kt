package com.example.fifa.presentation.playerslist

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.fifa.R
import com.example.fifa.data.remote.TOKEN
import com.example.fifa.domain.model.PlayerModel
import com.example.fifa.presentation.login.Animation
import com.example.fifa.presentation.teamlist.ShowTeamItem
import com.example.fifa.ui.theme.globalPadding
import com.google.android.material.search.SearchBar
import org.koin.androidx.compose.koinViewModel
import java.text.Collator
import java.text.Normalizer
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Local

private val REGEX_UNACCENT = "\\p{InCombiningDiacriticalMarks}+".toRegex()

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PlayersListScreen(
    idTeam: Int,
    onClick:(PlayerModel) -> Unit,
    onClickScaffold:() -> Unit,
    playerListViewModel: PlayerListViewModel = koinViewModel(),

) {

    val myList = playerListViewModel.playersList.observeAsState().value

    val ctx = LocalContext.current
    val laligaFont = FontFamily(Font(R.font.laligafuente))

    LaunchedEffect(null) {
        playerListViewModel.GetMyPlayers(idTeam)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.End
                    ) {
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
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                    ) {

                    }
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

        var query by remember { mutableStateOf("") }
        var active by remember { mutableStateOf(false) }

        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.barsaligacampeon),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
        }

        Column(
        ) {

            if(myList == null) {
                Animation()
            }
            else {
                Row() {
                    SearchBar(
                        query = query,
                        onQueryChange = { query = it },
                        onSearch = {
                            if(query.isNotEmpty()) {
                                playerListViewModel.filterListByName(query)
                            }
                            active = false
                        },
                        active = active,
                        onActiveChange = { active = it },
                        modifier = Modifier
                            .wrapContentHeight()
                            .fillMaxWidth()
                    ) {
                        if (query.isNotEmpty()) {
                            val filtredPlayers = playerListViewModel.AllPlayersOfTeam?.filter {
                                val namewithoutAccents = it.name.unaccent()
                                namewithoutAccents.contains(query, true)
                            }

                            LazyColumn(
                                modifier = Modifier
                                    .padding(10.dp)
                                    .fillMaxWidth()
                            ) {
                                filtredPlayers?.size?.let { player ->
                                    items(player) { myPlayer ->
                                        val player = filtredPlayers?.get(myPlayer)
                                        Row(modifier = Modifier
                                            .fillMaxWidth()
                                            .clickable {
                                                Toast
                                                    .makeText(
                                                        ctx,
                                                        "PULSADO EN ${player?.name}",
                                                        Toast.LENGTH_LONG
                                                    )
                                                    .show()

                                                player?.id?.let { idPlayer ->
                                                    playerListViewModel.filterListById(idPlayer)
                                                }
                                                active = false
                                            }
                                        )
                                        {
                                            Text(
                                                "${player?.name}",
                                                Modifier
                                                    .padding(16.dp),
                                                textAlign = TextAlign.Center,
                                                fontFamily = laligaFont,
                                            )

                                            AsyncImage(
                                                modifier = Modifier
                                                    .size(100.dp),
                                                placeholder = painterResource(id = R.drawable.loading_icon),
                                                error = painterResource(id = R.drawable.loading_icon),
                                                model = ImageRequest.Builder(LocalContext.current)
                                                    .data("https://futdb.app/api/players/${player?.id}/image")
                                                    .setHeader("X-AUTH-TOKEN", "$TOKEN")
                                                    .build(), contentDescription = ""
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                Row() {
                    LazyColumn(
                        modifier = Modifier.padding(
                            vertical = globalPadding
                        ),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        items(myList?.size ?: 0) { i ->
                            val item = myList?.get(i)
                            item?.let { team ->
                                ShowPlayerItem(team) { onClick(team) }
                            }
                        }
                    }
                }
            }
        }

    }
}

fun CharSequence.unaccent(): String {
    val temp = Normalizer.normalize(this, Normalizer.Form.NFD)
    return REGEX_UNACCENT.replace(temp, "")
}