package uml.graphic.component.dialog;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import af.swing.layout.AfYLayout;
import uml.graphic.component.umlobject.diagram.Diagram;

public class RenameDialog extends JDialog {

    private final Dimension size = new Dimension(250, 110);

    public RenameDialog(final Component parent, final Diagram target) {
        setLayout(new AfYLayout());
        setLocationRelativeTo(parent);
        final Point currentPos = getLocation();
        setBounds(currentPos.x - size.width / 2, currentPos.y - size.height / 2, size.width, size.height);
        setResizable(false);
        setTitle("Rename Diagram '" + target.getText() + "'");
        final JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("New Name: "));
        final JTextField inputTextField = new JTextField(12);
        inputPanel.add(inputTextField);
        final JPanel buttonPanel = new JPanel();
        final JButton buttonOK = new JButton("OK");
        final JButton buttonCancel = new JButton("Cancel");
        Arrays.asList(buttonOK, buttonCancel).forEach(btn -> {
            btn.setPreferredSize(new Dimension(80, 20));
            btn.setBackground(Color.WHITE);
            btn.setBorder(BorderFactory.createRaisedBevelBorder());
            btn.setFocusPainted(false);
        });
        getRootPane().setDefaultButton(buttonOK);
        buttonPanel.add(buttonOK);
        buttonPanel.add(Box.createHorizontalStrut(10));
        buttonPanel.add(buttonCancel);
        inputTextField.setDocument(new PlainDocument() {
            @Override
            public void insertString(final int offs, final String str, final AttributeSet a)
                    throws BadLocationException {
                if (str != null && (getLength() + str.length() < 12))
                    super.insertString(offs, str, a);
            }
        });
        buttonOK.addActionListener(l -> {
            target.rename(inputTextField.getText());
            dispose();
        });
        buttonCancel.addActionListener(l -> dispose());
        add(inputPanel, "30px");
        add(buttonPanel, "50px");
        setVisible(true);
    }
}
