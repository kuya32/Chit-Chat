package com.github.kuya32.chitchat.feature_post.data.data_source.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.github.kuya32.chitchat.core.domain.models.Post

class PostSource: PagingSource<Int, Post>() {

    override fun getRefreshKey(state: PagingState<Int, Post>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Post> {
        TODO("Not yet implemented")
    }
}