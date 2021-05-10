package nm.bruno.aluraKafka.service.producer

import nm.bruno.aluraKafka.domain.events.Order
import nm.bruno.aluraKafka.factory.producer.KafkaProducerFactory

class OrderServiceImpl(kafkaProducerFactory: KafkaProducerFactory<Order>) : OrderService,
    BaseProducerServiceImpl<Order>(kafkaProducerFactory.build("ECOMMERCE_NEW_ORDER"))