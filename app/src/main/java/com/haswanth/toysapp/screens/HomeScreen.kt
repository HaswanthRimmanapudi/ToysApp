package com.haswanth.toysapp


import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.haswanth.toysapp.components.AppToolbar
import com.haswanth.toysapp.components.HeadingTextComponent
import com.haswanth.toysapp.components.NavigationDrawerBody
import com.haswanth.toysapp.components.NavigationDrawerHeader
import com.haswanth.toysapp.data.home.HomeViewModel
import com.haswanth.toysapp.data.signup.SignupViewModel
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(  homeViewModel: HomeViewModel = viewModel()) {

    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val localContext = LocalContext.current

    var  signupViewModel : SignupViewModel? = null

    homeViewModel.getUserData()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            AppToolbar(toolbarTitle = stringResource(id = R.string.home),
                logoutButtonClicked = {
                    homeViewModel.logout()
                },
                navigationIconClicked = {
                    coroutineScope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            )
        },
        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
        drawerContent = {
            NavigationDrawerHeader(homeViewModel.emailId.value)

            NavigationDrawerBody(navigationDrawerItems = homeViewModel.navigationItemsList,
                onNavigationItemClicked = {

                })
        }

    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(paddingValues)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Spacer(modifier = Modifier.padding(5.dp))
                val itemList = listOf("Toys")
                Spacer(modifier = Modifier.padding(5.dp))
//                Spacer(modifier = Modifier.padding(5.dp))

                LazyColumn(content = {
                    item {
                        GenreTitle(genreTitle = "Recommended Toys")
                        ToyList(toyList = getActionToyList()) { toy ->
                            Toast.makeText(localContext, toy.name, Toast.LENGTH_SHORT).show()
                            localContext.startActivity(Intent(localContext, ToysDetailActivity::class.java)
                                    .putExtra("toy_data", toy))
                        }
                        Spacer(Modifier.size(10.dp))
                        GenreTitle(genreTitle = "Common Toys")
                        ToyList(toyList = getCommonToyList()) { toy ->
                          Toast.makeText(localContext, toy.name, Toast.LENGTH_SHORT).show()
                            localContext.startActivity(Intent(localContext, ToysDetailActivity::class.java)
                                    .putExtra("toy_data", toy))
                        }
                        Spacer(Modifier.size(10.dp))
                        GenreTitle(genreTitle = "Car Toys")
                        ToyList(toyList = getAnimationMovieList()) { toy ->
                            Toast.makeText(localContext, toy.name, Toast.LENGTH_SHORT).show()
                            localContext.startActivity(Intent(localContext, ToysDetailActivity::class.java)
                                .putExtra("toy_data", toy))
                        }
                    }
                })

            }
        }
    }
}

@Composable
fun GenreTitle(genreTitle: String) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(5.dp),
        style = TextStyle(fontSize = 25.sp, fontWeight = FontWeight.Bold),
        text = genreTitle
    )
}

@Composable
fun ToyList(toyList: List<Toy>, onItemClick: (movie: Toy) -> Unit) {
    LazyRow(content = {
        items(toyList) { toy ->
            MovieItemView(toy = toy) {
                onItemClick(toy)
            }
        }
    })
}

@Composable
fun MovieItemView(toy: Toy, onClick: (movie: Toy) -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable(
                onClick = { onClick(toy) }
            )
            .width(100.dp)
            .wrapContentHeight()) {
        Image(
            painterResource(id = toy.poster),
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(5.dp),
            contentDescription = ""
        )
        Text(
            text = toy.name,
            style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Bold)
        )
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}

