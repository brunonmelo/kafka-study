package nm.bruno.aluraKafka.service.consumer.fraudDetect

import nm.bruno.aluraKafka.domain.events.Order
import nm.bruno.aluraKafka.service.consumer.BaseConsumerService

interface FraudDetectConsumerService: BaseConsumerService<Order>
