package com.example.fifa.data.remote

import com.example.fifa.data.remote.dto.PlayersListDto
import com.example.fifa.data.remote.dto.TeamDto
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

const val TOKEN: String = "46ed2dd8-a0af-4bcf-a8a7-fe470a35fddc"

interface TeamApi {

    @GET("clubs?page=")
    @Headers("X-AUTH-TOKEN: $TOKEN")
    suspend fun getTeamList(@Query("page") number: Int): TeamDto

    @GET("clubs/{clubId}/image")
    @Headers("X-AUTH-TOKEN: $TOKEN")
    suspend fun getTeamUrl(@Path("clubId") clubId: Int): Response<ResponseBody>

    @GET("players?page=")
    @Headers("X-AUTH-TOKEN: $TOKEN")
    suspend fun getPlayersList(@Query("page") number: Int): PlayersListDto
}