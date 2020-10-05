package nm.bruno.aluraKafka.service.consumer

import nm.bruno.aluraKafka.factory.consumer.KafkaConsumerFactory.KConsumer
import org.apache.kafka.clients.consumer.ConsumerRecords

open class BaseConsumerServiceImpl(private var consumer: KConsumer<String>): BaseConsumerService {

    private var switch = false

    override fun start(callback: (ConsumerRecords<String, String>) -> Unit) {
        switch = true
        while (switch) {
            pool(callback)
        }
    }

    override fun stop() {
        switch = false
    }

    private fun pool(callback: (ConsumerRecords<String, String>) -> Unit) {
        consumer.poll(callback = callback)
    }
}