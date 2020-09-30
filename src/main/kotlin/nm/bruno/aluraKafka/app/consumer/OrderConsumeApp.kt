package nm.bruno.aluraKafka.app.consumer

import nm.bruno.aluraKafka.factory.consumer.KafkaConsumerFactoryImpl
import nm.bruno.aluraKafka.service.fraudDetect.FraudDetectService
import nm.bruno.aluraKafka.service.fraudDetect.FraudDetectServiceImpl

fun main() {
    val fraudDetectService: FraudDetectService = FraudDetectServiceImpl(KafkaConsumerFactoryImpl())
    fraudDetectService.start()
}
