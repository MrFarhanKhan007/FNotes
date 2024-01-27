package com.example.fnotes.ui.screens

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.fnotes.R
import com.example.fnotes.ui.theme.backgroundColor
import com.example.fnotes.ui.theme.contentColor
import com.example.fnotes.ui.theme.textColor
import com.example.fnotes.ui.theme.visby
import com.example.fnotes.ui.widgets.CustomTextField
import com.example.fnotes.ui.widgets.DeleteButton
import com.example.fnotes.ui.widgets.UpdateButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateNoteScreen(
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

            UpdateNote()

            Spacer(modifier.height(150.dp))

            Update_Note_Field(value = value)

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 20.dp),
                verticalArrangement = Arrangement.Bottom,
            ) {
                UpdateButton()
                Spacer(modifier.height(20.dp))
                DeleteButton()
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
fun UpdateNote(modifier: Modifier = Modifier) {
    Box(
        modifier
            .fillMaxWidth()
            .padding(start = 10.dp), contentAlignment = Alignment.TopStart
    ) {
        Column {
            Text(
                text = stringResource(id = R.string.update_note),
                style = TextStyle(
                    textAlign = TextAlign.Start,
                    color = if (isSystemInDarkTheme()) {
                        backgroundColor
                    } else {
                        textColor
                    },
                    fontFamily = visby,
                    fontSize = 55.sp
                )
            )

            Text(
                text = stringResource(id = R.string.update_note_subline_text),
                style = TextStyle(
                    textAlign = TextAlign.Start
                ),
                color = if (isSystemInDarkTheme()) {
                    backgroundColor
                } else {
                    textColor
                },
                fontFamily = visby,
                fontSize = 25.sp
            )

        }
    }
}

@Composable
fun Update_Note_Field(modifier: Modifier = Modifier, value: MutableState<String>) {
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
fun UpdateNoteScreenPreview() {
    UpdateNoteScreen(navController = rememberNavController())
}