package States.Integer

import NON_ZERO_DIGITS
import States.State

class FirstValueState_INT: State {
    override fun consumeLetter(letter: String) = when(letter){
        in NON_ZERO_DIGITS -> ValidState_INT()
        else -> InvalidState_INT()
    }
}