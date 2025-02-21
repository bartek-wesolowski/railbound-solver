package util

fun <T> Array<T>.mapAt(index: Int, transform: (T) -> T): Array<T> = copyOf()
    .also { it[index] = transform(it[index]) }

fun <T> List<T>.mapAt(index: Int, transform: (T) -> T): List<T> = mapIndexed { i, t ->
    if (i == index) {
        transform(t)
    } else {
        t
    }
}

fun <T> List<T>.removeAt(index: Int): List<T> = filterIndexed { i, _ -> i != index }