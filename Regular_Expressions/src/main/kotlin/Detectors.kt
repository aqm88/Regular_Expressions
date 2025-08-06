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

fun isValidBinary(value: String): Boolean {
    var state: State = States.Binary.FirstValueState_BIN()

    for (letter in value) {
        state = state.consumeLetter(letter.toString())
    }

    return state is States.Binary.ValidState_BIN
}

fun isValidEmail(value: String): Boolean {
    var state: State = States.Email.FirstValueState_EM()

    for (letter in value) {
        state = state.consumeLetter(letter.toString())
    }

    return state is States.Email.ValidState_EM
}