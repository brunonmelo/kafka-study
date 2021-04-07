package nm.bruno.aluraKafka.service.consumer.fraudDetect

import nm.bruno.aluraKafka.factory.consumer.KafkaConsumerFactory
import nm.bruno.aluraKafka.service.consumer.BaseConsumerServiceImpl

internal class FraudDetectConsumerServiceImpl(consumerFactory: KafkaConsumerFactory<String>) : FraudDetectConsumerService,
    BaseConsumerServiceImpl(consumerFactory.build("ECOMMERCE_NEW_ORDER", FraudDetectConsumerService::class.java))