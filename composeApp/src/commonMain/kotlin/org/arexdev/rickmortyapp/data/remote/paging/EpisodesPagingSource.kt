package org.arexdev.rickmortyapp.data.remote.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import org.arexdev.rickmortyapp.data.remote.ApiService
import org.arexdev.rickmortyapp.domain.model.EpisodeModel

class EpisodesPagingSource(private val apiService: ApiService) : PagingSource<Int, EpisodeModel>() {
    override fun getRefreshKey(state: PagingState<Int, EpisodeModel>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, EpisodeModel> {
        return try {
            val page = params.key ?: 1
            val response = apiService.getAllEpisodes(page)
            val episodes = response.results

            val prev = if (page > 0) page -1 else null
            val next = if (response.info.next != null) page + 1 else null
            LoadResult.Page(
                data = episodes.map { it -> it.toDomainModel() },
                prevKey = prev,
                nextKey = next
            )
        } catch (e: Exception) {
            LoadResult.Error(e)

        }
    }
}