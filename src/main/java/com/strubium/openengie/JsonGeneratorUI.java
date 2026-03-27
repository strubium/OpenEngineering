package com.strubium.openengie;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;

public class JsonGeneratorUI {

    private static final String BLOCKSTATE_TEMPLATE = "{\"variants\":{\"normal\":{\"model\":\"%s:%%s\"}}}";
    private static final String BLOCK_MODEL_TEMPLATE = "{\"parent\":\"block/cube_all\",\"textures\":{\"all\":\"%s:blocks/%%s\"}}";
    private static final String ITEM_MODEL_TEMPLATE = "{\"parent\":\"%s:block/%%s\"}";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JsonGeneratorUI::createUI);
    }

    private static void createUI() {
        JFrame frame = new JFrame("Minecraft JSON Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(2, 2));

        JTextField modIdField = new JTextField("openengie");
        JTextField blockNameField = new JTextField("ore_aluminum");

        inputPanel.add(new JLabel("Mod ID:"));
        inputPanel.add(modIdField);
        inputPanel.add(new JLabel("Block Name:"));
        inputPanel.add(blockNameField);

        JTextArea outputArea = new JTextArea();
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(outputArea);

        JButton generateButton = new JButton("Generate");
        JButton copyButton = new JButton("Copy to Clipboard");

        generateButton.addActionListener(e -> {
            String modId = modIdField.getText().trim();
            String block = blockNameField.getText().trim();

            String blockstate = String.format(BLOCKSTATE_TEMPLATE, modId).replace("%s", block);
            String blockModel = String.format(BLOCK_MODEL_TEMPLATE, modId).replace("%s", block);
            String itemModel = String.format(ITEM_MODEL_TEMPLATE, modId).replace("%s", block);

            String result = "Blockstate:\n" + blockstate + "\n\n"
                    + "Block Model:\n" + blockModel + "\n\n"
                    + "Item Model:\n" + itemModel;

            outputArea.setText(result);
        });

        copyButton.addActionListener(e -> {
            StringSelection selection = new StringSelection(outputArea.getText());
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(generateButton);
        buttonPanel.add(copyButton);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}

