package com.haswanth.toysapp.data.signup

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.haswanth.toysapp.data.rules.Validator
import com.haswanth.toysapp.data.RegistrationUIState
import com.haswanth.toysapp.navigation.Screen
import com.haswanth.toysapp.navigation.ToysAppRouter
import com.haswanth.toysapp.pref.UserPref
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import androidx.compose.runtime.collectAsState
import javax.inject.Inject


class SignupViewModel  : ViewModel() {

    private val TAG = SignupViewModel::class.simpleName

    var registrationUIState = mutableStateOf(RegistrationUIState())

    var allValidationsPassed = mutableStateOf(false)

    var signUpInProgress = mutableStateOf(false)


    fun onEvent(event: SignupUIEvent) {
        when (event) {

            is SignupUIEvent.FirstNameChanged -> {
                registrationUIState.value = registrationUIState.value.copy(firstName = event.firstName)
            }

            is SignupUIEvent.LastNameChanged -> {
                registrationUIState.value = registrationUIState.value.copy(lastName = event.lastName)
            }

            is SignupUIEvent.EmailChanged -> {
                registrationUIState.value = registrationUIState.value.copy(email = event.email)
            }

            is SignupUIEvent.PasswordChanged -> {
                registrationUIState.value = registrationUIState.value.copy(password = event.password)
            }

            is SignupUIEvent.RegisterButtonClicked -> {
                signUp()
            }

            is SignupUIEvent.PrivacyPolicyCheckBoxClicked -> {
                registrationUIState.value = registrationUIState.value.copy(privacyPolicyAccepted = event.status)
            }
        }
        validateDataWithRules()
    }


    private fun signUp() {

        createUserInFirebase(
            firstName = registrationUIState.value.firstName,
            lastName = registrationUIState.value.lastName,
            email = registrationUIState.value.email,
            password = registrationUIState.value.password
        )
    }

    private fun validateDataWithRules() {
        val fNameResult = Validator.validateFirstName(
            fName = registrationUIState.value.firstName
        )

        val lNameResult = Validator.validateLastName(
            lName = registrationUIState.value.lastName
        )

        val emailResult = Validator.validateEmail(
            email = registrationUIState.value.email
        )

        val passwordResult = Validator.validatePassword(
            password = registrationUIState.value.password
        )

        val privacyPolicyResult = Validator.validatePrivacyPolicyAcceptance(
            statusValue = registrationUIState.value.privacyPolicyAccepted
        )

        registrationUIState.value = registrationUIState.value.copy(
            firstNameError = fNameResult.status,
            lastNameError = lNameResult.status,
            emailError = emailResult.status,
            passwordError = passwordResult.status,
            privacyPolicyError = privacyPolicyResult.status
        )

        allValidationsPassed.value = fNameResult.status && lNameResult.status &&
                emailResult.status && passwordResult.status && privacyPolicyResult.status

    }

//    var userPref : UserPref? =null
//
//    val userName = userPref!!.getName().stateIn(
//        scope = viewModelScope,
//        started = SharingStarted.WhileSubscribed(),
//        initialValue = ""
//    )
//
//    fun saveData(name: String) {
//        viewModelScope.launch {
//            userPref!!.saveName(name)
//        }
//    }

    private fun createUserInFirebase(firstName :String, lastName:String ,email: String, password: String) {

        signUpInProgress.value = true
        FirebaseAuth
            .getInstance()
            .createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                signUpInProgress.value = false
                if (it.isSuccessful) {

//                    val userName = saveData(firstName)

                    ToysAppRouter.navigateTo(Screen.HomeScreen)

                }
            }
            .addOnFailureListener {

            }
    }
}
