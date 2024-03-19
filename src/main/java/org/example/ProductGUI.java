package org.example;

import com.google.gson.Gson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.table.DefaultTableModel;

public class ProductGUI extends JFrame {

    private static ArrayList<Product> list = new ArrayList<>();
    private static ArrayList<String> productsToTrack;
    private DefaultTableModel tableModel;
    private ScheduledExecutorService executorService;
    private boolean showAlerts = true;

    public ProductGUI() {
        setTitle("Product List");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();
        startDataUpdater();
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout());

        tableModel = new DefaultTableModel(
                new String[]{"Name", "Price", "Sell Price"}, 0);

        productsToTrack = new ArrayList<>(Arrays.asList(BazaarProducts.ENCHANTED_COBBLESTONE.toString()));

        for(String a: productsToTrack){
            System.out.println("BAZAAR PRODUCTS: " + a);
        }

        updateTableData();

        JTable productTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(productTable);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(e -> {
            list.clear();
            updateTableData();
        });
        mainPanel.add(refreshButton, BorderLayout.SOUTH);

        JCheckBox alertCheckBox = new JCheckBox("Show Alerts", true);
        alertCheckBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                showAlerts = true;
            } else {
                showAlerts = false;
            }
        });
        mainPanel.add(alertCheckBox, BorderLayout.NORTH);

        getContentPane().add(mainPanel);
    }

    private void updateTableData() {
        HypixelApi api = new HypixelApi();
        String result = api.sendAsync(HttpMethod.GET, Urls.BAZAAR.toString(), null);
        Gson gson = new Gson();
        ProductData data = gson.fromJson(result, ProductData.class);

        for (Map.Entry<String, ProductData.Product> entry : data.getProducts().entrySet()) {
            if (productsToTrack.contains(entry.getKey())) {
                Product product = new Product(entry.getValue().getProduct_id(), entry.getValue().getBuy_summary().get(0).getPricePerUnit(), entry.getValue().getSell_summary().get(0).getPricePerUnit());

                for (BazaarProducts enumValue : BazaarProducts.values()) {
                    if(enumValue.getText().equals(entry.getKey())){
                        product.setDesiredBuyPrice(enumValue.getDesiredBuyPrice());
                        product.setDesiredSellPrice(enumValue.getDesiredSellPrice());
                    }
                }
                list.add(product);

                if (showAlerts && product.getSellPrice() > product.getDesiredSellPrice()) {
                    JOptionPane.showMessageDialog(this, "Sell Price of " + product.getName() + " is more than " + product.getDesiredSellPrice() + "!");
                }
            }
        }

        tableModel.setRowCount(0);

        for (Product product : list) {
            tableModel.addRow(new Object[]{product.getName(), product.getBuyPrice(), product.getSellPrice()});
        }
    }

    private void startDataUpdater() {
        executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(() -> updateTableData(), 60, 60, TimeUnit.SECONDS);
    }

    public static void run() {
        SwingUtilities.invokeLater(() -> {
            ProductGUI productGUI = new ProductGUI();
            productGUI.setVisible(true);
        });
    }
}
