package com.laxman.binarysemantics.di

import com.laxman.binarysemantics.network.ApiInterface
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Reusable
    internal fun provideSaveEatClient(builder: OkHttpClient.Builder) : ApiInterface {
        return Retrofit.Builder()
            .baseUrl("https://3634b6f8-592f-4fe3-aff8-6fc39fecb3fa.mock.pstmn.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(builder.build())
            .build().create(ApiInterface::class.java)
    }


    @Provides
    @Reusable
    internal fun provideOkhttpClientBuilder(): OkHttpClient.Builder {
        val okHttpClientBuilder = OkHttpClient.Builder()
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        okHttpClientBuilder.connectTimeout(30, TimeUnit.SECONDS)
        okHttpClientBuilder.readTimeout(50, TimeUnit.SECONDS)
        okHttpClientBuilder.writeTimeout(60, TimeUnit.SECONDS)
        okHttpClientBuilder.addInterceptor(loggingInterceptor)
        return okHttpClientBuilder
    }


}