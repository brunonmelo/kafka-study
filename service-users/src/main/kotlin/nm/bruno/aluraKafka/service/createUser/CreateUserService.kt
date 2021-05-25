package nm.bruno.aluraKafka.service.createUser

import nm.bruno.aluraKafka.domain.Order
import org.apache.kafka.clients.consumer.ConsumerRecords

interface CreateUserService {

    fun checkAndCreateUsers(email: ConsumerRecords<String, Order>)
}