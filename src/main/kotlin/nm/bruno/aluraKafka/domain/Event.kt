package nm.bruno.aluraKafka.domain

data class Event<T>(
    val data: T
)