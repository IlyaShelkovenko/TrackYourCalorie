package com.gmail.hostov47.trackyourcalorie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.gmail.hostov47.core.domain.preferences.Preferences
import com.gmail.hostov47.onboarding_presentation.activity.ActivityScreen
import com.gmail.hostov47.onboarding_presentation.age.AgeScreen
import com.gmail.hostov47.onboarding_presentation.gender.GenderScreen
import com.gmail.hostov47.onboarding_presentation.goal.GoalScreen
import com.gmail.hostov47.onboarding_presentation.height.HeightScreen
import com.gmail.hostov47.onboarding_presentation.nutrient_goal.NutrientGoalScreen
import com.gmail.hostov47.onboarding_presentation.weight.WeightScreen
import com.gmail.hostov47.onboarding_presentation.welcome.WelcomeScreen
import com.gmail.hostov47.tracker_presentation.search.SearchScreen
import com.gmail.hostov47.tracker_presentation.tracker_overview.TrackerOverviewScreen
import com.gmail.hostov47.trackyourcalorie.navigation.Route
import com.gmail.hostov47.trackyourcalorie.ui.SearchArgs
import com.gmail.hostov47.trackyourcalorie.ui.theme.TrackYourCalorieTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val shouldShowOnboarding = preferences.loadShouldShowOnboarding()
        setContent {
            TrackYourCalorieTheme {
                val navController = rememberNavController()
                val scaffoldState = rememberScaffoldState()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    scaffoldState = scaffoldState
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = if (shouldShowOnboarding) {
                            Route.WELCOME
                        } else Route.TRACKER_OVERVIEW
                    ) {
                        composable(Route.WELCOME) {
                            WelcomeScreen(
                                onNextClick = {
                                    navController.navigate(Route.GENDER)
                                }
                            )
                        }
                        composable(Route.GENDER) {
                            GenderScreen(
                                onNextClick = {
                                    navController.navigate(Route.AGE)
                                }
                            )
                        }
                        composable(Route.AGE) {
                            AgeScreen(
                                scaffoldState = scaffoldState,
                                onNextClick = {
                                    navController.navigate(Route.HEIGHT)
                                }
                            )
                        }
                        composable(Route.HEIGHT) {
                            HeightScreen(
                                scaffoldState = scaffoldState,
                                onNextClick = {
                                    navController.navigate(Route.WEIGHT)
                                }
                            )
                        }
                        composable(Route.WEIGHT) {
                            WeightScreen(
                                scaffoldState = scaffoldState,
                                onNextClick = {
                                    navController.navigate(Route.ACTIVITY)
                                }
                            )
                        }
                        composable(Route.NUTRIENT_GOAL) {
                            NutrientGoalScreen(
                                scaffoldState = scaffoldState,
                                onNextClick = {
                                    navController.navigate(Route.TRACKER_OVERVIEW)
                                }
                            )
                        }
                        composable(Route.ACTIVITY) {
                            ActivityScreen(
                                onNextClick = {
                                    navController.navigate(Route.GOAL)
                                }
                            )
                        }
                        composable(Route.GOAL) {
                            GoalScreen(
                                onNextClick = {
                                    navController.navigate(Route.NUTRIENT_GOAL)
                                }
                            )
                        }
                        composable(Route.TRACKER_OVERVIEW) {
                            TrackerOverviewScreen(
                                onNavigateToSearch = { mealName, day, month, year ->
                                    navController.navigate(
                                        Route.SEARCH +
                                                "/$mealName" +
                                                "/$day" +
                                                "/$month" +
                                                "/$year",
                                    )
                                }
                            )
                        }
                        composable(
                            route = Route.SEARCH +
                                    "/{${SearchArgs.MEAL_TYPE.value}}" +
                                    "/{${SearchArgs.DAY_OF_MONTH.value}}" +
                                    "/{${SearchArgs.MONTH.value}}" +
                                    "/{${SearchArgs.YEAR.value}}",
                            arguments = listOf(
                                navArgument(SearchArgs.MEAL_TYPE.value) {
                                    type = NavType.StringType
                                },
                                navArgument(SearchArgs.DAY_OF_MONTH.value) {
                                    type = NavType.IntType
                                },
                                navArgument(SearchArgs.MONTH.value) {
                                    type = NavType.IntType
                                },
                                navArgument(SearchArgs.YEAR.value) {
                                    type = NavType.IntType
                                }
                            )
                        ) {
                            val mealName = it.arguments?.getString(SearchArgs.MEAL_TYPE.value)!!
                            val dayOfMonth = it.arguments?.getInt(SearchArgs.DAY_OF_MONTH.value)!!
                            val month = it.arguments?.getInt(SearchArgs.MONTH.value)!!
                            val year = it.arguments?.getInt(SearchArgs.YEAR.value)!!
                            SearchScreen(
                                scaffoldState = scaffoldState,
                                mealName = mealName,
                                dayOfMonth = dayOfMonth,
                                month = month,
                                year = year,
                                onNavigateUp = {
                                    navController.navigateUp()
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}