package States.Password

import SPECIAL_CHARS
import States.State

class ValidState_PW: State {
    override fun consumeLetter(letter: String): State {
        if(letter in SPECIAL_CHARS) return BothFoundState_PW()
        else return this
    }
}