package com.nehbules.nehbules.model.request

import com.nehbules.nehbules.model.Advantage
import com.nehbules.nehbules.model.Attributes
import com.nehbules.nehbules.model.PlayerCharacter
import java.util.*

data class PlayerCharacterRequest(
    val name: String,
    val className: String,
    val raceName: String,
    var attributes: Attributes,
    var advantage: List<UUID>
) {

    fun convertToPlayerCharacter(advantage: List<Advantage>): PlayerCharacter {
        return PlayerCharacter(
            name = this.name,
            currentGameId = null,
            className = this.className,
            raceName = this.raceName,
            attributes = this.attributes,
            advantage = advantage
        )
    }
}