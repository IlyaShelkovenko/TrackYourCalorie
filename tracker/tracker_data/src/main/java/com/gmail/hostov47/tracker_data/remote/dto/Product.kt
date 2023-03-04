/**
 * Created by Ilia Shelkovenko on 04.03.2023.
 */

package com.gmail.hostov47.tracker_data.remote.dto

import com.squareup.moshi.Json

data class Product(
    @field:Json(name = "image_front_thumb_url")
    val imageFrontThumbUrl: String?,
    val nutriments: Nutriments,
    @field:Json(name = "product_name")
    val productName: String?
)