package taller2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TALLER2 extends JFrame implements MouseListener{
    private static Container panelContenidos ;
    private static JFrame ventana;
    private static logicaJuego logica;
    private static JButton[][] cubos;
    private  JPanel panelJuego;
    private  JPanel panelStandby;
    private TALLER2 app;
    private int Nivel=10;
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
        cubos = constructUi();
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
        panelinformacion.setBackground(Color.BLACK);
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
        
        int dimensionActual=logicaJuego.getDimension();
        panelJuego = new JPanel((new GridLayout(dimensionActual,dimensionActual)));
        panelJuego.setSize(panelVisualizacion.getWidth(), panelVisualizacion.getHeight());
        cubos= constructUi();
        panelVisualizacion.add(panelJuego);
        panelJuego.setVisible(false);
       
        panelStandby = new JPanel();
        JLabel EtiquetaImagen=new JLabel();
        EtiquetaImagen.setIcon(new ImageIcon("uib.gif"));
        panelStandby.add(EtiquetaImagen);
        panelVisualizacion.add(panelStandby);
        panelStandby.setVisible(true);
        
        JSplitPane separador1 = new JSplitPane();
        JSplitPane separador2 = new JSplitPane();
        JSplitPane separador3 = new JSplitPane();
        
        
        ventana.setSize(1000, 800);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        ventana.setVisible(true);
         

    }
//     private void vaciarTablero(JButton[][] cubos) {
//        int dimensionActual = logicaJuego.getDimension();
//            for(int i = 0; i < dimensionActual; i++) {
//                for(int j = 0; j < dimensionActual; j++) {   
//                    this.remove(cubos[i][j]);
//                    cubos[i][j] = null;                              
//                }
//            }   
//    }
    private void llenarTablero(JButton[][] cubos) {
        int dimensionActual = logicaJuego.getDimension();
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
//        vaciarTablero(cubos);
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
    
    
     private JButton[][] constructUi()
    {   panelJuego= new JPanel();
        
        int dimensionActual = logicaJuego.getDimension();

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
       
    @Override
    public void mouseClicked(MouseEvent e)
    {
        JButton apuntarCubo = apuntarCubos(cubos); 
        if(e.getSource() == apuntarCubo)
        {
            actualizarTablero();
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



