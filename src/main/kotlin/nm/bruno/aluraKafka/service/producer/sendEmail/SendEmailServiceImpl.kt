package nm.bruno.aluraKafka.service.producer.sendEmail

import nm.bruno.aluraKafka.factory.producer.KafkaProducerFactory
import nm.bruno.aluraKafka.service.producer.BaseProducerService
import nm.bruno.aluraKafka.service.producer.BaseProducerServiceImpl
import org.apache.kafka.clients.producer.RecordMetadata

class SendEmailServiceImpl(kafkaProducerFactory: KafkaProducerFactory<String>) : SendEmailService,
    BaseProducerServiceImpl(kafkaProducerFactory.build("ECOMMERCE_SEND_EMAIL"))