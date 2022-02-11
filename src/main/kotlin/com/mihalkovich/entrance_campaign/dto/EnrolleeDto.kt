package com.mihalkovich.entrance_campaign.dto

data class EnrolleeDto(
    var name: String? = null,
    var patronymic: String? = null,
    var surname: String? = null,
    var telephoneNumber: String? = null,
    var email: String? = null,
    var testingResults: Map<String, Int>? = null,
    var averageRating: String? = null,
    var isGoldMedalist: Boolean? = false,
    var dreamSpeciality: DreamSpecialityDto? = null
)
