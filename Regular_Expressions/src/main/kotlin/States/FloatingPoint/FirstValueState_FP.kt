package States.FloatingPoint
import NON_ZERO_DIGITS
import States.State

class FirstValueState_FP: State {
    override fun consumeLetter(letter: String) = when(letter){
        in NON_ZERO_DIGITS -> HasDigitState_FP()
        "0" -> ZeroFirstState_FP()
        "." -> HasPeriodState_FP()
        else -> InvalidState_FP()
    }
}