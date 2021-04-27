package nm.bruno.aluraKafka.service.consumer.receiveEmail

import nm.bruno.aluraKafka.domain.events.Email
import nm.bruno.aluraKafka.service.consumer.BaseConsumerService

interface ReceiveEmailConsumerService : BaseConsumerService<Email>