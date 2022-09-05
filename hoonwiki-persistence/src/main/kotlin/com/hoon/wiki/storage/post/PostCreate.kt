package com.hoon.wiki.storage.post

import org.springframework.stereotype.Component

@Component
class PostCreate internal constructor(
    private val postRepository: PostRepository
) {
    fun save(
        title: String,
        content: String,
    ): Long {

        val post = Post(
            title = title,
            content = content,
        )

        return postRepository.save(post).id
    }
}