package com.example.fnotes.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.example.fnotes.ui.theme.textColor

@Composable
fun HomeScreen(navController: NavHostController) {
    MyApp(navController = navController)
}

@Composable
fun MyApp(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier.height(50.dp))
        Text(
            text = stringResource(R.string.tasks),
            modifier.align(Alignment.CenterHorizontally),
            style = TextStyle(
                color = textColor,
                textAlign = TextAlign.Center,
                fontSize = 50.sp
            )
        )
        Spacer(modifier.height(200.dp))
        NoAvailableTaskText()
    }
}

@Composable
fun NoAvailableTaskText(modifier: Modifier=Modifier){
    Text(
        text = stringResource(R.string.no_available_tasks_right_now_click_the_icon_to_add_a_task),
        style = TextStyle(
            color = textColor,
            fontSize = 25.sp,
            textAlign = TextAlign.Center
        )
    )
}
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())

}
