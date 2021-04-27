package nm.bruno.aluraKafka.domain.events

data class Email(
    val orderId: String,
    val userId: String,
    val message: String
)