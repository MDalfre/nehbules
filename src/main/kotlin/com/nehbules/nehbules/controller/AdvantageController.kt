package com.nehbules.nehbules.controller

import com.nehbules.nehbules.model.Advantage
import com.nehbules.nehbules.service.AdvantageService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AdvantageController(
        private val advantageService: AdvantageService
) {

    @PostMapping("/create/advantage")
    fun createAdvantage(@RequestBody advantage: Advantage): Advantage {
        return advantageService.createAdvantage(advantage)
    }

    @GetMapping("/list/advantage")
    fun findAllAdvantages(): List<Advantage> {
        return advantageService.findAllAdvantages()
    }
}