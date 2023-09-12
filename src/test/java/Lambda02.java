import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda02 {

    public static void main(String[] args) {

        List<Integer> sayilar = new ArrayList<>(Arrays.asList(3,9,4,2,5,5,7,8,7,6,1,4,2));

        //Listedeki her elemanin kupunu alip bir ekleyip sonucunu yazdirin
        sayilarinKupuArtiBir(sayilar);

        //Listedeki tek sayilarin kupunu alip iki cikartin
        tekSayilarinKupuEksiIki(sayilar);

        //Listedeki cift sayilarin karekokunu yazdirin
        ciftSayilarinKarekokPrint(sayilar);

        //Listedeki max sayiyi bul ve yazdir
        maxSayiyiBul(sayilar);

        //Listedeki tum elemanlarin toplami
        butunToplam(sayilar);

        //Listedeki cift sayilarin carpimini yaz
        ciftSayilariCarp(sayilar);

        //Listedeki min sayi
        minSayiyiBul(sayilar);

    }

    public static void minSayiyiBul(List<Integer> sayilar) {

        System.out.println("\nListedeki min eleman");

        //integer class'ini kullanarak
        System.out.println(sayilar.stream().reduce(Integer::min));

        //Math class'ini kullanarak
        System.out.println(sayilar.stream().reduce(Math::min));

        //Lambda Expression ile cozum
        int minSayiLambda = sayilar.stream().reduce(Integer.MAX_VALUE, (x,y) -> x<y ? x : y);


    }

    public static void ciftSayilariCarp(List<Integer> sayilar) {

        System.out.println("\nListedeki tum cift sayilarin carpimi");
        System.out.println("carpim sonucu = " +
                sayilar.stream().filter(Lambda01::ciftMi).reduce(Math::multiplyExact));

        System.out.println("function olarak = " + sayilar.stream().filter(Lambda01::ciftMi).reduce(1,(a,b) -> (a*b)));
    }

    public static void butunToplam(List<Integer> sayilar) {

        System.out.println("\nListedeki tum sayilarin toplami");
        System.out.println(sayilar.stream().reduce(0,(a,b) -> a+b ));

        Integer toplam = sayilar.stream().reduce(0,(a,b) -> a+b ) ;
        System.out.println("tum sayilarin toplami = " + toplam);

        System.out.println(sayilar.stream().reduce(Integer::sum));
    }

    public static void maxSayiyiBul(List<Integer> sayilar) {

        System.out.println("\nListedeki max sayi");
        System.out.println(sayilar.stream().reduce(Math::max));
        Optional<Integer> maxSayi = sayilar.stream().reduce(Math::max);

        /*
        reduce() => anlami azaltmak olarak gecer. Sonucun tek elemana inmesini istedigimiz durumlarda kullanilir.
        Mesela maxSayi , minSayi veya butun sayilarin toplami , butun sayilarin carpimi
         */

    }

    public static void ciftSayilarinKarekokPrint(List<Integer> sayilar) {

        System.out.println("\nCift sayilarin karekoku");
        sayilar.stream().filter(t -> t%2 == 0).map(Math::sqrt).forEach(t -> System.out.print(t + " "));
    }

    public static void tekSayilarinKupuEksiIki(List<Integer> sayilar) {

        System.out.println("\nTek sayilarin kupu -2");
        sayilar.stream().filter(t -> t%2 != 0).map(t -> (t*t*t)-2).forEach(Lambda01::yazdir);

    }

    public static void sayilarinKupuArtiBir(List<Integer> sayilar) {

        System.out.println("Sayilarin kupu +1");
        sayilar.stream().map(t -> (t*t*t)+1 ).forEach(Lambda01::yazdir);

    }


}
