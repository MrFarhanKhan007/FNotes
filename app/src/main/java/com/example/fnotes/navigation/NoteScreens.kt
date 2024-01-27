package com.example.fnotes.navigation

enum class NoteScreens {
    HOME_SCREEN,
    ADDNOTE_SCREEN,
    UPDATENOTE_SCREEN;

    companion object {
        fun fromRoute(route: String?): NoteScreens =
            when (route?.substringBefore("/")) {
                HOME_SCREEN.name -> HOME_SCREEN
                ADDNOTE_SCREEN.name -> ADDNOTE_SCREEN
                UPDATENOTE_SCREEN.name -> UPDATENOTE_SCREEN
                null -> HOME_SCREEN
                else -> {
                    throw IllegalStateException("This $route is invalid!")
                }
            }
    }
}

