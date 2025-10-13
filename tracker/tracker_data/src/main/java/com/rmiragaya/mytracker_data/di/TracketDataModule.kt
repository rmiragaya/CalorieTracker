package com.rmiragaya.mytracker_data.di

import android.app.Application
import androidx.room.Room
import com.rmiragaya.mytracker_data.local.TrackerDatabase
import com.rmiragaya.mytracker_data.remote.OpenFoodApi
import com.rmiragaya.mytracker_data.remote.OpenFoodApi.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TracketDataModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }

    @Provides
    @Singleton
    fun provideOpenFoodApi(client: OkHttpClient) : OpenFoodApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
            .create(OpenFoodApi::class.java)
    }

    @Provides
    @Singleton
    fun provideTrackerDatabase(app: Application): TrackerDatabase{
        return Room.databaseBuilder(
            app,
            TrackerDatabase::class.java,
            "tracker_db"
        ).build()
    }
}