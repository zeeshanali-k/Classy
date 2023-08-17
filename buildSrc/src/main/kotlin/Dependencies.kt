object Versions {
    const val koin = "3.4.3"
    const val koinCompose = "1.0.4"
    const val moko = "0.16.1"

    const val voyagerVersion = "1.0.0-rc06"
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
        const val navigator = "cafe.adriel.voyager:voyager-navigator:${Versions.voyagerVersion}"
    }
}