package nm.bruno.aluraKafka.factory.consumer

import com.google.gson.GsonBuilder
import org.apache.kafka.common.serialization.Deserializer
import java.nio.charset.StandardCharsets

@Suppress("UNCHECKED_CAST")
class GsonDeserializer<T> : Deserializer<T> {

    private lateinit var type: Class<T>

    override fun configure(configs: MutableMap<String, *>, isKey: Boolean) {
        val typeName = configs[TYPE_CONFIG].toString()
        type = Class.forName(typeName) as Class<T>
    }

    override fun deserialize(p0: String?, value: ByteArray): T {
        val gson = GsonBuilder().create()

        val valueString = String(value, StandardCharsets.UTF_8)
        return gson.fromJson(valueString, type)
    }

    companion object {
        const val TYPE_CONFIG = "TYPE_CONFIG"
    }
}