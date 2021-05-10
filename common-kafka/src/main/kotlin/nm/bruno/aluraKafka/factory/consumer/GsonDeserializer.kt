package nm.bruno.aluraKafka.factory.consumer

import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import nm.bruno.aluraKafka.domain.Event
import org.apache.kafka.common.serialization.Deserializer
import java.nio.charset.StandardCharsets


class GsonDeserializer<T> : Deserializer<Event<T>> {
    override fun deserialize(p0: String?, value: ByteArray): Event<T> {
        val gson = GsonBuilder().create()

        val type = object : TypeToken<Event<T>>() { }.type

        val valueString = String(value, StandardCharsets.UTF_8)
        return gson.fromJson(valueString, type)
    }
}