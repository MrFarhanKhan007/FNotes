package com.example.fnotes.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.fnotes.ui.theme.backgroundColor
import com.example.fnotes.ui.theme.contentColor
import com.example.fnotes.ui.theme.textColor
import com.example.fnotes.ui.theme.visby
import com.example.fnotes.widgets.CustomTextField
import com.example.fnotes.widgets.DoneButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTaskScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val value = remember {
        mutableStateOf("")
    }

    Scaffold(
        modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "")
                },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back Arrow",
                        modifier.clickable {
                            navController.popBackStack()
                        },
                        tint = textColor
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(backgroundColor)
            )
        },
        containerColor = backgroundColor
    )
    { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally, // Center content horizontally
            verticalArrangement = Arrangement.Center // Center content vertically
        ) {

            AddTask()

            Spacer(modifier.height(175.dp))

            Add_Note_Field(value = value)

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 20.dp),
                verticalArrangement = Arrangement.Bottom,
            ) {
                DoneButton()
            }


        }

    }
}

/*
modifier
                    .fillMaxSize()
                    .padding(bottom = 20.dp),
                verticalArrangement = Arrangement.Bottom,
 */

@Composable
fun AddTask(modifier: Modifier = Modifier) {
    Box(
        modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp), contentAlignment = Alignment.TopStart
    ) {
        Column {
            Text(
                text = "Add a note",
                style = TextStyle(
                    textAlign = TextAlign.Start,
                    color = if (isSystemInDarkTheme()) {
                        backgroundColor
                    } else {
                        textColor
                    },
                    fontFamily = visby,
                    fontSize = 60.sp
                )
            )

        }
    }
}

@Composable
fun Add_Note_Field(modifier: Modifier = Modifier, value: MutableState<String>) {
    Card(
        modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp),
        shape = RoundedCornerShape(corner = CornerSize(3.dp)),
        colors = CardDefaults.cardColors(contentColor),
        elevation = CardDefaults.cardElevation(3.dp)
    ) {
        CustomTextField(value = value)
    }
}


//@Preview
//@Composable
//fun Add_Note_FieldPreview(){
//    Add_Note_Field()
//}

@Preview(showBackground = true)
@Composable
fun AddTaskScreenPreview() {
    AddTaskScreen(navController = rememberNavController())
}