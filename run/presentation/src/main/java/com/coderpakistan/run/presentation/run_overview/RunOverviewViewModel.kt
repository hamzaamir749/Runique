package com.coderpakistan.run.presentation.run_overview

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coderpakistan.core.domain.SessionStorage
import com.coderpakistan.core.domain.run.RunRepository
import com.coderpakistan.core.domain.run.SyncRunScheduler
import com.coderpakistan.run.presentation.run_overview.mapper.toRunUi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.minutes

class RunOverviewViewModel(
    private val runRepository: RunRepository,
    private val syncRunScheduler: SyncRunScheduler,
    private val applicationScope:CoroutineScope,
    private val sessionStorage: SessionStorage
) : ViewModel() {
    var state by mutableStateOf(RunOverviewState())
        private set


    init {
        viewModelScope.launch {
            syncRunScheduler.scheduleSync(type = SyncRunScheduler.SyncType.FetchRuns(30.minutes))
        }
        runRepository.getRuns().onEach { runs ->

            val runsUi = runs.map { it.toRunUi() }
            state = state.copy(runs = runsUi)
        }.launchIn(viewModelScope)

        viewModelScope.launch {
            runRepository.fetchRuns()
        }
    }

    fun onAction(action: RunOverviewAction) {
        when (action) {
            RunOverviewAction.OnAnalyticsClick -> {

            }

            RunOverviewAction.OnLogoutClick -> {
                logout()
            }

            is RunOverviewAction.DeleteRun -> {
                viewModelScope.launch {
                    runRepository.deleteRun(action.runUi.id)
                }
            }

            else -> Unit
        }
    }

    private fun logout(){
        applicationScope.launch {
            syncRunScheduler.cancelAllSyncs()
            runRepository.deleteAllRuns()
            runRepository.logout()
            sessionStorage.set(null)
        }
    }
}