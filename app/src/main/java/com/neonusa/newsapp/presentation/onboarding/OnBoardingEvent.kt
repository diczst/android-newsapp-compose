package com.neonusa.newsapp.presentation.onboarding

sealed class OnBoardingEvent {
    object SaveAppEntry: OnBoardingEvent()
}