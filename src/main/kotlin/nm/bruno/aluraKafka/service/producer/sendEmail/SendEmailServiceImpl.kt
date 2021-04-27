package nm.bruno.aluraKafka.service.producer.sendEmail

import nm.bruno.aluraKafka.domain.events.Email
import nm.bruno.aluraKafka.factory.producer.KafkaProducerFactory
import nm.bruno.aluraKafka.service.producer.BaseProducerServiceImpl

class SendEmailServiceImpl(kafkaProducerFactory: KafkaProducerFactory<Email>) : SendEmailService,
    BaseProducerServiceImpl<Email>(kafkaProducerFactory.build("ECOMMERCE_SEND_EMAIL"))