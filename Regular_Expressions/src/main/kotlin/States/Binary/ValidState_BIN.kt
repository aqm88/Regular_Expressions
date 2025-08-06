package States.Binary

import States.InvalidState
import States.State

class ValidState_BIN: State {
    override fun consumeLetter(letter: String) = when(letter){
        "1" -> this
        "0" -> IsThereOneState_BIN()
        else -> InvalidState()
    }
}