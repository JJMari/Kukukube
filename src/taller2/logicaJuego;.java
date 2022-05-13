package taller2;

import java.util.Random;
import java.awt.Color;

public class logicaJuego{

    public static final int MAX_SIZE = 11; 
    public static final int COMPONENTES_COLOR = 3;
    public static final int VALORES_RGB = 255;
    private static final int SMOOTH_LVL=35;

    private static int Dimension;
    private int[] apuntarCubo;
    private Random r;
    
    private Color normalColor;
    private Color variantColor;
    private int smoothAmount;    

    public logicaJuego() {
        r = new Random();
        Dimension = 2;
        apuntarCubo = new int[2];
        smoothAmount = SMOOTH_LVL;
        nuevosColores();
    }
    public void nuevosColores() {
        int[] actualRgb = new int[3];
        int[] cambioRgb = new int[3];

        for(int i = 0; i < COMPONENTES_COLOR; i++)
        {        
            actualRgb[i] = r.nextInt(VALORES_RGB);
            if(actualRgb[i] <= 50) {
                actualRgb[i] += r.nextInt(220);
            }     
            cambioRgb[i] = actualRgb[i] - smoothAmount;
        }
        
        normalColor = new Color(actualRgb[0], actualRgb[1], actualRgb[2]);
        variantColor = new Color(changedRgb[0], changedRgb[1], changedRgb[2]);
    }
    public Color getNormalColor() {
        return normalColor;
    }

    public Color getVariantColor() {
        return variantColor;
    }

    public int[] getApuntarCubo() {
        return apuntarCubo;
    }

    public static int getDimension() {
        return Dimension;
    }

    public void nextLVL() {
            Dimension++;        
    }
    public void mezclarPosicionCubo() {
        apuntarCubo[0] = r.nextInt(Dimension);
        apuntarCubo[1] = r.nextInt(Dimension);
    }

}