package nm.bruno.aluraKafka.app.consumer

import nm.bruno.aluraKafka.factory.consumer.KafkaConsumerFactoryImpl
import nm.bruno.aluraKafka.service.consumer.logs.LogConsumerService
import nm.bruno.aluraKafka.service.consumer.logs.LogConsumerServiceImpl
import nm.bruno.aluraKafka.utils.defaultReceiveMessageCallback

private val logConsumerService: LogConsumerService by lazy { LogConsumerServiceImpl(KafkaConsumerFactoryImpl()) }

fun main() {
    logConsumerService.start { defaultReceiveMessageCallback(it, 500) }
}
