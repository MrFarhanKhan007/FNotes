package com.example.fnotes.ui.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.fnotes.R
import com.example.fnotes.data.Note
import com.example.fnotes.navigation.NoteScreens
import com.example.fnotes.ui.theme.backgroundColor
import com.example.fnotes.ui.theme.contentColor
import com.example.fnotes.ui.theme.textColor
import com.example.fnotes.ui.theme.visby

@Composable
fun HomeScreen(navController: NavHostController) {
    MyApp(navController = navController)
}

@Composable
fun MyApp(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {

    val homeScreenViewModel = hiltViewModel<HomeScreenViewModel>()
    val noteListState by homeScreenViewModel.noteList.collectAsState()
    val dynamicColor = if (isSystemInDarkTheme()) {
        textColor
    } else {
        backgroundColor
    }


    Column(modifier.background(dynamicColor)) {
        Spacer(modifier.height(50.dp))

        Text(
            text = stringResource(R.string.app_name),
            modifier = Modifier
                .padding(start = 10.dp),
            style = TextStyle(
                textAlign = TextAlign.Justify,
                color = if (isSystemInDarkTheme()) {
                    backgroundColor
                } else {
                    textColor
                },
                fontFamily = visby,
                fontSize = 80.sp
            )
        )

    }

    Box(
        modifier = modifier
            .padding(top = 150.dp)
            .fillMaxSize()
            .background(dynamicColor)
    ) {

        // LazyColumn is in the background
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp)
                .zIndex(-1f)
        ) {
            items(noteListState) { note ->
                // Render each note in a list item
                NoteListItem(note = note, navController = navController)
            }
        }

        // Other UI elements (Text, Spacer, FloatingActionButton) are in the foreground
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            if (noteListState.isEmpty()) {
                Spacer(modifier = Modifier.height(130.dp))
                NoAvailableTaskText()
            } else {
                Spacer(modifier = Modifier.height(260.dp))
            }

            // FloatingActionButton is in the foreground
            Box(
                modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomEnd
            ) {

                FloatingActionButton(
                    onClick = {
                        navController.navigate(route = NoteScreens.ADDNOTE_SCREEN.name)
                    },
                    modifier = Modifier
                        .padding(end = 20.dp, bottom = 20.dp)
                        .size(60.dp),
                    elevation = FloatingActionButtonDefaults.elevation(10.dp),
                    containerColor = Color(0xFFF4E680),
                    shape = CircleShape,
                    content = {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = null,
                            tint = textColor
                        )
                    }
                )
            }
        }
    }
}



@Composable
fun NoteListItem(note: Note, modifier: Modifier = Modifier, navController: NavHostController) {

    Card(
        modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, bottom = 20.dp)
            .clickable {
                navController.navigate(route = NoteScreens.UPDATENOTE_SCREEN.name + "/id=${note.id}")
            },
        shape = RoundedCornerShape(corner = CornerSize(3.dp)),
        colors = CardDefaults.cardColors(contentColor),
        elevation = CardDefaults.cardElevation(3.dp)

    ) {
        Column(
            modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 20.dp)
        ) {
//            Text(
//                text = note.id.toString(),
//                style = TextStyle(
//                    textAlign = TextAlign.Start,
//                    color = Color.Black,
//                    fontFamily = visibly,
//                    fontSize = 45.sp
//                )

            Text(
                text = note.noteDescription,
                style = TextStyle(
                    textAlign = TextAlign.Start,
                    color = textColor,
                    fontFamily = visby,
                    fontSize = 25.sp
                )
            )
        }
    }

}

@Composable
fun NoAvailableTaskText() {
    Text(
        text = stringResource(R.string.no_available_notes_right_now_click_the_icon_to_add_a_task),
        modifier = Modifier.padding(start = 10.dp, end = 10.dp),
        style = TextStyle(
            color = if (isSystemInDarkTheme()) {
                backgroundColor
            } else {
                textColor
            },
            fontFamily = visby,
            fontSize = 35.sp,
            textAlign = TextAlign.Start
        )
    )
}

@Composable
@Preview
fun Add_Note_Plus_Icon_Preview() {
    val navController = rememberNavController()
    val modifier = Modifier
    FloatingActionButton(
        onClick = {
            navController.navigate(route = NoteScreens.ADDNOTE_SCREEN.name)
        },
        modifier
            .padding(end = 20.dp, bottom = 20.dp)
            .size(60.dp),
        containerColor = Color.Green,
        shape = CircleShape,
        content = { Icon(imageVector = Icons.Default.Add, contentDescription = null) }
    )
}
