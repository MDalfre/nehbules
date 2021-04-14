package com.nehbules.nehbules.service

import com.nehbules.nehbules.model.PlayerCharacter
import com.nehbules.nehbules.model.request.PlayerCharacterRequest
import com.nehbules.nehbules.repository.AdvantageRepository
import com.nehbules.nehbules.repository.PlayerCharacterRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class PlayerCharacterService(
    private val playerCharacterRepository: PlayerCharacterRepository,
    private val advantageRepository: AdvantageRepository
) {


    fun createCharacter(playerCharacterRequest: PlayerCharacterRequest): PlayerCharacter {
        val advantageList= playerCharacterRequest.advantage.map {
            advantageRepository.findByIdOrNull(it)
        }.filterNotNull()

        if (advantageList.isNullOrEmpty()){
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid or Null attributes")
        }
        return playerCharacterRepository.save(
            playerCharacterRequest.convertToPlayerCharacter(advantageList)
        )

    }

}
