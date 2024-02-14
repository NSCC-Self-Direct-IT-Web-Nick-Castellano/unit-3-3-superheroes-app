package com.example.superheroesapp


import android.content.res.Configuration
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.expandHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroesapp.data.HeroesRepository
import com.example.superheroesapp.model.Hero
import com.example.superheroesapp.ui.theme.Shapes
import com.example.superheroesapp.ui.theme.SuperheroesAppTheme
import com.example.superheroesapp.ui.theme.Typography

@Composable
fun HeroesListItem(
    modifier: Modifier = Modifier,
    hero: Hero,
) {

    Card (
        modifier = modifier
        ,
        elevation = CardDefaults.cardElevation(2.dp),

    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top // Align items to the top vertically
        ) {

            // the left part of the
            Column (
                modifier = modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            ) {
                Text(
                    text = stringResource(id = hero.nameRes),
                    style = Typography.displaySmall
                )
                Text(
                    text = stringResource(id = hero.descriptionRes),
                    style = Typography.bodyLarge
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Box(
                modifier = Modifier
                    .size(72.dp)
                    .align(Alignment.CenterVertically)
                    .clip(RoundedCornerShape(8.dp))
                ,

                ) {


                Image(
                    modifier = Modifier
                        .size(72.dp),
                    painter = painterResource(
                        id = hero.imageRes
                    ),
                    contentDescription = null,
                    alignment = Alignment.Center,
                )

            }
        }
    }
}

@Composable
fun HeroesList(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    heroes: List<Hero>,
) {
    val itemsList = (0..5).toList()

    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
        ,
        contentPadding = contentPadding
    ) {
        itemsIndexed(heroes) { index, hero ->
            HeroesListItem(
                hero = hero,
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )
        }
    }
}

@Preview("Light Theme")
@Preview("Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ListItemPreview() {
    val hero = Hero(
        R.string.hero1,
        R.string.description1,
        R.drawable.android_superhero1
    )

    HeroesListItem(hero = hero)

}

@Preview("Heroes List")
@Composable
fun HeroesPreview() {
    SuperheroesAppTheme(darkTheme = false) {
        Surface (
            color = MaterialTheme.colorScheme.background
        ) {
            /* Important: It is not a good practice to access data source directly from the UI.
            In later units you will learn how to use ViewModel in such scenarios that takes the
            data source as a dependency and exposes heroes.
            */
//            HeroesList(heroes = HeroesRepository.heroes)
            HeroesList(heroes = HeroesRepository.heroes)
        }
    }
}