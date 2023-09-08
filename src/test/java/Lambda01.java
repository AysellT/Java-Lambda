import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda01 {

    public static void main(String[] args) {

        List<Integer> sayilar = new ArrayList<>(Arrays.asList(25,45,67,21,34,18,46,88,90,72,56,37,81,36,24,92));


        System.out.println("foreach loop ile");
        //sayilar listesinin elemanlarini aralarinda bir bosluk birakarak yazdirin
        for (int eachSayi: sayilar
             ) {
            System.out.print(eachSayi+" ");
        }


        System.out.println("\nLamda ile");
        sayilar.stream().forEach((t) -> System.out.print(t+" "));

    }

}
