// package week_8;

class BangunDatar{
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

    public BangunDatar(int sisi){
        this.sisi = sisi;
    }
    public BangunDatar(int panjang,int lebar){
        this.panjang = panjang;
        this.lebar = lebar;
        this.stat = "rectangle";
    }
    public BangunDatar(double alas,double tinggi){
        this.alas = alas;
        this.tinggi = tinggi;
        this.stat = "triangle";

    }
    public BangunDatar(double radius){
        this.radius = radius;
        this.stat = "circle";

    }
    public void luas(BangunDatar bd){
        if(bd.stat.equals("square")){
            this.luas = bd.sisi*bd.sisi;
        }

    }

    public void getLuas(){
        System.out.println(this.luas);
        
    }
}