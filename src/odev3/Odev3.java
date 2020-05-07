package odev3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class Odev3 {
    void getTakimBilgi() throws IOException {
        //getTakimBilgi() metodu ise ilgili takımın turnuva tablosu bilgilerini (sırasıyla, maçların sayısı, galibiyet sayısı, beraberlik sayısı, mağlubiyet sayısı,
        //attığı toplam gol, yediği toplam gol, kazanılan toplam puan) bir dizi biçiminde bu nesne dizisinden türetmek için kullanılır.
        //public int[] getTakimBilgi(Mac m[]);
        //Yukarıda tanımlanan m nesne dizisi için getTakimBilgi() metodu {5, 2, 2, 1, 6, 7, 8} dizisini üretecektir.
        Scanner oku = new Scanner(System.in);
        System.out.println("Lütfen Yukarıda Yazılan Takımlardan İstediğiniz Birisini Yazınız ");
        System.out.println("Lütfen Bilgilerini İstediğiniz Takımın İsmini Giriniz: ");
        String takim = oku.next();
        int macSay = 0, galiSay = 0, beraSay = 0, magSay = 0, topGol = 0, yenTopGol = 0, topPuan = 0;
        int atılan, yenilen;
        int macBilgi[] = new int[7];
        File dosya = new File("turnuva.txt");
        int haftaNO = 1;
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
                    System.out.println("Toplam Maç Sayısı: " + macSay
                            + "\nToplam Galibiyet Sayısı: " + galiSay
                            + "\nToplam Beraberlik Sayısı: " + beraSay
                            + "\nToplam Mağlubiyet Sayısı: " + magSay
                            + "\nToplam Gol Sayısı: " + topGol
                            + "\nToplam Yenilen Gol Sayısı: " + yenTopGol
                            + "\nToplam Kazanılan  Puan: " + topPuan
                    );
                    System.out.println("************************************************");
                    System.out.println(haftaNO + " .Maçı ");
                    System.out.println("************************************************");
                    haftaNO++;
                }
                else if(takim.equals(s[2])){
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
                    System.out.println("Toplam Maç Sayısı: " + macSay
                            + "\nToplam Galibiyet Sayısı: " + galiSay
                            + "\nToplam Beraberlik Sayısı: " + beraSay
                            + "\nToplam Mağlubiyet Sayısı: " + magSay
                            + "\nToplam Gol Sayısı: " + topGol
                            + "\nToplam Yenilen Gol Sayısı: " + yenTopGol
                            + "\nToplam Kazanılan  Puan: " + topPuan
                    );
                    System.out.println("************************************************");
                    System.out.println(haftaNO + " .Maçı ");
                    System.out.println("************************************************");
                    haftaNO++;
                }
            }
            scn.close();
        }
    }
    void haftaPuan() throws IOException {
        Scanner girdiOku = new Scanner(System.in);
        System.out.println("Lüften İstediğiniz Haftanın Puan Durumu");
        int hafta = girdiOku.nextInt();
        //Haftalık Puan Tablosu her takımın sadece kullanıcı haftaya girecek bütün takımların puanları listelenecek
        File dosya = new File("turnuva.txt");
        Scanner scn = new Scanner(dosya);
        int atılan, yenilen, topPuan = 0;
        String okunan="",yeni="";
        String temp[];
        if (!dosya.exists()) {
            dosya.createNewFile();
        } else {
            while (scn.hasNextLine()) {                
                okunan=scn.nextLine();
                yeni+=okunan;
            }
            scn.close();
            temp = yeni.split(" ");
            int macSayisi=temp.length/4;
            String belliHafta[][] = new String[macSayisi][4];
            int say=0;
            for (int i = 0; i < macSayisi; i++) {
                for (int j = 0; j < 4; j++) {
                    belliHafta[i][j] = temp[say];
                            say++;
                }
            }
            int macvarmı = 0;
            System.out.println("-------------------------------------");
            System.out.println("İstenilen Haftanın Macları ");
            System.out.println("-------------------------------------");
            for (int i = 0; i < macSayisi; i++) {
                for (int j = 0; j < 4; j++) {
                    if (belliHafta[i][0].equals(Integer.toString(hafta))) {
                        System.out.print(belliHafta[i][j]+" ");
                        macvarmı++;
                    }
                }
                System.out.println("");
            }
            System.out.println("-------------------------------------");
            System.out.println("İstenilen Haftanın Macları ");
            System.out.println("-------------------------------------");
            if (macvarmı==0) {
                System.out.println("\nGirdiğiniz Haftada Maç Yoktur.........\n");
            }
        }
    }
    public static void main(String[] args) throws IOException {
        mac saha = new mac();
        Odev3 takım = new Odev3();
        System.out.println("******************************\nTAKIMLAR");
        System.out.println("Fenerbahce\nGalatasaray\nBasaksehir\nAntalyaspor\nBesiktas");
        System.out.println("********************************************************");
        System.out.println("Lütfen istediğiniz işlemi için Numaraları Tuşlayınız : ");
        System.out.println("1)  İstenilen Takımın Bütün Bilgileri: ");
        System.out.println("2)  İstenilen Haftanın Maç Tablosu: ");
        System.out.println("3)  İstenilen Takımın Dizi Şeklindeki Bilgileri");
        System.out.println("0) Programdan Çıkmak....");
        System.out.println("********************************************************");
        boolean sec = true;
        int secint;
        Scanner scn = new Scanner(System.in);
        secint = scn.nextInt();
        while (sec) {
            if (secint == 1) {
                takım.getTakimBilgi();
                System.out.println("********************************************************");
                System.out.println("Başka Bİr İşlem Yapmak İstermisiniz");
                secint = scn.nextInt();
                System.out.println("********************************************************");
            } else if (secint == 2) {
                takım.haftaPuan();
                System.out.println("********************************************************");
                System.out.println("Başka Bİr İşlem Yapmak İstermisiniz");
                secint = scn.nextInt();
                System.out.println("********************************************************");
            } else if (secint == 3) {
                    saha.getTakimInfo();
                System.out.println("\n********************************************************");
                System.out.println("Başka Bİr İşlem Yapmak İstermisiniz");
                secint = scn.nextInt();
                System.out.println("********************************************************");
            } else if (secint == 0) {
                System.out.println("********************************************************");
                System.out.println("Programdan Çıkıyorsunuz...");
                System.exit(0);
                System.out.println("********************************************************");
            } else {
                System.out.println("Hatalı Tuşlama...");
                System.out.println("Böyle Bir Komut Yok");
                System.out.println("Programdan Çıkıyorsunuz...");
                System.exit(0);
            }
        }
    }
}