package me.tigrao.aegis.commons.di

import androidx.lifecycle.ViewModelProvider
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton

val commonsModule = Kodein.Module("commonsModule") {

    bind<ViewModelProvider.Factory>() with singleton {
        ViewModelFactory(kodein)
    }
}
