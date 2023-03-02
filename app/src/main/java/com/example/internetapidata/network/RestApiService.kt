package com.example.internetapidata.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()

// actual endpoint coding
interface RestApiService {

    // rest api endpoint
    @GET("realestate")
    suspend fun getRealStateProperties(): List<MarsItem>

//    Example of a POST request
//    @FormUrlEncoded
//    @POST("/realestate/add")
//    fun postNewProperty(
//        @Field("id") id: String,
//        @Field("imgSrcUrl") imgSrcUrl: String,
//        @Field("type") type: String,
//        @Field("price") price: Double
//    ) : PropertyResponse
}

// boilerplate code
object RestApi{
    val retrofitService: RestApiService by lazy{
        retrofit.create(RestApiService::class.java)
    }
}