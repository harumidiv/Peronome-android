package harumidiv.peronome

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MetronomeActivity : AppCompatActivity(), MetronomePresenterOutput {

    /**
     * lifecycle
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /**
     *　presenter output
     */
    override fun showLabel(tempo: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showStartMetronome(speed: Double) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showStopMetronome(speed: Double) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
