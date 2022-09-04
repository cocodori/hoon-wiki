package com.hoon.wiki

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HoonwikiApplication

fun main(args: Array<String>) {
    runApplication<HoonwikiApplication>(*args)
}
