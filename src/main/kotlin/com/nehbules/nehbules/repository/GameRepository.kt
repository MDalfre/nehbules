package com.nehbules.nehbules.repository

import com.nehbules.nehbules.model.Game
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface GameRepository: MongoRepository<Game, UUID> {
}