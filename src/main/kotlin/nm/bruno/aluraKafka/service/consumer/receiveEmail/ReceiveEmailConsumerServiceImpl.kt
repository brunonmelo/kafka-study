package nm.bruno.aluraKafka.service.consumer.receiveEmail

import nm.bruno.aluraKafka.factory.consumer.KafkaConsumerFactory
import nm.bruno.aluraKafka.service.consumer.BaseConsumerServiceImpl

internal class ReceiveEmailConsumerServiceImpl(consumerFactory: KafkaConsumerFactory<String>) : ReceiveEmailConsumerService,
    BaseConsumerServiceImpl(consumerFactory.build("ECOMMERCE_SEND_EMAIL", ReceiveEmailConsumerService::class.java))