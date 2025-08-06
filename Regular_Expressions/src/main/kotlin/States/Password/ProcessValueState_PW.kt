package States.Password

import SPECIAL_CHARS
import States.State

class ProcessValueState_PW: State {
    override fun consumeLetter(letter: String): State {
        if(letter[0].isUpperCase()) return CapitalFoundState_PW()
        else if(letter in SPECIAL_CHARS) return SpecialFoundState_PW()
        else return NeitherFoundState_PW()
    }
}