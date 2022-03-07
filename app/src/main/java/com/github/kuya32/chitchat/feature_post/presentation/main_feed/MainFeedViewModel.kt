package com.github.kuya32.chitchat.feature_post.presentation.main_feed

import androidx.lifecycle.ViewModel
import com.github.kuya32.chitchat.feature_post.domain.use_case.PostUseCases
import javax.inject.Inject

class MainFeedViewModel @Inject constructor(
    private val postUseCases: PostUseCases
): ViewModel() {


}