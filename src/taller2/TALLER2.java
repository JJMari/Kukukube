package taller2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TALLER2 extends JFrame implements MouseListener{
    private static Container panelContenidos ;
    private static JFrame ventana;
    private static logicaJuego logica;
    private static JButton[][] cubos;
    private static JPanel panelJuego;
    private  JPanel panelStandby;
    private static TALLER2 app;
    private int Nivel;
    private int Dificultad;
    int smooth;
    private int punt;
    @Override
    public void paint(Graphics g){
        super.paint(g);
    }
    
    
    
    public static void main(String[] args) {
       logica = new logicaJuego();       
       new TALLER2().metodoPrincipal();
       
    }
    
    public void metodoPrincipal(){
        app= new TALLER2();
        ventana=new JFrame();        
        ventana.setTitle(" KUKU KUBE ");

        panelContenidos=ventana.getContentPane();
        panelContenidos.setBackground(Color.BLACK);
        

        
        inicializacion();        
    }
    
    public void inicializacion(){
        
        ActionListener manipuladorEventos=new ActionListener()  { 
                @Override
                public void actionPerformed(ActionEvent evento)  { 
                        switch (evento.getActionCommand()) {
                            
                            case "NUEVA PARTIDA":panelStandby.setVisible(false);                                                 
                                                 panelJuego.setVisible(true);       
                                                 break;
                            case "SALIR"        ://Salir de la aplicación
                                                 System.exit(0);
                        }      
                }
        };
        
        JPanel panelBotones = new JPanel();
        panelBotones.setBackground(Color.BLACK);
        panelBotones.setLayout(new FlowLayout());
        
        JButton nuevaPartida = new JButton("NUEVA PARTIDA");
        nuevaPartida.setFont(new Font("arial", 0, 10));       
        nuevaPartida.setForeground(Color.white);
        nuevaPartida.setBackground(Color.black);        
        nuevaPartida.addActionListener(manipuladorEventos);
        panelBotones.add(nuevaPartida); 
        
        JButton salir = new JButton("SALIR");
        salir.setFont(new Font("arial", 0, 10));
        salir.setForeground(Color.WHITE);
        salir.setBackground(Color.BLACK);
        salir.addActionListener(manipuladorEventos);
        panelBotones.add(salir);  
        
        panelContenidos.add(panelBotones, BorderLayout.SOUTH); 
        
        
        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new GridLayout(2,1));
        panelContenidos.add(panelSuperior, BorderLayout.NORTH);
        
        JMenuBar barraMenu = new JMenuBar();
        barraMenu.setBackground(Color.LIGHT_GRAY);

        JMenu menu = new JMenu("MENÚ");
        JMenuItem nuevaPartidaMenu= new JMenuItem("NUEVA PARTIDA");
        nuevaPartidaMenu.addActionListener(manipuladorEventos);
        menu.add(nuevaPartidaMenu); 
        JMenuItem salirMenu= new JMenuItem("SALIR");
        salirMenu.addActionListener(manipuladorEventos);
        menu.add(salirMenu);
        barraMenu.add(menu);
        panelSuperior.add(barraMenu, BorderLayout.NORTH);
        
        JPanel panelinformacion = new JPanel();
        //panelinformacion.setBackground(Color.BLACK);
        panelinformacion.setLayout(new GridLayout(2,2) );
        
        JPanel panelinformativo1 =new JPanel();
        panelinformativo1.setLayout(new FlowLayout());
        JLabel nivelesPartida = new JLabel("NIVELES PARTIDA");        
        JLabel valNivelesPartida = new JLabel("000");
        valNivelesPartida.setForeground(Color.RED);
        panelinformativo1.add(nivelesPartida);
        panelinformativo1.add(valNivelesPartida);

        
        JPanel panelinformativo2 =new JPanel();
        panelinformativo2.setLayout(new FlowLayout());
        JLabel nivelesRestantes = new JLabel("NIVELES RESTANTES");
        JLabel valNivelesRestantes = new JLabel("000");
        valNivelesRestantes.setForeground(Color.RED);
        panelinformativo2.add(nivelesRestantes);
        panelinformativo2.add(valNivelesRestantes);
        
        JPanel panelinformativo3 =new JPanel();
        panelinformativo3.setLayout(new FlowLayout());
        JLabel nivelActual = new JLabel("NIVEL ACTUAL");
        JLabel valNivelActual = new JLabel("000") ;
        valNivelActual.setForeground(Color.RED);
        panelinformativo3.add(nivelActual);
        panelinformativo3.add(valNivelActual);
        
        JPanel panelinformativo4 =new JPanel();
        panelinformativo4.setLayout(new FlowLayout());
        JLabel puntuacion = new JLabel("PUNTUACIÓN");
        JLabel valPuntuacion = new JLabel("000");
        valPuntuacion.setForeground(Color.RED);
        panelinformativo4.add(puntuacion);
        panelinformativo4.add(valPuntuacion);

        panelinformacion.add(panelinformativo1);
        panelinformacion.add(panelinformativo2);
        panelinformacion.add(panelinformativo3);
        panelinformacion.add(panelinformativo4);

        panelSuperior.add(panelinformacion, BorderLayout.SOUTH);
                
        JPanel panelVisualizacion = new JPanel();
        panelContenidos.add(panelVisualizacion, BorderLayout.CENTER);        
        
        int dimensionActual = logica.getDimension();
        panelJuego = new JPanel((new GridLayout(dimensionActual,dimensionActual)));
        panelJuego.setSize(panelVisualizacion.getWidth(), panelVisualizacion.getHeight());
        cubos = constructUi();
        panelVisualizacion.add(panelJuego);
        panelJuego.setVisible(false);
       
        panelStandby = new JPanel();
        JLabel EtiquetaImagen=new JLabel();
        EtiquetaImagen.setIcon(new ImageIcon("uib.gif"));
        panelStandby.add(EtiquetaImagen);
        panelVisualizacion.add(panelStandby);
        panelStandby.setVisible(true);
        

        String[] niveles = {
            "1","2","3","4","5","6","7","8","9","10"};
        String[] dificultad ={"1","2","3","4","5"};
        String resp = (String) JOptionPane.showInputDialog(null, "SIntroduzca partidas a realizar, por defecto estará a 1",
                      "Partidas", JOptionPane.DEFAULT_OPTION, null, niveles, niveles[0]);
        String resp1 = (String) JOptionPane.showInputDialog(null, "SIntroduzca nivel de dificultad, por defecto estará a 1",
                      "Dificultad", JOptionPane.DEFAULT_OPTION, null, dificultad, dificultad[0]);   
        switch(resp){
            case "1":  Nivel=1;      break;
            case "2":  Nivel=2;      break;
            case "3":  Nivel=3;      break;
            case "4":  Nivel=4;      break;
            case "5":  Nivel=5;      break;
            case "6":  Nivel=6;      break;
            case "7":  Nivel=7;      break;
            case "8":  Nivel=8;      break;
            case "9":  Nivel=9;      break;
            case "10": Nivel=10;     break;
        }
         switch(resp1){
            case "1":  Dificultad=1;      break;
            case "2":  Dificultad=2;      break;
            case "3":  Dificultad=3;      break;
            case "4":  Dificultad=4;      break;
            case "5":  Dificultad=5;      break;
        }
         switch(Dificultad){
            case 1:  smooth=logica.getSmooth();        break;
            case 2:  smooth=logica.getSmooth()-4;      break;
            case 3:  smooth=logica.getSmooth()-7;      break;
            case 4:  smooth=logica.getSmooth()-10;     break;
            case 5:  smooth=logica.getSmooth()-15;     break;
        }
         
        

        JSplitPane separador1 = new JSplitPane();
        separador1.setOrientation(JSplitPane.VERTICAL_SPLIT);
        separador1.setTopComponent (barraMenu);
        separador1.setBottomComponent (panelinformacion);
        separador1.setDividerSize (2);
        JSplitPane separador2 = new JSplitPane();
        separador2.setOrientation (JSplitPane.VERTICAL_SPLIT);
        separador2.setTopComponent (panelinformacion);
        separador2.setBottomComponent (panelVisualizacion);
        separador2.setDividerLocation (70);
        separador2.setDividerSize (2);
        JSplitPane separador3 = new JSplitPane();
        separador3.setOrientation (JSplitPane.VERTICAL_SPLIT);
        separador3.setTopComponent (panelVisualizacion);
        separador3.setBottomComponent (panelBotones);
        separador3.setDividerSize (2);
        
        panelSuperior.add(separador1);
        panelContenidos.add(separador2);
        panelContenidos.add(separador3);
        
        ventana.setSize(1100, 950);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        ventana.setVisible(true);
         

    }//metodos para crear el juego
     private void vaciarTablero(JButton[][] cubos) {
        int dimensionActual = logica.getDimension();
            for(int i = 0; i < dimensionActual; i++) {
               for(int j = 0; j < dimensionActual; j++) {   
                    panelJuego.remove(cubos[i][j]);
                    cubos[i][j] = null;                              
                }
            }   
    }
    private static void llenarTablero(JButton[][] cubos) {
        int dimensionActual = logica.getDimension();
        for(int i = 0; i < dimensionActual; i++) {
            for(int j = 0;j < dimensionActual; j++) {
                cubos[i][j] = new JButton(i + "," + j);
                cubos[i][j].addMouseListener(app);
                cubos[i][j].setBackground(logica.getNormalColor());                
                panelJuego.add(cubos[i][j]);
            }
        }
    }
        private void actualizarTablero() {
            if(isGameOver()==false){
                JOptionPane.showMessageDialog(null, "se Acabó, has obtenido  "+punt+" puntos","Game Over!", JOptionPane.DEFAULT_OPTION, null);
                System.exit(0);
            }else
            vaciarTablero(cubos);
            logica.actualizarTamanio();
            cubos=constructUi();        
    } 
        
        
    private static JButton apuntarCubos(JButton[][] cubos) {
        int[] apuntarCubo = logica.getApuntarCubo();
        return cubos[apuntarCubo[0]][apuntarCubo[1]];
    }  
    private static void printApuntarCubos(JButton[][] cubos) {
        System.out.println(apuntarCubos(cubos).getText());
    }
    
    
     private static JButton[][] constructUi()
    {           
        int dimensionActual = logica.getDimension();

        JButton[][] cubos = new JButton[dimensionActual][dimensionActual];
        
        // Create a new GridLayout to place cubes in.
        panelJuego.setLayout(new GridLayout(dimensionActual,dimensionActual));
        
        logica.nuevosColores();
        
        llenarTablero(cubos);
    
        // Choose a new target cube.
        logica.mezclarPosicionCubo();
        
        // Subtly change the color of target cube.
        apuntarCubos(cubos).setBackground(logica.getVariantColor());

        // Force refresh UI, to ensure butts are re-rendered correctly.
        SwingUtilities.updateComponentTreeUI(panelJuego);

        // For debugging purposes, and a way to cheat ;)
        printApuntarCubos(cubos);

        return cubos;
    }
     public boolean isGameOver() {
        int dimensionActual = logica.getDimension();
        return dimensionActual > Nivel;
    }
       
    @Override
    public void mouseClicked(MouseEvent e)
    {
        JButton apuntarCubo = apuntarCubos(cubos); 
        if(e.getSource() == apuntarCubo)
        {
            actualizarTablero();
            logica.actualizarPuntuacion(punt,Dificultad);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }        
}

