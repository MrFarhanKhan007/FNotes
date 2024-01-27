package com.example.fnotes.ui.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fnotes.R
import com.example.fnotes.ui.theme.contentColor
import com.example.fnotes.ui.theme.textColor
import com.example.fnotes.ui.theme.visby

@Composable
fun UpdateButton(modifier: Modifier = Modifier) {
    Card(
        modifier
            .height(50.dp)
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp)
            .clickable {
                //TODO delete the values in the database
            },
        shape = RoundedCornerShape(corner = CornerSize(3.dp)),
        colors = CardDefaults.cardColors(contentColor),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {

        Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(
                text = stringResource(R.string.update),
                style = TextStyle(fontSize = 20.sp),
                fontFamily = visby,
                color = textColor
            )
        }
    }
}

@Composable
fun DeleteButton(modifier: Modifier = Modifier) {
    Card(
        modifier
            .height(50.dp)
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp)
            .clickable {
                //TODO delete the values in the database
            },
        shape = RoundedCornerShape(corner = CornerSize(3.dp)),
        colors = CardDefaults.cardColors(contentColor),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {

        Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(
                text = stringResource(R.string.delete),
                style = TextStyle(fontSize = 20.sp),
                fontFamily = visby,
                color = textColor
            )
        }
    }
}

@Composable
fun DoneButton(modifier: Modifier = Modifier) {
    Card(
        modifier
            .height(50.dp)
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp)
            .clickable {
                //TODO save the values in the database
            },
        shape = RoundedCornerShape(corner = CornerSize(3.dp)),
        colors = CardDefaults.cardColors(contentColor),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {

        Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(
                text = stringResource(R.string.done),
                style = TextStyle(fontSize = 20.sp),
                fontFamily = visby,
                color = textColor
            )
        }
    }
}