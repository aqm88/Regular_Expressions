package States.FloatingPoint

import DIGITS
import States.State

class HasPeriodState_FP: State {
    override fun consumeLetter(letter: String) = when(letter){
        in DIGITS -> ValidState_FP()
        else -> InvalidState_FP()
    }
}