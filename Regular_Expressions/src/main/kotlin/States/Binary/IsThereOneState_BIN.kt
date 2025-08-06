package States.Binary

import States.InvalidState
import States.State

class IsThereOneState_BIN: State {
    override fun consumeLetter(letter: String) = when(letter){
        "1" -> ValidState_BIN()
        "0" -> this
        else -> InvalidState()
    }
}