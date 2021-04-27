package nm.bruno.aluraKafka.service.producer.order

import nm.bruno.aluraKafka.domain.events.Order
import nm.bruno.aluraKafka.service.producer.BaseProducerService

interface OrderService : BaseProducerService<Order>