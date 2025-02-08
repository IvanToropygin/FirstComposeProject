package com.sumin.firstcomposeproject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MainViewModel: ViewModel() {

    private val initialList = mutableListOf<InstagramModel>().apply {
        repeat(500) {
            add(InstagramModel(
                id = it,
                title = "Title $it",
                isFollowed = Random.nextBoolean()
            ))
        }
    }

    private val _models = MutableLiveData<List<InstagramModel>>(initialList)
    val models : LiveData<List<InstagramModel>> = _models

    fun changeFollowingStatus(instagramModel: InstagramModel) {
        val listToModify = _models.value?.toMutableList() ?: mutableListOf()
        listToModify.replaceAll { itemInList ->
            if (itemInList == instagramModel) {
                itemInList.copy(isFollowed = !itemInList.isFollowed)
            } else itemInList
        }
        _models.value = listToModify
    }
}