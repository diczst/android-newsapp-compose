package com.neonusa.newsapp.domain.usecases.app_entry

import com.neonusa.newsapp.domain.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(
    private val localUserManger: LocalUserManager
) {
    operator fun invoke(): Flow<Boolean> {
        return localUserManger.readAppEntry()
    }

}