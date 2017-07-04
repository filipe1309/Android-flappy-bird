package br.com.alura.jumper.engine;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by filipe1309 on 03/07/17.
 */

public class Game extends SurfaceView implements Runnable {
    private boolean isRunning = true;
    private SurfaceHolder holder = getHolder();

    public Game(Context context) {
        super(context);
    }

    @Override
    public void run() {
        while (isRunning) {
            if (!holder.getSurface().isValid()) continue;
            Canvas canvas = holder.lockCanvas();
            // draw game components
            holder.unlockCanvasAndPost(canvas);
        }
    }

    public void inicia() {
        isRunning = true;
    }

    public void pausa() {
        isRunning = false;
    }
}
