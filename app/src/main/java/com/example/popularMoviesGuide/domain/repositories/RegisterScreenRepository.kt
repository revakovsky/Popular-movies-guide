package com.example.popularMoviesGuide.domain.repositories

import android.content.Intent
import androidx.activity.result.ActivityResultLauncher

interface RegisterScreenRepository {

    fun launchRegistrationScreen(launcher: ActivityResultLauncher<Intent>)

}