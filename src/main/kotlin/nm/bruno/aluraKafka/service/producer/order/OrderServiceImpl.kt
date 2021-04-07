package nm.bruno.aluraKafka.service.producer.order

import nm.bruno.aluraKafka.factory.producer.KafkaProducerFactory
import nm.bruno.aluraKafka.service.producer.BaseProducerServiceImpl

class OrderServiceImpl(kafkaProducerFactory: KafkaProducerFactory<String>) : OrderService,
    BaseProducerServiceImpl(kafkaProducerFactory.build("ECOMMERCE_NEW_ORDER"))