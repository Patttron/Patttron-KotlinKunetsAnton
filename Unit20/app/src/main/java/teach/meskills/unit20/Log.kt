package teach.meskills.unit20

import android.util.Log


fun log(any: Any, message: String) {
    Log.d("${any::class.simpleName}TAG", message)
}