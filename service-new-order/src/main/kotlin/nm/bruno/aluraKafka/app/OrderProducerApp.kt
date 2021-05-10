package nm.bruno.aluraKafka.app

import nm.bruno.aluraKafka.domain.Email
import nm.bruno.aluraKafka.domain.Order
import nm.bruno.aluraKafka.factory.producer.KafkaProducerFactoryImpl
import nm.bruno.aluraKafka.service.producer.OrderService
import nm.bruno.aluraKafka.service.producer.OrderServiceImpl
import nm.bruno.aluraKafka.service.producer.SendEmailService
import nm.bruno.aluraKafka.service.producer.SendEmailServiceImpl
import nm.bruno.aluraKafka.utils.defaultSendMessageCallback
import java.util.*

private val orderService: OrderService by lazy { OrderServiceImpl(KafkaProducerFactoryImpl()) }
private val sendEmailService: SendEmailService by lazy { SendEmailServiceImpl(KafkaProducerFactoryImpl()) }

fun main() {
    for (x in 0..10) {
        val orderId = UUID.randomUUID().toString()
        val userId = UUID.randomUUID().toString()
        val value = (Math.random() * 5000 + 1).toBigDecimal()

        val order = Order(orderId, userId, value)
        orderService.sendMessage(order, orderId) { defaultSendMessageCallback(it) }

        val email = Email(orderId, userId, "Thank you for order. We are processing now.")
        sendEmailService.sendMessage(
            email,
            orderId
        ) { defaultSendMessageCallback(it) }
    }
}
