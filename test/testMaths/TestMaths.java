/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testMaths;

import static java.lang.Math.ceil;
import static java.lang.Math.floor;
import java.util.Random;
/**
 *
 * @author Morghen
 */
public class TestMaths {
        
        
        public static void main(String[] args) {        
            int tab2[][] = new int[125][125];
            for(int j=0;j<tab2[0].length - 1;j++)
            {
                for(int i=0;i<tab2.length - 1;i++)
                {
                    // points a interpoler
                    double p = i/1.25;
                    double q = j/1.25;
                    
                    /*if(p == 0 && q == 0)
                    {
                        tab2[i][j] = 0;
                        continue;
                    }*/
                    
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
    }
            
}
