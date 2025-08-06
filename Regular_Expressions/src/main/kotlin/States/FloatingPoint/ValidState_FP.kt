package States.FloatingPoint

import DIGITS
import States.State

class ValidState_FP: State {
    override fun consumeLetter(letter: String)= when(letter) {
        in DIGITS -> this
        else -> InvalidState_FP()
    }
}