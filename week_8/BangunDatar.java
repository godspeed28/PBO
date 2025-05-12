// package week_8;

class BangunDatar {
    protected int sisi;
    protected int lebar;
    protected int panjang;
    protected double alas;
    protected double tinggi;
    protected double radius;
    protected int luas;
    protected double luas2;
    protected String stat = "square";
    protected final double PHI = 3.14;

    public BangunDatar(int sisi) {
        this.sisi = sisi;
    }

    public BangunDatar(int panjang, int lebar) {
        this.panjang = panjang;
        this.lebar = lebar;
        this.stat = "rectangle";
    }

    public BangunDatar(double alas, double tinggi, String stat) {
        this.alas = alas;
        this.tinggi = tinggi;
        this.stat = stat;

    }

    public BangunDatar(double radius, String stat) {
        this.radius = radius;
        this.stat = stat;

    }

    public void luas(BangunDatar bd) {
        if (bd.stat.equals("square")) {
            this.luas = bd.sisi * bd.sisi;
        }
        if (bd.stat.equals("rectangle")) {
            this.luas = bd.panjang * bd.lebar;
        }
        if (bd.stat.equals("triangle")) {
            this.luas2 = 0.5 * bd.alas * bd.tinggi;
        }
        if (bd.stat.equals("circle")) {
            this.luas2 = PHI * bd.radius * bd.radius;
        }

    }

    public void getLuas() {
        System.out.println(this.luas);

    }

    public void getLuas2() {
        System.out.println(this.luas2);
    }
}