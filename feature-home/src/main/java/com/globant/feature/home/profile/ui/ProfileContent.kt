package com.globant.feature.home.profile.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.globant.design.R
import com.globant.design.atoms.IconWithCircle
import com.globant.design.atoms.Text
import com.globant.design.theme.DarkGray
import com.globant.design.theme.LightGray
import com.globant.design.theme.White
import com.globant.design.theme.Yellow
import com.globant.feature.home.model.AccountModel
import com.globant.feature.home.profile.ProfileViewModel

@Composable
fun ProfileContent(viewModel: ProfileViewModel, account: AccountModel?) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(White),
    ) {
        HeaderProfile(account = account)
        Spacer(modifier = Modifier.height(8.dp))
        Divider(color = LightGray, thickness = 8.dp)
        Spacer(modifier = Modifier.height(8.dp))
        ContentProfile(viewModel = viewModel)
    }
}

@Composable
fun ContentProfile(viewModel: ProfileViewModel) {
    val personPopular = viewModel.personPopular.collectAsState().value
    val top1 = personPopular?.getOrNull(0)

    Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
        Row {
            AsyncImage(
                model = top1?.profilePath,
                contentDescription = "Movie Image",
            )
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    modifier = Modifier.align(Alignment.End),
                    text = "Popularity: ${String.format("%.2f", top1?.popularity)}",
                    fontSize = 10.sp,
                )
                Text(
                    modifier = Modifier.padding(start = 16.dp),
                    text = top1?.name.orEmpty(),
                    fontWeight = FontWeight.Bold,
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Best Know for:",
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(items = personPopular?.getOrNull(0)?.knownFor ?: emptyList(), itemContent = {
                Row(modifier = Modifier.padding(8.dp)) {
                    AsyncImage(
                        modifier = Modifier.height(150.dp),
                        model = it.posterPath,
                        contentDescription = "Poster Image",
                    )
                    Column(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                        Text(
                            modifier = Modifier.align(Alignment.End),
                            text = "Popularity: ${String.format("%.2f", it.popularity)}",
                            fontSize = 10.sp,
                        )
                        Text(
                            text = it.title.orEmpty(),
                            fontWeight = FontWeight.Bold,
                        )
                        Text(
                            text = it.overview,
                            fontSize = 12.sp,
                        )
                    }
                }
            })
        }
    }
}

@Composable
fun HeaderProfile(account: AccountModel?) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(White),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            IconWithCircle(
                modifier = Modifier.size(48.dp),
                painterResource = R.drawable.ic_avatar,
            )
            Text(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp)
                    .align(Alignment.CenterVertically),
                text = account?.username.orEmpty(),
                fontWeight = FontWeight.Bold,
                color = DarkGray,
            )
            Icon(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .size(24.dp),
                painter = painterResource(id = R.drawable.ic_settings),
                contentDescription = "settings",
                tint = Yellow,
            )
        }
    }
}
