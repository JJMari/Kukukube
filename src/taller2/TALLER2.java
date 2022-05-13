/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TALLER2 extends JFrame {
    private Container panelContenidos;
    private JFrame ventana;
    @Override
    public void paint(Graphics g){
        super.paint(g);
    }
    
    
    
    public static void main(String[] args) {
       new TALLER2().metodoPrincipal();
    }
    
    public void metodoPrincipal(){
        ventana=new JFrame();
        ventana.setTitle(" KUKU KUBE ");
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
        
        JPanel panelinformacion = new JPanel();
        panelinformacion.setBackground(Color.BLACK);
        panelinformacion.setLayout(new GridLayout(2,2) );
        
        JPanel panelinformativo1 =new JPanel();
        JLabel nivelesPartida = new JLabel();        
        JLabel valNivelesPartida = new JLabel();
        
        JPanel panelinformativo2 =new JPanel();
        JLabel nivelesRestantes = new JLabel();
        JLabel valNivelesRestantes = new JLabel();
        
        JPanel panelinformativo3 =new JPanel();
        JLabel nivelActual = new JLabel();
        JLabel valNivelesActual = new JLabel();
        
        JPanel panelinformativo4 =new JPanel();
        JLabel puntuacion = new JLabel();
        JLabel valPuntuacion = new JLabel();
        
        
        JPanel panelVisualizacion = new JPanel();
        panelVisualizacion.setLayout(new CardLayout());        
        panelContenidos.add(panelVisualizacion,BorderLayout.CENTER);
        
        JPanel panelJuego = new JPanel();
                
       
        JPanel panelStandby = new JPanel();
        JLabel EtiquetaImagen=new JLabel();
        EtiquetaImagen.setIcon(new ImageIcon("uib.gif"));
        panelVisualizacion.add(panelStandby,"STANDBY");
        
        JSplitPane separador1 = new JSplitPane();
        JSplitPane separador2 = new JSplitPane();
        JSplitPane separador3 = new JSplitPane();

        ventana.setSize(1000, 800);
    }
}
