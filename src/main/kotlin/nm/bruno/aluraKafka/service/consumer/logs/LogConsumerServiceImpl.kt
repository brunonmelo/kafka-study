package nm.bruno.aluraKafka.service.consumer.logs

import nm.bruno.aluraKafka.factory.consumer.KafkaConsumerFactory
import nm.bruno.aluraKafka.service.consumer.BaseConsumerServiceImpl
import java.util.regex.Pattern

internal class LogConsumerServiceImpl(consumerFactory: KafkaConsumerFactory<Any>) : LogConsumerService,
    BaseConsumerServiceImpl<Any>(consumerFactory.build(Pattern.compile("ECOMMERCE.*"), LogConsumerService::class.java))