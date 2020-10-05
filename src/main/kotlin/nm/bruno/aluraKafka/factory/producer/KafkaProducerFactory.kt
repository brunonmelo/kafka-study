package nm.bruno.aluraKafka.factory.producer

import org.apache.kafka.clients.producer.RecordMetadata

interface KafkaProducerFactory <T> {
    fun build(topic: String): KProducer<T>

    interface KProducer<T> {
        fun send(value: T, key: String?, callback: (data: RecordMetadata?) -> Unit)
    }
}
