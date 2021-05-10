package nm.bruno.aluraKafka.service.producer

import org.apache.kafka.clients.producer.RecordMetadata

interface BaseProducerService<T> {

    fun sendMessage(message: T, key: String? = null, callback: (RecordMetadata?) -> Unit)
}