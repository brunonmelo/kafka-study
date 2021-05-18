package nm.bruno.aluraKafka.service.fraudCheck

import nm.bruno.aluraKafka.domain.Order
import nm.bruno.aluraKafka.service.producer.OrderService
import nm.bruno.aluraKafka.utils.defaultSendMessageCallback
import org.apache.kafka.clients.consumer.ConsumerRecords
import java.math.BigDecimal

class FraudServiceImpl(private val orderService: OrderService) : FraudService {

    override fun processFraudVerification(records: ConsumerRecords<String, Order>) {
        if (!records.isEmpty) {
            println("---------------------------------------")
            println("Encontrei ${records.count()} registros")
            records.forEach {
                val order: Order = it.value()

                println("Registros encontrados no tópico: ${it.topic()}")
                println("Chave: ${it.key()}")
                println("offset: ${it.offset()}")
                println("Partition: ${it.partition()}")


                if (order.value >= BigDecimal("4500")) {
                    println("Status: Order é uma fraude")
                    orderService.sendDeniedMessage(order) { record -> defaultSendMessageCallback(record) }
                } else {
                    println("Status: Aprovado")
                    orderService.sendApprovedMessage(order) { record -> defaultSendMessageCallback(record) }
                }
                println("Valor: $order")


                Thread.sleep(2000)
                println("Finished processing")

            }
        }
    }
}