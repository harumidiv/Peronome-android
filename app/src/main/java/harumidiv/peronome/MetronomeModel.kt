package harumidiv.peronome

interface MetronomeModelInput {
    fun loadAudio()
    fun stopAudio()
    fun startAudio()
    fun addTempo(): Int
    fun subTempo(): Int
}

class MetronomeModel(private var stepValue: Int): MetronomeModelInput{
    var speed: Double = stepValue as Double

    override fun loadAudio() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun stopAudio() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun startAudio() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addTempo(): Int {
        if(stepValue >= 240){
            return stepValue
        }
        stepValue += 1
        return stepValue
    }

    override fun subTempo(): Int {
        if(stepValue >= 40) {
            return stepValue
        }
        stepValue -= 1
        return stepValue
    }
}