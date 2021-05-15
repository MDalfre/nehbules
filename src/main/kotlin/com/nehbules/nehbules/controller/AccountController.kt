package com.nehbules.nehbules.controller

import com.nehbules.nehbules.model.Account
import com.nehbules.nehbules.model.request.Login
import com.nehbules.nehbules.model.response.LoginResponse
import com.nehbules.nehbules.service.AccountService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AccountController(
    private val accountService: AccountService
) {

    @PostMapping("/create/account")
    fun createAccount(@RequestBody account: Account): Account {
        return accountService.createAccount(account)
    }

    @PostMapping("/login")
    fun login(@RequestBody login: Login): LoginResponse {
        return accountService.login(login)
    }
}