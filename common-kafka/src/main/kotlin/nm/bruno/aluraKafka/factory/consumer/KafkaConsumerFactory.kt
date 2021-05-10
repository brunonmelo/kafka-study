package nm.bruno.aluraKafka.factory.consumer

import nm.bruno.aluraKafka.domain.Event
import org.apache.kafka.clients.consumer.ConsumerRecords
import java.util.regex.Pattern

interface KafkaConsumerFactory <T> {
    fun <C> build(topic: String, clazz: Class<C>): KConsumer<T>
    fun <C> build(pattern: Pattern, clazz: Class<C>): KConsumer<T>

    interface KConsumer<T> {
        fun poll(mills: Long = 100, callback: (ConsumerRecords<String, Event<T>>) -> Unit)
    }
}
