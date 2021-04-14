package com.nehbules.nehbules.model

data class Account(
        val login: String,
        val password: String,
        val email: String,
        val playerCharacterList: List<PlayerCharacter>
)