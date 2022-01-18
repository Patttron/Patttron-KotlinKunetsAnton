package teach.meskills.timer

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import teach.meskills.timer.MainActivity.Companion.input

class TimerViewModel : ViewModel() {
    private var inputSeconds = 0
    private var job: Job? = null
    private val scope = CoroutineScope(Dispatchers.Main)
    var someData = MutableLiveData<Int>()
    var timerStateLiveData = MutableLiveData<Boolean>()

    fun start() {
        if (inputSeconds == 0) {
            inputSeconds = input
        }
        timerStateLiveData.value = true
        job = scope.launch {
            someData.value = inputSeconds
            withContext(Dispatchers.Main) {
                while (inputSeconds > 0) {
                    delay(1000)
                    inputSeconds -= 1
                    someData.value = inputSeconds
                    if (inputSeconds == 0) {
                        timerStateLiveData.value = false
                    }
                }
            }
        }
    }

    fun pause() {
        job?.cancel()
        someData.value = inputSeconds
        timerStateLiveData.value = false
    }

    fun reset() {
        job?.cancel()
        someData.value = 0
        inputSeconds = 0
        timerStateLiveData.value = false
    }

    override fun onCleared() {
        super.onCleared()
        scope.cancel()
    }
}