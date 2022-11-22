package control;

import view.InvoiceFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    private final InvoiceFrame frame;
    public Controller(InvoiceFrame frame) {
        this.frame = frame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Create New Invoice" -> newInvoice();
            case "Delete Invoice" -> deleteInvoice();
            case "Save" -> saveItem();
            case "Delete" -> deleteItem();
            case "load file" -> frame.loadFile();
            case "save file" -> saveFile();
        }
    }
    private void newInvoice() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    private void deleteInvoice() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    private void saveItem() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    private void deleteItem() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    private void saveFile() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}