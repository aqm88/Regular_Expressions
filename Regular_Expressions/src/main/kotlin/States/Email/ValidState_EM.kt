package States.Email

import States.InvalidState
import States.State

class ValidState_EM: State {
    override fun consumeLetter(letter: String) = when(letter) {
        "@" -> InvalidState()
        " " -> InvalidState()
        "." -> InvalidState()
        else -> ValidState_EM()
    }
}