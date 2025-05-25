package com.coderpakistan.run.presentation.active_run.maps

import androidx.compose.ui.graphics.Color
import com.coderpakistan.core.domain.location.Location

data class PolylineUi(
    val location1: Location,
    val location2: Location,
    val color: Color
)
