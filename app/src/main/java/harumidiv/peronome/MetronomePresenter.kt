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
class MetronomePresenter(output: MetronomePresenterOutput, tempo:Int): MetronomeInput {
    val output: MetronomePresenterOutput = output
    val model = MetronomeModel(stepValue = tempo)


    override fun subTempo() {
        output.showLabel(model.subTempo().toString())
    }
    override fun addTempo() {
        output.showLabel(model.addTempo().toString())
    }

    override fun startStopState() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}