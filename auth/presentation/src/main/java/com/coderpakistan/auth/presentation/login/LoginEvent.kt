package com.coderpakistan.auth.presentation.login

import com.coderpakistan.core.presentation.ui.UiText

sealed interface LoginEvent {
    data class Error(val error: UiText) : LoginEvent
    data object LoginSuccess : LoginEvent
}