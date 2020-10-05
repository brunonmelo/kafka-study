package nm.bruno.aluraKafka.app.producer

import nm.bruno.aluraKafka.factory.producer.KafkaProducerFactoryImpl
import nm.bruno.aluraKafka.service.producer.sendEmail.SendEmailService
import nm.bruno.aluraKafka.service.producer.sendEmail.SendEmailServiceImpl
import nm.bruno.aluraKafka.service.producer.order.OrderService
import nm.bruno.aluraKafka.service.producer.order.OrderServiceImpl
import nm.bruno.aluraKafka.utils.defaultSendMessageCallback
import java.util.*

fun main() {
    val orderService: OrderService = OrderServiceImpl(KafkaProducerFactoryImpl())
    val sendEmailService: SendEmailService = SendEmailServiceImpl(KafkaProducerFactoryImpl())

    for (x in 0..500) {
        val id = UUID.randomUUID().toString()
        orderService.sendMessage("$id 12,522,12341", id) { defaultSendMessageCallback(it) }
        sendEmailService.sendMessage("Thank you for order. We are processing now.",
            id) { defaultSendMessageCallback(it) }
    }
}
