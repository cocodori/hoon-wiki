package com.hoon.wiki.storage.post

import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.spyk
import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith


@ExtendWith(MockKExtension::class)
internal class PostCreateTest {

    @MockK
    lateinit var postRepository: PostRepository

    @InjectMockKs
    lateinit var postCreate: PostCreate

    @Test
    fun `post 저장하고 id 반환한다`() {
        //given
        val post = spyk(Post(title = "title", content = "content"))

        every { post.id } returns 1L
        every { postRepository.save(any()) } returns post

        //when
        val postId = postCreate.save(title = "title", content = "content")

        //then
        assertThat(postId).isEqualTo(1L)
    }

}