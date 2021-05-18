package nm.bruno.aluraKafka.factory.consumer

import org.apache.kafka.clients.consumer.ConsumerRecords
import java.util.regex.Pattern

interface KafkaConsumerFactory <T> {
    fun <C> build(topic: String, clazz: Class<C>, type: Class<T>): KConsumer<T>
    fun <C> build(pattern: Pattern, clazz: Class<C>, type: Class<T>): KConsumer<T>

    interface KConsumer<T> {
        fun poll(mills: Long = 100, callback: (ConsumerRecords<String, T>) -> Unit)
    }
}
