package nm.bruno.aluraKafka.service.producer

import nm.bruno.aluraKafka.domain.events.Email

interface SendEmailService : BaseProducerService<Email>