package nm.bruno.aluraKafka.utils

import org.apache.kafka.clients.producer.RecordMetadata

fun defaultSendMessageCallback(metadata: RecordMetadata?) {
    metadata?.let {
        val msg =
            "${it.topic()} \n::: partition: ${it.partition()}\n::: offset: ${it.offset()}\n::: timestamp: ${it.timestamp()}"
        println(msg)
    }
}
