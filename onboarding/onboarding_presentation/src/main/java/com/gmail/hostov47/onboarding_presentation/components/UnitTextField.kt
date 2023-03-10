/**
 * Created by Ilia Shelkovenko on 26.01.2023.
 */

package com.gmail.hostov47.onboarding_presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp
import com.gmail.hostov47.core_ui.LocalSpacing

@Composable
fun UnitTextField(
    value: String,
    onValueChanged: (String) -> Unit,
    unit: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle(
        color = MaterialTheme.colors.primaryVariant,
        fontSize = 70.sp
    )
) {
    val spacing = LocalSpacing.current
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ){
        BasicTextField(
            value = value,
            onValueChange = onValueChanged,
            textStyle = textStyle,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            singleLine = true,
            modifier = Modifier
                .width(IntrinsicSize.Min)
                .alignBy(LastBaseline)
        )
        Spacer(
            modifier = Modifier.width(spacing.spaceSmall)
        )
        Text(
            text = unit,
            modifier = Modifier.alignBy(LastBaseline)
        )
    }
}