import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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

    }

    public static void wHarfiIleBaslayanYemekOlmamali(List<String> menu) {

        System.out.println("\nmenude w harfi ile baslayan yemek olmamasi gerektigini test et");

        System.out.println("w harfi ile baslayan yemek ismi yok :  "+
                menu
                        .stream()
                        .noneMatch(t -> t.startsWith("w"))
        );
    }

    public static void menude7denAzKarakterliYemekVarMi(List<String> menu) {

        System.out.println("\nmenude 7'den az karakterde ymeek ismi olmamasi gerekiyor");
        System.out.println(menu
                .stream()
                .allMatch(t -> t.length() <= 7)); //true yada false donecek

        boolean kontrol = menu
                .stream()
                .allMatch(t -> t.length() <= 7);

        if (kontrol){
            System.out.println("Butun yemek isimleri en az 7 karakterli");
        }else {
            System.out.println("En az bir yemek ismi 7'den daha az karaktere sahip");
        }

        //
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
