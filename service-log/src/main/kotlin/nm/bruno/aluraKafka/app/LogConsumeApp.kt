package nm.bruno.aluraKafka.app

import nm.bruno.aluraKafka.factory.consumer.KafkaConsumerFactoryImpl
import nm.bruno.aluraKafka.service.LogConsumerService
import nm.bruno.aluraKafka.service.LogConsumerServiceImpl
import nm.bruno.aluraKafka.utils.defaultReceiveMessageCallback

private val logConsumerService: LogConsumerService by lazy { LogConsumerServiceImpl(KafkaConsumerFactoryImpl()) }

fun main() {
    logConsumerService.start { defaultReceiveMessageCallback(it, 500) }
}
