package com.nehbules.nehbules.service

import com.nehbules.nehbules.model.Account
import com.nehbules.nehbules.model.request.Login
import com.nehbules.nehbules.model.response.LoginResponse
import com.nehbules.nehbules.repository.AccountRepository
import org.slf4j.LoggerFactory
import org.springframework.dao.DuplicateKeyException
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.*

@Service
class AccountService(
    private val accountRepository: AccountRepository
) {

    private val logger = LoggerFactory.getLogger(javaClass)

    fun createAccount(account: Account): Account {
        logger.info("Creating account: ${account.login}")
        try {
           return accountRepository.save(account)
        } catch (e: DuplicateKeyException) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already taken.")
        }

    }

    fun login(login: Login): LoginResponse {
        logger.info("User ${login.user} is trying to login.")
        try {
            val account = accountRepository.findAccountByLogin(login.user)
            return if( account.password == login.password) {
                LoginResponse(loginResponse = true, token = UUID.randomUUID())
            }else{
                throw ResponseStatusException(HttpStatus.FORBIDDEN, "Invalid credentials.")
            }
        } catch (e: Exception) {
            throw ResponseStatusException(HttpStatus.FORBIDDEN, "Invalid credentials.")
        }


    }

}
