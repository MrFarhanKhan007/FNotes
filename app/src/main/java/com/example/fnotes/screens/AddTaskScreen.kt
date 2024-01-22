package com.example.fnotes.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun AddTaskScreen(navController: NavHostController) {

}

@Preview
@Composable
fun AddTaskScreenPreview() {
    AddTaskScreen(navController= rememberNavController())
}