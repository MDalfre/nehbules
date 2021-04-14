package com.nehbules.nehbules.repository

import com.nehbules.nehbules.model.Advantage
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AdvantageRepository: MongoRepository<Advantage, UUID>