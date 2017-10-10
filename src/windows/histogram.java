
package windows;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Morghen
 */


public class histogram extends javax.swing.JDialog {
    
    static public int maxVal;
    static public double coefY;
    static public Map<Integer,Integer> mapGray;
    static public int[][] gray;
            
    public histogram(java.awt.Frame parent, boolean modal,int[][] tab) {
        super(parent, modal);
        setParam(tab);
        mapGray = new TreeMap<>();
        for(int i = 0;i<256;i++)
        {
            mapGray.put(i, 0);
        }
        for(int i = 0;i<gray.length;i++)
        {
            for(int j = 0;j<gray[0].length;j++)
            {
                if(mapGray.containsKey((int)gray[i][j]))
                {
                    mapGray.replace(gray[i][j],mapGray.get(gray[i][j]) + 1);
                }
            }
        }
        // Chercher la maxVal
        maxVal = 0;
        for(int i = 0;i<mapGray.size();i++)
        {
            if(mapGray.get(i) > maxVal)
            {
                maxVal = mapGray.get(i);
            }
        }
        coefY = maxVal/510;
        initComponents();
        setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelDessin = new javax.swing.JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Creating a copy of the Graphics
                // so any reconfiguration we do on
                // it doesn't interfere with what
                // Swing is doing.
                Graphics2D g2 = (Graphics2D) g.create();
                // Drawing the image.
                int w = PanelDessin.getWidth();
                int h = PanelDessin.getHeight();
                g2.setColor(Color.BLACK);
                g2.setFont(null);
                g2.drawLine(50,10,50,h-30);
                g2.drawLine(50,h-30,w-50,h-30);
                g2.drawString("0",45,h-15);
                g2.drawString("255",w-100,h-15);
                g2.drawString(Integer.toString(maxVal),10,10);
                // Dessine les 2 axes
                int offset = 3;
                for(int i = 0;i<255;i++)
                {
                    if(mapGray.get(i) == 0)
                    {
                        offset = offset+3;
                        continue;
                    }
                    g2.drawLine(50 + offset,h-31,50 + offset,h - 31 - (int)(mapGray.get(i) / coefY));
                    offset= offset+3;
                }
                // Dessine l'histogramme
            }
        };

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Histogramme");
        setResizable(false);

        PanelDessin.setPreferredSize(new java.awt.Dimension(900, 550));

        javax.swing.GroupLayout PanelDessinLayout = new javax.swing.GroupLayout(PanelDessin);
        PanelDessin.setLayout(PanelDessinLayout);
        PanelDessinLayout.setHorizontalGroup(
            PanelDessinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        PanelDessinLayout.setVerticalGroup(
            PanelDessinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 555, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelDessin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelDessin, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(histogram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(histogram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(histogram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(histogram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                             
                histogram dialog = new histogram(new javax.swing.JFrame(), true, new int[0][0]);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    public void setParam(int[][] param) {
        gray = param;
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelDessin;
    // End of variables declaration//GEN-END:variables
}