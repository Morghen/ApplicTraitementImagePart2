/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traitements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import static java.lang.Math.floor;

/**
 *
 * @author Morghen
 */
public class traitementImage {
    
    private BufferedImage imgPrinc;
    public int[][] tabR;
    public int[][] tabG;
    public int[][] tabB;
    public int[][] tabGray;
    
    public traitementImage(){
        
        imgPrinc = null;
    }
    
    public traitementImage(BufferedImage img) {
        setImage(img);
    }
    
    public void setImage(BufferedImage img) {
        imgPrinc = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
        Graphics g = imgPrinc.getGraphics();
        g.drawImage(img, 0, 0, null);
        g.dispose();
    }
    
    public BufferedImage getImage() {
        return imgPrinc;
    }
    
    public void setSize(int x,int y) {
        BufferedImage tmp = new BufferedImage(x, y, imgPrinc.getType());
        Graphics g = tmp.getGraphics();
        g.fillRect(0, 0, x, y);
        g.drawImage(imgPrinc, 0, 0, null);
        g.dispose();
        imgPrinc = tmp;
    }
    
    public void ROI(int X1, int Y1, int X2, int Y2) {
        
        
        for(int i =0; i < Math.abs(X2-X1); i++)
        {
            for(int j =0; j < Math.abs(Y2-Y1); j++)
            {
                imgPrinc.setRGB(i, j, imgPrinc.getRGB(X1+i, Y1+j));
            }
        }
        setSize(Math.abs(X2-X1),Math.abs(Y2-Y1));
    }
    
    public void Palette(Color ColorBefore,int rouge,int vert,int bleu) {
        
        
        Color modification = new Color(rouge,vert,bleu);
        for(int i=0; i<imgPrinc.getWidth();i++)
        {
            for(int j=0; j<imgPrinc.getHeight(); j++)
            {
                Color tmp = new Color(imgPrinc.getRGB(i, j));
                if(tmp.equals(ColorBefore))
                {
                    imgPrinc.setRGB(i, j, modification.getRGB());
                }
            }
        }
    }
    
    public void Expand(double coef) {
        
        ImageToMatrix();
        int [][] newTabR = Interpolation(this.tabR,coef);
        int [][] newTabG = Interpolation(this.tabG,coef);
        int [][] newTabB = Interpolation(this.tabB,coef);
        MatrixToImage(newTabR,newTabG,newTabB); 
    }
    
    public int[][] Interpolation(int[][] tab,double coef) {
        
        int tab2[][] = new int[(int)floor(tab.length * coef)][(int)floor(tab[0].length * coef)];
        for(int j=0;j<tab2[0].length-1;j++)
        {
            for(int i=0;i<tab2.length-1;i++)
            {
                // points a interpoler
                double p = i/coef;
                double q = j/coef;

                // trouver les 4 points a interpoler
                int a,b,c,d;
                a = (int)floor(p);  // X
                b = a+1;            // X+1
                c = (int)floor(q);  // Y
                d = c+1;            // Y+1


                double Vn1,Vn2,V;
                Vn1 = tab[a][c] + ((tab[b][c] - tab[a][c]) / ((b) - a)) * (p - a);
                Vn2 = tab[a][d] + ((tab[b][d] - tab[a][d]) / ((b) - a)) * (p - a);
                V = Vn1 + ((Vn2 - Vn1)/((d)-c)) * (q - c);
                tab2[i][j] = (int)floor(V);
            }
        }
        System.out.println("Interpolation terminée");
        return tab2;
    }

    public void ImageToMatrix() {
        tabR = new int[imgPrinc.getWidth()][imgPrinc.getHeight()];
        tabG = new int[imgPrinc.getWidth()][imgPrinc.getHeight()];
        tabB = new int[imgPrinc.getWidth()][imgPrinc.getHeight()];
        for(int i = 0;i<imgPrinc.getWidth();i++)
        {
            for(int j = 0;j<imgPrinc.getHeight();j++)
            {
                tabR[i][j] = getRed(i,j);
                tabG[i][j] = getGreen(i,j);
                tabB[i][j] = getBlue(i,j);
            }
        }
        System.out.println("Matrice créée");
    }
    
    public void MatrixToImage(int[][] rouge,int[][] vert,int[][] bleu) {
        BufferedImage reformed = new BufferedImage(rouge.length,rouge[0].length,imgPrinc.getType());
        for(int i = 0;i<rouge.length;i++)
        {
            for(int j = 0;j<rouge[0].length;j++)
            {
                Color tmp = new Color(rouge[i][j],vert[i][j],bleu[i][j]);
                reformed.setRGB(i, j, tmp.getRGB());
            }
        }
        setImage(reformed);
        System.out.println("Image reformée");
    }
    
    public int getHeight() {
        return imgPrinc.getHeight();
    }

    public int getWidth() {
        return imgPrinc.getWidth();
    }

    public int getRed(int x, int y)
    {
        Color rouge = new Color(imgPrinc.getRGB(x, y));
        return rouge.getRed();
    }
    
    public int getGreen(int x, int y)
    {
        Color vert= new Color(imgPrinc.getRGB(x, y));
        return vert.getGreen();
    }
    
    public int getBlue(int x, int y)
    {
        Color bleu = new Color(imgPrinc.getRGB(x, y));
        return bleu.getBlue();
    }
    
    public void getGrayMatrix() {
        ImageToMatrix();
        int[][] tabGrayTmp = new int[tabR.length][tabR[0].length];
        for(int i = 0;i<tabR.length;i++)
        {
            for(int j = 0;j<tabR[0].length;j++)
            {
                tabGrayTmp[i][j] = (tabR[i][j] + tabG[i][j] + tabB[i][j]) / 3;
            }
        }
        this.tabGray = tabGrayTmp;
    }
}
