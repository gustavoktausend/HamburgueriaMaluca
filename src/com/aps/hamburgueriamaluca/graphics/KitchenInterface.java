package com.aps.hamburgueriamaluca.graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class KitchenInterface extends JFrame {

    public static String pathImageForBoard = "/home/gustavo/Documentos/HamburgueriaMaluca/src/resources/boardNew.png";
    public static int WIDTH, HEIGHT;

    Icon vazia = new ImageIcon(getClass().getResource("vazio.gif"));
    Icon cheese = new ImageIcon(getClass().getResource("cheese.gif"));
    Icon meat = new ImageIcon(getClass().getResource("meat.gif"));
    Icon chicken = new ImageIcon(getClass().getResource("chicken.gif"));
    Icon tomato = new ImageIcon(getClass().getResource("tomato.gif"));
    Icon letuce = new ImageIcon(getClass().getResource("letuce.gif"));
    Icon ok = new ImageIcon(getClass().getResource("thumbup.gif"));
    Icon playerPos = new ImageIcon(getClass().getResource("playerposition.gif"));
    Icon oppPos = new ImageIcon(getClass().getResource("opponentposition.gif"));

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

    protected AtorJogador jogo;

    private static final long serialVersionUID = 1L;

    private JPanel jContentPane = null;

    protected boolean emRede = false;
    protected String idJ1 = "";

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
        try {
            BufferedImage bufferedImage = ImageIO.read(new File(pathImageForBoard));
            WIDTH = bufferedImage.getWidth();
            HEIGHT = bufferedImage.getHeight();
            jContentPane = new JPanel();
            jContentPane.setLayout(null);
            writePlayerHeader("Fulano");
            writeOpponentHeader("Aderbal");
            writeGameTitle();
            writePlayerPosition();
            writeOpponentPosition();
            int[]pixels = new int[WIDTH * HEIGHT];
            bufferedImage.getRGB(0,0, bufferedImage.getWidth(), bufferedImage.getHeight(), pixels, 0, bufferedImage.getWidth());
            for (int i = 0; i < bufferedImage.getWidth(); i++){
                for (int j = 0; j < bufferedImage.getHeight(); j++) {
                    // Escrita a partir do bufferedImage
                    switch (pixels[i + (j * bufferedImage.getWidth())]) {
                        // Vermelho
                        case -61952 ->
                            writeNewSquareForBoard(new Rectangle(20 + (i *70),600 - (70 *j),70,70), vazia);
                        // Rosa
                        case -65282 ->
                            writeNewSquareForBoard(new Rectangle(20 + (i *70),600 - (70 *j),70,70), cheese);
                        // Azul Marinho
                        case -16121736 ->
                            writeNewSquareForBoard(new Rectangle(20 + (i *70),600 - (70 *j),70,70), meat);
                        // Amarelo
                        case -327928 ->
                            writeNewSquareForBoard(new Rectangle(20 + (i *70),600 - (70 *j),70,70), tomato);
                        default -> {
                        }
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return jContentPane;
    }

    private void writeGameTitle() {
        Font font = new Font("Titulo", Font.BOLD, 22);
        JLabel titleLabel = new JLabel();
        titleLabel.setBounds(new Rectangle(20,20,370,40));
        titleLabel.setFont(font);
        titleLabel.setText("HAMBURGUERIA MALUCA");
        jContentPane.add(titleLabel, null);

    }

    private void writeNewSquareForBoard(Rectangle rectangle, Icon icon) {
        JLabel jLabel = new JLabel();
        jLabel.setBounds(rectangle);
        jLabel.setIcon(icon);
        jContentPane.add(jLabel, null);
    }

    private void writePlayerHeader(String playerName) {
        JLabel jogadorLabel = new JLabel();
        jogadorLabel.setBounds(new Rectangle(20,150,150,20));
        jogadorLabel.setText("Jogador: " + playerName);
        jContentPane.add(jogadorLabel, null);
    }

    private void writeOpponentHeader(String playerName) {
        JLabel jogadorLabel = new JLabel();
        jogadorLabel.setBounds(new Rectangle(370,150,150,20));
        jogadorLabel.setText("Oponente: " + playerName);
        jContentPane.add(jogadorLabel, null);
    }

    private void writePlayerPosition() {
        writeNewSquareForBoard(new Rectangle(20 ,600 ,70,70), playerPos);
    }

    private void writeOpponentPosition() {
        writeNewSquareForBoard(new Rectangle(90 ,600 ,70,70), oppPos);
    }

}
