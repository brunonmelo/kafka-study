package nm.bruno.aluraKafka.app

import nm.bruno.aluraKafka.factory.consumer.KafkaConsumerFactoryImpl
import nm.bruno.aluraKafka.factory.producer.KafkaProducerFactoryImpl
import nm.bruno.aluraKafka.service.consumer.FraudDetectConsumerService
import nm.bruno.aluraKafka.service.consumer.FraudDetectConsumerServiceImpl
import nm.bruno.aluraKafka.service.fraudCheck.FraudService
import nm.bruno.aluraKafka.service.fraudCheck.FraudServiceImpl
import nm.bruno.aluraKafka.service.producer.OrderServiceImpl

private val fraudDetectConsumerService: FraudDetectConsumerService by lazy {
    FraudDetectConsumerServiceImpl(KafkaConsumerFactoryImpl())
}

private val fraudCheck: FraudService by lazy {
    FraudServiceImpl(OrderServiceImpl(KafkaProducerFactoryImpl()))
}

fun main() {
    fraudDetectConsumerService.start {
        fraudCheck.processFraudVerification(it)
    }
}
