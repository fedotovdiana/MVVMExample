package com.itis.group11801.fedotova.mvvmexample.di.module

import com.itis.group11801.fedotova.mvvmexample.BuildConfig
import com.itis.group11801.fedotova.mvvmexample.data.remote.service.NewsApiService
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideService(retrofit: Retrofit): NewsApiService {
        return retrofit.create(NewsApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        @Named(TAG_AUTH) authInterceptor: Interceptor,
        @Named(TAG_LOGGING) loggingInterceptor: Interceptor
    ): OkHttpClient {
        return OkHttpClient()
            .newBuilder()
            .addInterceptor(authInterceptor)
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        client: OkHttpClient,
        converterFactory: GsonConverterFactory,
        @Named(TAG_BASE_URL) url: String,
        factory: RxJava2CallAdapterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .client(client)
            .baseUrl(url)
            .addConverterFactory(converterFactory)
            .addCallAdapterFactory(factory)
            .build()
    }

    @Provides
    @Singleton
    fun provideRxJavaCallAdapterFactory() = RxJava2CallAdapterFactory.create()

    @Provides
    @Singleton
    @Named(TAG_AUTH)
    fun provideAuthInterceptor(
        @Named(TAG_API_KEY) apiKey: String
    ): Interceptor = Interceptor { chain ->
        val newUrl = chain
            .request()
            .url
            .newBuilder()
            .addQueryParameter(API_KEY, apiKey)
            .build()

        val newRequest = chain.request().newBuilder().url(newUrl).build()
        chain.proceed(newRequest)
    }

    @Provides
    @Singleton
    @Named(TAG_LOGGING)
    fun provideLoggingInterceptor(): Interceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    @Singleton
    fun provideConvertFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    @Singleton
    @Named(TAG_BASE_URL)
    fun provideBaseURL(): String = BuildConfig.API_ENDPOINT

    @Provides
    @Singleton
    @Named(TAG_API_KEY)
    fun provideApyKey(): String = BuildConfig.API_KEY

    companion object {
        private const val TAG_LOGGING = "tag_logging"
        private const val TAG_AUTH = "tag_auth"
        private const val TAG_API_KEY = "tag_apy_key"
        private const val TAG_BASE_URL = "tag_base_url"
        private const val API_KEY = "apiKey"
    }
}
