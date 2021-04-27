package nm.bruno.aluraKafka.service.consumer

import nm.bruno.aluraKafka.domain.Event
import nm.bruno.aluraKafka.factory.consumer.KafkaConsumerFactory.KConsumer
import org.apache.kafka.clients.consumer.ConsumerRecords

open class BaseConsumerServiceImpl<T>(private val consumer: KConsumer<T>): BaseConsumerService<T> {

    private var switch = false

    override fun start(callback: (ConsumerRecords<String, Event<T>>) -> Unit) {
        switch = true
        while (switch) {
            pool(callback)
        }
    }

    override fun stop() {
        switch = false
    }

    private fun pool(callback: (ConsumerRecords<String, Event<T>>) -> Unit) {
        consumer.poll(callback = callback)
    }
}