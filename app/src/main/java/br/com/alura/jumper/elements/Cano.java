package br.com.alura.jumper.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

import br.com.alura.jumper.graphic.Cores;
import br.com.alura.jumper.graphic.Tela;

/**
 * Created by filipe1309 on 03/07/17.
 */

public class Cano {
    private static final int TAMANHO_DO_CANO = 250;
    private static final Paint VERDE = Cores.getCorDoCano();
    private static final int LARGURA_DO_CANO = 100;
    private int posicao;
    private int alturaDoCanoInferior;
    private Tela tela;

    public Cano(Tela tela, int posicao) {
        this.tela = tela;
        alturaDoCanoInferior = tela.getAltura() - TAMANHO_DO_CANO;
        this.posicao = posicao;
    }

    public void desenhaNo(Canvas canvas) {
        desenhaCanoInferiorNo(canvas);
    }

    private void desenhaCanoInferiorNo(Canvas canvas) {
        canvas.drawRect(posicao, alturaDoCanoInferior, posicao + LARGURA_DO_CANO, tela.getAltura(), VERDE);
    }

    public void move() {
        this.posicao -= 5;
    }
}
