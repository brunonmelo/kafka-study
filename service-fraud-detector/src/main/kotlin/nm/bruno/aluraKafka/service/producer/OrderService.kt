package nm.bruno.aluraKafka.service.producer

import nm.bruno.aluraKafka.domain.Order
import org.apache.kafka.clients.producer.RecordMetadata

interface OrderService : BaseProducerService<Order> {
    fun sendApprovedMessage(message: Order, callback: (RecordMetadata?) -> Unit)
    fun sendDeniedMessage(message: Order, callback: (RecordMetadata?) -> Unit)
}