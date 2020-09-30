package nm.bruno.aluraKafka.service.order

import nm.bruno.aluraKafka.factory.producer.KafkaProducerFactory

class OrderServiceImpl(kafkaProducerFactory: KafkaProducerFactory<String>) : OrderService {

    private val producer = kafkaProducerFactory.build("ECOMMERCE_NEW_ORDER")

    override fun sendOrder(order: String) {
        producer.send(order) { metadata ->
            metadata?.let {
                val msg =
                    "${it.topic()} \n::: partition: ${it.partition()}\n::: offset: ${it.offset()}\n::: timestamp: ${it.timestamp()}"
                println(msg)
            }
        }
    }
}