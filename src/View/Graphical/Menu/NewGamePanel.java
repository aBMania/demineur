package View.Graphical.Menu;

import Model.GameState.GameConstants;

import javax.swing.*;

public class NewGamePanel extends JPanel {

    private CustomGamePanel customGamePanel;

    private ButtonGroup buttonGroup;
    private JRadioButtonMenuItem beginnerRadioButton;
    private JRadioButtonMenuItem intermediateRadioButton;
    private JRadioButtonMenuItem expertRadioButton;
    private JRadioButtonMenuItem customRadioButton;

    public CustomGamePanel getCustomGamePanel() {
        return customGamePanel;
    }

    public NewGamePanel() {
        buttonGroup = new ButtonGroup();

        beginnerRadioButton = new JRadioButtonMenuItem("Beginner: " + GameConstants.BEGINNER_MINES + " mines in a " + GameConstants.BEGINNER_ROW + "x " + GameConstants.BEGINNER_COLS + " field");
        buttonGroup.add(beginnerRadioButton);
        add(beginnerRadioButton);

        intermediateRadioButton = new JRadioButtonMenuItem("Intermediate: " + GameConstants.INTERMEDIATE_MINES + " mines in a " + GameConstants.INTERMEDIATE_ROW + "x " + GameConstants.INTERMEDIATE_COLS + " field");
        buttonGroup.add(intermediateRadioButton);
        add(intermediateRadioButton);

        expertRadioButton = new JRadioButtonMenuItem("Expert: " + GameConstants.EXPERT_MINES + " mines in a " + GameConstants.EXPERT_ROW + "x " + GameConstants.EXPERT_COLS + " field");
        buttonGroup.add(expertRadioButton);
        add(expertRadioButton);

        customRadioButton =  new JRadioButtonMenuItem("Custom: ");
        buttonGroup.add(customRadioButton);
        add(customRadioButton);

        customGamePanel = new CustomGamePanel();
        add(customGamePanel);

    }
}
