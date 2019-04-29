package me.tigrao.movielist

import android.app.Application
import android.content.Context
import me.tigrao.aegis.commons.di.commonsModule
import me.tigrao.movielist.detail.di.detailViewModel
import me.tigrao.movielist.di.movieListModule
import me.tigrao.persistence.persistenceModule
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.provider

internal class CustomApplication : Application(), KodeinAware {

    override val kodein: Kodein = Kodein {

        import(movieListModule)
        import(commonsModule)
        import(persistenceModule)
        import(detailViewModel)

        bind<Context>() with provider {
            applicationContext
        }
    }
}
