package nm.bruno.aluraKafka.domain.events

import java.math.BigDecimal

data class Order(
    val orderId: String,
    val userId: String,
    val value: BigDecimal
)