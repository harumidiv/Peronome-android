package harumidiv.peronome

interface MetronomeInput {
    fun addTempo()
    fun subTempo()
    fun startStopState()
}
interface MetronomePresenterOutput {
    fun showLabel(tempo: String)
    fun showStartMetronome(speed: Double)
    fun showStopMetronome(speed: Double)
}
class MetronomePresenter(output: MetronomePresenterOutput, tempo:Double): MetronomeInput {
    val output: MetronomePresenterOutput = output
    val tempo: Double = tempo


    override fun subTempo() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun startStopState() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addTempo() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}