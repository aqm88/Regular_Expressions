package States

interface State {
    fun consumeLetter(letter: String): State
}