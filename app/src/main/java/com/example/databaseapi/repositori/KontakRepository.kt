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

class NetworkKontakRepositori(
    private val kontakApiService: KontakService
) : KontakRepositori {
    override suspend fun getKontak(): List<Kontak> = kontakApiService.getKontak()

    override suspend fun insertkontak(kontak: Kontak) {
        kontakApiService.insertKontak(kontak)
    }

    override suspend fun updatekontak(id: Int, kontak: Kontak) {
        kontakApiService.updateKontak(id, kontak)
    }

    override suspend fun deletekontak(id: Int) {
        try {
            val response = kontakApiService.deleteKontak(id)
            if (!response.isSuccessful){
                throw IOException("Failed to delete kontak. HTTP status code: " +
                "${response.code()}"
                )
            }
            else{
                response.message()
                println(response.message())
            }
        }
        catch (e:Exception){
            throw e
        }

    }

    override suspend fun getkontakById(id: Int): Kontak {
        return kontakApiService.getKontakById(id)
    }

}