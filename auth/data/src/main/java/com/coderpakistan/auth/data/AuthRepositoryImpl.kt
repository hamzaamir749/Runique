package com.coderpakistan.auth.data

import com.coderpakistan.auth.domain.AuthRepository
import com.coderpakistan.core.data.networking.post
import com.coderpakistan.core.domain.AuthInfo
import com.coderpakistan.core.domain.SessionStorage
import com.coderpakistan.core.domain.util.DataError
import com.coderpakistan.core.domain.util.EmptyResult
import com.coderpakistan.core.domain.util.Result
import com.coderpakistan.core.domain.util.asEmptyDataResult
import io.ktor.client.HttpClient

class AuthRepositoryImpl(private val httpClient: HttpClient,private val sessionStorage: SessionStorage) : AuthRepository {
    override suspend fun login(email: String, password: String): EmptyResult<DataError.Network> {
        val result = httpClient.post<LoginRequest, LoginResponse>(
            route = "/login",
            body = LoginRequest(
                email = email,
                password = password
            )
        )

        if (result is Result.Success){
            sessionStorage.set(
                AuthInfo(
                    accessToken = result.data.accessToken,
                    refreshToken = result.data.refreshToken,
                    userId = result.data.userId
                )
            )
        }

        return result.asEmptyDataResult()
    }

    override suspend fun register(email: String, password: String): EmptyResult<DataError.Network> {
        return httpClient.post<RegisterRequest, Unit>(
            route = "/register",
            body = RegisterRequest(
                email = email,
                password = password
            )
        )
    }
}