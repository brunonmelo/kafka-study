package nm.bruno.aluraKafka.service.consumer

import nm.bruno.aluraKafka.factory.consumer.KafkaConsumerFactory.KConsumer
import org.apache.kafka.clients.consumer.ConsumerRecords

open class BaseConsumerServiceImpl<T>(private val consumer: KConsumer<T>): BaseConsumerService<T> {

    private var switch = false

    override fun start(callback: (ConsumerRecords<String, T>) -> Unit) {
        switch = true
        while (switch) {
            pool(callback)
        }
    }

    override fun stop() {
        switch = false
    }

    private fun pool(callback: (ConsumerRecords<String, T>) -> Unit) {
        consumer.poll(callback = callback)
    }
}