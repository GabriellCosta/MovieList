package me.tigrao.movielist

import android.app.Application
import me.tigrao.aegis.commons.di.commonsModule
import me.tigrao.movielist.di.movieListModule
import me.tigrao.persistence.persistenceModule
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware

internal class CustomApplication : Application(), KodeinAware {

    override val kodein: Kodein = Kodein {

        import(movieListModule)
        import(commonsModule)
        import(persistenceModule)
    }
}
