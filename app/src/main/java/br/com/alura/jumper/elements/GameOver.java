package br.com.alura.jumper.elements;

import android.graphics.Canvas;
import android.graphics.Paint;
import br.com.alura.jumper.graphic.Cores;
import br.com.alura.jumper.graphic.Tela;

public class GameOver {
    private static final Paint VERMELHO = Cores.getCorDoGameOver();
    private Tela tela;

    public GameOver(Tela tela) {
        this.tela = tela;
    }

    public void desenhaNo(Canvas canvas) {
        String gameOver = "Game Over";
        canvas.drawText(gameOver, 0, tela.getAltura()/2, VERMELHO);
    }
}
