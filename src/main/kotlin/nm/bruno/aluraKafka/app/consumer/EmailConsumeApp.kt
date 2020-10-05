package nm.bruno.aluraKafka.app.consumer

import nm.bruno.aluraKafka.factory.consumer.KafkaConsumerFactoryImpl
import nm.bruno.aluraKafka.service.consumer.logs.LogService
import nm.bruno.aluraKafka.service.consumer.logs.LogServiceImpl
import nm.bruno.aluraKafka.service.consumer.receiveEmail.ReceiveEmailService
import nm.bruno.aluraKafka.service.consumer.receiveEmail.ReceiveEmailServiceImpl
import nm.bruno.aluraKafka.utils.defaultReceiveMessageCallback

fun main() {
    val fraudDetectService: ReceiveEmailService = ReceiveEmailServiceImpl(KafkaConsumerFactoryImpl())
    fraudDetectService.start { defaultReceiveMessageCallback(it) }
}
