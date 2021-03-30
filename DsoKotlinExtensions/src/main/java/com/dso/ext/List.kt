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
 * List 转 ArrayList
 * @return ArrayList
 */
fun <T> List<T>.toArrayList(): ArrayList<T> {
    val arrayList = ArrayList<T>()
    arrayList.addAll(this)
    return arrayList
}

/**
 * List 切割
 * 平均分配
 */
fun <T> List<T>.averageAssignFixLength(splitItemNum: Int): List<List<T>> {
    val result = ArrayList<List<T>>()
    if (this.run { isNotEmpty() } && splitItemNum > 0) {
        if (this.size <= splitItemNum) {
            // 源List元素数量小于等于目标分组数量
            result.add(this)
        } else {
            // 计算拆分后list数量
            val splitNum =
                if (this.size % splitItemNum == 0) this.size / splitItemNum else this.size / splitItemNum + 1

            var value: List<T>? = null
            for (i in 0 until splitNum) {
                value = if (i < splitNum - 1) {
                    this.subList(i * splitItemNum, (i + 1) * splitItemNum)
                } else {
                    // 最后一组
                    this.subList(i * splitItemNum, this.size)
                }
                result.add(value)
            }
        }
    }
    return result
}