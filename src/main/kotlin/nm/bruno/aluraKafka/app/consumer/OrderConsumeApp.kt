package nm.bruno.aluraKafka.app.consumer

import nm.bruno.aluraKafka.factory.consumer.KafkaConsumerFactoryImpl
import nm.bruno.aluraKafka.service.consumer.fraudDetect.FraudDetectService
import nm.bruno.aluraKafka.service.consumer.fraudDetect.FraudDetectServiceImpl
import nm.bruno.aluraKafka.utils.defaultReceiveMessageCallback

fun main() {
    val fraudDetectService: FraudDetectService = FraudDetectServiceImpl(KafkaConsumerFactoryImpl())
    fraudDetectService.start { defaultReceiveMessageCallback(it) }
}
