/**
 * Created by Ilia Shelkovenko on 27.01.2023.
 */

package com.gmail.hostov47.core.domain.use_case

class FilterOutDigits {
    operator fun invoke(text: String): String {
        return text.filter { it.isDigit() }
    }
}