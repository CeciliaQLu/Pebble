import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.HashSet;

public class GUI extends JFrame {

    static String[] preferredFonts = {"Arial", "Times New Roman"};
    JPanel ButtonPanel;
    JPanel panel;
    Border border;
    BoardCanvas canvas;
    int heightBoard;

    int topLeft_x = 20;
    int topLeft_y = 20;
    int rowheight;
    int firstRowWidth;

    public GUI(){
        super("Pebble");

        ButtonPanel = new JPanel();
        ButtonPanel.setLayout(new GridLayout(1, 5));
        JButton newGame = new JButton("New Game");
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setRowNumber();
            }
        });
        JButton instruction = new JButton("Instruction");
        ButtonPanel.add(newGame);
        ButtonPanel.add(instruction);

        add(ButtonPanel, BorderLayout.NORTH);


        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        border = BorderFactory.createCompoundBorder(BorderFactory
                .createEmptyBorder(10, 10, 10, 10), BorderFactory
                .createLineBorder(Color.white));
        panel.setBorder(border);

        canvas = new BoardCanvas();

        panel.add(canvas);
        add(panel, BorderLayout.CENTER);

        setFocusable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        setResizable(false);
    }


    private class BoardCanvas extends Canvas {
        /**
         * Font.
         */
        private Font font;

        /**
         * A constructor.
         * When constructing a board canvas, initialise a Board object and MazeRenderer object.
         */
        public BoardCanvas() {
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int height1 = screenSize.height * 9 / 14;
            int remainNum = height1 % 9;
            heightBoard = height1 - remainNum;
            rowheight = heightBoard/12;
            firstRowWidth = rowheight * 6;
            setBounds(0, 0, heightBoard, heightBoard);
            GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
            HashSet<String> availableNames = new HashSet();
            for (String name : env.getAvailableFontFamilyNames()) {
                availableNames.add(name);
            }
            for (String pf : preferredFonts) {
                if (availableNames.contains(pf)) {
                    font = new Font(pf, Font.PLAIN, 20);
                    break;
                }
            }
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            drawPebbleBoard(g);
        }

        public void drawPebbleBoard(Graphics g){
            for(int i = 0; i < 6; i++){
                g.setColor(new Color(255, 222, 173));
                g.fillRect(topLeft_x, topLeft_y + i * rowheight, firstRowWidth + i * rowheight, rowheight);
                g.setColor(Color.BLACK);
                g.drawRect(topLeft_x, topLeft_y + i * rowheight, firstRowWidth + i * rowheight, rowheight);
                for(int j = 0; j < i + 6; j++){
                    drawDish(g, topLeft_x + rowheight * j, topLeft_y + i * rowheight);
                }
            }

        }

        // x: top left x of pebbles' outside rectangle
        public void drawDish(Graphics g, int x, int y){
            g.setColor(new Color(255, 250, 205));
            g.fillOval(x + 2, y + rowheight/6, rowheight - 4, rowheight * 2 / 3);
            g.setColor(new Color(255, 248, 220));
            g.drawOval(x + 2, y + rowheight/6, rowheight - 4, rowheight * 2 / 3);
        }
    }

    public void setRowNumber(){
        JFrame rowNumber = new JFrame();
        
    }

    public static void main(String[] args) {
        GUI gui = new GUI();
    }
}
