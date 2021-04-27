package nm.bruno.aluraKafka.factory.producer

import com.google.gson.GsonBuilder
import org.apache.kafka.common.serialization.Serializer

class GsonSerializable<T> : Serializer<T> {
    override fun serialize(s: String?, value: T): ByteArray {
        val gsonBuilder = GsonBuilder().create()
        return gsonBuilder.toJson(value).toByteArray()
    }
}