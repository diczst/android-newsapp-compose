package com.neonusa.newsapp.presentation.bookmark

import android.widget.Space
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.neonusa.newsapp.presentation.Dimens.MediumPadding1
import com.neonusa.newsapp.presentation.common.ArticlesList
import com.neonusa.newsapp.presentation.navgraph.Route


@Composable
fun BookmarkScreen(
    state: BookmarkState,
    navigate: (String) -> Unit
){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(top = MediumPadding1, start = MediumPadding1, end = MediumPadding1)
    ){
        Text(text = "Bookmark", style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.Bold))
        Spacer(modifier = Modifier.height(MediumPadding1))
        ArticlesList(articles = state.articles, onClick = {navigate(Route.DetailsScreen.route)})
    }
}