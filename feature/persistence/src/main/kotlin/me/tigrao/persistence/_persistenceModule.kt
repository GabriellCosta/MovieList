package me.tigrao.persistence

import android.app.Activity
import org.kodein.di.Kodein
import org.kodein.di.android.AndroidComponentsWeakScope
import org.kodein.di.generic.bind
import org.kodein.di.generic.scoped
import org.kodein.di.generic.singleton

val persistenceModule = Kodein.Module("persistenceModule") {

    bind<MovieDatabaseFacade>() with scoped(AndroidComponentsWeakScope<Activity>()).singleton {
        MovieDatabaseFacade(context)
    }
}
