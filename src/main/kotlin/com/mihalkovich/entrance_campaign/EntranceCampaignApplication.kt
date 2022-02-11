package com.mihalkovich.entrance_campaign

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.kafka.annotation.EnableKafka

@SpringBootApplication
@EnableKafka
class EntranceCampaignApplication

fun main(args: Array<String>) {
    runApplication<EntranceCampaignApplication>(*args)
}
