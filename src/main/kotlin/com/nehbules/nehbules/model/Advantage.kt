package com.nehbules.nehbules.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
data class Advantage(
    @Id
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val effect: AbilityEffects,
    val description: String,
    val modifier: Boolean,
    val spellCost: Int
)