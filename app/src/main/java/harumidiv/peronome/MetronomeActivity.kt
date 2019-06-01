package harumidiv.peronome

import android.media.AudioAttributes
import android.media.Image
import android.media.SoundPool
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import java.util.concurrent.ForkJoinPool


class MetronomeActivity : AppCompatActivity(), MetronomePresenterOutput, Runnable,View.OnTouchListener {
    enum class PushButtonType{
        ADD,SUB
    }
    private lateinit var pendlumImage:ImageView
    private lateinit var tempoLabel: TextView

    private lateinit var startStopButton: ImageButton
    private lateinit var presenter: MetronomePresenter

    private var type: PushButtonType? = null

    private lateinit var soundPool: SoundPool
    var tempoSound = 0

    /**
     * lifecycle
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val audioAtributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_GAME)
            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
            .build()
        soundPool = SoundPool.Builder()
            .setAudioAttributes(audioAtributes)
            .setMaxStreams(2)
            .build()

        soundPool.setOnLoadCompleteListener{ soundPool, sampleId, status ->
            Log.d("debug", "sampleId=$sampleId")
            Log.d("debug", "status=$status")
        }

        tempoSound = soundPool.load(this, R.raw.tempo_sound, 1)


        setContentView(R.layout.activity_main)
        pendlumImage = findViewById(R.id.pendlumImage)
        tempoLabel = findViewById(R.id.tempoLabel)

        //テンポの変更　
        var addTempoButton: ImageButton = findViewById(R.id.addTempoButton)
        addTempoButton.setOnTouchListener(this)
        var subTempoButton: ImageButton = findViewById(R.id.subTempoButton)
        subTempoButton.setOnTouchListener(this)

        startStopButton = findViewById(R.id.startStopButton)
        presenter = MetronomePresenter(this, 120)


        startStopButton.setOnClickListener {
            Log.d("aaa", "aaaa")
            soundPool.play(tempoSound, 1.0f, 1.0f, 0, 0, 1.0f)
        }
    }
    var handler: Handler = Handler()
    val longPressHandler = Handler()
    val longPressReceiver = Runnable {
        handler.post(this)
    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        when (v!!.id) {
            R.id.addTempoButton -> {
                when (event!!.action) {
                    MotionEvent.ACTION_DOWN -> {
                        type = PushButtonType.ADD
                        presenter.addTempo()
                        longPressHandler.postDelayed(longPressReceiver, 500);
                    }
                    MotionEvent.ACTION_UP -> {
                        longPressHandler.removeCallbacks(longPressReceiver);
                        handler.removeCallbacks(this)
                    }
                }
            }
            R.id.subTempoButton -> {
                when (event!!.action) {
                    MotionEvent.ACTION_DOWN -> {
                        type = PushButtonType.SUB
                        presenter.subTempo()
                        longPressHandler.postDelayed(longPressReceiver, 500);
                    }
                    MotionEvent.ACTION_UP -> {
                        longPressHandler.removeCallbacks(longPressReceiver);
                        handler.removeCallbacks(this)
                    }
                }
            }
        }
        return false
    }

    override fun run() {
        when (type) {
            PushButtonType.ADD -> {
                presenter.addTempo()

            }
            PushButtonType.SUB -> {
                presenter.subTempo()
            }
        }
        handler.postDelayed( this, 50)
    }

    /**
     *　presenter output method
     */
    override fun showLabel(tempo: String) {
        tempoLabel.text = tempo
    }

    override fun showStartMetronome(speed: Double) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showStopMetronome(speed: Double) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
