package br.com.alura.jumper.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

import br.com.alura.jumper.graphic.Cores;
import br.com.alura.jumper.graphic.Tela;

public class Passaro {

    private static final float X = 100;
    private static final float RAIO = 50;
    private static final Paint VERMELHO = Cores.getCorDoPassaro();
    private float altura;
    private Tela tela;

    public Passaro(Tela tela) {
        this.tela = tela;
        this.altura = 100;
    }

    public void desenhaNoCanvas(Canvas canvas) {
        canvas.drawCircle(X, altura, RAIO, VERMELHO);
    }

    public void cai() {
        boolean chegouNoChao = altura + RAIO > tela.getAltura();

        if (!chegouNoChao) {
            this.altura += 5;
        }
    }

    public void pula() {
        if (altura - RAIO > 0) {
            this.altura -= 150;
        }
    }
}
