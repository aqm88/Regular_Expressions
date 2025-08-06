package States.Integer

import DIGITS
import States.State

class ValidState_INT: State {
    override fun consumeLetter(letter: String) = when(letter){
        in DIGITS -> this
        else -> InvalidState_INT()
    }
}