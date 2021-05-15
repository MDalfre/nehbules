package com.nehbules.nehbules.model.response

import java.util.*

data class LoginResponse(
    var loginResponse: Boolean,
    var token: UUID?
)