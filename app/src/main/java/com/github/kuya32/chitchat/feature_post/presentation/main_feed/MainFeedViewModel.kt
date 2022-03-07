package com.github.kuya32.chitchat.feature_post.presentation.main_feed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.github.kuya32.chitchat.core.domain.models.Post
import com.github.kuya32.chitchat.core.utils.Constants
import com.github.kuya32.chitchat.feature_post.data.data_source.paging.PostSource
import com.github.kuya32.chitchat.feature_post.domain.use_case.PostUseCases
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainFeedViewModel @Inject constructor(
    private val postUseCases: PostUseCases
): ViewModel() {

    val posts = postUseCases.getPostsForFollowUseCase()
        .cachedIn(viewModelScope)
}