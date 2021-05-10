package nm.bruno.aluraKafka.domain

data class Email(
    val orderId: String,
    val userId: String,
    val message: String
)