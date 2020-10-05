package nm.bruno.aluraKafka.service.producer

import org.apache.kafka.clients.producer.RecordMetadata

interface BaseProducerService {

    fun sendMessage(message: String, key: String? = null, callback: (RecordMetadata?) -> Unit)
}