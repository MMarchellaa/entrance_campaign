package com.mihalkovich.entrance_campaign.dto

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.ObjectIdGenerators

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator::class, property = "id", scope = ResultsDto::class)
data class ResultsDto(
    var name: String? = null,
    var patronymic: String? = null,
    var surname: String? = null,
    var telephoneNumber: String? = null,
    var email: String? = null,
    var result: Boolean? = false
)
