package View.Graphical.GamePanel;

import javax.swing.*;
import java.awt.*;

public class NewGamePanel extends JPanel {

    private CustomGamePanel customGamePanel;

    private ButtonGroup buttonGroup;
    private JRadioButtonMenuItem beginnerRadioButton;
    private JRadioButtonMenuItem intermediateRadioButton;
    private JRadioButtonMenuItem expertRadioButton;
    private JRadioButtonMenuItem customRadioButton;

    public NewGamePanel() {
        buttonGroup = new ButtonGroup();

        beginnerRadioButton = new JRadioButtonMenuItem("Beginner: 10 mines in a 9x9 field");
        buttonGroup.add(beginnerRadioButton);
        add(beginnerRadioButton);

        intermediateRadioButton = new JRadioButtonMenuItem("Intermediate: 40 mines in a 16x16 field");
        buttonGroup.add(intermediateRadioButton);
        add(intermediateRadioButton);

        expertRadioButton = new JRadioButtonMenuItem("Expert: 99 mines in a 16x30 field");
        buttonGroup.add(expertRadioButton);
        add(expertRadioButton);

        customRadioButton = new JRadioButtonMenuItem("Custom: ");
        buttonGroup.add(customRadioButton);
        add(customRadioButton);

        customGamePanel = new CustomGamePanel();
        add(customGamePanel);

    }
}
