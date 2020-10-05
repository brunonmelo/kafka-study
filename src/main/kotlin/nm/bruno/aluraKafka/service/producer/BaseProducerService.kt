package nm.bruno.aluraKafka.service.producer

import org.apache.kafka.clients.producer.RecordMetadata

interface BaseProducerService {

    fun sendMessage(message: String, callback: (RecordMetadata?) -> Unit)
}