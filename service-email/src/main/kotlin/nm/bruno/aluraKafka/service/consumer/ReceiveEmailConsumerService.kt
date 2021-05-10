package nm.bruno.aluraKafka.service.consumer

import nm.bruno.aluraKafka.domain.events.Email

interface ReceiveEmailConsumerService : BaseConsumerService<Email>