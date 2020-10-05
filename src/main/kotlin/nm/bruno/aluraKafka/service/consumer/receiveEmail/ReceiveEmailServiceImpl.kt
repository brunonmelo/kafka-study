package nm.bruno.aluraKafka.service.consumer.receiveEmail

import nm.bruno.aluraKafka.factory.consumer.KafkaConsumerFactory
import nm.bruno.aluraKafka.service.consumer.BaseConsumerServiceImpl
import nm.bruno.aluraKafka.service.consumer.logs.LogService
import org.apache.kafka.clients.consumer.ConsumerRecords

internal class ReceiveEmailServiceImpl(consumerFactory: KafkaConsumerFactory<String>) : ReceiveEmailService,
    BaseConsumerServiceImpl(consumerFactory.build("ECOMMERCE_SEND_EMAIL", ReceiveEmailService::class.java))