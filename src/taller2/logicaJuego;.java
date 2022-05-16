package taller2;

import java.util.Random;
import java.awt.Color;

/**
 * Manages the entire game state, including turns played, the colors of various cubes, grid dimensions, and game difficulty.
 */

public final class logicaJuego{
    
public static final int MAX_SIZE = 11; 
public static final int COMPONENTES_COLOR = 3;
public static final int VALORES_RGB = 256;
private static final int SMOOTH_LVL=30;

private int Dimension;
private final int[] apuntarCubo;
private final Random r;

private Color normalColor;
private Color variantColor;
private final int smoothAmount;    

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
            actualRgb[i] += r.nextInt(200);
        }     
        cambioRgb[i] = actualRgb[i] - smoothAmount;
    }
    
    normalColor = new Color(actualRgb[0], actualRgb[1], actualRgb[2]);
    variantColor = new Color(cambioRgb[0], cambioRgb[1], cambioRgb[2]);
}
public Color getNormalColor() {
    return normalColor;
}
public Color getVariantColor() {
    return variantColor;
}
public int getSmooth(){
    return smoothAmount;
}
public int[] getApuntarCubo() {
    return apuntarCubo;
}
public int getDimension() {
    return Dimension;
}
public void mezclarPosicionCubo() {
    apuntarCubo[0] = r.nextInt(Dimension);
    apuntarCubo[1] = r.nextInt(Dimension);
}
public void actualizarTamanio(){
    Dimension++;
}
public void actualizarPuntuacion(int p,int n){
    p+=(p+20)*n;
}
}