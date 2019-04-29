package me.tigrao.persistence

import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider

val persistenceModule = Kodein.Module("persistenceModule") {

    bind<MovieDatabaseFacade>() with provider {
        MovieDatabaseFacade(instance())
    }
}
