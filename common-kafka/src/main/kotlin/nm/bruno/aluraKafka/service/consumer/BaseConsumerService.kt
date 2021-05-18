package nm.bruno.aluraKafka.service.consumer

import org.apache.kafka.clients.consumer.ConsumerRecords

interface BaseConsumerService<T> {

    fun start(callback: (ConsumerRecords<String, T>) -> Unit)
    fun stop()
}
