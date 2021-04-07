package nm.bruno.aluraKafka.app.producer

import nm.bruno.aluraKafka.factory.producer.KafkaProducerFactoryImpl
import nm.bruno.aluraKafka.service.producer.sendEmail.SendEmailService
import nm.bruno.aluraKafka.service.producer.sendEmail.SendEmailServiceImpl
import nm.bruno.aluraKafka.service.producer.order.OrderService
import nm.bruno.aluraKafka.service.producer.order.OrderServiceImpl
import nm.bruno.aluraKafka.utils.defaultSendMessageCallback
import java.util.*

private val orderService: OrderService by lazy { OrderServiceImpl(KafkaProducerFactoryImpl()) }
private val sendEmailService: SendEmailService by lazy { SendEmailServiceImpl(KafkaProducerFactoryImpl()) }

fun main() {
    for (x in 0..200) {
        val id = UUID.randomUUID().toString()
        orderService.sendMessage("$id 12,522,12341", id) { defaultSendMessageCallback(it) }
        sendEmailService.sendMessage(
            "Thank you for order. We are processing now.",
            id
        ) { defaultSendMessageCallback(it) }
    }
}
