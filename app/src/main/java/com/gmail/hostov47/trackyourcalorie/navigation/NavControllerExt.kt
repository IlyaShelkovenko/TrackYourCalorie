/**
 * Created by Ilia Shelkovenko on 26.01.2023.
 */

package com.gmail.hostov47.trackyourcalorie.navigation

import androidx.navigation.NavController
import com.gmail.hostov47.core.util.UiEvent


fun NavController.navigate(event: UiEvent.Navigate) {
    this.navigate(event.route)
}