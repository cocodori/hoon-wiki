package com.hoon.wiki.storage.post

import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class PostView(
    private val postRepository: PostRepository
) {

    @Transactional(readOnly = true)
    fun getAllPost(): List<Post> {
        return postRepository.findAll()
    }
}