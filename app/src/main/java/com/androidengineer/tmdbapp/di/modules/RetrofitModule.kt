package com.androidengineer.tmdbapp.di.modules

import android.content.Context
import com.androidengineer.tmdbapp.R
import com.androidengineer.tmdbapp.data.remote.TMDBApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor()= HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor)= OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
        .callTimeout(2, TimeUnit.MINUTES)
        .connectTimeout(20, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .dispatcher(Dispatcher().apply {
            maxRequests = 1
        }).build()

    @Singleton
    @Provides
    fun provideRetrofitInstance(@ApplicationContext context: Context, okHttpClient: OkHttpClient)= Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(context.getString(R.string.api_base_url))
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Singleton
    @Provides
    fun provideNewsHeadlinesApiInterface(retrofit: Retrofit) = retrofit.create(
        TMDBApiService::class.java)

}