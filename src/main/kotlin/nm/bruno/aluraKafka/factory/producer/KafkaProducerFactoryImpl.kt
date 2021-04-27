package nm.bruno.aluraKafka.factory.producer

import nm.bruno.aluraKafka.domain.Event
import nm.bruno.aluraKafka.factory.producer.KafkaProducerFactory.KProducer
import org.apache.kafka.clients.producer.*
import org.apache.kafka.common.serialization.StringSerializer
import java.util.*

class KafkaProducerFactoryImpl<T> : KafkaProducerFactory<T> {

    private val kafkaProducer by lazy { KafkaProducer<String, Event<T>>(properties()) }

    override fun build(topic: String): KProducer<T> {
        return KProducerImpl(kafkaProducer, topic)
    }

    private fun properties(): Properties {
        return Properties().apply {
            setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
            setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer::class.java.name)
            setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, GsonSerializable::class.java.name)
        }
    }

    internal class KProducerImpl<T>(
        private val kafkaProducer: KafkaProducer<String, Event<T>>,
        private val topic: String,
    ) : KProducer<T> {
        override fun send(value: T, key: String?, callback: (data: RecordMetadata?) -> Unit) {
            val event = Event(data = value)
            val record = ProducerRecord<String, Event<T>>(topic, key, event)
            kafkaProducer.send(record, callbackFunction(callback)).get()
        }

        private fun callbackFunction(callback: (data: RecordMetadata?) -> Unit): Callback {
            return Callback { metadata: RecordMetadata?, exception: Exception? ->
                callback(metadata)
                exception?.printStackTrace()
            }
        }
    }

}