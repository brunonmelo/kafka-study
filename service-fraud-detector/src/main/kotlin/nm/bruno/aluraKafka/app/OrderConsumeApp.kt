package nm.bruno.aluraKafka.app

import nm.bruno.aluraKafka.factory.consumer.KafkaConsumerFactoryImpl
import nm.bruno.aluraKafka.service.consumer.FraudDetectConsumerService
import nm.bruno.aluraKafka.service.consumer.FraudDetectConsumerServiceImpl
import nm.bruno.aluraKafka.utils.defaultReceiveMessageCallback

private val fraudDetectConsumerService: FraudDetectConsumerService by lazy {
    FraudDetectConsumerServiceImpl(KafkaConsumerFactoryImpl())
}

fun main() {
    fraudDetectConsumerService.start { defaultReceiveMessageCallback(it, 2000) }
}
