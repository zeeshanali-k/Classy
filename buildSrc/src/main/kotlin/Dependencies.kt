object Versions {
    const val koin = "3.5.3"
    const val koinCompose = "1.1.2"
    const val moko = "0.16.1"

    const val voyager = "1.0.0"
    const val typistCmp = "1.1.5"
    const val calf = "0.3.0"
    const val sqlDelight = "2.0.0"
    const val ktorClient = "2.3.3"
    const val kotlinxSerialisationJson = "1.6.0"
}

object Deps {

    object Koin {
        const val core = "io.insert-koin:koin-core:${Versions.koin}"
        const val compose = "io.insert-koin:koin-compose:${Versions.koinCompose}"
        const val test = "io.insert-koin:koin-test:${Versions.koin}"
        const val android = "io.insert-koin:koin-android:${Versions.koin}"
    }

    object Moko{
        const val mvvmCore = "dev.icerock.moko:mvvm-core:${Versions.moko}"
        const val mvvmCompose = "dev.icerock.moko:mvvm-compose:${Versions.moko}"
        const val mvvmFlowCompose = "dev.icerock.moko:mvvm-flow-compose:${Versions.moko}"
    }
    object Voyager{
        const val navigator = "cafe.adriel.voyager:voyager-navigator:${Versions.voyager}"
    }

    object Calf{
        const val ui = "com.mohamedrejeb.calf:calf-ui:${Versions.calf}"
    }

    object SQLDelight{
        const val nativeDriver = "app.cash.sqldelight:native-driver:${Versions.sqlDelight}"
        const val androidDriver = "app.cash.sqldelight:android-driver:${Versions.sqlDelight}"
        const val jvmDriver = "app.cash.sqldelight:sqlite-driver:${Versions.sqlDelight}"
    }

    object KtorClient{
        const val core = "io.ktor:ktor-client-core:${Versions.ktorClient}"
        const val contentNegotiation = "io.ktor:ktor-client-content-negotiation:${Versions.ktorClient}"
        const val serializationKotlinxJson = "io.ktor:ktor-serialization-kotlinx-json:${Versions.ktorClient}"

        const val android = "io.ktor:ktor-client-android:${Versions.ktorClient}"
        const val native = "io.ktor:ktor-client-darwin:${Versions.ktorClient}"
        const val jvm = "io.ktor:ktor-client-apache5:${Versions.ktorClient}"
        const val web = "io.ktor:ktor-client-js:${Versions.ktorClient}"
    }
    const val TYPIST_CMP="tech.dev-scion:typist-cmp:${Versions.typistCmp}"
    const val KOTLINX_SERIALISATION_JSON="org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinxSerialisationJson}"

}