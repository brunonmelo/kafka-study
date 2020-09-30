package nm.bruno.aluraKafka.factory.consumer

import org.apache.kafka.clients.consumer.ConsumerRecords

interface KafkaConsumerFactory <T> {
    fun build(topic: String): KConsumer<T>

    interface KConsumer<T> {
        fun poll(mills: Long = 100, callback: (ConsumerRecords<String, T>) -> Unit)
    }
}
