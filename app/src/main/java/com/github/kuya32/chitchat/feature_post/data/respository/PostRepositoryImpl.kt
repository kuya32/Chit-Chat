package com.github.kuya32.chitchat.feature_post.data.respository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.github.kuya32.chitchat.R
import com.github.kuya32.chitchat.core.domain.models.Post
import com.github.kuya32.chitchat.core.utils.Constants
import com.github.kuya32.chitchat.core.utils.Resource
import com.github.kuya32.chitchat.core.utils.UiText
import com.github.kuya32.chitchat.feature_auth.data.dto.request.CreateAccountRequest
import com.github.kuya32.chitchat.feature_post.data.data_source.paging.PostSource
import com.github.kuya32.chitchat.feature_post.data.data_source.remote.PostApi
import com.github.kuya32.chitchat.feature_post.domain.respoitory.PostRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.HttpException
import java.io.IOException

class PostRepositoryImpl(
    private val api: PostApi
): PostRepository {

    override val posts: Flow<PagingData<Post>>
        get() = Pager(PagingConfig(pageSize = Constants.PAGE_SIZE_POSTS)) {
            PostSource(api)
        }.flow
}