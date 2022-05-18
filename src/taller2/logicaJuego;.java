package taller2;


import java.util.Random;
import java.awt.Color;
import javax.swing.JLabel;

public final class logicaJuego{
 
    public static final int COMPONENTES_COLOR = 3;
    public static final int VALORES_RGB = 256;
    private static final int SMOOTH_LVL=30;

    private static int Dimension;
    private int Nivel;
    private final int[] apuntarCubo;
    private final Random r;
    
    private boolean partidaEmpezada;
    private Color normalColor;
    private Color variantColor;
    private final int smoothAmount;
    private JLabel ValNivelesPartida;
    private JLabel ValNivelActual;
    private JLabel ValPuntuacion;
    private JLabel ValNivelesRestantes;    

    public logicaJuego() {
        r = new Random();
        Dimension = 2;
        apuntarCubo = new int[2];
        smoothAmount = SMOOTH_LVL;        
        nuevosColores(Nivel);
    }
    public  void nuevosColores(int n) {
        int[] actualRgb = new int[3];
        int[] cambioRgb = new int[3];

        for(int i = 0; i < COMPONENTES_COLOR; i++)
        {        
            actualRgb[i] = r.nextInt(VALORES_RGB);
            if(actualRgb[i] <= 50) {
                actualRgb[i] += r.nextInt(200);
            }     
            cambioRgb[i] = actualRgb[i] - (smoothAmount-4*n);
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
    
    public void setValNivelesPartida(int n) {
        if (n < 10) {
            this.ValNivelesPartida.setText("00" + n);
        } else {
            this.ValNivelesPartida.setText("0" + n);
        }

    }

    public void setValNivelActual(int n) {
        if (n < 10) {
            this.ValNivelActual.setText("00" + n);
        } else {
            this.ValNivelActual.setText("0" + n);
        }
    }

    public String getValPuntuacion() {
        return ValPuntuacion.getText();
    }

    public void setValPuntuacion(int sumar) {
        int val = Integer.parseInt(ValPuntuacion.getText());
        val += sumar;
        if (val < 10) {
            this.ValPuntuacion.setText("00" + val);
        } else {
            this.ValPuntuacion.setText("0" + val);
        }
    }

    public void resetValPuntuacion() {
        ValPuntuacion.setText("000");
    }

    public JLabel getValNivelesRestantes() {
        return ValNivelesRestantes;
    }

    public void setValNivelesRestantes(int n) {
        if (n < 10) {
            this.ValNivelesRestantes.setText("00" + n);
        } else {
            this.ValNivelesRestantes.setText("0" + n);
        }
    }
}