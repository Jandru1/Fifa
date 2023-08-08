package com.example.fifa.data.remote

import com.example.fifa.data.remote.dto.PhotoTeamDto
import com.example.fifa.data.remote.dto.PlayerDto
import com.example.fifa.data.remote.dto.PlayersListDto
import com.example.fifa.data.remote.dto.SearchDto
import com.example.fifa.data.remote.dto.TeamDto
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

const val TOKEN: String = "8e5d1d91-d190-4894-a33d-b9ef2996f235"

interface TeamApi {

    @GET("clubs?page=")
    @Headers("X-AUTH-TOKEN: $TOKEN")
    suspend fun getTeamList1(@Query("page") number: Int): TeamDto

    @GET("clubs/{clubId}/image")
    @Headers("X-AUTH-TOKEN: $TOKEN")
    suspend fun getTeamUrl(@Path("clubId") clubId: Int): Response<ResponseBody>

    @GET("players?page=")
    @Headers("X-AUTH-TOKEN: $TOKEN")
    suspend fun getPlayersList(@Query("page") number: Int): PlayersListDto
}