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