package nm.bruno.aluraKafka.service.consumer

import nm.bruno.aluraKafka.domain.Event
import org.apache.kafka.clients.consumer.ConsumerRecords

interface BaseConsumerService<T> {

    fun start(callback: (ConsumerRecords<String, Event<T>>) -> Unit)
    fun stop()
}
