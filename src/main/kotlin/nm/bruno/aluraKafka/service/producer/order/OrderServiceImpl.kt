package nm.bruno.aluraKafka.service.producer.order

import nm.bruno.aluraKafka.domain.events.Order
import nm.bruno.aluraKafka.factory.producer.KafkaProducerFactory
import nm.bruno.aluraKafka.service.producer.BaseProducerServiceImpl

class OrderServiceImpl(kafkaProducerFactory: KafkaProducerFactory<Order>) : OrderService,
    BaseProducerServiceImpl<Order>(kafkaProducerFactory.build("ECOMMERCE_NEW_ORDER"))