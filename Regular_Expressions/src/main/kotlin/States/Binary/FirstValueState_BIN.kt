package States.Binary

import States.InvalidState
import States.State

class FirstValueState_BIN: State {
    override fun consumeLetter(letter: String) = when (letter){
        "1" -> ValidState_BIN()
        else -> InvalidState()
    }
}