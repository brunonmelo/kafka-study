package nm.bruno.aluraKafka.service.producer

import nm.bruno.aluraKafka.domain.events.Order

interface OrderService : BaseProducerService<Order>