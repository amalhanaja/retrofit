package retrofit2.kotlin

import retrofit2.Retrofit

fun retrofit(init: RetrofitKotlinBuilder.() -> Unit) =
        RetrofitKotlinBuilder().apply(init).run {
            Retrofit.Builder().apply {
                baseUrl?.let { baseUrl(it) } ?: throw IllegalArgumentException("baseUrl == null")
                client(client)
                callbackExecutor?.let { callbackExecutor(it) }
                converterFactories().addAll(converterFactories)
                callAdapterFactories().addAll(callAdapterFactories)
                validateEagerly?.let { validateEagerly(it) }
            }.build()
}

inline fun <reified T> Retrofit.create() =
    create(T::class.java)