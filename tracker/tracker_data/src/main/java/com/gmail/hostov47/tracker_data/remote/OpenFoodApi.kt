/**
 * Created by Ilia Shelkovenko on 04.03.2023.
 */
package com.gmail.hostov47.tracker_data.remote

import com.gmail.hostov47.tracker_data.remote.dto.SearchDto
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenFoodApi {

    @GET
    suspend fun searchFood(
        @Query("search_terms") query: String,
        @Query("page") page: Int,
        @Query("page_size") pageSize: Int,
    ) : SearchDto

    companion object {
        const val BASE_URL = "https://us.openfoodfacts.org/"
    }
}