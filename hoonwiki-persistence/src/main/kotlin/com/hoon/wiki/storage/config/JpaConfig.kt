package com.hoon.wiki.storage.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = ["com.hoon.wiki.storage"])
@EntityScan(basePackages = ["com.hoon.wiki.storage"])
class JpaConfig