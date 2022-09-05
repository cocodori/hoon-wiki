package com.hoon.wiki.post.web

import com.hoon.wiki.post.dto.PostCreateRequest
import com.hoon.wiki.post.web.service.PostCreateService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/v1/api/post")
internal class PostCreateApiController(
    private val postCreateService: PostCreateService
){

    @PostMapping
    fun save(@RequestBody @Valid request: PostCreateRequest): ResponseEntity<Long> {
        val postId = postCreateService.savePost(request)

        return ResponseEntity<Long>(postId, HttpStatus.CREATED)
    }

}