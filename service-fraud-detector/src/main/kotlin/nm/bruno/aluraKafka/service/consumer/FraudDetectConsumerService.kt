package nm.bruno.aluraKafka.service.consumer

import nm.bruno.aluraKafka.domain.events.Order

interface FraudDetectConsumerService: BaseConsumerService<Order>
