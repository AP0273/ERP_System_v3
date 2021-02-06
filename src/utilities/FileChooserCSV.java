package utilities;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooserCSV {
    public String getCsvPath() {
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Selecione o Arquivo csv","csv");
        fc.setFileFilter(filter);
        int rt = fc.showOpenDialog(null);

        if(rt == JFileChooser.APPROVE_OPTION && fc.getSelectedFile().getPath().endsWith(".csv")) {
            return fc.getSelectedFile().getAbsolutePath();
        }else{
            return "Error";
        }
    }
}
