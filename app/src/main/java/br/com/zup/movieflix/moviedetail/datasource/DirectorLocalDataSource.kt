package br.com.zup.movieflix.moviedetail.datasource

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.os.Parcelable
import android.provider.Contacts.SettingsColumns.KEY
import br.com.zup.movieflix.*
import br.com.zup.movieflix.moviedetail.model.DirectorModel


class DirectorLocalDataSource(private val application: Application) {
    private val pref: SharedPreferences =
        application.getSharedPreferences(CHAVE_PREFERENCIA, Context.MODE_PRIVATE)
    private val prefEditor = pref.edit()

    val directorList = mutableListOf<DirectorModel>(
        DirectorModel(
            TARANTINO,
            TARANTINO_INFO
        ),
        DirectorModel(
            MARTIN_SCORSESE,
            MARTIN_SCORSESE_INFO
        )
    )

    fun savedMovieFavorited(movieName: String, checked: Boolean) {
        prefEditor.putBoolean(movieName, checked)
        prefEditor.apply()
    }

    fun getMovieFavorited(movieName: String) : Boolean {
        return pref.getBoolean(movieName, false)
    }

}