package com.hoon.wiki.post.web

import com.fasterxml.jackson.databind.ObjectMapper
import com.hoon.wiki.post.dto.PostCreateRequest
import com.hoon.wiki.storage.post.PostView
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullSource
import org.junit.jupiter.params.provider.ValueSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post
import org.springframework.web.client.HttpClientErrorException.BadRequest

@SpringBootTest
@AutoConfigureMockMvc
class PostCreateApiControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var objectMapper: ObjectMapper

    @Autowired
    lateinit var postView: PostView

    @Test
    fun `Post 등록 200 OK`() {
        //given
        val request = PostCreateRequest(
            title = "test title",
            content = "content",
        )
        val jsonBody = objectMapper.writeValueAsString(request)

        //when
        val response = mockMvc.post("/v1/api/post") {
            this.contentType = MediaType.APPLICATION_JSON
            this.content = jsonBody
        }

        //then
        val post = postView.getAllPost().last()

        response.andExpect {
            status { isCreated() }
            content { string("${post.id}") }
        }.andDo { print() }
    }

    @ParameterizedTest
    @ValueSource(strings = [
        """{"title": "  ", "content": ""}""",
        """{"title": "", "content": "  "}"""
    ])
    fun `필수값 없으면 BadRequestException`(input: String?) {
        //given-when
        val response = mockMvc.post("/v1/api/post") {
            this.contentType = MediaType.APPLICATION_JSON
            this.content = input
        }

        //then
        response.andExpect {
            status { isBadRequest() }
            jsonPath("$['code']") { value(HttpStatus.BAD_REQUEST.reasonPhrase) }
            jsonPath("$['message']") { value("validation failed") }
        }.andDo { print() }
    }


}