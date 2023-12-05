package com.haswanth.toysapp

import android.content.Context
import android.content.SharedPreferences

class LocalData {

     var _context: Context? = null
     lateinit var prefs: SharedPreferences
     var editor: SharedPreferences.Editor? = null
     constructor(_context: Context?) {
         this._context = _context
         if (_context != null) {
             prefs = _context.getSharedPreferences(_context.getString(R.string.app_name), Context.MODE_PRIVATE)
         }
         editor = prefs.edit()
     }

     companion object {
        const val FIRST_NAME = "first_name"
        const val LAST_NAME = "last_name"
        const val PASSWORD = "password"
        const val USER_EMAIL = "user_email"
    }
     
    fun saveAuthToken( first_name: String, last_name: String, password: String, user_email: String) {
        saveString( FIRST_NAME, first_name, LAST_NAME,last_name, PASSWORD,password, USER_EMAIL, user_email)
    }

    fun saveString(
        FIRST_NAME: String,
        first_name: String,
        LAST_NAME: String,
        last_name: String,
        PASSWORD: String,
        password: String,
        USER_EMAIL:String,
        user_email:String
    ) {
        editor!!.putString(FIRST_NAME, first_name)
        editor!!.putString(LAST_NAME, last_name)
        editor!!.putString(USER_EMAIL, user_email)
        editor!!.putString(PASSWORD, password)
        editor!!.apply()
    }


    fun getSingleField(key: String?): String? {
         return prefs.getString(key, null)
     }


    fun getUserDetails(): HashMap<String, String>? {
        //Use hashmap to store user credentials
        val user = HashMap<String, String>()
        prefs.getString(FIRST_NAME, null)?.let { user.put(FIRST_NAME, it) }
        prefs.getString(LAST_NAME, null)?.let { user.put(LAST_NAME, it) }
        prefs.getString(USER_EMAIL, null)?.let { user.put(USER_EMAIL, it) }
        prefs.getString(PASSWORD, null)?.let { user.put(PASSWORD, it) }

        return user
    }


//     fun getString(context: Context, key: String): String? {
//        val prefs: SharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
//        return prefs.getString(Companion.USER_TOKEN, null)
//    }

    fun clearData(context: Context){
        val editor = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE).edit()
        editor.clear()
        editor.apply()
    }



}