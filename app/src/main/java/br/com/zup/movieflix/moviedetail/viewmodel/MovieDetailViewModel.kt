package br.com.zup.movieflix.moviedetail.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.zup.movieflix.home.model.Movie
import br.com.zup.movieflix.moviedetail.datasource.DirectorLocalDataSource
import br.com.zup.movieflix.moviedetail.model.MovieWithDirectorModel
import br.com.zup.movieflix.moviedetail.repository.MovieDetailRepository

class MovieDetailViewModel(application: Application) : AndroidViewModel(application) {
    private val repository  = MovieDetailRepository(DirectorLocalDataSource(application))
    private var _response : MutableLiveData<MovieWithDirectorModel> = MutableLiveData()
    val response : LiveData<MovieWithDirectorModel> = _response

    fun getMovieWithDirector(movie: Movie){
        try {
            _response.value = repository.getMovieWithDirector(movie)
        }catch (e:Exception){
            Log.e("Erro", e.message.toString())
        }
    }

    fun savedMovieFavorited(movieName: String, isChecked: Boolean){
        repository.savedMovieFavorited(movieName, isChecked)
    }

    fun getMovieFavorited(movieName: String) : Boolean {
        return repository.getMovieFavorited(movieName)
    }
}