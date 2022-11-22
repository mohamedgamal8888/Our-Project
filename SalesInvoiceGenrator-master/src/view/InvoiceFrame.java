package view;

import control.Controller;
import model.InvoiceHeader;
import model.Item;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class InvoiceFrame extends javax.swing.JFrame {
    public InvoiceFrame() {
        controller = new Controller(this);
        initComponents();
    }
    @SuppressWarnings("@unchecked")
    private void initComponents() {
        JScrollPane jScrollPane1 = new JScrollPane();
        InvoiceTable = new javax.swing.JTable();
        JScrollPane jScrollPane2 = new JScrollPane();
        ItemTable = new javax.swing.JTable();
        JButton newInvBtn = new JButton();
        newInvBtn.addActionListener(controller);
        JButton deleteInvBtn = new JButton();
        deleteInvBtn.addActionListener(controller);
        JButton saveItemBtn = new JButton();
        saveItemBtn.addActionListener(controller);
        JButton deleteItemBtn = new JButton();
        deleteItemBtn.addActionListener(controller);
        JLabel invNumlbl = new JLabel();
        JLabel invDatelbl = new JLabel();
        JLabel custNamelbl = new JLabel();
        JLabel invTotallbl = new JLabel();
        JLabel invTablelbl = new JLabel();
        JLabel invItemslbl = new JLabel();
        JLabel namelbl = new JLabel();
        JLabel datelbl = new JLabel();
        JLabel numlbl = new JLabel();
        JLabel totallbl = new JLabel();
        JMenuBar jMenuBar1 = new JMenuBar();
        JMenu jMenu1 = new JMenu();
        JMenuItem loadMI = new JMenuItem();
        loadMI.addActionListener(controller);
        JMenuItem saveMI = new JMenuItem();
        saveMI.addActionListener(controller);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        InvoiceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Num", "Customer", "Date", "Total"
            }
        ) {
            final boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        InvoiceTable.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(InvoiceTable);
        InvoiceTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        ItemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                    },
            new String [] {
                "Item", "Item price", "Count", "Total"
            }
        ));
        jScrollPane2.setViewportView(ItemTable);
        newInvBtn.setText("Create New Invoice");
        deleteInvBtn.setText("Delete Invoice");
        saveItemBtn.setText("Save");
        deleteItemBtn.setText("Delete");
        invNumlbl.setText("Invoice Num");
        invDatelbl.setText("Invoice Date");
        custNamelbl.setText("Customer Name");
        invTotallbl.setText("Invoice Total");
        invTablelbl.setText("Invoices Table");
        invItemslbl.setText("Invoices Items");
        namelbl.setText(".");
        datelbl.setText(".");
        numlbl.setText(".");
        totallbl.setText(".");
        jMenu1.setText("File");
        loadMI.setText("load file");
        jMenu1.add(loadMI);
        saveMI.setText("save file");
        jMenu1.add(saveMI);
        jMenuBar1.add(jMenu1);
        setJMenuBar(jMenuBar1);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(invTablelbl)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(invNumlbl)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(numlbl))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(invDatelbl)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(datelbl))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(custNamelbl)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(namelbl)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(invTotallbl)
                                        .addGap(24, 24, 24)
                                        .addComponent(totallbl))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(60, 60, 60)
                                        .addComponent(saveItemBtn)
                                        .addGap(52, 52, 52)
                                        .addComponent(deleteItemBtn))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(invItemslbl)))
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(newInvBtn)
                        .addGap(26, 26, 26)
                        .addComponent(deleteInvBtn)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(invNumlbl)
                    .addComponent(invTablelbl)
                    .addComponent(numlbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(invDatelbl)
                            .addComponent(datelbl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(custNamelbl)
                            .addComponent(namelbl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(invTotallbl)
                            .addComponent(totallbl))
                        .addGap(18, 18, 18)
                        .addComponent(invItemslbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newInvBtn)
                    .addComponent(deleteInvBtn)
                    .addComponent(saveItemBtn)
                    .addComponent(deleteItemBtn))
                .addGap(12, 12, 12))
        );
        pack();
    }
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new InvoiceFrame().setVisible(true));
    }
    protected javax.swing.JTable InvoiceTable;
    private javax.swing.JTable ItemTable;
    private final Controller controller;
    public String headerPath ;
    public String ItemPath ;
    public ArrayList <InvoiceHeader> inv ;
    public ArrayList <Item> items;
    public void loadFile() {
       JFileChooser fc1 = new JFileChooser();
        if(fc1.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
            headerPath = fc1.getSelectedFile().getPath();
            File file = new File(headerPath);
            try{
                String line;
                BufferedReader br = new BufferedReader(new FileReader(file));
              int num;
              String name;
              Date date;
             while ((line =br.readLine())!=null){
                 String[] dataRow = line.split(",");
                 num=Integer.parseInt(dataRow[0]);
                 name=dataRow[2];
                 date=new SimpleDateFormat("dd-MM-yyyy").parse((dataRow[1]));
                 InvoiceHeader header =new InvoiceHeader(num,name,date);
                 inv.add(header);
                 }
              DefaultTableModel model = (DefaultTableModel) InvoiceTable.getModel();
        Object[] rowData = new Object[4];
                for (InvoiceHeader invoiceHeader : inv) {
                    rowData[0] = invoiceHeader.getNum();
                    rowData[1] = invoiceHeader.getName();
                    rowData[2] = invoiceHeader.getDate();
                    rowData[3] = invoiceHeader.getTotal();
                    model.addRow(rowData);
                }
            } catch (IOException | ParseException ex) {
                ex.printStackTrace();
        }
        }
        JFileChooser fc2 = new JFileChooser();
        if(fc2.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
            ItemPath = fc2.getSelectedFile().getPath();
            File file2 = new File(ItemPath);
            try{
                String line2;
                BufferedReader br2 = new BufferedReader(new FileReader(file2));
                String name ;
                 int count;
                 double price;
                 while ((line2 =br2.readLine())!=null){
                     String[] dataRow2 = line2.split(",");
                     name=dataRow2[1];
                     price=Double.parseDouble(dataRow2[2]);
                     count=Integer.parseInt(dataRow2[3]);
                     Item item =new Item(name ,count ,price);
                     items.add(item);
                 }
                DefaultTableModel model2 = (DefaultTableModel) ItemTable.getModel();
                Object[] rowData2 = new Object[4];
                for (Item item : items) {
                    rowData2[0] = item.getName();
                    rowData2[1] = item.getPrice();
                    rowData2[2] = item.getCount();
                    rowData2[3] = item.getTotal();
                    model2.addRow(rowData2);
                }
            } catch (Exception ex) {
            ex.printStackTrace();
        }
}
    }
}