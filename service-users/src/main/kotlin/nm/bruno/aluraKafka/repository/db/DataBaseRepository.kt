package nm.bruno.aluraKafka.repository.db

import nm.bruno.aluraKafka.domain.User

interface DataBaseRepository {
    fun isNewUser(email: String): Boolean
    fun getUser(email: String): User
    fun insertNewUser(email: String): User
}