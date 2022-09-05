package com.hoon.wiki.storage.post

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Post internal constructor(
    title: String,
    content: String,
) {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = -1

    @Column
    var title: String = title
        protected set

    @Column(columnDefinition = "text")
    var content: String = content
        protected set

    @CreatedDate
    val createdDate: LocalDateTime = LocalDateTime.now()

    @LastModifiedDate
    var updatedAt: LocalDateTime = LocalDateTime.now()
        protected set

    var deletedAt: LocalDateTime? = null
        protected set


    fun delete() {
        this.deletedAt = LocalDateTime.now()
    }
}