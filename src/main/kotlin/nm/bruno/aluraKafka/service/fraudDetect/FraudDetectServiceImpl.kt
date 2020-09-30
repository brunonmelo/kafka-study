package nm.bruno.aluraKafka.service.fraudDetect

import nm.bruno.aluraKafka.factory.consumer.KafkaConsumerFactory

internal class FraudDetectServiceImpl(consumerFactory: KafkaConsumerFactory<String>) : FraudDetectService {

    private var switch = false
    private val consumer = consumerFactory.build("ECOMMERCE_NEW_ORDER")

    override fun start() {
        switch = true
        while (switch) {
            pool()
        }
    }

    override fun stop() {
        switch = false
    }

    private fun pool() {
        consumer.poll { records ->
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
    }
}
