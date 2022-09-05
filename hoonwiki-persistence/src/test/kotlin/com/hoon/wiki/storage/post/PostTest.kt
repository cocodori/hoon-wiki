package com.hoon.wiki.storage.post

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PostTest {

    @Test
    fun `삭제하면 deletedAt 현재 시간으로 채워넣는다`() {
        val post = Post("test", "test")

        assertThat(post.deletedAt).isNull()

        post.delete()

        assertThat(post.deletedAt).isNotNull
    }
}