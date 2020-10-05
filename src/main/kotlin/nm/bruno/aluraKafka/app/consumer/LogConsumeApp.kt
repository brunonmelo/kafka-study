package nm.bruno.aluraKafka.app.consumer

import nm.bruno.aluraKafka.factory.consumer.KafkaConsumerFactoryImpl
import nm.bruno.aluraKafka.service.consumer.logs.LogService
import nm.bruno.aluraKafka.service.consumer.logs.LogServiceImpl
import nm.bruno.aluraKafka.utils.defaultReceiveMessageCallback

fun main() {
    val logService: LogService = LogServiceImpl(KafkaConsumerFactoryImpl())
    logService.start { defaultReceiveMessageCallback(it) }
}
