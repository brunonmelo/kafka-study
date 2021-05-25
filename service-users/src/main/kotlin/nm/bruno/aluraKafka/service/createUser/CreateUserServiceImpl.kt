package nm.bruno.aluraKafka.service.createUser

import nm.bruno.aluraKafka.domain.Order
import nm.bruno.aluraKafka.domain.User
import nm.bruno.aluraKafka.repository.db.DataBaseRepository
import org.apache.kafka.clients.consumer.ConsumerRecords

class CreateUserServiceImpl(private val dataBaseRepository: DataBaseRepository):CreateUserService {

    override fun checkAndCreateUsers(records: ConsumerRecords<String, Order>) {
        if (!records.isEmpty) {
            records.forEach {
                val order = it.value()
                // TODO refatorar estrutura do Order para trabalhar com o email do usuário
//                trySaveAndReturnUser(order.email)
            }
        }
    }

    private fun trySaveAndReturnUser(email: String): User {
        if (isNewUser(email)) {
            dataBaseRepository.insertNewUser(email)
        }
        return getUser(email)
    }

    private fun isNewUser(email: String): Boolean {
        return dataBaseRepository.isNewUser(email)
    }

    private fun getUser(email: String): User {
        return dataBaseRepository.getUser(email)
    }
}