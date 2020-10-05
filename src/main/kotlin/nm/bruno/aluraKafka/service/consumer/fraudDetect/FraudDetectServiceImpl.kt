package nm.bruno.aluraKafka.service.consumer.fraudDetect

import nm.bruno.aluraKafka.factory.consumer.KafkaConsumerFactory
import nm.bruno.aluraKafka.service.consumer.BaseConsumerServiceImpl

internal class FraudDetectServiceImpl(consumerFactory: KafkaConsumerFactory<String>) : FraudDetectService,
    BaseConsumerServiceImpl(consumerFactory.build("ECOMMERCE_NEW_ORDER", FraudDetectService::class.java))