package util

fun <T> Array<T>.mapAt(index: Int, transform: (T) -> T): Array<T> = copyOf()
    .also { it[index] = transform(it[index]) }