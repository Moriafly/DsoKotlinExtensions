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
 * 字节数组转 16 进制字符串
 */
fun ByteArray.toHex(): String? {
    val stringBuilder = StringBuilder("")
    if (this.isEmpty()) {
        return null
    }
    for (element in this) {
        val v = element.toInt() and 0xFF
        val hv = Integer.toHexString(v)
        if (hv.length < 2) {
            stringBuilder.append(0)
        }
        stringBuilder.append(hv)
    }
    return stringBuilder.toString()
}