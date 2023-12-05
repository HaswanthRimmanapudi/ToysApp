package com.haswanth.toysapplication

sealed class Screen(val route: String) {
    object SplashScreen : Screen("splash_screen")
    object DashboardScreen : Screen("dashboard_screen")
    object ProductListScreen : Screen("product_list_screen")
    object ProductDetailScreen : Screen("product_detail_screen")
    object MainActivity : Screen("main_activity_screen")

}

