import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class SimpleDialog extends JFrame {
    static int width = 800;
    static int height = 600;
    static int clientWidth;
    static int clientHeight;
    public JPanel panel;

    public SimpleDialog() {
        super("simple dialog");
        try {
            initGui();
        } catch (IOException ignored) {
            System.out.println("initGui error");
        }
    }
    private void initGui() throws IOException {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(SimpleDialog.width, SimpleDialog.height));
        this.setLocation(d.width / 2 - SimpleDialog.width / 2, d.height / 2 - SimpleDialog.height / 2);
        this.getContentPane().setBackground(Color.lightGray);
        this.setResizable(false);

        panel = new JPanel();
        panel.setBackground(Color.lightGray);
        panel.setFocusable(true);
        panel.setLayout(null);
        this.getContentPane().add(panel);

        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (e.getKeyChar() == KeyEvent.VK_SPACE) {
                    JOptionPane.showMessageDialog(null, "Andrei");
                }
            }
        });
    }

    public void setVisible(boolean b) {
        super.setVisible(b);
        clientWidth = SimpleDialog.width;
        clientHeight = SimpleDialog.height;
        if (isResizable()) {
            clientWidth = getContentPane().getWidth();
            clientHeight = getContentPane().getHeight();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SimpleDialog frame = new SimpleDialog();
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
