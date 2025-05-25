package com.coderpakistan.auth.domain

import com.coderpakistan.core.domain.util.DataError
import com.coderpakistan.core.domain.util.EmptyResult

interface AuthRepository {
    suspend fun login(email: String, password: String): EmptyResult<DataError.Network>
    suspend fun register(email: String, password: String): EmptyResult<DataError.Network>
}