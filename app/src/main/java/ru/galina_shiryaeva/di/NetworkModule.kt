package ru.galina_shiryaeva.di

import android.annotation.SuppressLint
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
@SuppressLint("LogNotTimber")
class NetworkModule {
/*
    @Provides
    @Singleton
    fun provideDynamicBaseUrlInterceptor(): DynamicBaseUrlInterceptor {
        return DynamicBaseUrlInterceptor()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        dynamicBaseUrlInterceptor: DynamicBaseUrlInterceptor,
        loggingInterceptor: LoggingInterceptor
    ): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .client(
                okHttpClient.newBuilder()
                    .addInterceptor(dynamicBaseUrlInterceptor)
                    .addInterceptor(loggingInterceptor)
                    .build()
            )
            .build()
    }

    @Provides
    @Singleton
    fun provideLogging(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        if (BuildConfig.DEBUG) {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    @Singleton
    fun provideOkHttp(
        logging: HttpLoggingInterceptor,
        authInterceptor: AuthInterceptor,
    ): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(logging)
        .addInterceptor(authInterceptor)
        .connectTimeout(100, TimeUnit.SECONDS)
        .readTimeout(100, TimeUnit.SECONDS)
        .build()

    @Provides
    @Singleton
    fun provideApiService(
        retrofit: Retrofit
    ): ApiService = retrofit.create()

    @Provides
    @Singleton
    fun provideMissedCallApiService(
        retrofit: Retrofit
    ): MissedCallApiService = retrofit.create()

    fun provideHistoryCallApiService(
        retrofit: Retrofit
    ): HistoryCallApiService = retrofit.create()

    @Provides
    @Singleton
    fun provideDomofonCamerasApiService(
        retrofit: Retrofit
    ): DomofonCamerasApiService = retrofit.create()

    @Provides
    @Singleton
    fun provideCrashCityCamApiService(
        retrofit: Retrofit
    ): CrashCityCamApiService = retrofit.create()

 */
}