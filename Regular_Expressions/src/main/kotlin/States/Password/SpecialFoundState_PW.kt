package States.Password

import States.State

class SpecialFoundState_PW: State {
    override fun consumeLetter(letter: String): State {
        if(letter[0].isUpperCase()) return ValidState_PW()
        else return this
    }
}