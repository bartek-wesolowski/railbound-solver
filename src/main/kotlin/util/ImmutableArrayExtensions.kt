package util

import com.danrusu.pods4k.immutableArrays.ImmutableArray
import com.danrusu.pods4k.immutableArrays.buildImmutableArray

fun <T> ImmutableArray<T>.removeAt(index: Int): ImmutableArray<T> = buildImmutableArray(size - 1) {
    for (i in indices) {
        if (i != index) {
            add(this@removeAt[i])
        }
    }
}