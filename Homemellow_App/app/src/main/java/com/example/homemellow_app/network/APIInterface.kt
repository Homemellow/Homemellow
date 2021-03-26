package com.example.homemellow_app.network

import com.example.homemellow_app.data.Post
import com.ramkishorevs.graphqlconverter.converter.GraphQuery
import com.ramkishorevs.graphqlconverter.converter.QueryContainerBuilder
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface APIInterface {
    @POST("/v1/graphql")
    @GraphQuery("testquery")
    fun getResponse(@Body query: QueryContainerBuilder): Call<Post>
}