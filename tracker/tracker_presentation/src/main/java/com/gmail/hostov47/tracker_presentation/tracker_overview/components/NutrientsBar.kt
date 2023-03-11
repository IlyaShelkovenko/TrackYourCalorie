/**
 * Created by Ilia Shelkovenko on 07.03.2023.
 */

package com.gmail.hostov47.tracker_presentation.tracker_overview.components

import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.Canvas
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import com.gmail.hostov47.trackyourcalorie.ui.theme.CarbColor
import com.gmail.hostov47.trackyourcalorie.ui.theme.FatColor
import com.gmail.hostov47.trackyourcalorie.ui.theme.ProteinColor

@Composable
fun NutrientsBar(
    carbs: Int,
    protein: Int,
    fat: Int,
    calories: Int,
    calorieGoal: Int,
    modifier: Modifier = Modifier
) {
    val background = MaterialTheme.colors.background
    val caloriesExceedColor = MaterialTheme.colors.error
    val carbWidthRatio = remember {
        Animatable(0f)
    }
    val proteinWidthRation = remember {
        Animatable(0f)
    }
    val fatWidthRation = remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = carbs) {
        carbWidthRatio.animateTo(
            targetValue = ((carbs * 4f) / calorieGoal)
        )
    }
    LaunchedEffect(key1 = carbs) {
        proteinWidthRation.animateTo(
            targetValue = ((protein * 4f) / calorieGoal)
        )
    }
    LaunchedEffect(key1 = carbs) {
        fatWidthRation.animateTo(
            targetValue = ((fat * 9f) / calorieGoal)
        )
    }

    Canvas(modifier = modifier) {
        if (calories <= calorieGoal) {
            val carbsWidth = carbWidthRatio.value * size.width
            val proteinWidth = proteinWidthRation.value * size.width
            val fatWidth = fatWidthRation.value * size.width

            drawRoundRect(
                color = background,
                size = size,
                cornerRadius = CornerRadius(100f)
            )
            drawRoundRect(
                color = FatColor,
                size = Size(
                    width = carbsWidth + proteinWidth + fatWidth,
                    height = size.height
                ),
                cornerRadius = CornerRadius(100f)
            )
            drawRoundRect(
                color = ProteinColor,
                size = Size(
                    width = carbsWidth + proteinWidth,
                    height = size.height
                ),
                cornerRadius = CornerRadius(100f)
            )
            drawRoundRect(
                color = CarbColor,
                size = Size(
                    width = carbsWidth,
                    height = size.height
                ),
                cornerRadius = CornerRadius(100f)
            )
        } else {
            drawRoundRect(
                color = caloriesExceedColor,
                size = size,
                cornerRadius = CornerRadius(100f)
            )
        }
    }
}