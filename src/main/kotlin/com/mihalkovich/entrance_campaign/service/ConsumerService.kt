package com.mihalkovich.entrance_campaign.service

import com.mihalkovich.entrance_campaign.dto.EnrolleeDto
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class ConsumerService(
    val campaignService: CampaignService,
) {

    @KafkaListener(topics = ["enrollee"], groupId = "message_group_id")
    fun consume(enrolleeDto: EnrolleeDto) {
        println("Consuming the message: $enrolleeDto")
        campaignService.campaign(enrolleeDto)
    }
}