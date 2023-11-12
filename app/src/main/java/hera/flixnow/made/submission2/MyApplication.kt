package hera.flixnow.made.submission2

import android.app.Application
import hera.flixnow.made.submission2.di.AppComponent
import hera.flixnow.made.submission2.di.DaggerAppComponent
import hera.flixnow.made.core.di.CoreComponent
import hera.flixnow.made.core.di.DaggerCoreComponent

open class MyApplication : Application() {

  private val coreComponent: CoreComponent by lazy {
    DaggerCoreComponent.factory().create(applicationContext)
  }

  val appComponent: AppComponent by lazy {
    DaggerAppComponent.factory().create(coreComponent)
  }
}