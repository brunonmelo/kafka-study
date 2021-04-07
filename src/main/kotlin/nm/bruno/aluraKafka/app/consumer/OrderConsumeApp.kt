package nm.bruno.aluraKafka.app.consumer

import nm.bruno.aluraKafka.factory.consumer.KafkaConsumerFactoryImpl
import nm.bruno.aluraKafka.service.consumer.fraudDetect.FraudDetectConsumerService
import nm.bruno.aluraKafka.service.consumer.fraudDetect.FraudDetectConsumerServiceImpl
import nm.bruno.aluraKafka.utils.defaultReceiveMessageCallback

private val fraudDetectConsumerService: FraudDetectConsumerService by lazy {
    FraudDetectConsumerServiceImpl(KafkaConsumerFactoryImpl())
}

fun main() {
    fraudDetectConsumerService.start { defaultReceiveMessageCallback(it, 2000) }
}
