package com.hoon.wiki.common.error

data class ErrorResult(
    val code: String,
    val message: String? = null
)