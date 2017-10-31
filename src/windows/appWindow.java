/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windows;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import traitements.*;

/**
 *
 * @author Morghen
 */
public class appWindow extends javax.swing.JFrame {

    public traitementImage imgTrt;
    public BufferedImage imageDep;
    public File fichierSource;
    public String lastDirectoryUsed;
    public int etatVar;
    public int X1;
    public int Y1;
    public int X2;
    public int Y2;
    public Color ColorBefore;
    
    public appWindow() {
        initComponents();
        imgTrt = new traitementImage();
        imageDep = null;
        fichierSource = null;
        lastDirectoryUsed=null;
        fermerImage.setEnabled(false);
        sauverImage.setEnabled(false);
        etatVar=1;
        X1=0;
        X2=0;
        Y1=0;
        Y2=0;
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GroupageBouttonOutils = new javax.swing.ButtonGroup();
        imageDepSP = new javax.swing.JScrollPane();
        imageDepPanel = new javax.swing.JPanel();
        imageLabelG = new javax.swing.JLabel();
        imageResSP = new javax.swing.JScrollPane();
        imageResPanel = new javax.swing.JPanel();
        imageLabelD = new javax.swing.JLabel();
        barreOutils = new javax.swing.JToolBar();
        BouttonPalette = new javax.swing.JRadioButton();
        BouttonROI = new javax.swing.JRadioButton();
        BouttonAgrandir = new javax.swing.JRadioButton();
        LabelHauteur = new javax.swing.JLabel();
        imageHauteur = new javax.swing.JTextField();
        LabelLargeur = new javax.swing.JLabel();
        imageLargeur = new javax.swing.JTextField();
        LabelR = new javax.swing.JLabel();
        imageCouleurR = new javax.swing.JTextField();
        LabelG = new javax.swing.JLabel();
        imageCouleurG = new javax.swing.JTextField();
        LabelB = new javax.swing.JLabel();
        imageCouleurB = new javax.swing.JTextField();
        BouttonValider = new javax.swing.JButton();
        menuPrincipal = new javax.swing.JMenuBar();
        fichierMenu = new javax.swing.JMenu();
        ouvrirImage = new javax.swing.JMenuItem();
        fermerImage = new javax.swing.JMenuItem();
        sauverImage = new javax.swing.JMenuItem();
        quitterApp = new javax.swing.JMenuItem();
        editionMenu = new javax.swing.JMenu();
        expansionExtractionMenuItem = new javax.swing.JMenuItem();
        HistogramMenuItem = new javax.swing.JMenuItem();
        SeuillageMenuItem = new javax.swing.JMenuItem();
        SeuillageMultMenuItem = new javax.swing.JMenuItem();
        EgalisationHistoMenuItem = new javax.swing.JMenuItem();
        ErosionMenuItem = new javax.swing.JMenuItem();
        DilatationMenuItem = new javax.swing.JMenuItem();
        OuvertureMenuItem = new javax.swing.JMenuItem();
        FermetureMenuItem = new javax.swing.JMenuItem();
        aproposMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Application traitement d'image - HEPL");
        setLocation(new java.awt.Point(0, 0));
        setName("mainWindow"); // NOI18N
        setSize(new java.awt.Dimension(1024, 720));

        imageDepSP.setViewportBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        imageDepPanel.setLayout(new java.awt.BorderLayout());

        imageLabelG.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        imageLabelG.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        imageLabelG.setPreferredSize(null);
        imageLabelG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageLabelGMouseClicked(evt);
            }
        });
        imageDepPanel.add(imageLabelG, java.awt.BorderLayout.PAGE_START);

        imageDepSP.setViewportView(imageDepPanel);

        imageResSP.setViewportBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        imageResPanel.setLayout(new java.awt.BorderLayout());

        imageLabelD.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        imageLabelD.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        imageLabelD.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        imageLabelD.setPreferredSize(null);
        imageResPanel.add(imageLabelD, java.awt.BorderLayout.PAGE_START);

        imageResSP.setViewportView(imageResPanel);

        barreOutils.setRollover(true);

        GroupageBouttonOutils.add(BouttonPalette);
        BouttonPalette.setSelected(true);
        BouttonPalette.setText("Palette");
        BouttonPalette.setFocusable(false);
        BouttonPalette.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barreOutils.add(BouttonPalette);

        GroupageBouttonOutils.add(BouttonROI);
        BouttonROI.setText("R.O.I.");
        BouttonROI.setFocusable(false);
        BouttonROI.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barreOutils.add(BouttonROI);

        GroupageBouttonOutils.add(BouttonAgrandir);
        BouttonAgrandir.setText("Taille");
        BouttonAgrandir.setFocusable(false);
        BouttonAgrandir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BouttonAgrandir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BouttonAgrandirActionPerformed(evt);
            }
        });
        barreOutils.add(BouttonAgrandir);

        LabelHauteur.setText("Hauteur");
        LabelHauteur.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 40, 0, 10));
        barreOutils.add(LabelHauteur);

        imageHauteur.setEditable(false);
        imageHauteur.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        imageHauteur.setMinimumSize(new java.awt.Dimension(50, 28));
        imageHauteur.setPreferredSize(new java.awt.Dimension(50, 28));
        barreOutils.add(imageHauteur);

        LabelLargeur.setText("Largeur");
        LabelLargeur.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 40, 0, 10));
        barreOutils.add(LabelLargeur);

        imageLargeur.setEditable(false);
        imageLargeur.setPreferredSize(new java.awt.Dimension(50, 28));
        barreOutils.add(imageLargeur);

        LabelR.setText("R");
        LabelR.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 40, 0, 10));
        barreOutils.add(LabelR);

        imageCouleurR.setEditable(false);
        imageCouleurR.setPreferredSize(new java.awt.Dimension(50, 28));
        barreOutils.add(imageCouleurR);

        LabelG.setText("G");
        LabelG.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 40, 0, 10));
        barreOutils.add(LabelG);

        imageCouleurG.setEditable(false);
        imageCouleurG.setPreferredSize(new java.awt.Dimension(50, 28));
        barreOutils.add(imageCouleurG);

        LabelB.setText("B");
        LabelB.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 40, 0, 10));
        barreOutils.add(LabelB);

        imageCouleurB.setEditable(false);
        imageCouleurB.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 20));
        imageCouleurB.setPreferredSize(new java.awt.Dimension(50, 28));
        barreOutils.add(imageCouleurB);

        BouttonValider.setText("Valider");
        BouttonValider.setEnabled(false);
        BouttonValider.setFocusable(false);
        BouttonValider.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BouttonValider.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BouttonValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BouttonValiderActionPerformed(evt);
            }
        });
        barreOutils.add(BouttonValider);

        fichierMenu.setText("Fichier");

        ouvrirImage.setText("Ouvrir...");
        ouvrirImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ouvrirImageActionPerformed(evt);
            }
        });
        fichierMenu.add(ouvrirImage);

        fermerImage.setText("Fermer image");
        fermerImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fermerImageActionPerformed(evt);
            }
        });
        fichierMenu.add(fermerImage);

        sauverImage.setText("Sauver image destination");
        fichierMenu.add(sauverImage);

        quitterApp.setText("Quitter");
        quitterApp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitterAppActionPerformed(evt);
            }
        });
        fichierMenu.add(quitterApp);

        menuPrincipal.add(fichierMenu);

        editionMenu.setText("Edition");

        expansionExtractionMenuItem.setText("Expansion/extraction");
        expansionExtractionMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expansionExtractionMenuItemActionPerformed(evt);
            }
        });
        editionMenu.add(expansionExtractionMenuItem);

        HistogramMenuItem.setText("Histogramme");
        HistogramMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HistogramMenuItemActionPerformed(evt);
            }
        });
        editionMenu.add(HistogramMenuItem);

        SeuillageMenuItem.setText("Seuillage simple");
        SeuillageMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeuillageMenuItemActionPerformed(evt);
            }
        });
        editionMenu.add(SeuillageMenuItem);

        SeuillageMultMenuItem.setText("Seuillage multiple");
        SeuillageMultMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeuillageMultMenuItemActionPerformed(evt);
            }
        });
        editionMenu.add(SeuillageMultMenuItem);

        EgalisationHistoMenuItem.setText("Egalisation d'histogramme");
        EgalisationHistoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EgalisationHistoMenuItemActionPerformed(evt);
            }
        });
        editionMenu.add(EgalisationHistoMenuItem);

        ErosionMenuItem.setText("Erosion");
        ErosionMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ErosionMenuItemActionPerformed(evt);
            }
        });
        editionMenu.add(ErosionMenuItem);

        DilatationMenuItem.setText("Dilatation");
        DilatationMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DilatationMenuItemActionPerformed(evt);
            }
        });
        editionMenu.add(DilatationMenuItem);

        OuvertureMenuItem.setText("Ouverture");
        OuvertureMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OuvertureMenuItemActionPerformed(evt);
            }
        });
        editionMenu.add(OuvertureMenuItem);

        FermetureMenuItem.setText("Fermeture");
        FermetureMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FermetureMenuItemActionPerformed(evt);
            }
        });
        editionMenu.add(FermetureMenuItem);

        menuPrincipal.add(editionMenu);

        aproposMenu.setText("A propos");
        menuPrincipal.add(aproposMenu);

        setJMenuBar(menuPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageDepSP, javax.swing.GroupLayout.PREFERRED_SIZE, 954, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imageResSP)
                .addContainerGap())
            .addComponent(barreOutils, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(barreOutils, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imageResSP, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
                    .addComponent(imageDepSP, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /*
    APPEL : quand un utilisateur clique sur le boutton Quitter du menu Fichier
    FONCTION : permet de quitter le programme proprement tout en demandant à l'utilisateur s'il veut sauvegarder son travail
    */
    private void quitterAppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitterAppActionPerformed
        if(fichierSource == null)
            System.exit(0);
        else
        {
            int choixDialog = JOptionPane.showConfirmDialog(null,"Votre travail peut être perdu, voulez-vous sauvegarder le résultat ?","Avertissement",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
            if(choixDialog == JOptionPane.YES_OPTION)   // Si OUI
            {
                // Sauvegarder l'image résultat
                System.exit(0);
            }
            if(choixDialog == JOptionPane.NO_OPTION)    // Si NON
            {
                System.exit(0);
            }        
            // Rien ne se passe si Annuler
        }
    }//GEN-LAST:event_quitterAppActionPerformed
    
    /*
    APPEL : quand un utilisateur clique sur le boutton Ouvrir... du menu Fichier
    FONCTION : permet d'ouvrir une image provenant de son disque dur
    */
    private void ouvrirImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ouvrirImageActionPerformed
        if(imageDep != null)
        {
            int choixDialog = JOptionPane.showConfirmDialog(null,"Votre travail peut être perdu, voulez-vous sauvegarder le résultat ?","Avertissement",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
            if(choixDialog == JOptionPane.YES_OPTION)   // Si OUI
            {
                // Sauvegarder l'image résultat
                cleanVariables();
                fermerImage.setEnabled(false);
                sauverImage.setEnabled(false);
            }
            if(choixDialog == JOptionPane.NO_OPTION)    // Si NON
            {
                cleanVariables();
                fermerImage.setEnabled(false);
                sauverImage.setEnabled(false);
            }         
        }       
        fichierSource = ouvrirImage();
        if(fichierSource != null)
        {
            afficherImageInit();
            fermerImage.setEnabled(true);
            sauverImage.setEnabled(true);
            //imageHauteur.setText(Integer.toString(imageDep.getHeight(null)));
            //imageLargeur.setText(Integer.toString(imageDep.getWidth(null)));
            imageHauteur.setText(Integer.toString(imageDep.getHeight()));
            imageLargeur.setText(Integer.toString(imageDep.getWidth()));
        }          
        else
            JOptionPane.showMessageDialog(null, "Aucune image chargée", "Avertissement", JOptionPane.WARNING_MESSAGE);
 
    }//GEN-LAST:event_ouvrirImageActionPerformed
    
    /*
    APPEL : quand un utilisateur clique sur le boutton Fermer du menu Fichier
    FONCTION : permet de fermer l'image ouverte et de clean les variables membres
    */
    private void fermerImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fermerImageActionPerformed
        int choixDialog = JOptionPane.showConfirmDialog(null,"Votre travail peut être perdu, voulez-vous sauvegarder le résultat ?","Avertissement",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
        if(choixDialog == JOptionPane.YES_OPTION)   // Si OUI
        {
            // Sauvegarder l'image résultat
            cleanVariables();
            fermerImage.setEnabled(false);
            sauverImage.setEnabled(false);
        }
        if(choixDialog == JOptionPane.NO_OPTION)    // Si NON
        {
            cleanVariables();
            fermerImage.setEnabled(false);
            sauverImage.setEnabled(false);
        }        
        // Rien ne se passe si Annuler
       
    }//GEN-LAST:event_fermerImageActionPerformed

    private void imageLabelGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageLabelGMouseClicked
        try
        {
            if(BouttonPalette.isSelected() && imageDep != null)
            {   
                imageHauteur.setEditable(false);
                imageLargeur.setEditable(false);
                BouttonValider.setEnabled(true);
                imageCouleurR.setEditable(true);
                imageCouleurG.setEditable(true);
                imageCouleurB.setEditable(true);
                ColorBefore = null;
                ColorBefore = new Color(imageDep.getRGB(evt.getX(),evt.getY()));
                imageCouleurR.setText(Integer.toString(ColorBefore.getRed()));
                imageCouleurG.setText(Integer.toString(ColorBefore.getGreen()));
                imageCouleurB.setText(Integer.toString(ColorBefore.getBlue()));
                
            }
            if(BouttonROI.isSelected() && imageDep != null)
            {          
                imageHauteur.setEditable(false);
                imageLargeur.setEditable(false);
                imageCouleurR.setEditable(false);
                imageCouleurG.setEditable(false);
                imageCouleurB.setEditable(false);
                if(etatVar==1)
                {
                    X1 = evt.getX();
                    Y1 = evt.getY();
                    etatVar=2;
                }
                else
                {
                    X2 = evt.getX();
                    Y2 = evt.getY();
                    imgTrt.setImage(imageDep);
                    imgTrt.ROI(X1,Y1,X2,Y2);
                    imageLabelD.setIcon(new ImageIcon(imgTrt.getImage()));
                    etatVar=1;
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
    }//GEN-LAST:event_imageLabelGMouseClicked

    private void BouttonValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BouttonValiderActionPerformed
        if(BouttonPalette.isSelected())
        {
            imgTrt.setImage(imageDep);
            imgTrt.Palette(ColorBefore,Integer.parseInt(imageCouleurR.getText()),Integer.parseInt(imageCouleurG.getText()),Integer.parseInt(imageCouleurB.getText()));
            BouttonValider.setEnabled(false);
            imageCouleurR.setEditable(false);
            imageCouleurG.setEditable(false);
            imageCouleurB.setEditable(false);
            imageLabelD.setIcon(new ImageIcon(imgTrt.getImage()));
        }
        else
        {
            imgTrt.setImage(imageDep);
            imgTrt.setSize(Integer.parseInt(imageLargeur.getText()),Integer.parseInt(imageHauteur.getText()));
            imageLabelD.setIcon(new ImageIcon(imgTrt.getImage()));
        }
    }//GEN-LAST:event_BouttonValiderActionPerformed

    private void BouttonAgrandirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BouttonAgrandirActionPerformed
        if(BouttonAgrandir.isSelected() && imageDep != null)
        {
                imageCouleurR.setEditable(false);
                imageCouleurG.setEditable(false);
                imageCouleurB.setEditable(false);
                imageHauteur.setEditable(true);
                imageLargeur.setEditable(true);
                BouttonValider.setEnabled(true);
        }
    }//GEN-LAST:event_BouttonAgrandirActionPerformed

    private void expansionExtractionMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expansionExtractionMenuItemActionPerformed
        expansionExtraction zoom = new expansionExtraction(this,true);
        zoom.setVisible(true);
        double value = zoom.getValue();
        imgTrt.setImage(imageDep);
        imgTrt.Expand(value);
        imageLabelD.setIcon(new ImageIcon(imgTrt.getImage()));
    }//GEN-LAST:event_expansionExtractionMenuItemActionPerformed

    private void HistogramMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HistogramMenuItemActionPerformed
        imgTrt.setImage(imageDep);
        imgTrt.getGrayMatrix();
        histogram histo = new histogram(this,false,imgTrt.tabGray);
        imgTrt.MatrixToImage(imgTrt.tabGray);
        imageLabelD.setIcon(new ImageIcon(imgTrt.getImage()));
        histo.setVisible(true);
    }//GEN-LAST:event_HistogramMenuItemActionPerformed

    private void SeuillageMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeuillageMenuItemActionPerformed
        thresholdSimple simple = new thresholdSimple(this,true);
        simple.setVisible(true);
        int value;
        if((value = simple.getValue()) == -1)
            return;
        imgTrt.setImage(imageDep);
        imgTrt.simpleThres(value);
        imageLabelD.setIcon(new ImageIcon(imgTrt.getImage()));       
    }//GEN-LAST:event_SeuillageMenuItemActionPerformed

    private void SeuillageMultMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeuillageMultMenuItemActionPerformed
        thresholdMulti multi = new thresholdMulti(this,true);
        multi.setVisible(true);
        int[] values;
        values = multi.getValues();
        if(values[0] == -1)
            return;
        imgTrt.setImage(imageDep);
        imgTrt.multiThres(values);
        imageLabelD.setIcon(new ImageIcon(imgTrt.getImage()));
    }//GEN-LAST:event_SeuillageMultMenuItemActionPerformed

    private void EgalisationHistoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EgalisationHistoMenuItemActionPerformed
        imgTrt.setImage(imageDep);
        imgTrt.equalizeHisto();
        imageLabelD.setIcon(new ImageIcon(imgTrt.getImage()));
    }//GEN-LAST:event_EgalisationHistoMenuItemActionPerformed

    private void ErosionMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ErosionMenuItemActionPerformed
        imgTrt.setImage(imageDep);
        imgTrt.erode();
        imageLabelD.setIcon(new ImageIcon(imgTrt.getImage()));
    }//GEN-LAST:event_ErosionMenuItemActionPerformed

    private void DilatationMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DilatationMenuItemActionPerformed
        imgTrt.setImage(imageDep);
        imgTrt.dilate();
        imageLabelD.setIcon(new ImageIcon(imgTrt.getImage()));
    }//GEN-LAST:event_DilatationMenuItemActionPerformed

    private void OuvertureMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OuvertureMenuItemActionPerformed
        imgTrt.setImage(imageDep);
        imgTrt.erode();
        imgTrt.dilate();
        imageLabelD.setIcon(new ImageIcon(imgTrt.getImage()));
    }//GEN-LAST:event_OuvertureMenuItemActionPerformed

    private void FermetureMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FermetureMenuItemActionPerformed
        imgTrt.setImage(imageDep);
        imgTrt.dilate();
        imgTrt.erode();
        imageLabelD.setIcon(new ImageIcon(imgTrt.getImage()));
    }//GEN-LAST:event_FermetureMenuItemActionPerformed

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
            java.util.logging.Logger.getLogger(appWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(appWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(appWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(appWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new appWindow().setVisible(true);
            }
        });
    }

    /*
    APPEL : quand un utilisateur veut ouvrir une image
    FONCTION : permet à l'utilsateur de choisir l'image et de renvoyer le descripteur dans la variable membre
    */
    public File ouvrirImage() {
        
        JFileChooser openPic = new JFileChooser();  // Selection de fichier
        openPic.setAcceptAllFileFilterUsed(false);  // Cacher "Tous les fichier"
        openPic.setFileFilter(new FileNameExtensionFilter("Images (gif,jpg,png,bmp)","gif","jpg","png","bmp"));   // Filtrer uniquement sur certaines extension
        if(lastDirectoryUsed != null)
            openPic.setCurrentDirectory(new File(lastDirectoryUsed));
        else
            openPic.setCurrentDirectory(new File(System.getProperty("user.home"))); // Dossier de départ : home
        int resultat = openPic.showOpenDialog(null);    // Dialogue Ouvrir...
        if(resultat == JFileChooser.APPROVE_OPTION)
        {
            try
            {
                File fich = openPic.getSelectedFile();
                lastDirectoryUsed=fich.getParent();
                return fich;
            }  
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return fichierSource;
    }
    
    /*
    APPEL : quand un utilisateur a selectionné une image
    FONCTION : permet a la JVM d'afficher l'image départ et résultat (les mêmes au début) dans les panel appropriés
    */
    public void afficherImageInit() {
        
        try
        {
                //imageDep = ImageIO.read(fichierSource);
                //imageRes = ImageIO.read(fichierSource);
                imageDep = ImageIO.read(fichierSource);
                imgTrt.setImage(imageDep);
                //ImageIcon imgG = new ImageIcon(imageDep);
                //ImageIcon imgD = new ImageIcon(imageRes);
                ImageIcon imgG = new ImageIcon(imageDep);
                ImageIcon imgD = new ImageIcon(imgTrt.getImage());
                imageLabelG.setIcon(imgG);
                imageLabelD.setIcon(imgD);
                imageDepPanel.add(imageLabelG);
                imageResPanel.add(imageLabelD);               
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    /*
    APPEL : quand un utilisateur veut quitter le programme ou fermer l'image
    FONCTION : permet de nettoyer les variables pour le Garbage Collector
    */
    public void cleanVariables() {
        
        imageLabelG.setIcon(null);
        imageLabelD.setIcon(null);
        imageLabelG.repaint();
        imageLabelD.repaint();
        fichierSource = null;
        imageHauteur.setText("");
        imageLargeur.setText("");
        imageCouleurR.setText("");
        imageCouleurG.setText("");
        imageCouleurB.setText("");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton BouttonAgrandir;
    private javax.swing.JRadioButton BouttonPalette;
    private javax.swing.JRadioButton BouttonROI;
    private javax.swing.JButton BouttonValider;
    private javax.swing.JMenuItem DilatationMenuItem;
    private javax.swing.JMenuItem EgalisationHistoMenuItem;
    private javax.swing.JMenuItem ErosionMenuItem;
    private javax.swing.JMenuItem FermetureMenuItem;
    private javax.swing.ButtonGroup GroupageBouttonOutils;
    private javax.swing.JMenuItem HistogramMenuItem;
    private javax.swing.JLabel LabelB;
    private javax.swing.JLabel LabelG;
    private javax.swing.JLabel LabelHauteur;
    private javax.swing.JLabel LabelLargeur;
    private javax.swing.JLabel LabelR;
    private javax.swing.JMenuItem OuvertureMenuItem;
    private javax.swing.JMenuItem SeuillageMenuItem;
    private javax.swing.JMenuItem SeuillageMultMenuItem;
    private javax.swing.JMenu aproposMenu;
    private javax.swing.JToolBar barreOutils;
    private javax.swing.JMenu editionMenu;
    private javax.swing.JMenuItem expansionExtractionMenuItem;
    private javax.swing.JMenuItem fermerImage;
    private javax.swing.JMenu fichierMenu;
    private javax.swing.JTextField imageCouleurB;
    private javax.swing.JTextField imageCouleurG;
    private javax.swing.JTextField imageCouleurR;
    private javax.swing.JPanel imageDepPanel;
    private javax.swing.JScrollPane imageDepSP;
    private javax.swing.JTextField imageHauteur;
    private javax.swing.JLabel imageLabelD;
    private javax.swing.JLabel imageLabelG;
    private javax.swing.JTextField imageLargeur;
    private javax.swing.JPanel imageResPanel;
    private javax.swing.JScrollPane imageResSP;
    private javax.swing.JMenuBar menuPrincipal;
    private javax.swing.JMenuItem ouvrirImage;
    private javax.swing.JMenuItem quitterApp;
    private javax.swing.JMenuItem sauverImage;
    // End of variables declaration//GEN-END:variables

    
}
