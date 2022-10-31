package com.example.rickandmortyapp.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.rickandmortyapp.api.ApiService
import com.example.rickandmortyapp.models.RickMorty
import java.lang.Exception

class RickMortyPagingSource(private val apiService: ApiService) : PagingSource<Int,RickMorty>() {
    override fun getRefreshKey(state: PagingState<Int, RickMorty>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RickMorty> {
        return try {
            val currentPager=params.key ?: 1
            val response=apiService.getAllCharacters(currentPager)
            val data=response.body()?.results ?: emptyList()
            val responseData= mutableListOf<RickMorty>()
            responseData.addAll(data)

            LoadResult.Page(
                data=responseData,
                prevKey = if(currentPager ==1) null else -1,
                nextKey = currentPager.plus(1)
                )
        }catch (e:Exception){
            LoadResult.Error(e)
        }
    }
}
