package com.islas.marvelsapi.presentation.stateholders

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.islas.marvelsapi.core.util.ResultAPI
import com.islas.marvelsapi.data.remote.models.v2.MarvelResult
import com.islas.marvelsapi.data.remote.models.v2.ResultComics
import com.islas.marvelsapi.data.remote.models.v2.ResultSeries
import com.islas.marvelsapi.domain.repository.IMarvelRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MasterViewModel(private val marvelRepository: IMarvelRepository) : ViewModel() {

    private val _characters = mutableStateListOf<MarvelResult>()
    private val _comics = mutableStateListOf<ResultComics>()
    private val _series = mutableStateListOf<ResultSeries>()
    private var _idComic = MutableLiveData(-1)
    private var _idCharacter = MutableLiveData(-1)
    private var _idSeries =  MutableLiveData(-1)
    lateinit var singleComic: ResultComics
    lateinit var singleCharacter: MarvelResult
    lateinit var singleSeries: ResultSeries

    val characters: SnapshotStateList<MarvelResult>
        get() = _characters

    val comics: SnapshotStateList<ResultComics>
        get() = _comics

    val series: SnapshotStateList<ResultSeries>
        get() = _series

    fun setIdCharacter(idItemCharacter: Int) {
        _idCharacter.value = idItemCharacter
    }

    fun setIdComic(idItemComic: Int) {
        _idComic.value = idItemComic
    }

    fun setIdSeries(idItemSeries: Int) {
        _idSeries.value = idItemSeries
    }

    private fun setMarvelResult(marvelResult: MarvelResult) {
        singleCharacter = marvelResult
    }

    private fun setComicResult(comics: ResultComics) {
        singleComic = comics
    }

    private fun setSeriesResult(series: ResultSeries) {
        singleSeries = series
    }

    fun getIdCharacter(): Int {
        return _idCharacter.value ?: -1
    }

    fun getIdComic(): Int {
        return _idComic.value ?: -1
    }

    fun getIdSeries(): Int{
        return _idSeries.value ?: -1
    }

    fun findCharacter(idCharacterItem: Int) {
        for (character in _characters) {
            if (character.id == idCharacterItem) {
                setMarvelResult(character)
            }
        }
    }

    fun findComic(idComicItem: Int) {
        for (comic in _comics){
            if (comic.id == idComicItem){
                setComicResult(comic)
            }
        }
    }

    fun findSeries(idSeriesItem: Int) {
        for (series in _series){
            if (series.id == idSeriesItem){
                setSeriesResult(series)
            }
        }
    }

    fun getCharacterList() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result =
                marvelRepository.getCharacters(offset = 340, limit = 25, orderBy = "name")
            ) {
                is ResultAPI.Success -> {
                    _characters.clear()
                    _characters.addAll(result.data.data.results)
                }

                is ResultAPI.Error -> {
                    Log.e("MainViewModel", "getCharacterList failed")
                }
            }
        }
    }

    fun getComicsList(){
        viewModelScope.launch(Dispatchers.IO) {
            when(val resultComic =
                marvelRepository.getComics(offset = 0, limit = 25, orderBy = "onsaleDate")
            ){
                is ResultAPI.Success -> {
                    _comics.clear()
                    _comics.addAll(resultComic.data.data.results)
                }
                is ResultAPI.Error -> {
                    Log.e("MainViewModel", "getComicsLis failed")
                }
            }
        }
    }
}
