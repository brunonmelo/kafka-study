package nm.bruno.aluraKafka.service.order

interface OrderService {

    fun sendOrder(order: String)
}