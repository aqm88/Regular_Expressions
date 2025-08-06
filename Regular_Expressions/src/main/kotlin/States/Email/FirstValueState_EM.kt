package States.Email

import States.InvalidState
import States.State

class FirstValueState_EM: State {
    override fun consumeLetter(letter: String)= when(letter){
        "@" -> InvalidState()
        " "-> InvalidState()
        else-> LookForAtState_EM()
    }
}