package nm.bruno.aluraKafka.service.consumer

import org.apache.kafka.clients.consumer.ConsumerRecords

interface BaseConsumerService {

    fun start(callback: (ConsumerRecords<String, String>) -> Unit)
    fun stop()
}
