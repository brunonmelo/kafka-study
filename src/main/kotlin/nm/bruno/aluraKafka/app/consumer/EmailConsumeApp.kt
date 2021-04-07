package nm.bruno.aluraKafka.app.consumer

import nm.bruno.aluraKafka.factory.consumer.KafkaConsumerFactoryImpl
import nm.bruno.aluraKafka.service.consumer.receiveEmail.ReceiveEmailConsumerService
import nm.bruno.aluraKafka.service.consumer.receiveEmail.ReceiveEmailConsumerServiceImpl
import nm.bruno.aluraKafka.utils.defaultReceiveMessageCallback

private val receiveEmailConsumerService: ReceiveEmailConsumerService by lazy {
    ReceiveEmailConsumerServiceImpl(KafkaConsumerFactoryImpl())
}

fun main() {
    receiveEmailConsumerService.start { defaultReceiveMessageCallback(it, 1000) }
}
