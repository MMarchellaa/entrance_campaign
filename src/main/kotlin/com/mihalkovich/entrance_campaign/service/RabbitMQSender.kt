package com.mihalkovich.entrance_campaign.service

import com.mihalkovich.entrance_campaign.dto.ResultsDto
import org.springframework.amqp.core.AmqpTemplate
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class RabbitMQSender(
    private val rabbitTemplate: AmqpTemplate,
    @Value("\${javainuse.rabbitmq.exchange}")
    private val exchange: String,
    @Value("\${javainuse.rabbitmq.routingkey}")
    private val routingkey: String
) {
    fun send(resultsDto: ResultsDto) {
        rabbitTemplate.convertAndSend(exchange, routingkey, resultsDto) {
            it.messageProperties.headers["__TypeId__"] = "com.mihalkovich.notification.dto.ResultsDto"
            it
        }
        println("Send msg = $resultsDto")
    }
}