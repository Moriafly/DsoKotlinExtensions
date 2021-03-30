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
 * ArrayList 中上一项
 */
fun <T> ArrayList<T>.previous(current: T?): T? {
    if (this.isEmpty() || current == null) {
        return null
    }
    when (val position = this.indexOf(current)) {
        -1 -> return null
        0 -> {
            this[this.lastIndex]?.let {
                return it
            }
        }
        else -> {
            this[position - 1]?.let {
                return it
            }
        }
    }
    return null
}

/**
 * ArrayList 中下一项
 * 传入当前项 [current]，返回下一项（可能为空）
 */
fun <T> ArrayList<T>.next(current: T?): T? {
    if (this.isEmpty() || current == null) {
        return null
    }
    when (val position = this.indexOf(current)) {
        -1 -> return null
        this.lastIndex -> {
            this[0]?.let {
                return it
            }
        }
        else -> {
            this[position + 1]?.let {
                return it
            }
        }
    }
    return null
}

