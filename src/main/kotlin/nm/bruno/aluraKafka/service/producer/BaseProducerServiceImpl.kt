package nm.bruno.aluraKafka.service.producer

import nm.bruno.aluraKafka.factory.producer.KafkaProducerFactory.KProducer
import org.apache.kafka.clients.producer.RecordMetadata

open class BaseProducerServiceImpl(private val producer: KProducer<String>): BaseProducerService {

    override fun sendMessage(message: String, callback: (RecordMetadata?) -> Unit) {
        producer.send(message, callback)
    }
}