package com.hoon.wiki.post.service

import com.hoon.wiki.post.dto.PostCreateRequest
import com.hoon.wiki.post.web.service.PostCreateService
import com.hoon.wiki.storage.post.PostCreate
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class PostCreateServiceTest {

    @InjectMockKs
    internal lateinit var postCreateService: PostCreateService

    @MockK
    lateinit var postCreate: PostCreate

    @Test
    fun `save 함수 호출하고 id 반환한다`() {
        val request = PostCreateRequest(
            title = "save title",
            content = "save content",
        )

        every { postCreate.save(any(), any()) } returns 1L

        val postId = postCreateService.savePost(request)

        assertThat(postId).isEqualTo(1L)
    }
}