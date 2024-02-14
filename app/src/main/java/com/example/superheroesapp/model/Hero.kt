package com.example.superheroesapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/*
Define the model for our hero class
 */
data class Hero(
    @StringRes val nameRes: Int,
    @StringRes val descriptionRes: Int,
    @DrawableRes val imageRes: Int,
)