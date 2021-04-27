package nm.bruno.aluraKafka.service.producer.sendEmail

import nm.bruno.aluraKafka.domain.events.Email
import nm.bruno.aluraKafka.service.producer.BaseProducerService

interface SendEmailService : BaseProducerService<Email>