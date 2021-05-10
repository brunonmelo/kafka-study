package nm.bruno.aluraKafka.app

import nm.bruno.aluraKafka.factory.consumer.KafkaConsumerFactoryImpl
import nm.bruno.aluraKafka.service.consumer.ReceiveEmailConsumerService
import nm.bruno.aluraKafka.service.consumer.ReceiveEmailConsumerServiceImpl
import nm.bruno.aluraKafka.utils.defaultReceiveMessageCallback

private val receiveEmailConsumerService: ReceiveEmailConsumerService by lazy {
    ReceiveEmailConsumerServiceImpl(KafkaConsumerFactoryImpl())
}

fun main() {
    receiveEmailConsumerService.start { defaultReceiveMessageCallback(it, 1000) }
}
