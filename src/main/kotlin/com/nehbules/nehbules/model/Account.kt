package com.nehbules.nehbules.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

import java.util.*

@Document
data class Account(
        @Id
        val accountId: UUID = UUID.randomUUID(),
        @Indexed(unique = true)
        val login: String,
        val password: String,
        val email: String,
        var playerCharacterList: List<UUID?> = emptyList()
)