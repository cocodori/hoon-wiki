package com.hoon.wiki.post.web.service

import com.hoon.wiki.post.dto.PostCreateRequest
import com.hoon.wiki.storage.post.PostCreate
import org.springframework.stereotype.Service

@Service
internal class PostCreateService(
    private val postCreate: PostCreate
) {

    fun savePost(request: PostCreateRequest): Long {
        return postCreate.save(
            title = request.title,
            content = request.content,

        )
    }
}