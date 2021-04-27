package nm.bruno.aluraKafka.utils

import nm.bruno.aluraKafka.domain.Event
import org.apache.kafka.clients.consumer.ConsumerRecords

fun <T>defaultReceiveMessageCallback(records: ConsumerRecords<String, Event<T>>, sleep: Long? = null) {
    if (!records.isEmpty) {
        println("---------------------------------------")
        println("Encontrei ${records.count()} registros")
        records.forEach {
            println("Registros encontrados no tópico: ${it.topic()}")
            println("Chave: ${it.key()}")
            println("Valor: ${it.value().data}")
            println("offset: ${it.offset()}")
            println("Partition: ${it.partition()}")

            sleep?.let { sleepTime ->
                Thread.sleep(sleepTime)
                println("Finished processing")
            }
        }
    }
}
