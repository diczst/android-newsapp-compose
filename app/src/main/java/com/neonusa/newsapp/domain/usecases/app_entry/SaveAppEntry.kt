package com.neonusa.newsapp.domain.usecases.app_entry

import com.neonusa.newsapp.domain.LocalUserManager

class SaveAppEntry(private val localUserManger: LocalUserManager) {

    suspend operator fun invoke(){
        localUserManger.saveAppEntry()
    }

}