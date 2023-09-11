import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda01 {

    /*

    1-) Lambda "Functional programming" --> method(action) kullanarak programlama
    ** Genellikle method create etmek yerine hazir methodlar kullanarak yazili
    ** Methodlarin calismasi icin gerekli duzenekler onceden hazirlanmistir
    ** cok az kod kullanarak kompleks islemler yapilabilir

    2-) Nasil yapabilirim'den ziyade ne yapabilirim sorusunun cevabini lambda ile verebilirsiniz
    ** "Structured programming" kodlari kendimiz yazdigimiz
    ** "Functional programming" hazir methodlar kullanilarak, cok daha kisa ve oz, hatasiz calisma

    3-) Collectionlar icin kullanilir (List, Oueue, Set vs), map'ler kullanilamaz


     */

    public static void main(String[] args) {

        List<Integer> sayilar = new ArrayList<>(Arrays.asList(25,45,67,21,34,18,46,88,90,72,56,37,81,36,11,34,51,24,92));

        elemanlariYazdirForeach(sayilar);

        elemanlariYazdirLambda(sayilar);

        elemanlariYazdirFunctionLmabda(sayilar);

        System.out.println("\nListedeki cift sayilari java ile yazdiralim");
        ciftSayilariYazdirStructured(sayilar);

        System.out.println("\nListedeki cift sayilari lambda ile yazdiralim");
        ciftSayilariYazdirFunctional(sayilar);
        System.out.println("  ");
        ciftSayilariYazdirFunctional2(sayilar);

        System.out.println("\n50 sayisindan kucuk cift sayilari yazdiralim");
        elliSayisindanKucukCiftSayilariYazdir(sayilar);

        System.out.println("\n50 sayisindan buyuk cift sayilari yazdiralim");
        elliSayisindanBuyukCiftSayilariYazdir(sayilar);

    }

    private static void elliSayisindanBuyukCiftSayilariYazdir(List<Integer> sayilar) {

        sayilar.stream().filter(Lambda01::ciftMi).filter(Lambda01::ellidenBuyukMu).forEach(Lambda01::yazdir);

    }

    public static Boolean ellidenBuyukMu(Integer a){
        boolean ellidenBuyukMu = true ;

        if (a>50){
            ellidenBuyukMu = true ;
        }else {
            ellidenBuyukMu = false ;
        }

        return ellidenBuyukMu;
    }

    public static void elliSayisindanKucukCiftSayilariYazdir(List<Integer> sayilar) {

        sayilar.stream().filter(Lambda01::ciftMi).filter(Lambda01::ellidenKucukMu).forEach(Lambda01::yazdir);

    }

    public static Boolean ellidenKucukMu(Integer a) {

        boolean ellidenKucukMu = true;

        if (a < 50) {
            ellidenKucukMu = true;
        } else {
            ellidenKucukMu = false;
        }

        return ellidenKucukMu;
    }



    private static void ciftSayilariYazdirFunctional2(List<Integer> sayilar) {

        sayilar.stream().filter(Lambda01::ciftMi).forEach(Lambda01::yazdir);

    }

    public static Boolean ciftMi(Integer a){

        boolean ciftKontrolu = a % 2 == 0;

        return ciftKontrolu;
    }

    public static void ciftSayilariYazdirFunctional(List<Integer> sayilar) {

        sayilar.stream().filter( t -> t%2 == 0 ).forEach(Lambda01::yazdir);

    }


    public static void ciftSayilariYazdirStructured(List<Integer> sayilar) {

        for (Integer eachSayi:sayilar
             ) {

            if (eachSayi%2==0){
                System.out.print(eachSayi+ " ");
            }
        }

    }

    public static void elemanlariYazdirFunctionLmabda(List<Integer> sayilar) {

        System.out.println("\nFunction olarak method kullanma");
        sayilar.stream().forEach(Lambda01::yazdir);

    }

    public static void yazdir(int a){

        System.out.print(a + " ");

    }

    public static void elemanlariYazdirLambda(List<Integer> sayilar) {

        System.out.println("\nLamda ile");
        sayilar.stream().forEach((t) -> System.out.print(t+" "));

    }


    public static void elemanlariYazdirForeach(List<Integer> sayilar) {

        System.out.println("foreach loop ile");
        //sayilar listesinin elemanlarini aralarinda bir bosluk birakarak yazdirin
        for (int eachSayi: sayilar
        ) {
            System.out.print(eachSayi+" ");
        }

    }

}
