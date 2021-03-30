/**
 * Copyright 2021 Moriafly
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dso.ext

/**
 * 转换成大小格式
 */
fun Long.toSizeFormat(): String {
    val source = this.toDouble()
    if (this < 1_000) {
        return "${String.format("%.2f", source)} KB"
    }
    if (this < 1_000_000) {
        return "${String.format("%.2f", source / 1_000)} KB"
    }
    if (this < 1_000_000_000) {
        return "${String.format("%.2f", source / 1_000_000)} MB"
    }
    return "${String.format("%.2f", source / 1_000_000_000)} GB"
}

/**
 * 转换成时间格式
 */
fun Long.toTimeFormat(): String {
    // 时，分，秒
    val hour = this / (60 * 60 * 1000)
    val min = this % (60 * 60 * 1000) / (60 * 1000)
    val sec = this % (60 * 1000) / 1000
    return if (hour == 0L) {
        String.format("%02d:%02d", min, sec)
    } else {
        String.format("%02d:%02d:%02d", hour, min, sec)
    }
}