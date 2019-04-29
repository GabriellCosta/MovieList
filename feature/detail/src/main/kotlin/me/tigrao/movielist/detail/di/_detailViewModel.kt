package me.tigrao.movielist.detail.di

import me.tigrao.movielist.detail.viewmodel.DetailViewModel
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider

val detailViewModel = Kodein.Module("detailViewModel") {

    bind() from provider {
        DetailViewModel(instance())
    }
}
