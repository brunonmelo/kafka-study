package nm.bruno.aluraKafka.app

import nm.bruno.aluraKafka.factory.consumer.KafkaConsumerFactoryImpl
import nm.bruno.aluraKafka.repository.db.DataBaseRepositoryImpl
import nm.bruno.aluraKafka.service.consumer.CreateUserConsumerService
import nm.bruno.aluraKafka.service.consumer.CreateUserConsumerServiceImpl
import nm.bruno.aluraKafka.service.createUser.CreateUserService
import nm.bruno.aluraKafka.service.createUser.CreateUserServiceImpl
import nm.bruno.aluraKafka.utils.defaultReceiveMessageCallback

private val CREATE_USER_CONSUMER_SERVICE: CreateUserConsumerService by lazy {
    CreateUserConsumerServiceImpl(KafkaConsumerFactoryImpl())
}

private val createUserService: CreateUserService by lazy {
    CreateUserServiceImpl(DataBaseRepositoryImpl())
}

fun main() {
    CREATE_USER_CONSUMER_SERVICE.start {
        defaultReceiveMessageCallback(it)
        createUserService.checkAndCreateUsers(it)
    }
}
