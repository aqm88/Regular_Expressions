package States.Email

import States.InvalidState
import States.State

class LookForAtState_EM: State {
    override fun consumeLetter(letter: String) = when(letter) {
        "@" -> AfterAtState_EM()
        " " -> InvalidState()
        else -> LookForAtState_EM()
    }
}