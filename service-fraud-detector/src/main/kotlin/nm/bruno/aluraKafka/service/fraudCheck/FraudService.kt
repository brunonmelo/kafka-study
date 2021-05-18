package nm.bruno.aluraKafka.service.fraudCheck

import nm.bruno.aluraKafka.domain.Order
import org.apache.kafka.clients.consumer.ConsumerRecords

interface FraudService {
    fun processFraudVerification(records: ConsumerRecords<String, Order>)
}