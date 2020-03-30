package com.itis.group11801.fedotova.mvvmexample.di.module

import com.itis.group11801.fedotova.mvvmexample.BuildConfig
import com.itis.group11801.fedotova.mvvmexample.data.remote.repository.NewsRepository
import com.itis.group11801.fedotova.mvvmexample.data.remote.repository.NewsRepositoryImpl
import com.itis.group11801.fedotova.mvvmexample.data.remote.service.NewsApiService
import com.itis.group11801.fedotova.mvvmexample.domain.NewsInteractor
import com.itis.group11801.fedotova.mvvmexample.domain.NewsInteractorImpl
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient()
            .newBuilder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(client)
            .baseUrl(BuildConfig.API_ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideService(retrofit: Retrofit): NewsApiService {
        return retrofit.create(NewsApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(userRepository: NewsRepositoryImpl): NewsRepository = userRepository

    @Provides
    @Singleton
    fun provideNewsInteractor(userInteractor: NewsInteractorImpl): NewsInteractor = userInteractor

}
