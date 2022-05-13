
package taller2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TALLER2 extends JFrame implements MouseListener{
    private static Container panelContenidos;
    private static JFrame ventana;
    private  static logicaJuego logica;
    private static JLabel[][] cubos;
    private int Nivel;
    @Override
    public void paint(Graphics g){
        super.paint(g);
    }
    
    
    
    public static void main(String[] args) {
       
        logica = new logicaJuego(); 
        

       new TALLER2().metodoPrincipal();
    }
    
    public void metodoPrincipal(){
        ventana=new JFrame();
        ventana.setTitle(" KUKU KUBE ");
        int dimension=logicaJuego.getDimension();

        panelContenidos=ventana.getContentPane();

        
        inicializacion();
    }
    
    public void inicializacion(){
        
        ActionListener manipuladorEventos=new ActionListener()  { 
                @Override
                public void actionPerformed(ActionEvent evento)  { 
                        switch (evento.getActionCommand()) {
                            case "NUEVA PARTIDA": 
                           
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

        JMenu menu = new JMenu();
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
        JLabel valNivelesPartida = new JLabel(String p );
        panelinformativo1.add(nivelesPartida);
        panelinfomativo1.add(valNivelesPartida);

        
        JPanel panelinformativo2 =new JPanel();
        panelinformativo2.setLayout(new FlowLayout());
        JLabel nivelesRestantes = new JLabel("NIVELES RESTANTES");
        JLabel valNivelesRestantes = new JLabel(String v);
        panelinformativo2.add(nivelesRestantes);
        panelinfomativo2.add(valNivelesRestantes);
        
        JPanel panelinformativo3 =new JPanel();
        panelinformativo3.setLayout(new FlowLayout());
        JLabel nivelActual = new JLabel("NIVEL ACTUAL");
        JLabel valNivelActual = new JLabel(String a) ;
        panelinformativo3.add(nivelActual);
        panelinfomativo3.add(valNivelActual);
        
        JPanel panelinformativo4 =new JPanel();
        panelinformativo4.setLayout(new FlowLayout());
        JLabel puntuacion = new JLabel("PUNTUACIÓN");
        JLabel valPuntuacion = new JLabel(String b);
        panelinformativo4.add(puntuacion);
        panelinfomativo4.add(valPuntuacion);

        panelinformativo.add(panelinformativo1,BorderLayout.EAST);
        panelinformativo.add(panelinformativo2);
        panelinformativo.add(panelinformativo3);
        panelinformativo.add(panelinformativo4);

        panelSuperior.add(panelinformacion, BorderLayout.SOUTH);
        
        
        JPanel panelVisualizacion = new JPanel();
        panelContenidos.add(panelVisualizacion, BorderLayout.CENTER);
        panelVisualizacion.setLayout(new CardLayout());        
        panelContenidos.add(panelVisualizacion,BorderLayout.CENTER);
        
        JPanel panelJuego = new JPanel((new GridLayout(Dimension, Dimension)));

       
        JPanel panelStandby = new JPanel();
        JLabel EtiquetaImagen=new JLabel();
        EtiquetaImagen.setIcon(new ImageIcon("uib.gif"));
        panelVisualizacion.add(panelStandby,"STANDBY");
        
        JSplitPane separador1 = new JSplitPane();
        JSplitPane separador2 = new JSplitPane();
        JSplitPane separador3 = new JSplitPane();

        ventana.setSize(1000, 800);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        ventana.setVisible(true);
    
    private static JLabel[][] constructUi()
    {   
        int dimensionActual = logica.getDimension();

        JLabel[][] cubes = new JLabel[dimensionActual][dimensionActual];

        panelJuego.setLayout(new GridLayout(dimensionActual,dimensionActual));
        
        logica.assignNewCubeColors();
        
        populateGameBoard(cubes);
    
        logica.shuffleTargetCubeCoordinates();
        
        getTargetCube(cubes).setBackground(manager.getVariantColor());

        SwingUtilities.updateComponentTreeUI(frame);

        printTargetCubeCoordinates(cubes);

        return cubes;
    }
    private static void updateBoard() {
        clearBoard(cubes);
    }

            private static void llenarTablero(JLabel[][] cubes) {
                int dimensionActual = logica.getDimension();
                for(int i = 0; i < dimensionActual; i++) {
                    for(int j = 0;j < dimensionActual; j++) {
                        cubes[i][j] = new JLabel(i + "," + j);
                        cubes[i][j].addMouseListener(app);
                        cubes[i][j].setBackground(manager.getNormalColor());
                        panelJuego.add(cubes[i][j]);
                    }
                }
            }
}

