public class Main {
    
    static int luasPersegi(int s){
        return s * s; 
    }
    static int kelilingPersegi(int s){
        return 4 * s; 
    }
    static double luasSegitiga(int a, int t){
        double lS = 1.0/2.0 * a * t;
        return lS;
    }
    static int kelilingSegitiga(int a, int b, int c){
        return a + b + c;
    }
    static double luasLingkaran(int r){
        double lL = 22.0/7.0 * r * r;
        return lL;
    }
    static double kelilingLingkaran(int r){
        double kL = 2 * 22.0/7.0 * r ;
        return kL;
    }
    static int luasKubus(int s){
        return 6 * s * s;
    }
    static int kelilingKubus(int s){
        return 12 * s;
    }
    public static void main(String[] args) {
        int sisiPersegi = 5;
        int alasSegitiga = 10;
        int jari_jari = 21;
        int panjangSisiKubus = 4;
        System.out.println("Luas Persegi : " + luasPersegi(sisiPersegi));
        System.out.println("Keliling Persegi : " + kelilingPersegi(sisiPersegi));
        System.out.println("Luas Segitiga : " + (int)luasSegitiga(alasSegitiga,8));
        System.out.println("Keliling Segitiga : " + kelilingSegitiga(alasSegitiga,5,5));
        System.out.println("Luas Lingkaran : " + (int)luasLingkaran(jari_jari));
        System.out.println("Keliling Lingkaran : " + (int)kelilingLingkaran(jari_jari));
        System.out.println("Luas Kubus : " + luasKubus(panjangSisiKubus));
        System.out.println("Keliling Kubus : " + kelilingKubus(panjangSisiKubus));
    }
}