package br.com.alura.jumper.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

import br.com.alura.jumper.graphic.Cores;
import br.com.alura.jumper.graphic.Tela;

public class Cano {
    private static final int TAMANHO_DO_CANO = 250;
    private static final Paint VERDE = Cores.getCorDoCano();
    private static final int LARGURA_DO_CANO = 100;
    private int posicao;
    private int alturaDoCanoInferior;
    private Tela tela;
    private int alturaDoCanoSuperior;

    public Cano(Tela tela, int posicao) {
        this.tela = tela;
        alturaDoCanoInferior = tela.getAltura() - TAMANHO_DO_CANO;
        this.posicao = posicao;
        alturaDoCanoSuperior = 0 + TAMANHO_DO_CANO;
    }

    public void desenhaNo(Canvas canvas) {
        desenhaCanoSuperiorNo(canvas);
        desenhaCanoInferiorNo(canvas);
    }

    private void desenhaCanoSuperiorNo(Canvas canvas) {
        canvas.drawRect(posicao, 0, posicao + LARGURA_DO_CANO, alturaDoCanoSuperior, VERDE);
    }

    private void desenhaCanoInferiorNo(Canvas canvas) {
        canvas.drawRect(posicao, alturaDoCanoInferior, posicao + LARGURA_DO_CANO, tela.getAltura(), VERDE);
    }

    public void move() {
        this.posicao -= 5;
    }
}
