package com.islas.marvelsapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.compose.rememberNavController
import com.islas.marvelsapi.core.network.NetworkConnectivityObserver
import com.islas.marvelsapi.core.util.ConnectivityObserver
import com.islas.marvelsapi.navigation.navhost.RootNavigationGraph
import com.islas.marvelsapi.presentation.stateholders.MasterViewModel
import com.islas.marvelsapi.presentation.ui.theme.MarvelsAPITheme
import com.islas.marvelsapi.presentation.views.NoConnectionView
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {


    private lateinit var connectivityObserver: ConnectivityObserver
    override fun onCreate(savedInstanceState: Bundle?) {
        val masterViewModel by viewModel<MasterViewModel>()
        super.onCreate(savedInstanceState)

        connectivityObserver = NetworkConnectivityObserver(applicationContext)

        setContent {
            MarvelsAPITheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val status by connectivityObserver.observe().collectAsState(
                        initial = ConnectivityObserver.Status.Unavailable
                    )
                    when(status){
                        ConnectivityObserver.Status.Available -> {
                            RootNavigationGraph(
                                navController = rememberNavController(),
                                masterViewModel
                                )
                        }
                        ConnectivityObserver.Status.Unavailable -> {
                            NoConnectionView("Unavailable Connection")
                        }
                        ConnectivityObserver.Status.Losing -> {
                            NoConnectionView("Losing Connection")
                        }
                        ConnectivityObserver.Status.Lost -> {
                            NoConnectionView("Lost Connection")
                        }
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        hideStatusBar()
    }

    private fun hideStatusBar() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowInsetsControllerCompat(window, window.decorView).let { controller ->
            controller.hide(WindowInsetsCompat.Type.systemBars())
            controller.systemBarsBehavior =
                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    }
}
