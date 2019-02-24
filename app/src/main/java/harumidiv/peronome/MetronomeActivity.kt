package harumidiv.peronome

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class MetronomeActivity : AppCompatActivity(), MetronomePresenterOutput {

    private var pendlumImage:ImageView? =null
    private var tempoLabel: TextView? = null
    private var addTempoButton: ImageButton? = null
    private var subTempoButton: ImageButton? = null
    private var startStopButton: ImageButton? = null

    private var presenter: MetronomePresenter? = null

    /**
     * lifecycle
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pendlumImage = findViewById(R.id.pendlumImage)
        tempoLabel = findViewById(R.id.tempoLabel)
        addTempoButton = findViewById(R.id.addTempoButton)
        subTempoButton = findViewById(R.id.subTempoButton)
        startStopButton = findViewById(R.id.startStopButton)
        presenter = MetronomePresenter(this, 120.0)
    }

    /**
     *　presenter output method
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
