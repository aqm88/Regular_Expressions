package States.FloatingPoint

import States.InvalidState
import States.State

class ZeroFirstState_FP: State {
    override fun consumeLetter(letter: String) = when(letter){
        "." -> HasPeriodState_FP()
        else -> InvalidState()
    }
}