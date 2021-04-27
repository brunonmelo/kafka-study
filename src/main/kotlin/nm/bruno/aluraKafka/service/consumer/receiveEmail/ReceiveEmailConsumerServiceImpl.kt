package nm.bruno.aluraKafka.service.consumer.receiveEmail

import nm.bruno.aluraKafka.domain.events.Email
import nm.bruno.aluraKafka.factory.consumer.KafkaConsumerFactory
import nm.bruno.aluraKafka.service.consumer.BaseConsumerServiceImpl

internal class ReceiveEmailConsumerServiceImpl(consumerFactory: KafkaConsumerFactory<Email>) : ReceiveEmailConsumerService,
    BaseConsumerServiceImpl<Email>(consumerFactory.build("ECOMMERCE_SEND_EMAIL", ReceiveEmailConsumerService::class.java))