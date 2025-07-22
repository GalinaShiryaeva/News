package ru.galina_shiryaeva.news.data.util

import androidx.paging.PagingSource
import androidx.paging.PagingState
import ru.galina_shiryaeva.news.data.local.Constants
import ru.galina_shiryaeva.news.data.remote.ApiService
import ru.galina_shiryaeva.news.domain.model.everything_by_plants.NewsItem

class NewsPagingSource(
    private val apiService: ApiService,
//    private val query: String
) : PagingSource<Int, NewsItem>() {
    override fun getRefreshKey(state: PagingState<Int, NewsItem>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition) ?: return null
        return page.prevKey?.plus(1) ?: page.nextKey?.minus(1)

//        return state.anchorPosition?.let { position ->
//            state.closestPageToPosition(position)?.prevKey?.plus(1)
//                ?: state.closestPageToPosition(position)?.nextKey?.minus(1)
//        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, NewsItem> {
//        if (query.isEmpty()) {
//            return LoadResult.Page(emptyList(), prevKey = null, nextKey = null)
//        }

        val page: Int = params.key ?: 1
        val pageSize: Int = params.loadSize.coerceAtMost(Constants.Network.MAX_PAGE_SIZE)

        val response = apiService.getNews(page, pageSize)
        if (response.isSuccessful) {
            val news = checkNotNull(response.body()).articles?.map { it.mapToDomain() } ?: emptyList()
            val nextKey = if (news.size < pageSize) null else page + 1
            val prevKey = if (page == 1) null else page - 1
            return LoadResult.Page(news, prevKey, nextKey)
        } else {
            return LoadResult.Error(retrofit2.HttpException(response))
        }

//        return try {
//            val page = params.key ?: 1
//            val response = apiService.getNews(page)
//            val news = response.body()?.news?.map { it.mapToDomain() } ?: emptyList()
//            println(":::::load news size = ${news.size}")
//
//            LoadResult.Page(
//                data = news,
//                prevKey = if (page == 1) null else page - 1,
//                nextKey = if (news.isEmpty()) null else page + 1
//            )
//        } catch (e: Exception) {
//            LoadResult.Error(e)
//        }
    }
}