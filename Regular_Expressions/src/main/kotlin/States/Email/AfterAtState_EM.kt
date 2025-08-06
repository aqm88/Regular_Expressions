package States.Email

import States.InvalidState
import States.State

class AfterAtState_EM: State {
    override fun consumeLetter(letter: String) = when(letter){
        "@" -> InvalidState()
        " " -> InvalidState()
        "." -> InvalidState()
        else-> LookForPeriodState_EM()
    }
}