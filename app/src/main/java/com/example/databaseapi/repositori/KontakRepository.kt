package com.example.databaseapi.repositori

import com.example.databaseapi.model.Kontak
import com.example.databaseapi.service_api.KontakService
import java.io.IOException

interface KontakRepositori{
    suspend fun getKontak(): List<Kontak>

    suspend fun insertkontak(kontak: Kontak)

    suspend fun updatekontak(id: Int, kontak: Kontak)

    suspend fun deletekontak(id: Int)

    suspend fun getkontakById(id: Int): Kontak
}

