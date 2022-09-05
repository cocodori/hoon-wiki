package com.hoon.wiki.post.dto

import org.springframework.web.multipart.MultipartFile
import javax.validation.constraints.NotBlank

data class PostCreateRequest(
    @field:NotBlank(message = "필수값입니다.")
    val title: String,
    @field:NotBlank(message = "필수값입니다.")
    val content: String,
)