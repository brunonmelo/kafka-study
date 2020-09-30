package nm.bruno.aluraKafka.factory.consumer

import com.fasterxml.jackson.databind.JsonDeserializer
import nm.bruno.aluraKafka.factory.consumer.KafkaConsumerFactory.KConsumer
import nm.bruno.aluraKafka.service.fraudDetect.FraudDetectService
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.consumer.ConsumerRecords
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.common.serialization.StringSerializer
import java.time.Duration
import java.util.*

class KafkaConsumerFactoryImpl<T> : KafkaConsumerFactory<T> {

    private val consumer: KafkaConsumer<String, T> by lazy { KafkaConsumer(properties()) }

    override fun build(topic: String): KConsumer<T> {
        consumer.subscribe(listOf(topic))
        return KConsumerImpl(consumer)
    }

    private fun properties(): Properties {
        return Properties().apply {
            setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
            setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer::class.java.name)
            setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer::class.java.name)
            setProperty(ConsumerConfig.GROUP_ID_CONFIG, FraudDetectService::class.java.simpleName)
        }
    }


    internal class KConsumerImpl<T>(private val consumer: KafkaConsumer<String, T>) : KConsumer<T> {
        override fun poll(mills: Long, callback: (ConsumerRecords<String, T>) -> Unit) {
            val records: ConsumerRecords<String, T> = consumer.poll(Duration.ofMillis(mills))

            callback(records)
        }
    }
}
