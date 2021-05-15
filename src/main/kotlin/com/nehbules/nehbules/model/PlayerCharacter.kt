package com.nehbules.nehbules.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
data class PlayerCharacter(
    @Id
    val id: UUID = UUID.randomUUID(),
    val name: String,
    var currentGameId: UUID?,
    val className: String,
    val raceName: String,
    var attributes: Attributes,
    var advantage: List<Advantage>
)

data class Attributes(
    var strength: Int,
    var ability: Int,
    var armor: Int,
    var resistance: Int,
    var firePower: Int,
    var health: Int,
    var mana: Int,
    var level: Int
) {
    constructor(strength: Int, ability: Int, resistance: Int, armor: Int, firePower: Int, level: Int) : this(
        strength = strength,
        ability = ability,
        resistance = resistance,
        armor = armor,
        firePower = firePower,
        health = healthCalculator(resistance, false),
        mana = manaCalculator(resistance, false),
        level = level
    )

    companion object {
        private fun healthCalculator(resistance: Int, modifier: Boolean): Int {
            return if (modifier) {
                (resistance + 2) * 5
            } else {
                resistance * 5
            }
        }

        private fun manaCalculator(resistance: Int, modifier: Boolean): Int {
            return if (modifier) {
                (resistance + 2) * 5
            } else {
                resistance * 5
            }
        }
    }

}

enum class AbilityEffects {
    STUNNED,
    SLOWED,
    FROZEN,
    BURNED,
    POISONED,
    CURSED
}
