package nm.bruno.aluraKafka.factory.consumer

import nm.bruno.aluraKafka.factory.consumer.KafkaConsumerFactory.KConsumer
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.consumer.ConsumerRecords
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.common.serialization.StringDeserializer
import java.time.Duration
import java.util.*
import java.util.regex.Pattern

class KafkaConsumerFactoryImpl<T> : KafkaConsumerFactory<T> {

    private lateinit var consumer: KafkaConsumer<String, T>

    override fun <C> build(topic: String, clazz: Class<C>): KConsumer<T> {
        consumer = KafkaConsumer(properties(clazz))
        consumer.subscribe(listOf(topic))
        return KConsumerImpl(consumer)
    }

    override fun <C> build(pattern: Pattern, clazz: Class<C>): KConsumer<T> {
        consumer = KafkaConsumer(properties(clazz))
        consumer.subscribe(pattern)
        return KConsumerImpl(consumer)
    }

    private fun <C> properties(clazz: Class<C>): Properties {
        return Properties().apply {
            setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
            setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer::class.java.name)
            setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer::class.java.name)
            setProperty(ConsumerConfig.GROUP_ID_CONFIG, clazz.simpleName)
            setProperty(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "1")
        }
    }


    internal class KConsumerImpl<T>(private val consumer: KafkaConsumer<String, T>) : KConsumer<T> {
        override fun poll(mills: Long, callback: (ConsumerRecords<String, T>) -> Unit) {
            val records: ConsumerRecords<String, T> = consumer.poll(Duration.ofMillis(mills))

            callback(records)
        }
    }
}
