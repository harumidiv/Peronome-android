package harumidiv.peronome

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.MotionEvent
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class MetronomeActivity : AppCompatActivity(), MetronomePresenterOutput, Runnable {

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
        presenter = MetronomePresenter(this, 120)

        tapButton()
    }
    var handler: Handler = Handler()

    val longPressHandler = Handler()
    val longPressReceiver = Runnable {
        handler.post(this)
    }

    fun tapButton(){

        addTempoButton!!.setOnTouchListener { _, event ->
            when (event!!.action) {
                // タップされた時
                MotionEvent.ACTION_DOWN -> {
                    presenter!!.addTempo()
                    longPressHandler.postDelayed(longPressReceiver, 500);
                }
                // タップ終了時
                MotionEvent.ACTION_UP -> {
                    longPressHandler.removeCallbacks(longPressReceiver);    // 長押し中に指を上げたらhandlerの処理を中止
                    handler.removeCallbacks(this)
                }
            }
            false
        }

        subTempoButton!!.setOnClickListener {
            presenter!!.subTempo()
        }
    }

    override fun run() {
        presenter!!.addTempo()
        handler.postDelayed( this, 50)
    }

    /**
     *　presenter output method
     */
    override fun showLabel(tempo: String) {
        tempoLabel!!.text = tempo
    }

    override fun showStartMetronome(speed: Double) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showStopMetronome(speed: Double) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
