package com.example.fnotes.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.fnotes.R
import com.example.fnotes.navigation.NoteScreens
import com.example.fnotes.ui.theme.backgroundColor
import com.example.fnotes.ui.theme.textColor
import com.example.fnotes.ui.theme.visby

@Composable
fun HomeScreen(navController: NavHostController) {
    MyApp(navController = navController)
}

@Composable
fun MyApp(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier
            .fillMaxSize()
            .background(backgroundColor),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Spacer(modifier.height(50.dp))

        Text(
            text = stringResource(R.string.app_name),
            modifier
                .align(Alignment.Start)
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
        Spacer(modifier.height(200.dp))

        NoAvailableTaskText()

        Box(
            modifier
                .fillMaxSize(),
            contentAlignment = Alignment.BottomEnd,

            ) {
            FloatingActionButton(
                onClick = {
                    navController.navigate(route = NoteScreens.ADDNOTE_SCREEN.name)
                },
                modifier
                    .padding(end = 20.dp, bottom = 20.dp)
                    .size(60.dp),
                containerColor = Color(0xFFfef08a),
                shape = CircleShape,
                content = { Icon(imageVector = Icons.Default.Add, contentDescription = null) }
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

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}
