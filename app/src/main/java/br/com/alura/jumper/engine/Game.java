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
import br.com.alura.jumper.elements.Canos;
import br.com.alura.jumper.elements.GameOver;
import br.com.alura.jumper.elements.Passaro;
import br.com.alura.jumper.elements.Pontuacao;
import br.com.alura.jumper.graphic.Tela;

import static br.com.alura.jumper.R.drawable.cano;


public class Game extends SurfaceView implements Runnable, View.OnTouchListener {
    private boolean isRunning = true;
    private SurfaceHolder holder = getHolder();
    private Passaro passaro;
    private Bitmap background;
    private final Tela tela;
    private Context context;
    private Canos canos;
    private Pontuacao pontuacao;

    public Game(Context context) {
        super(context);

        tela = new Tela(context);
        this.context = context;
        inicializaElementos();

        setOnTouchListener(this);
    }

    private void inicializaElementos() {
        passaro = new Passaro(tela, context);
        pontuacao = new Pontuacao();
        canos = new Canos(tela, pontuacao);

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

            canos.desenhaNo(canvas);
            canos.move();

            pontuacao.desenhaNo(canvas);

            if (new VerificadorDeColisao(passaro, canos).temColisao()) {
                new GameOver(tela).desenhaNo(canvas);
                isRunning = false;
            }

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
