package com.aps.hamburgueriamaluca.graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class KitchenInterface extends JFrame {

    public static String pathImageForBoard = "/home/gustavo/Documentos/HamburgueriaMaluca/src/resources/boardNew.png";
    public static int WIDTH, HEIGHT;

    private static JLabel[][] vPosicoes;

    protected AtorJogador jogo;

    private static final long serialVersionUID = 1L;

    private JPanel jContentPane = null;

    protected boolean emRede = false;
    protected String idJ1 = "";

    // Ingredientes
    private JLabel vPosicao11;
    private JLabel vPosicao12;
    private JLabel vPosicao13;
    private JLabel vPosicao14;
    private JLabel vPosicao15;
    // Ok
    private JLabel vPosicao16;
    // avatar
    private JLabel vPosicao17;

    private JLabel vPosicao21;
    private JLabel vPosicao31;
    private JLabel vPosicao41;
    private JLabel vPosicao51;
    private JLabel vPosicao61;
    private JLabel vPosicao71;
    private JLabel vPosicao81;
    private JLabel vPosicao91;

    protected JLabel mapaVPosicao[][] = new JLabel[10][10];

    private JMenuBar jMenuBar1 = null;

    private JMenu menuJogo = null;

    private JMenuItem jMenuItem1 = null;

    private JMenuItem jMenuItem2 = null;

    private JMenuItem jMenuItem3 = null;

    private JLabel vMensagem1 = null;

    private JLabel vPlacar1 = null;

    private JLabel vMensagem2 = null;

    private JLabel vPedido = null;

    private JLabel vTurnoDoJogador = null;



    public KitchenInterface() throws HeadlessException {
        super();
        initialize();
    }

    public KitchenInterface(GraphicsConfiguration arg0) {
        super(arg0);
        initialize();
    }

    public KitchenInterface(String arg0) throws HeadlessException {
        super(arg0);
        initialize();
    }

    public KitchenInterface(String arg0, GraphicsConfiguration arg1) {
        super(arg0, arg1);
        initialize();
    }

    private void initialize() {
        this.setSize(1200, 800);
        this.setContentPane(getJContentPane());
        this.setLocation(300,200);
        this.setTitle("Ufsc - Hamburgueria Maluca");
        this.setResizable(false);
        jogo = new AtorJogador(this);
    }

    private JPanel getJContentPane() {
        Icon vazia = new ImageIcon(getClass().getResource("vazio.gif"));
        Icon cheese = new ImageIcon(getClass().getResource("cheese.gif"));
        Icon meat = new ImageIcon(getClass().getResource("meat.gif"));
        Icon chicken = new ImageIcon(getClass().getResource("chicken.gif"));
        Icon tomato = new ImageIcon(getClass().getResource("tomato.gif"));
        Icon letuce = new ImageIcon(getClass().getResource("letuce.gif"));
        try {
            BufferedImage bufferedImage = ImageIO.read(new File(pathImageForBoard));
            WIDTH = bufferedImage.getWidth();
            HEIGHT = bufferedImage.getHeight();
            jContentPane = new JPanel();
            jContentPane.setLayout(null);
            int[]pixels = new int[WIDTH * HEIGHT];
            vPosicoes = new JLabel[WIDTH][HEIGHT];
            bufferedImage.getRGB(0,0, bufferedImage.getWidth(), bufferedImage.getHeight(), pixels, 0, bufferedImage.getWidth());
            for (int i = 0; i < bufferedImage.getWidth(); i++){
                for (int j = 0; j < bufferedImage.getHeight(); j++) {
                    int pixelToAnalyze = pixels[i + (j * bufferedImage.getWidth())];
                    if(pixelToAnalyze == -61952) {
                        JLabel jLabel = new JLabel();
                        jLabel.setBounds(new Rectangle(20 + (i *70),600 - (70 *j),70,70));
                        jLabel.setIcon(vazia);
                        jContentPane.add(jLabel,null);
                        mapaVPosicao[i][j] = jLabel;
//                        vPosicoes[i][j] = jLabel;
                    } else if (pixelToAnalyze == -65282) {
                        JLabel jLabel = new JLabel();
                        jLabel.setBounds(new Rectangle(20 + (i *70),600 - (70 *j),70,70));
                        jLabel.setIcon(cheese);
                        jContentPane.add(jLabel,null);
                        mapaVPosicao[i][j] = jLabel;
                    } else if (pixelToAnalyze == -16121736) {
                        JLabel jLabel = new JLabel();
                        jLabel.setBounds(new Rectangle(20 + (i *70),600 - (70 *j),70,70));
                        jLabel.setIcon(meat);
                        jContentPane.add(jLabel,null);
                        mapaVPosicao[i][j] = jLabel;
                    } else if (pixelToAnalyze == -327928) {
                        JLabel jLabel = new JLabel();
                        jLabel.setBounds(new Rectangle(20 + (i *70),600 - (70 *j),70,70));
                        jLabel.setIcon(tomato);
                        jContentPane.add(jLabel,null);
                        mapaVPosicao[i][j] = jLabel;
                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jContentPane;

    }

    private JPanel getJContentPane2() {
        if(jContentPane == null) {

            Icon vazia = new ImageIcon(getClass().getResource("vazio.gif"));

            Icon cheese = new ImageIcon(getClass().getResource("cheese.gif"));

            Icon meat = new ImageIcon(getClass().getResource("meat.gif"));

            Icon chicken = new ImageIcon(getClass().getResource("chicken.gif"));

            Icon tomato = new ImageIcon(getClass().getResource("tomato.gif"));

            Icon letuce = new ImageIcon(getClass().getResource("letuce.gif"));

            Icon ok = new ImageIcon(getClass().getResource("thumbup.gif"));

            //Avatar
            Icon chef = new ImageIcon(getClass().getResource("chef.gif"));

            //Montagem
            Icon bread1 = new ImageIcon(getClass().getResource("bread1.gif"));
            Icon bread2 = new ImageIcon(getClass().getResource("bread2.gif"));
            Icon cheese2 = new ImageIcon(getClass().getResource("cheese2.gif"));
            Icon chicken2 = new ImageIcon(getClass().getResource("chicken1.gif"));
            Icon meat2 = new ImageIcon(getClass().getResource("meat1.gif"));
            Icon letuce2 = new ImageIcon(getClass().getResource("letuce1.gif"));
            Icon tomato2 = new ImageIcon(getClass().getResource("tomato1.gif"));

            vMensagem1 = new JLabel();
            vMensagem1.setBounds(new Rectangle(25,10,150,20));
            vMensagem1.setText("Jogador: ");

            vPlacar1 = new JLabel();
            vPlacar1.setBounds(new Rectangle(300,10,150,20));
            vPlacar1.setText("Partidas Vencidas: ");

            vMensagem2 = new JLabel();
            vMensagem2.setBounds(new Rectangle(25,30,150,20));
            vMensagem2.setText("Adversário: ");

            vPedido = new JLabel();
            vPedido.setBounds(new Rectangle(25,80,500,20));
            vPedido.setText("Queijo, Queijo, Carne, Frango, Queijo, Carne, Tomate");

            vTurnoDoJogador = new JLabel();
            vTurnoDoJogador.setBounds(new Rectangle(500, 80 ,150,20));
            vTurnoDoJogador.setText("Turno: Jogador 1");

            vPosicao11 = new JLabel();
            vPosicao11.setBounds(new Rectangle(20,600,70,70));
            vPosicao11.setIcon(cheese);
            vPosicao11.addKeyListener(
                    new java.awt.event.KeyListener() {
                          @Override
                          public void keyTyped(KeyEvent e) {

                          }
                          @Override
                          public void keyPressed(KeyEvent e) {
                              if (e.getKeyCode() == KeyEvent.VK_Q) {
                                      System.out.println("Q");
                              } else {
                                      System.out.println("não é q");
                              }
                          }
                          @Override
                          public void keyReleased(KeyEvent e) {

                          }
                    }
            );

            vPosicao12 = new JLabel();
            vPosicao12.setBounds(new Rectangle(90,600,70,70));
            vPosicao12.setIcon(meat);
            vPosicao13 = new JLabel();
            vPosicao13.setBounds(new Rectangle(160,600,70,70));
            vPosicao13.setIcon(chicken);

            vPosicao14 = new JLabel();
            vPosicao14.setBounds(new Rectangle(230,600,70,70));
            vPosicao14.setIcon(tomato);

            vPosicao15 = new JLabel();
            vPosicao15.setBounds(new Rectangle(300,600,70,70));
            vPosicao15.setIcon(letuce);

            vPosicao16 = new JLabel();
            vPosicao16.setBounds(new Rectangle(370,600,70,70));
            vPosicao16.setIcon(ok);

            vPosicao17 = new JLabel();
            vPosicao17.setBounds(new Rectangle(500,310,500,360));
            vPosicao17.setIcon(chef);

            vPosicao21 = new JLabel();
            vPosicao21.setBounds(new Rectangle(90,500,210,70));
            vPosicao21.setIcon(bread1);



            vPosicao31 = new JLabel();
            vPosicao31.setBounds(new Rectangle(90,450,210,70));
            vPosicao31.setIcon(cheese2);

            vPosicao41 = new JLabel();
            vPosicao41.setBounds(new Rectangle(98,430,210,35));
            vPosicao41.setIcon(chicken2);

            vPosicao51 = new JLabel();
            vPosicao51.setBounds(new Rectangle(90,400,210,35));
            vPosicao51.setIcon(letuce2);

            vPosicao61 = new JLabel();
            vPosicao61.setBounds(new Rectangle(90,370,210,30));
            vPosicao61.setIcon(tomato2);

            vPosicao71 = new JLabel();
            vPosicao71.setBounds(new Rectangle(90,340,210,30));
            vPosicao71.setIcon(bread2);

            vPosicao81 = new JLabel();
            vPosicao81.setBounds(new Rectangle(160,530,70,70));
            vPosicao81.setIcon(vazia);

            vPosicao91 = new JLabel();
            vPosicao91.setBounds(new Rectangle(160,600,70,70));
            vPosicao91.setIcon(vazia);

            jContentPane = new JPanel();
            jContentPane.setLayout(null);
            jContentPane.add(vPosicao11, null);
            jContentPane.add(vPosicao12, null);
            jContentPane.add(vPosicao13, null);
            jContentPane.add(vPosicao14, null);
            jContentPane.add(vPosicao15, null);
            jContentPane.add(vPosicao16, null);
            jContentPane.add(vPosicao17, null);

            jContentPane.add(vPosicao21, null);
            jContentPane.add(vPosicao31, null);
            jContentPane.add(vPosicao41, null);
            jContentPane.add(vPosicao51, null);
            jContentPane.add(vPosicao61, null);
            jContentPane.add(vPosicao71, null);
//            jContentPane.add(vPosicao81, null);
//            jContentPane.add(vPosicao91, null);

            mapaVPosicao[0][0] =vPosicao11;
            mapaVPosicao[0][1] =vPosicao12;
            mapaVPosicao[0][2] =vPosicao13;
            mapaVPosicao[0][3] =vPosicao14;
            mapaVPosicao[0][4] =vPosicao15;
            mapaVPosicao[0][5] = vPosicao16;
            mapaVPosicao[0][6] = vPosicao17;

            mapaVPosicao[1][0] =vPosicao21;
            mapaVPosicao[2][0] =vPosicao31;
            mapaVPosicao[3][0] =vPosicao41;
            mapaVPosicao[4][0] =vPosicao51;
            mapaVPosicao[5][0] =vPosicao61;
            mapaVPosicao[6][0] =vPosicao71;
//            mapaVPosicao[7][0] =vPosicao81;
//            mapaVPosicao[8][0] =vPosicao91;

            jContentPane.add(vMensagem1, null);
            jContentPane.add(vPlacar1, null);
            jContentPane.add(vMensagem2, null);

            jContentPane.add(vPedido, null);
            jContentPane.add(vTurnoDoJogador, null);


        }
        return jContentPane;
    }

}
