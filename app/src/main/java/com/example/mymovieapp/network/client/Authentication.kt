package com.example.mymovieapp.network.client

import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route

class Authentication : Authenticator {
    override fun authenticate(route: Route?, response: Response): Request {

        // request
        return response.request.newBuilder()
            .header("Authorization",
                "Bearer {access token here}")
            .build()
    }
}