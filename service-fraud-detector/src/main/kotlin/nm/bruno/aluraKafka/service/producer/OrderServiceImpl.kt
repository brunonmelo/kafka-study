package nm.bruno.aluraKafka.service.producer

import nm.bruno.aluraKafka.domain.Order
import nm.bruno.aluraKafka.factory.producer.KafkaProducerFactory
import org.apache.kafka.clients.producer.RecordMetadata

class OrderServiceImpl(private val kafkaProducerFactory: KafkaProducerFactory<Order>) : OrderService,
    BaseProducerServiceImpl<Order>(kafkaProducerFactory.build("ECOMMERCE_NEW_ORDER")) {

    private val approvedProducer = this.kafkaProducerFactory.build("ECOMMERCE_ORDER_APPROVED")
    private val deniedProducer = this.kafkaProducerFactory.build("ECOMMERCE_ORDER_DENIED")

    override fun sendApprovedMessage(message: Order, callback: (RecordMetadata?) -> Unit) {
        approvedProducer.send(message, message.orderId, callback)
    }

    override fun sendDeniedMessage(message: Order, callback: (RecordMetadata?) -> Unit) {
        deniedProducer.send(message, message.orderId, callback)
    }
}