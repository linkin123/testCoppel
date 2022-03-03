package com.tp.testcoppel.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.tp.testcoppel.core.Resource
import com.tp.testcoppel.repository.CharactersRepository
import kotlinx.coroutines.Dispatchers

class CharactersViewModel(private val repo: CharactersRepository) : ViewModel() {

    fun fetchCharacters() = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(repo.getCharacters()))
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }

    fun fetchCharacterDetailById(id: Int) = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(
                Resource.Success(
                    NTuple4(
                        repo.getComicsByCharacter(id),
                        repo.getEventsByCharacter(id),
                        repo.getSeriesByCharacter(id),
                        repo.getStoriesByCharacter(id)
                    )
                )
            )
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }

}


data class NTuple4<T1, T2, T3, T4>(val t1: T1, val t2: T2, val t3: T3, val t4: T4)

class CharactersViewModelFactory(private val repo: CharactersRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(CharactersRepository::class.java).newInstance(repo)
    }

}