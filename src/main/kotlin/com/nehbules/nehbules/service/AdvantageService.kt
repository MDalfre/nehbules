package com.nehbules.nehbules.service

import com.nehbules.nehbules.model.*
import com.nehbules.nehbules.repository.AccountRepository
import com.nehbules.nehbules.repository.AdvantageRepository
import com.nehbules.nehbules.repository.GameRepository
import com.nehbules.nehbules.repository.PlayerCharacterRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class AdvantageService(
        private val accountRepository: AccountRepository,
        private val gameRepository: GameRepository,
        private val advantageRepository: AdvantageRepository,
        private val playerCharacterRepository: PlayerCharacterRepository
){

    fun createAdvantage(advantage: Advantage): Advantage {
        return advantageRepository.save(advantage)
    }

    fun findAllAdvantages():List<Advantage> {
        return advantageRepository.findAll()
    }
}