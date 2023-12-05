package com.haswanth.toysapp

import com.haswanth.toysapp.R
import com.haswanth.toysapp.Toy


fun getActionToyList() = listOf(
    Toy(R.drawable.teddy_1, "Teddy 01","Price : $50","Rating : 5.0 ", "2.42m"),
    Toy(R.drawable.teddy_2, "Teddy 02","Price : $10","Rating : 2.5 ", "2.19m"),
    Toy(R.drawable.teddy_3, "Teddy 03","Price : $5","Rating : 3.0 ", "2.26m"),
    Toy(R.drawable.teddy_4, "Teddy 04","Price : $18","Rating : 4.9 ", "2 m"),
    Toy(R.drawable.teddy_5, "Teddy 05", "Price : $50","Rating : 5 ","1.56m"),
)

fun getCommonToyList() = listOf(
    Toy(R.drawable.common_5, "Horse Toy", "Price :$18","Rating : 1.9 ","1.50m"),
    Toy(R.drawable.common_2, "Gift Toys","Price : $50","Rating : 5 ", "1.44m"),
    Toy(R.drawable.common_3, "Multiple Toys","Price : $20","Rating : 5 ", "1.56m"),
    Toy(R.drawable.common_4, "Smart toys","Price : $40","Rating : 5 ","1.51m"),
    Toy(R.drawable.common_5, "Horse Toy","Price : $10","Rating : 5 ", "1.39m"),
)

fun getAnimationMovieList() = listOf(
    Toy(R.drawable.car_1, "Car 01", "Price : $51","Rating : 5 ", "1.51m"),
    Toy(R.drawable.car_2, "Car 02","Price : $22","Rating : 5 ", "1.36m"),
    Toy(R.drawable.car_3, "Car 03","Price : $33","Rating : 5 ",  "1.36m"),
    Toy(R.drawable.car_4, "Car 04","Price : $43","Rating : 5 ", "1.56m"),
    Toy(R.drawable.car_5, "Car 05","Price : $5","Rating : 5 ", "1.35m"),
)