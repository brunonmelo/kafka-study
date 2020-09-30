package nm.bruno.aluraKafka.app.producer

import nm.bruno.aluraKafka.factory.producer.KafkaProducerFactoryImpl
import nm.bruno.aluraKafka.service.order.OrderService
import nm.bruno.aluraKafka.service.order.OrderServiceImpl

fun main() {
    val orderService: OrderService = OrderServiceImpl(KafkaProducerFactoryImpl())
    orderService.sendOrder("12,522,12341")
}
