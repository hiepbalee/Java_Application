package org.pnv.functions;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

public class SnapshotExample {

    public static String makePanelImage(Component panel) {
        String path = null;
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = file.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = file.getSelectedFile();
            path = selectedFile.getAbsolutePath();
            System.out.println(path);
            Dimension size = panel.getSize();
            BufferedImage image = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2 = image.createGraphics();
            panel.paint(g2);
            try {
                ImageIO.write(image, "png", new File(path+".png"));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return path;

    }
}
