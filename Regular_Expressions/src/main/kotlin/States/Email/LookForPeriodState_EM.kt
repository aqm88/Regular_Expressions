package States.Email

import States.InvalidState
import States.State

class LookForPeriodState_EM: State {
    override fun consumeLetter(letter: String)= when(letter) {
        "." -> AfterPeriodState_EM()
        " " -> InvalidState()
        "@" -> InvalidState()
        else -> LookForPeriodState_EM()
    }
}