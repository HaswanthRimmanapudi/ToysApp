package com.haswanth.toysapp.data.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.haswanth.toysapp.pref.UserPref
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
public class MainViewModel @Inject constructor(private val userPref: UserPref) : ViewModel() {

    val userName = userPref.getName().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = ""
    )

    fun saveData(name: String) {
        viewModelScope.launch {
            userPref.saveName(name)
        }
    }


}