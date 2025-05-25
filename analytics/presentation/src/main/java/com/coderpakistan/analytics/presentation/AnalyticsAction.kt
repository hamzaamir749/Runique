package com.coderpakistan.analytics.presentation

sealed interface AnalyticsAction {
    data object OnBackClick: AnalyticsAction
}