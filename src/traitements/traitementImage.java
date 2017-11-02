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
import static java.lang.Math.sqrt;
import static java.util.Collections.sort;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;
import windows.histogram;

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
    public int[][] tabThres;
    
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
                try
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
                catch(ArrayIndexOutOfBoundsException e)
                {
                    //
                }
                
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
        System.out.println("Image RGB reformée RGB");
    }
    
    public void MatrixToImage(int[][] gray) {
        BufferedImage reformed = new BufferedImage(gray.length,gray[0].length,BufferedImage.TYPE_BYTE_GRAY);
        for(int i = 0;i<gray.length;i++)
        {
            for(int j = 0;j<gray[0].length;j++)
            {
                Color tmp = new Color(gray[i][j],gray[i][j],gray[i][j]);
                reformed.setRGB(i, j, tmp.getRGB());
            }
        }
        setImage(reformed);
        System.out.println("Image nv gris reformée");
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
        BufferedImage grey = new BufferedImage(imgPrinc.getWidth(),imgPrinc.getHeight(),BufferedImage.TYPE_BYTE_GRAY);
        Graphics g = grey.getGraphics();
        g.drawImage(imgPrinc,0,0,null);
        g.dispose();
        int[][] tabGrayTmp = new int[imgPrinc.getWidth()][imgPrinc.getHeight()];
        for(int i = 0;i<tabGrayTmp.length;i++)
        {
            for(int j = 0;j<tabGrayTmp[0].length;j++)
            {
                Color tmp = new Color(grey.getRGB(i, j));
                tabGrayTmp[i][j] = (tmp.getRed() + tmp.getGreen() + tmp.getBlue()) / 3;
            }
        }
        this.tabGray = tabGrayTmp;
    }
    
    public void simpleThres(int seuil) {
        getGrayMatrix();
        tabThres = new int[tabGray.length][tabGray[0].length];
        for(int i=0;i<tabGray.length;i++)
        {
            for(int j=0;j<tabGray[0].length;j++)
            {
                if(tabGray[i][j] < seuil)
                {
                    tabThres[i][j] = 0;
                }
                else
                    tabThres[i][j] = 255;
            }
        }
        MatrixToImage(tabThres);
    }
    
    public void multiThres(int[] seuils) {
        int a,b,c;
        a = seuils[0];
        b = seuils[1];
        c = seuils[2];
        getGrayMatrix();
        tabThres = new int[tabGray.length][tabGray[0].length];
        for(int i=0;i<tabGray.length;i++)
        {
            for(int j=0;j<tabGray[0].length;j++)
            {
                if(tabGray[i][j] < a)
                    tabThres[i][j] = 0;
                else if(tabGray[i][j] < b)
                    tabThres[i][j] = 84;
                else if(tabGray[i][j] < c)
                    tabThres[i][j] = 168;
                else
                    tabThres[i][j] = 255;
            }
        }
        MatrixToImage(tabThres);
    }
    
    public void equalizeHisto() {
        getGrayMatrix();
        int h,w,size;
        h = this.getHeight();
        w = this.getWidth();
        size = h*w;
        Map<Integer,Integer> histoN = new TreeMap();
        Map<Integer,Double> histoC = new TreeMap();
        for(int i = 0;i<256;i++)
        {
            histoN.put(i, 0);
            histoC.put(i, 0.0);
        }
        // Mappage sur table normale
        for(int i = 0;i<tabGray.length;i++)
        {
            for(int j = 0;j<tabGray[0].length;j++)
            {
                if(histoN.containsKey(tabGray[i][j]))
                {
                    histoN.replace(tabGray[i][j], histoN.get(tabGray[i][j]) + 1);
                }
            }
        }
        // Mappage cumulé
        histoC.replace(0, (double)histoN.get(0) / size);
        for(int i = 1;i<256;i++)
        {
            histoC.replace(i, histoC.get(i-1) + ((double)histoN.get(i)/size));
        }
        // Total doit faire 1
        for(int i = 0;i<256;i++)
            System.out.println("Valeur totale a  " + i + " : " + histoC.get(i));
        int[][] tabTest = new int[tabGray.length][tabGray[0].length];
        for(int a = 0;a<256;a++)
        {
            for(int i = 0;i<tabGray.length;i++)
            {
                for(int j = 0;j<tabGray[0].length;j++)
                {
                    if(tabGray[i][j] == a)
                    {
                        tabTest[i][j] = (int)floor(255*histoC.get(a));
                    }
                }
            }
        }
        MatrixToImage(tabTest);
        histogram histoEq = new histogram(null,true,tabTest);
        histoEq.setVisible(true);
    }
    
    public void erode()
    {
        getGrayMatrix();
        int tabErode[][] = new int[tabGray.length][tabGray[0].length];
        for(int i = 0;i<tabErode.length;i++)
        {
            for(int j = 0;j<tabErode[0].length;j++)
            {
                if(i==0 || j==0 || i==(tabGray.length - 1) ||  j==(tabGray[0].length - 1))
                {
                    tabErode[i][j] = tabGray[i][j];
                }
                else
                {
                    int minVal = 255;
                    for(int a = i-1;a<i+2;a++)
                    {
                        for(int b = j-1;b<j+2;b++)
                        {
                            if(minVal>tabGray[a][b])
                                minVal = tabGray[a][b];
                        }
                    } 
                    tabErode[i][j] = minVal;
                }
                
            }
        }
        MatrixToImage(tabErode);
    }
    
    public void dilate()
    {
        getGrayMatrix();
        int tabDilate[][] = new int[tabGray.length][tabGray[0].length];
        for(int i = 0;i<tabDilate.length;i++)
        {
            for(int j = 0;j<tabDilate[0].length;j++)
            {
                if(i==0 || j==0 || i==(tabGray.length - 1) ||  j==(tabGray[0].length - 1))
                {
                    tabDilate[i][j] = tabGray[i][j];
                }
                else
                {
                    int maxVal = 0;
                    for(int a = i-1;a<i+2;a++)
                    {
                        for(int b = j-1;b<j+2;b++)
                        {
                            if(maxVal<tabGray[a][b])
                                maxVal = tabGray[a][b];
                        }
                    } 
                    tabDilate[i][j] = maxVal;
                }
                
            }
        }
        MatrixToImage(tabDilate);
    }
    
    public void median() {
        getGrayMatrix();
        int tabMedian[][] = new int[tabGray.length][tabGray[0].length];
        for(int i = 0;i<tabMedian.length;i++)
        {
            for(int j = 0;j<tabMedian[0].length;j++)
            {
                if(i==0 || j==0 || i==(tabGray.length - 1) ||  j==(tabGray[0].length - 1))
                {
                    tabMedian[i][j] = tabGray[i][j];
                }
                else
                {
                    Vector<Integer> vect = new Vector<>();
                    for(int a = i-1;a<i+2;a++)
                    {
                        for(int b = j-1;b<j+2;b++)
                        {
                            vect.add(tabGray[a][b]);
                        }
                    }
                    sort(vect);
                    tabMedian[i][j] = vect.elementAt(4);
                }               
            }
        }
        MatrixToImage(tabMedian);
    }
    
    public void moyen() {
        getGrayMatrix();
        int tabMoyen[][] = new int[tabGray.length][tabGray[0].length];
        for(int i = 0;i<tabMoyen.length;i++)
        {
            for(int j = 0;j<tabMoyen[0].length;j++)
            {
                if(i==0 || j==0 || i==(tabGray.length - 1) ||  j==(tabGray[0].length - 1))
                {
                    tabMoyen[i][j] = tabGray[i][j];
                }
                else
                {
                    int sum = 0;
                    for(int a = i-1;a<i+2;a++)
                    {
                        for(int b = j-1;b<j+2;b++)
                        {
                            sum = sum + tabGray[a][b];
                        }
                    }
                    tabMoyen[i][j] = sum / 9;
                }               
            }
        }
        MatrixToImage(tabMoyen);
    }
    
    public void gauss() {
        getGrayMatrix();
        int tabGauss[][] = new int[tabGray.length][tabGray[0].length];
        for(int i = 0;i<tabGauss.length;i++)
        {
            for(int j = 0;j<tabGauss[0].length;j++)
            {
                if(i==0 || j==0 || i==(tabGray.length - 1) ||  j==(tabGray[0].length - 1))
                {
                    tabGauss[i][j] = tabGray[i][j];
                }
                else
                {
                    int sum = 0;
                    sum = sum + tabGray[i-1][j-1] + (tabGray[i][j-1] * 2) + tabGray[i+1][j-1];      // Premiere ligne
                    sum = sum + (tabGray[i-1][j] * 2) + (tabGray[i][j]*4) + (tabGray[i+1][j] * 2);  // Deuxieme ligne
                    sum = sum + tabGray[i-1][j+1] + (tabGray[i+1][j+1] * 2) + tabGray[i+1][j+1];    // Troisieme ligne
                    tabGauss[i][j] = sum/16;
                }               
            }
        }
        MatrixToImage(tabGauss);
    }
    
    public void laplacian() {
        getGrayMatrix();
        int tabLaplace[][] = new int[tabGray.length][tabGray[0].length];
        for(int i = 0;i<tabLaplace.length;i++)
        {
            for(int j = 0;j<tabLaplace[0].length;j++)
            {
                if(i==0 || j==0 || i==(tabGray.length - 1) ||  j==(tabGray[0].length - 1))
                {
                    tabLaplace[i][j] = tabGray[i][j];
                }
                else
                {
                    int sum = 0;
                    sum = sum + (tabGray[i][j-1]);                                               // Premiere ligne
                    sum = sum + (tabGray[i-1][j]) + (tabGray[i][j] * (-4)) + (tabGray[i+1][j]);  // Deuxieme ligne
                    sum = sum + (tabGray[i+1][j+1]);                                             // Troisieme ligne
                    sum = sum + 128;      
                    if(sum<0)
                        tabLaplace[i][j] = 0;
                    else if(sum>255)
                        tabLaplace[i][j] = 255;
                    else
                        tabLaplace[i][j] = sum;
                }               
            }
        }
        MatrixToImage(tabLaplace);
    }
    
    public void kirsch() {
        getGrayMatrix();
        int tabKirsch[][] = new int[tabGray.length][tabGray[0].length];
        for(int i = 0;i<tabKirsch.length;i++)
        {
            for(int j = 0;j<tabKirsch[0].length;j++)
            {
                if(i==0 || j==0 || i==(tabGray.length - 1) ||  j==(tabGray[0].length - 1))
                {
                    tabKirsch[i][j] = tabGray[i][j];
                }
                else
                {
                    Vector<Integer> vect = new Vector();
                    int g1,g2,g3,g4,g5,g6,g7,g8,elem;
                    g1 = (tabGray[i-1][j-1] * 5) + (tabGray[i][j-1] * 5) + (tabGray[i+1][j-1] * 5) - (tabGray[i-1][j] * 3) - (tabGray[i+1][j] * 3) - (tabGray[i-1][j+1] * 3) - (tabGray[i][j+1] * 3) - (tabGray[i+1][j+1] * 3);
                    g2 = (tabGray[i-1][j-1] * 5) + (tabGray[i][j-1] * 5) - (tabGray[i+1][j-1] * 3) + (tabGray[i-1][j] * 5) - (tabGray[i+1][j] * 3) - (tabGray[i-1][j+1] * 3) - (tabGray[i][j+1] * 3) - (tabGray[i+1][j+1] * 3);
                    g3 = (tabGray[i-1][j-1] * 5) - (tabGray[i][j-1] * 3) - (tabGray[i+1][j-1] * 3) + (tabGray[i-1][j] * 5) - (tabGray[i+1][j] * 3) + (tabGray[i-1][j+1] * 5) - (tabGray[i][j+1] * 3) - (tabGray[i+1][j+1] * 3);
                    g4 = (tabGray[i-1][j-1] * -3) - (tabGray[i][j-1] * 3) - (tabGray[i+1][j-1] * 3) + (tabGray[i-1][j] * 5) - (tabGray[i+1][j] * 3) + (tabGray[i-1][j+1] * 5) + (tabGray[i][j+1] * 5) - (tabGray[i+1][j+1] * 3);
                    g5 = (tabGray[i-1][j-1] * -3) - (tabGray[i][j-1] * 3) - (tabGray[i+1][j-1] * 3) - (tabGray[i-1][j] * 3) - (tabGray[i+1][j] * 3) + (tabGray[i-1][j+1] * 5) + (tabGray[i][j+1] * 5) + (tabGray[i+1][j+1] * 5);
                    g6 = (tabGray[i-1][j-1] * -3) - (tabGray[i][j-1] * 3) - (tabGray[i+1][j-1] * 3) - (tabGray[i-1][j] * 3) + (tabGray[i+1][j] * 5) - (tabGray[i-1][j+1] * 3) + (tabGray[i][j+1] * 5) + (tabGray[i+1][j+1] * 5);
                    g7 = (tabGray[i-1][j-1] * -3) - (tabGray[i][j-1] * 3) + (tabGray[i+1][j-1] * 5) - (tabGray[i-1][j] * 3) + (tabGray[i+1][j] * 5) - (tabGray[i-1][j+1] * 3) - (tabGray[i][j+1] * 3) + (tabGray[i+1][j+1] * 5);
                    g8 = (tabGray[i-1][j-1] * -3) + (tabGray[i][j-1] * 5) + (tabGray[i+1][j-1] * 5) - (tabGray[i-1][j] * 3) + (tabGray[i+1][j] * 5) - (tabGray[i-1][j+1] * 3) - (tabGray[i][j+1] * 3) - (tabGray[i+1][j+1] * 3);
                    vect.add(g1);
                    vect.add(g2);
                    vect.add(g3);
                    vect.add(g4);
                    vect.add(g5);
                    vect.add(g6);
                    vect.add(g7);
                    vect.add(g8);
                    sort(vect);
                    elem = vect.elementAt(7);
                    if(elem < 0)
                        elem = 0;
                    else if(elem > 255)
                        elem = 255;
                    tabKirsch[i][j] = elem;
                }               
            }
        }
        MatrixToImage(tabKirsch);
    }
    
    public void sobel() {
        getGrayMatrix();
        int tabSobel[][] = new int[tabGray.length][tabGray[0].length];
        for(int i = 0;i<tabSobel.length;i++)
        {
            for(int j = 0;j<tabSobel[0].length;j++)
            {
                if(i==0 || j==0 || i==(tabGray.length - 1) ||  j==(tabGray[0].length - 1))
                {
                    tabSobel[i][j] = tabGray[i][j];
                }
                else
                {
                    int Gx,Gy,elem;
                    Gx = (tabGray[i-1][j-1]) - (tabGray[i+1][j-1]) + (tabGray[i-1][j] * 2) - (tabGray[i+1][j] * 2) + (tabGray[i-1][j+1]) - (tabGray[i+1][j+1]);
                    Gy = (tabGray[i-1][j-1]) + (tabGray[i][j-1] * 2) + (tabGray[i+1][j-1]) - (tabGray[i-1][j+1]) - (tabGray[i][j+1] * 2) - (tabGray[i+1][j+1]);
                    elem = (Gx*Gx) + (Gy*Gy);
                    elem = (int)sqrt(elem);
                    if(elem < 0)
                        elem = 0;
                    else if(elem > 255)
                        elem = 255;
                    tabSobel[i][j] = elem;
                }               
            }
        }
        MatrixToImage(tabSobel);
    }
    
    public void prewitt() {
        getGrayMatrix();
        int tabPrewitt[][] = new int[tabGray.length][tabGray[0].length];
        for(int i = 0;i<tabPrewitt.length;i++)
        {
            for(int j = 0;j<tabPrewitt[0].length;j++)
            {
                if(i==0 || j==0 || i==(tabGray.length - 1) ||  j==(tabGray[0].length - 1))
                {
                    tabPrewitt[i][j] = tabGray[i][j];
                }
                else
                {
                    int Gx,Gy,elem;
                    Gx = (tabGray[i-1][j-1] * -1) + (tabGray[i+1][j-1]) - (tabGray[i-1][j]) + (tabGray[i+1][j]) - (tabGray[i-1][j+1]) + (tabGray[i+1][j+1]);
                    Gy = (tabGray[i-1][j-1] * -1) - (tabGray[i][j-1]) - (tabGray[i+1][j-1]) + (tabGray[i-1][j+1]) + (tabGray[i][j+1]) + (tabGray[i+1][j+1]);
                    elem = (Gx*Gx) + (Gy*Gy);
                    elem = (int)sqrt(elem);
                    if(elem < 0)
                        elem = 0;
                    else if(elem > 255)
                        elem = 255;
                    tabPrewitt[i][j] = elem;
                }               
            }
        }
        MatrixToImage(tabPrewitt);
    }
    
    public void roberts() {
        getGrayMatrix();
        int tabRoberts[][] = new int[tabGray.length][tabGray[0].length];
        for(int i = 0;i<tabRoberts.length;i++)
        {
            for(int j = 0;j<tabRoberts[0].length;j++)
            {
                if(i==(tabGray.length - 1) ||  j==(tabGray[0].length - 1))
                {
                    tabRoberts[i][j] = tabGray[i][j];
                }
                else
                {
                    int Gx,Gy,elem;
                    Gx = tabGray[i][j] - tabGray[i+1][j+1];
                    Gy = tabGray[i+1][j] - tabGray[i][j+1];
                    elem = (Gx*Gx) + (Gy*Gy);
                    elem = (int)sqrt(elem);
                    elem = elem + 128;
                    if(elem < 0)
                        elem = 0;
                    else if(elem > 255)
                        elem = 255;
                    tabRoberts[i][j] = elem;
                }               
            }
        }
        MatrixToImage(tabRoberts);
    }
    
    public void autothres() {
        getGrayMatrix();
        int tabAuto[][] = new int[tabGray.length][tabGray[0].length];
        int h,w,size;
        h = this.getHeight();
        w = this.getWidth();
        size = h*w;
        Map<Integer,Integer> histoN = new TreeMap();
        for(int i = 0;i<256;i++)
        {
            histoN.put(i, 0);
        }
        // Mappage sur table normale
        for(int i = 0;i<tabGray.length;i++)
        {
            for(int j = 0;j<tabGray[0].length;j++)
            {
                if(histoN.containsKey(tabGray[i][j]))
                {
                    histoN.replace(tabGray[i][j], histoN.get(tabGray[i][j]) + 1);
                }
            }
        }
        // Methode Otsu
        int seuil = 0,varMax = 0,sum = 0,sumB = 0,q1 = 0,q2 = 0,u1 = 0,u2 = 0,covar = 0;
        for(int i = 0;i<256;i++)
        {
            sum += i * histoN.get(i);
        }
        for(int t = 0;t<256;t++)
        {
            q1 += histoN.get(t);
            if(q1 == 0)
                continue;
            q2 = size - q1;
            if(q2 == 0)
                continue;
            
            sumB += t * histoN.get(t);
            u1 = sumB/q1;
            u2 = (sum - sumB)/q2;
            
            covar = q1 * q2 * ((u1 - u2) * (u1 - u2));
            
            if(covar > varMax)
            {
                seuil = t;
                varMax = covar;
            }
        }
        
        for(int i = 0;i<tabGray.length;i++)
        {
            for(int j = 0;j<tabGray[0].length;j++)
            {
                if(tabGray[i][j] > seuil)
                    tabAuto[i][j] = 255;
                else
                    tabAuto[i][j] = 0;
            }
        }
        MatrixToImage(tabAuto);
    }
}
