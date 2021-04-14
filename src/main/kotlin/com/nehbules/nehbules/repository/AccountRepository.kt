package com.nehbules.nehbules.repository

import com.nehbules.nehbules.model.Account
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AccountRepository: MongoRepository<Account, UUID> {
}