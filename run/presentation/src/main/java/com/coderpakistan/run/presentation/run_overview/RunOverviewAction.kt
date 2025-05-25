package com.coderpakistan.run.presentation.run_overview

import com.coderpakistan.run.presentation.run_overview.model.RunUi

sealed interface RunOverviewAction {

    data object OnLogoutClick : RunOverviewAction

    data object OnAnalyticsClick : RunOverviewAction

    data object OnStartClick : RunOverviewAction

    data class DeleteRun(val runUi: RunUi):RunOverviewAction

}