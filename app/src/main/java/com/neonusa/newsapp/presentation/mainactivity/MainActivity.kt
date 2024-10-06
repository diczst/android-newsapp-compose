package com.neonusa.newsapp.presentation.mainactivity

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import com.neonusa.newsapp.domain.usecases.app_entry.AppEntryUseCases
import com.neonusa.newsapp.presentation.navgraph.NavGraph
import com.neonusa.newsapp.presentation.onboarding.OnBoardingScreen
import com.neonusa.newsapp.presentation.onboarding.OnBoardingViewModel
import com.neonusa.newsapp.ui.theme.NewsAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()
//    @Inject
//    lateinit var appEntryUseCases: AppEntryUseCases
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition(condition = { viewModel.splashCondition.value })
        }

//        lifecycleScope.launch {
//            appEntryUseCases.readAppEntry().collect{
//                Log.d("TEST", "onCreate: $it")
//            }
//        }

        setContent {
            NewsAppTheme( dynamicColor = false) {
                Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
//                    val viewModel: OnBoardingViewModel = hiltViewModel()
//                    OnBoardingScreen(onEvent = viewModel::onEvent)
                    NavGraph(startDestination = viewModel.startDestination.value)
                }
            }
        }
    }
}

