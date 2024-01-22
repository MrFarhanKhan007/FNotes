package com.example.fnotes.navigation

enum class TaskScreens {
    HOME_SCREEN,
    ADDTASK_SCREEN,
    UPDATETASK_SCREEN;

    companion object {
        fun fromRoute(route: String?): TaskScreens =
            when (route?.substringBefore("/")) {
                HOME_SCREEN.name -> HOME_SCREEN
                ADDTASK_SCREEN.name -> ADDTASK_SCREEN
                UPDATETASK_SCREEN.name -> UPDATETASK_SCREEN
                null -> HOME_SCREEN
                else -> {
                    throw IllegalStateException("This $route is invalid!")
                }
            }
    }
}

