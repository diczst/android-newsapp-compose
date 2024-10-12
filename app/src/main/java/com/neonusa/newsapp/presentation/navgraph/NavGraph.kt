package com.neonusa.newsapp.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.neonusa.newsapp.presentation.bookmark.BookmarkScreen
import com.neonusa.newsapp.presentation.bookmark.BookmarkViewModel
import com.neonusa.newsapp.presentation.home.HomeScreen
import com.neonusa.newsapp.presentation.home.HomeViewModel
import com.neonusa.newsapp.presentation.news_navigator.NewsNavigator
import com.neonusa.newsapp.presentation.onboarding.OnBoardingScreen
import com.neonusa.newsapp.presentation.onboarding.OnBoardingViewModel
import com.neonusa.newsapp.presentation.search.SearchScreen
import com.neonusa.newsapp.presentation.search.SearchViewModel

@Composable
fun NavGraph(
    startDestination: String
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ) {
            composable(route = Route.OnBoardingScreen.route) {
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(onEvent = viewModel::onEvent)
            }
        }

        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.NewsNavigatorScreen.route
        ) {
//            composable(route = Route.HomeScreen.route) {
//
//            }
//            composable(route = Route.SearchScreen.route) {
//
//            }
//            composable(route = Route.BookmarkScreen.route) {
//
//            }
//            composable(route = Route.DetailsScreen.route) {
//
//            }
//            composable(route = Route.NewsNavigatorScreen.route){
////                val viewModel: HomeViewModel = hiltViewModel()
////                val articles = viewModel.news.collectAsLazyPagingItems()
////                HomeScreen(articles = articles, navigate = {})
//                val viewModel: SearchViewModel = hiltViewModel()
//                SearchScreen(state = viewModel.state.value, event=viewModel::onev, navigate = {})
//            }

            composable(route = Route.NewsNavigatorScreen.route){
//                NewsNavigator()
                val viewModel: BookmarkViewModel = hiltViewModel()
                BookmarkScreen(state = viewModel.state.value, navigate = {})
            }


        }
    }
}