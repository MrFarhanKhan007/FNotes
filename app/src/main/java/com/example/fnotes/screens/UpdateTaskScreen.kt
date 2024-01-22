package com.example.fnotes.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

//This Screen involved updating or deleting the note...basically editing the note

@Composable
fun UpdateTaskScreen(navController: NavHostController) {

}

@Preview
@Composable
fun UpdateTaskScreenPreview() {
    UpdateTaskScreen(navController = rememberNavController())
}