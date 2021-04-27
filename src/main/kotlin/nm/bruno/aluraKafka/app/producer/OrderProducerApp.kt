package nm.bruno.aluraKafka.app.producer

import nm.bruno.aluraKafka.domain.events.Email
import nm.bruno.aluraKafka.domain.events.Order
import nm.bruno.aluraKafka.factory.producer.KafkaProducerFactoryImpl
import nm.bruno.aluraKafka.service.producer.order.OrderService
import nm.bruno.aluraKafka.service.producer.order.OrderServiceImpl
import nm.bruno.aluraKafka.service.producer.sendEmail.SendEmailService
import nm.bruno.aluraKafka.service.producer.sendEmail.SendEmailServiceImpl
import nm.bruno.aluraKafka.utils.defaultSendMessageCallback
import java.util.*

private val orderService: OrderService by lazy { OrderServiceImpl(KafkaProducerFactoryImpl()) }
private val sendEmailService: SendEmailService by lazy { SendEmailServiceImpl(KafkaProducerFactoryImpl()) }

fun main() {
    for (x in 0..2) {
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
