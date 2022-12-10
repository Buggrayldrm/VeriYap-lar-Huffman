//02210201002--Mehmet Buğra Yıldırım

import java.util.HashMap;
import java.util.Scanner;

public class HuffmanList {
    public static void main(String[] args) {
        HashMap<String, String> degerler = new HashMap<String, String>();
        Scanner inputlar = new Scanner(System.in);//Degerlerin alınması
        String[] dizi = new String[8];//Alınan stringlerin atıldığı dizi
        String b;
        String[] output = new String[8];
        String[] harfler = new String[4];
        int[] frekans = new int[4];//Frekansların tutulduğu liste
        int uzunluk = dizi.length;
        int Esayisi = 0;
        int Lsayisi = 0;
        int İsayisi = 0;
        int Fsayisi = 0;
        System.out.println("Sadece E L İ F harflerini içeren değerler giriniz(Tüm değerler büyük olmalı): ");

        for (int i = 0; i < uzunluk; i++) {// Karakterler teker teker diziye atılıyor.
            b = inputlar.nextLine();
            dizi[i] = b;
        }
        for (int j = 0; j < uzunluk; j++) {
            System.out.print(dizi[j] + " ");//Karakterlerin ekrana yazdırılması
        }
        System.out.println(" ");

        for (int i = 0; i < uzunluk; i++) {//İnputlara göre frekans degerlerininin arttırlması.
            if (dizi[i].equals("E")) {
                Esayisi++;
            }
            if (dizi[i].equals("L")) {
                Lsayisi++;
            }
            if (dizi[i].equals("İ")) {
                İsayisi++;
            }
            if (dizi[i].equals("F")) {
                Fsayisi++;
            }
        }
        int tmp = 0, k = 0, l = 0;
        String tmp1 = "";

        harfler[0] = "E";
        harfler[1] = "L";
        harfler[2] = "İ";
        harfler[3] = "F";

        frekans[0] = Esayisi;
        frekans[1] = Lsayisi;
        frekans[2] = İsayisi;
        frekans[3] = Fsayisi;
        for (k = 0; k < frekans.length; k++) {//Frekansların küçükten büyüğe sıralanması.
            for (l = 0; l < frekans.length - 1; l++) {
                if (frekans[l] > frekans[l + 1]) {
                    tmp = frekans[l];
                    frekans[l] = frekans[l + 1];
                    frekans[l + 1] = tmp;
                    tmp1 = harfler[l];
                    harfler[l] = harfler[l + 1];
                    harfler[l + 1] = tmp1;
                }
            }
        }
        degerler.put(harfler[0], "00");//frekansı en küçük olana 00 biti verilir.
        degerler.put(harfler[1], "01");
        degerler.put(harfler[2], "10");
        degerler.put(harfler[3], "11");//frekansı en büyük olana 11  biti verilir.

        for (int j = 0; j < uzunluk; j++) {
            if (dizi[j].equals("E")) {
                output[j] = degerler.get("E");
            }
            if (dizi[j].equals("L")) {
                output[j] = degerler.get("L");
            }
            if (dizi[j].equals("İ")) {
                output[j] = degerler.get("İ");
            }
            if (dizi[j].equals("F")) {
                output[j] = degerler.get("F");
            }
        }
        for (int j = 0; j < uzunluk; j++) {//Girilen değerlerin bit karşılığının sırayla tek satıra yazdırılması.
            System.out.print(output[j] + " ");
        }
        System.out.println(" ");
        for (int j = 0; j < harfler.length; j++) {//Tekrar sayısına göre alfabe harflerinin yazdırılması.
            System.out.print(harfler[j] + " ");
        }
        System.out.println(" ");
        for (int j = 0; j < harfler.length; j++) {//Alfabe harflerinin tekrar sayılarının gösterilmesi..
            System.out.print(frekans[j] + " ");
        }
    }
}