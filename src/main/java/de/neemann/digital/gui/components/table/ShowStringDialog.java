/*
 * Copyright (c) 2016 Helmut Neemann
 * Use of this source code is governed by the GPL v3 license
 * that can be found in the LICENSE file.
 */
package de.neemann.digital.gui.components.table;

import de.neemann.gui.Screen;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;

/**
 * Shows a simple string
 */
public class ShowStringDialog extends JDialog {

    /**
     * Creates a new instance
     *
     * @param parent the parent
     * @param title  the dialog title
     * @param str    the text to show
     */
    public ShowStringDialog(JFrame parent, String title, String str) {
        super(parent, title);
        init(parent, str, false);
    }

    /**
     * Creates a new instance
     *
     * @param parent the parent
     * @param title  the dialog title
     * @param str    the text to show
     */
    public ShowStringDialog(JDialog parent, String title, String str) {
        this(parent, title, str, false);
    }

    /**
     * Creates a new instance
     *
     * @param parent the parent
     * @param title  the dialog title
     * @param str    the text to show
     * @param html   is the string a html string?
     */
    public ShowStringDialog(Window parent, String title, String str, boolean html) {
        super(parent, title, ModalityType.APPLICATION_MODAL);
        init(parent, str, html);
    }

    private void init(Window parent, String str, boolean html) {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JTextComponent textComp;
        if (html) {
            textComp = new JEditorPane("text/html", str);
            textComp.setCaretPosition(0);
            textComp.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, true);
            textComp.setPreferredSize(Screen.getInstance().scale(new Dimension(600, 800)));
        } else {
            textComp = new JTextArea(str);
            textComp.setFont(new JLabel().getFont());
        }
        textComp.setEditable(false);
        textComp.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        getContentPane().add(new JScrollPane(textComp));

        pack();
        setLocationRelativeTo(parent);
    }
}
