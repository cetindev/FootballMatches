/*
5 takımlı bir futbol grubunda takımların birbirleri ile yapmış olduğu maç sonuçlarına göre puan durumu oluşturulacaktır.
Bu amaçla bir “turnuva.txt” dosyasında haftalık maç bilgileri aşağıdaki gibi tutulacaktır.
 */
package odev3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class kazanma {

    int atılanGol;
    int yenilenGol;

    public kazanma(int atılanGol, int yenilenGol) {
        this.atılanGol = atılanGol;
        this.yenilenGol = yenilenGol;
    }
}

class berabere {

    int atılanGol;
    int yenilenGol;

    public berabere(int atılanGol, int yenilenGol) {
        this.atılanGol = atılanGol;
        this.yenilenGol = yenilenGol;
    }
}

class kaybedilen {

    int atılanGol;
    int yenilenGol;

    public kaybedilen(int atılanGol, int yenilenGol) {
        this.atılanGol = atılanGol;
        this.yenilenGol = yenilenGol;
    }
}
public class mac {
    public int[] getTakimInfo() throws IOException {
        System.out.println("Lütfen Yukarıda Yazılan Takımlardan İstediğiniz Birisini Yazınız ");
        Scanner oku = new Scanner(System.in);
        String takim = oku.next();
        int macSay = 0, galiSay = 0, beraSay = 0, magSay = 0, topGol = 0, yenTopGol = 0, topPuan = 0;
        int atılan, yenilen;
        int macBilgi[] = new int[7];
        File dosya = new File("turnuva.txt");
        Scanner scn = new Scanner(dosya);
        if (!dosya.exists()) {
            dosya.createNewFile();
        } else {
            while (scn.hasNextLine()) {
                String okunan = scn.nextLine();
                String s[] = okunan.split(" ");
                if (takim.equals(s[1])) {
                    macSay++;                       //yapılan maç sayısını artıyor
                    atılan = Character.getNumericValue(s[3].charAt(0));
                    yenilen = Character.getNumericValue(s[3].charAt(2));
                    topGol += atılan;
                    yenTopGol += yenilen;
                    if (atılan > yenilen) {
                        galiSay++;
                        topPuan += 3;
                    } else if (atılan == yenilen) {
                        beraSay++;
                        topPuan += 1;
                    } else {
                        magSay++;
                    }
                    macBilgi[0] = macSay;
                    macBilgi[1] = galiSay;
                    macBilgi[2] = beraSay;
                    macBilgi[3] = magSay;
                    macBilgi[4] = topGol;
                    macBilgi[5] = yenTopGol;
                    macBilgi[6] = topPuan;
                } else if (takim.equals(s[2])) {
                    macSay++;                       //yapılan maç sayısını artıyor
                    atılan = Character.getNumericValue(s[3].charAt(2));
                    yenilen = Character.getNumericValue(s[3].charAt(0));
                    topGol += atılan;
                    yenTopGol += yenilen;
                    if (atılan > yenilen) {
                        galiSay++;
                        topPuan += 3;
                    } else if (atılan == yenilen) {
                        beraSay++;
                        topPuan += 1;
                    } else {
                        magSay++;
                    }
                    macBilgi[0] = macSay;
                    macBilgi[1] = galiSay;
                    macBilgi[2] = beraSay;
                    macBilgi[3] = magSay;
                    macBilgi[4] = topGol;
                    macBilgi[5] = yenTopGol;
                    macBilgi[6] = topPuan;
                }
            }
            for (int i = 0; i < 7; i++) {
                System.out.print(macBilgi[i] + ",");
            }
        }
        return macBilgi;
    }
}