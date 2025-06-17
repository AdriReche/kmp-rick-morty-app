package org.arexdev.rickmortyapp.di

import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.arexdev.rickmortyapp.data.RepositoryImpl
import org.arexdev.rickmortyapp.data.remote.ApiService
import org.arexdev.rickmortyapp.domain.Repository
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val dataModule = module {
    //Ktor configuration
    single {
        HttpClient {
            install(ContentNegotiation) {
                //Ignore unknown keys discard extra fields in JSON responses
                json(json = Json { ignoreUnknownKeys = true }, contentType = ContentType.Any)
            }
            install(DefaultRequest) {
                url {
                    protocol = URLProtocol.HTTPS
                    host = "rickandmortyapi.com"
                    //In case of API Key needed
                    //parameters.append("key", "f3b6c0d1-2a4e-4b5c-8f7d-9e1c2b3d4e5f")
                }
            }
        }
    }
    factoryOf(::ApiService)
    factory<Repository> {
        RepositoryImpl(get())
    }
}