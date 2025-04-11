package ru.galina_shiryaeva.news.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class DbModule {
/*
    @Singleton
    @Provides
    fun provideDb(
        @ApplicationContext context: Context
    ): AppDb = Room.databaseBuilder(context, AppDb::class.java, "app.db")
        .addTypeConverter(Converters(Gson()))
        .addTypeConverter(UserPaymentsConverters(Gson()))
        .addTypeConverter(PublicInfoConverters(Gson()))
        .addMigrations(Migrations.migration_1_2)
        .addMigrations(Migrations.migration_2_3)
        .addMigrations(Migrations.migration_3_4)
        .addMigrations(Migrations.migration_5_6)
        .addMigrations(Migrations.migration_6_7)
        .addMigrations(Migrations.migration_7_8)
        .addMigrations(Migrations.migration_8_9)
        .addMigrations(Migrations.migration_9_10)
        .addMigrations(Migrations.migration_10_11)
        // .addTypeConverter(ConvertersDvr())
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    fun provideUserInfoDao(
        appDb: AppDb
    ): UserInfoDao = appDb.userInfoDao()

    @Provides
    fun provideUserPaymentsDao(
        appDb: AppDb
    ): UserPaymentsDao = appDb.paymentsHistoryDao()

    @Provides
    fun provideLogDao(
        appDb: AppDb
    ): AppLogDao = appDb.logDao()

    @Provides
    fun provideDomofonCallSelectableDao(
        appDb: AppDb
    ): DomofonCallSelectableDao = appDb.domofonCallSelectableDao()

    @Provides
    fun provideMapCategorySelectableDao(
        appDb: AppDb
    ): MapCategorySelectableDao = appDb.mapCategorySelectableDao()

    @Provides
    fun provideMapFavoriteCityCamDao(
        appDb: AppDb
    ): MapFavoriteCityCamDao = appDb.mapFavoriteCityCamDao()

    @Provides
    fun providePublicInfoDao(
        appDb: AppDb
    ): PublicInfoDao = appDb.publicInfoDao()

 */
}