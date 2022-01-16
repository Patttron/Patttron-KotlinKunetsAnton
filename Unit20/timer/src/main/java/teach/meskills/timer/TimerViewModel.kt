package teach.meskills.timer

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import teach.meskills.timer.MainActivity.Companion.timerState

class TimerViewModel : ViewModel() {
    private var inputSeconds = 10L
    private var job: Job? = null
    private val scope = CoroutineScope(Dispatchers.Main)
    var someData = MutableLiveData<Long>()

    fun start() {
        timerState = TimerState.STARTED
        job = scope.launch {
            someData.value = inputSeconds
            withContext(Dispatchers.Main) {
                while (inputSeconds > 0) {
                    delay(1000)
                    inputSeconds -= 1
                  someData.value = inputSeconds
                    if(inputSeconds == 0L){
                        timerState = TimerState.ENDED
                    }
                }
            }
        }
    }

    fun pause() {
        job?.cancel()
        someData.value = inputSeconds
        timerState = TimerState.PAUSED
    }

    fun reset() {
        job?.cancel()
        someData.value = 0
        timerState = TimerState.ENDED
    }

    override fun onCleared() {
        super.onCleared()
        scope.cancel()
    }
}