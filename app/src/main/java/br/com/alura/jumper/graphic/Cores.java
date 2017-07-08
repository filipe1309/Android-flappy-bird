package br.com.alura.jumper.graphic;

import android.graphics.Paint;

/**
 * Created by filipe1309 on 03/07/17.
 */

public class Cores {
    public static Paint getCorDoPassaro() {
        Paint paint = new Paint();
        paint.setColor(0xFFFF0000); // ARGB
        return paint;
    }

    public static Paint getCorDoCano() {
        Paint verde = new Paint();
        verde.setColor(0xFF00FF00); // ARGB
        return verde;
    }

    public static Paint getCorDaPontuacao() {
        Paint branco = new Paint();
        branco.setColor(0xFFFFFFFF); // ARGB
        return branco;
    }
}
