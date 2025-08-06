import States.FloatingPoint.FirstValueState_FP
import States.State

fun isValidFloatingPoint(value: String): Boolean{
    var state: State = FirstValueState_FP()

    for (letter in value) {
        state = state.consumeLetter(letter.toString())
    }

    return state is States.FloatingPoint.ValidState_FP
}