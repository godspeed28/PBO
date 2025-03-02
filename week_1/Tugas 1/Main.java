public class Main {
    static void setNim(String nim){
        System.out.println("NIM : " + nim);
    }
    static void setNama(String nama){
        System.out.println("Nama : " + nama);
    }
    static void setAlamat(String jln, String kel, String kec, String kota, String prov, int kodePos){
        System.out.println("Alamat : " + "Jln. " + jln +", "+kel+", " +"Kec. " + kec + ", " + "Kota " + kota + ", " + prov + " " + kodePos );
    }
    static String setNoHP(long noHP){
        return "Telp : " + noHP;
    }
    static void setEmail(String email){
        System.out.println("Email : " + email);
    }
    public static void main(String[] args){
        setNim("A11.2023.15193");
        setNama("Albert Kolin");
        setAlamat("Nakula Raya No. 36", "Pendirikan Kidul", "Semarang Tengah", "Semarang", "Jawa Tengah", 5013);
        System.out.println(setNoHP(6281236262924L));
        setEmail("albertog4taz28@gmail.com");
    }
}