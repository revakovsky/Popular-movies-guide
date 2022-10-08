package com.example.popularMoviesGuide.domain.repositories

import android.content.Intent
import androidx.activity.result.ActivityResultLauncher

interface RegisterScreenRepository {

    fun launchRegistering(launcher: ActivityResultLauncher<Intent>)

}