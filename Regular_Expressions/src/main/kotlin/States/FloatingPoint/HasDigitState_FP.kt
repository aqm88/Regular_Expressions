package States.FloatingPoint

import DIGITS
import States.State

class HasDigitState_FP: State {
    override fun consumeLetter(letter: String) = when(letter){
        in DIGITS -> this
        "." -> HasPeriodState_FP()
        else -> InvalidState_FP()
    }
}