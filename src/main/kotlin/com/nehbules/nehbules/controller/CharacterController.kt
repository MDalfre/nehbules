package com.nehbules.nehbules.controller

import com.nehbules.nehbules.model.PlayerCharacter
import com.nehbules.nehbules.model.request.PlayerCharacterRequest
import com.nehbules.nehbules.repository.PlayerCharacterRepository
import com.nehbules.nehbules.service.PlayerCharacterService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CharacterController(
    private val playerCharacterRepository: PlayerCharacterRepository,
    private val advantageController: AdvantageController,
    private val playerCharacterService: PlayerCharacterService
) {

    @PostMapping("/create/character")
    fun createPlayerCharacter(@RequestBody playerCharacterRequest: PlayerCharacterRequest): PlayerCharacter {
        return playerCharacterService.createCharacter(playerCharacterRequest)
    }
}