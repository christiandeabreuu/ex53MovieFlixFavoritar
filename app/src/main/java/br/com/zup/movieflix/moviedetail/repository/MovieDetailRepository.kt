package br.com.zup.movieflix.moviedetail.repository

import br.com.zup.movieflix.home.model.Movie
import br.com.zup.movieflix.moviedetail.datasource.DirectorLocalDataSource
import br.com.zup.movieflix.moviedetail.model.DirectorModel
import br.com.zup.movieflix.moviedetail.model.MovieWithDirectorModel

class MovieDetailRepository (val dataSource: DirectorLocalDataSource) {

    fun getMovieWithDirector(movie: Movie) : MovieWithDirectorModel{
        val listaDeDiretores = dataSource.directorList
        var diretor = DirectorModel("","")
        listaDeDiretores.forEach {
            if(it.name == movie.director){
                diretor = it
            }
        }
        return MovieWithDirectorModel(diretor,movie)
    }

    fun savedMovieFavorited(movieName: String, isChecked: Boolean){
        dataSource.savedMovieFavorited(movieName, isChecked)
    }

    fun getMovieFavorited(movieName: String) : Boolean {
        return dataSource.getMovieFavorited(movieName)
    }
}