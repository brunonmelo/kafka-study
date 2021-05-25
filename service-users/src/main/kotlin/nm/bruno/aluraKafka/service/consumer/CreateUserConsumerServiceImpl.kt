package nm.bruno.aluraKafka.service.consumer

import nm.bruno.aluraKafka.domain.Order
import nm.bruno.aluraKafka.factory.consumer.KafkaConsumerFactory

class CreateUserConsumerServiceImpl(consumerFactory: KafkaConsumerFactory<Order>) :
    CreateUserConsumerService,
    BaseConsumerServiceImpl<Order>(
        consumerFactory.build(
            "ECOMMERCE_NEW_ORDER",
            CreateUserConsumerService::class.java,
            Order::class.java
        )
    )