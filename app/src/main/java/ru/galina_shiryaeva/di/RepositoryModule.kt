package ru.galina_shiryaeva.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
/*
    @Binds
    @Singleton
    fun bindRepository(repository: RepositoryImpl): Repository

    @Binds
    @Singleton
    fun bindUserInfoRepository(repository: UserInfoRepositoryImpl): UserInfoRepository

    @Binds
    @Singleton
    fun bindPublicInfoRepository(repository: PublicInfoRepositoryImpl): PublicInfoRepository

    @Binds
    @Singleton
    fun bindPaymentRepository(repository: PaymentRepositoryImpl): PaymentRepository

    @Binds
    @Singleton
    fun bindArchiveRepository(archiveRepositoryImpl: ArchiveRepositoryImpl): ArchiveRepository

    @Binds
    @Singleton
    fun bindOutDoorRepository(outDoorRepositoryImpl: OutDoorRepositoryImpl): OutDoorRepository

    @Binds
    @Singleton
    fun bindDomofonRepository(domofonRepositoryImpl: DomofonRepositoryImpl): DomofonRepository

    @Binds
    @Singleton
    fun bindHistoryCallRepository(historyCallRepositoryImpl: HistoryCallRepositoryImpl): HistoryCallRepository

    @Binds
    @Singleton
    fun bindMissedCallRepository(missedCallRepositoryImpl: MissedCallRepositoryImpl): MissedCallRepository

    @Binds
    @Singleton
    fun bindMapRepository(mapRepositoryImpl: MapRepositoryImpl): MapRepository

    @Binds
    @Singleton
    fun bindArchiveCityCamRepository(archiveCityCamRepositoryImpl: ArchiveCityCamRepositoryImpl): ArchiveCityCamRepository

    @Binds
    @Singleton
    fun bindFlussonicRepository(flussonicRepositoryImpl: FlussonicRepositoryImpl) : FlussonicRepository

 */
}