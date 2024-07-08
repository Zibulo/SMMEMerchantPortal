package za.co.vodacom.fileUploadHandler;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Properties;

public class fileupload {


    public void handleFileDialog(String filePath) {
        try {
            Robot paste = new Robot();
            paste.delay(1000);

            StringSelection stringSelection = new StringSelection(filePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

            paste.keyPress(KeyEvent.VK_CONTROL);
            paste.keyPress(KeyEvent.VK_V);
            paste.keyRelease(KeyEvent.VK_V);
            paste.keyRelease(KeyEvent.VK_CONTROL);

            paste.keyPress(KeyEvent.VK_ENTER);
            paste.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}


