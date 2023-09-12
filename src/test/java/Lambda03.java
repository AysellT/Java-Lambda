import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Lambda03 {

    public static void main(String[] args) {

        List<String> menu = new ArrayList<>(Arrays.asList("saksuka", "lahmacun", "yaglama","manti", "borek", "doner", "iskender", "kokorec",
                      "cacik", "makarna", "pizza", "yaglama"));

        //alfebetik siralama ile tekrarsiz olarak menudeki yemekleri buyuk harf ile yazdirin
        alfebetikTekrarsizMenu(menu);

        //menudeki yemekleri karakter sayilarini yazdirin
        karakterSayilariniYazdir(menu);

        //menudeki yemekleri son harflerine gore siralayip yazdirin
        yemekleriSonHarflerineGoreYazdir(menu);

        //menudeki karakter sayisi cift olan yemekleri tekrarsiz buyukten kucuge siralayin
        ciftKarakterliYemekleriSiraliYazdir(menu);

        //menude 7'den az karakterde ymeek ismi olmamasi gerekiyor
        menude7denAzKarakterliYemekVarMi(menu);

        //menude w harfi ile baslayan yemek olmamasi gerektigini test et
        wHarfiIleBaslayanYemekOlmamali(menu);

        //menude x harfi ile baslayan yemek var mi
        xHarfiIleBaslayanYemekVarMi(menu);

        //menude karakter sayisi en fazla olan yemegi yazdirin
        karakterSayisiEnFazlaOlanYemekYazdir(menu);

        //menudeki yemekleri son harfine gore siralayip ilk elemani yazdirmayin
        sonHarfeGoreSiralaIlkYemegiAtla(menu);

    }

    public static void sonHarfeGoreSiralaIlkYemegiAtla(List<String> menu) {

        System.out.println("\nyemekler son harfine gore siralandi ilk yemek atlandi");
        menu
                .stream()
                .sorted(Comparator.comparing(t -> t.charAt(t.length()-1)))
                .skip(1)
                .forEach(t -> System.out.print(t + " "));
    }

    public static void karakterSayisiEnFazlaOlanYemekYazdir(List<String> menu) {

        System.out.println("\nkarakter sayisi en fazla olan yemek");
        System.out.println(menu
                .stream()
                .sorted(Comparator.comparing(t -> t.toString().length()).reversed())
                .findFirst()); // en cok karaktere sahip birinci yemegi yazdirir



        System.out.println("\nen fazla karaktere sahip ilk uc yemek");
        System.out.println(menu
                .stream()
                .sorted(Comparator.comparing(t -> t.toString().length()).reversed())
                .limit(3)); //limit fonsksiyonu bize array dondurdugu icin direk yazdiramiyorum

        Stream<String> ilkUcYemek = menu
                .stream()
                .sorted(Comparator.comparing(t -> t.toString().length()).reversed())
                .limit(3);
        System.out.println(Arrays.toString(ilkUcYemek.toArray())); // bir stream'i array'e cevirip,Arrays classindan yardim aliyoruz

        System.out.println(Arrays.toString(menu.stream().sorted(Comparator.comparing(t -> t.toString().length()).reversed()).limit(3).toArray()));

        // limit() eğer stream'den belli sayıdaki elemanları almak istersek kullanılır. Bize dönüş olarak bir stream döndürecektir.
        // Bu yüzden direk yazdırılmasi mümkün değildir.
        // Bu streamın yazdırılması için ilk olarak toArray() method ile array'e çevrilmeli sonra Arrays.toString() methodu ile yazdırılmalı


    }

    public static void xHarfiIleBaslayanYemekVarMi(List<String> menu) {

        System.out.println("\nx harfi ile baslayan yemek var mi?");
        System.out.println(menu
                .stream()
                .anyMatch(t -> t.startsWith("x"))); //bir tane yemegin x ile baslamasi true dondurecektir

        System.out.println(menu
                .stream()
                .anyMatch(t -> t.startsWith("x")) ? "x ile baslayan yemek ismi var" : "x ile baslayan yemek ismi yok");

    }

    public static void wHarfiIleBaslayanYemekOlmamali(List<String> menu) {

        System.out.println("\nmenude w harfi ile baslayan yemek olmamasi gerektigini test et");

        System.out.println("w harfi ile baslayan yemek ismi yok :  "+
                menu
                        .stream()
                        .noneMatch(t -> t.startsWith("w"))); //hicbirinin w ila baslamamasi durumu true

    }

    public static void menude7denAzKarakterliYemekVarMi(List<String> menu) {

        System.out.println("\nmenude 7'den az karakterde ymeek ismi olmamasi gerekiyor");
        System.out.println(menu
                .stream()
                .allMatch(t -> t.length() <= 7)); //true yada false donecek

        boolean kontrol = menu
                .stream()
                .allMatch(t -> t.length() <= 7); //kosul tum elemanlar icin saglandiginda true doner

        if (kontrol){
            System.out.println("Butun yemek isimleri en az 7 karakterli");
        }else {
            System.out.println("En az bir yemek ismi 7'den daha az karaktere sahip");
        }

        System.out.println(kontrol ? "Butun yemek isimleri en az 7 karakterli" : "En az bir yemek ismi 7'den daha az karaktere sahip");

    }

    public static void ciftKarakterliYemekleriSiraliYazdir(List<String> menu) {

        System.out.println("\nmenudeki karakter sayisi cift olan yemekleri tekrarsiz buyukten kucuge siralayin");
        menu
                .stream()
                .map(String::length)
                .filter(Lambda01::ciftMi)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .forEach(Lambda01::yazdir);
    }


    public static void yemekleriSonHarflerineGoreYazdir(List<String> menu) {

        System.out.println("\nmenudeki yemekleri son harflerine gore siralayip yazdirin");
        menu
                .stream()
                .sorted(Comparator.comparing(t -> t.charAt(t.length()-1))) //t.toString() eklenebilir
                .forEach(t -> System.out.print(t + " "));
    }

    public static void karakterSayilariniYazdir(List<String> menu) {

        System.out.println("\nmenudeki yemekleri karakter sayilarini yazdirin");
        menu
                .stream()
                .map(String::length)
                //.sorted(Comparator.reverseOrder()) buyukten kucuge siralar
                .forEach(Lambda01::yazdir);

    }


    public static void alfebetikTekrarsizMenu(List<String> menu) {

        System.out.println("alfebetik siralama ile tekrarsiz olarak menudeki yemekleri buyuk harf ile yazdirin");
        menu
                .stream()
                //.map(t -> t.toUpperCase()) //listedeki tum elemanlarin hepsine uygulanacak bir degisim "map"
                .map(String::toUpperCase)
                .sorted()  //dogal siraya koyar
                .distinct() //tekrarlari siler
                .forEach(t -> System.out.print(t+ " "));
        
    }
}
