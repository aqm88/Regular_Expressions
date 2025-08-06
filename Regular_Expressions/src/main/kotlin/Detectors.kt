import States.FloatingPoint.FirstValueState_FP
import States.State

fun isValidFloatingPoint(value: String): Boolean{
    var state: State = FirstValueState_FP()

    for (letter in value) {
        state = state.consumeLetter(letter.toString())
    }

    return state is States.FloatingPoint.ValidState_FP
}

fun isValidInteger(value: String): Boolean {
    var state: State = States.Integer.FirstValueState_INT()

    for (letter in value) {
        state = state.consumeLetter(letter.toString())
    }

    return state is States.Integer.ValidState_INT
}