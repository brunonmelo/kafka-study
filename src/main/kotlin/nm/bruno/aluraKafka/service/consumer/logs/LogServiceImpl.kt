package nm.bruno.aluraKafka.service.consumer.logs

import nm.bruno.aluraKafka.factory.consumer.KafkaConsumerFactory
import nm.bruno.aluraKafka.service.consumer.BaseConsumerServiceImpl
import org.apache.kafka.clients.consumer.ConsumerRecords
import java.util.regex.Pattern

internal class LogServiceImpl(consumerFactory: KafkaConsumerFactory<String>) : LogService,
    BaseConsumerServiceImpl(consumerFactory.build(Pattern.compile("ECOMMERCE.*"), LogService::class.java))