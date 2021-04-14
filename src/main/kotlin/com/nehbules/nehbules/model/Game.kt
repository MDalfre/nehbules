package com.nehbules.nehbules.model

import java.util.*

class Game (
        val id: UUID,
        val name: String,
        val characters: List<PlayerCharacter>,
        val master: Account
)