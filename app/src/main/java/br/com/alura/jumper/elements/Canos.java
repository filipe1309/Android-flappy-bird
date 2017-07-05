package br.com.alura.jumper.elements;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.jumper.graphic.Tela;

/**
 * Created by filipe1309 on 04/07/17.
 */

public class Canos {

    public static final int DISTANCIA_ENTRE_CANOS = 200;
    public static final int QUANTIDADE_DE_CANOS = 5;
    private final List<Cano> canos = new ArrayList<Cano>();

    public Canos(Tela tela) {
        int posicao = 400;

        for (int i = 0; i < QUANTIDADE_DE_CANOS; i++) {
            posicao += DISTANCIA_ENTRE_CANOS;
            Cano cano = new Cano(tela, posicao);
            canos.add(cano);
        }
    }

    public void desenhaNo(Canvas canvas) {
        for (Cano cano : canos) {
            cano.desenhaNo(canvas);
        }
    }

    public void move() {
        for (Cano cano : canos) {
            cano.move();
        }
    }
}
