package nm.bruno.aluraKafka.utils

import org.apache.kafka.clients.consumer.ConsumerRecords

fun defaultReceiveMessageCallback(records: ConsumerRecords<String, String>) {
    if (!records.isEmpty) {
        println("---------------------------------------")
        println("Encontrei ${records.count()} registros")
        records.forEach {
            println("Registros encontrados no tópico: ${it.topic()}")
            println("Chave: ${it.key()}")
            println("Valor: ${it.value()}")
            println("offset: ${it.offset()}")
            println("Partition: ${it.partition()}")
        }
    }
}