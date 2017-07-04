package br.com.alura.jumper.engine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import br.com.alura.jumper.R;
import br.com.alura.jumper.elements.Cano;
import br.com.alura.jumper.elements.Passaro;
import br.com.alura.jumper.graphic.Tela;

import static br.com.alura.jumper.R.drawable.cano;


public class Game extends SurfaceView implements Runnable, View.OnTouchListener {
    private boolean isRunning = true;
    private SurfaceHolder holder = getHolder();
    private Passaro passaro;
    private Bitmap background;
    private final Tela tela;
    private Cano cano;

    public Game(Context context) {
        super(context);

        tela = new Tela(context);
        inicializaElementos();

        setOnTouchListener(this);
    }

    private void inicializaElementos() {
        passaro = new Passaro();
        cano = new Cano(tela, 400);

        Bitmap back = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        background = Bitmap.createScaledBitmap(back, back.getWidth(), tela.getAltura(), false);
    }

    @Override
    public void run() {
        while (isRunning) {
            if (!holder.getSurface().isValid()) continue;
            Canvas canvas = holder.lockCanvas();
            // draw game components
            canvas.drawBitmap(background, 0, 0, null);
            passaro.desenhaNoCanvas(canvas);
            passaro.cai();

            cano.desenhaNo(canvas);
            cano.move();

            holder.unlockCanvasAndPost(canvas);
        }
    }

    public void inicia() {
        isRunning = true;
    }

    public void pausa() {
        isRunning = false;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        passaro.pula();
        return false;
    }
}
