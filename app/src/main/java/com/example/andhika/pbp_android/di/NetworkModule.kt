package com.example.andhika.pbp_android.di

import com.example.andhika.pbp_android.BuildConfig
import com.example.andhika.pbp_android.network.NetworkAPI
import com.example.andhika.pbp_android.network.NetworkManager
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    private val REQUEST_TIMEOUT = 10


    @Provides
    @Singleton
    fun providesGson() = GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
            .create()

    @Provides
    @Singleton
    fun providesNetworkService(retrofit: Retrofit): NetworkAPI = retrofit.create(NetworkAPI::class.java)

    @Singleton
    @Provides
    fun providesNetworkManager(service: NetworkAPI) = NetworkManager(service)

    @Provides
    @Singleton
    fun providesLoggingInterceptor() = HttpLoggingInterceptor()
            .setLevel(if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE)

    @Provides
    @Singleton
    fun providesOkHttpClient(loggingInterceptor: HttpLoggingInterceptor) = OkHttpClient.Builder()
            .readTimeout(REQUEST_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .writeTimeout(REQUEST_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .connectTimeout(REQUEST_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .build()

    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient, gson: Gson) = Retrofit.Builder()
            .baseUrl("http://project-tf.xyz/index.php/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
}