package nm.bruno.aluraKafka.service.producer

import nm.bruno.aluraKafka.domain.Email
import nm.bruno.aluraKafka.factory.producer.KafkaProducerFactory

class SendEmailServiceImpl(kafkaProducerFactory: KafkaProducerFactory<Email>) : SendEmailService,
    BaseProducerServiceImpl<Email>(kafkaProducerFactory.build("ECOMMERCE_SEND_EMAIL"))