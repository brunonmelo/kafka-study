package nm.bruno.aluraKafka.service.producer

import nm.bruno.aluraKafka.factory.producer.KafkaProducerFactory.KProducer
import org.apache.kafka.clients.producer.RecordMetadata

open class BaseProducerServiceImpl<T>(private val producer: KProducer<T>): BaseProducerService<T> {

    override fun sendMessage(message: T, key: String?, callback: (RecordMetadata?) -> Unit) {
        producer.send(message, key, callback)
    }

}