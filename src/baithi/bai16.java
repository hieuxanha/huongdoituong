package baithi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

abstract class giaodich1{
   private String magiaodich;
   private Date ngaygiaodich;

   private long dongia;
   private long dientich;

    public String getMagiaodich() {
        return magiaodich;
    }

    public Date getNgaygiaodich() {
        return ngaygiaodich;
    }

    public long getDongia() {
        return dongia;
    }

    public long getDientich() {
        return dientich;
    }

    public void setMagiaodich(String magiaodich) {
        this.magiaodich = magiaodich;
    }

    public void setNgaygiaodich(Date ngaygiaodich) {
        this.ngaygiaodich = ngaygiaodich;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }

    public void setDientich(int dientich) {
        this.dientich = dientich;
    }

    public giaodich1() {
    }

    public giaodich1(String magiaodich, Date ngaygiaodich, long dongia, long dientich) {
        this.magiaodich = magiaodich;
        this.ngaygiaodich = ngaygiaodich;
        this.dongia = dongia;
        this.dientich = dientich;
    }

    public void input(){
        Scanner sc=new Scanner(System.in);
        System.out.println("nhập mã giao dich : ");
        magiaodich=sc.nextLine();
        SimpleDateFormat abcc=new SimpleDateFormat("dd/MM/yyyy");
        try {
            System.out.println("ngay giao dich ");
            ngaygiaodich=abcc.parse(sc.nextLine());
        } catch (ParseException e) {
            throw new RuntimeException(e);

        }

        do{
            System.out.println("nhâp don giá : ");
            dongia=sc.nextLong();
            if(dongia <= 0){
                System.out.println(" vui long nhâp lại ");
            }
        }while(dongia <= 0);

        System.out.println("nhập điện tích : ");
        dientich=sc.nextLong();

    }

    public void output(){
        SimpleDateFormat abcc=new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("mã giao dich :"+magiaodich);
        System.out.println("ngayf giao dich :"+abcc.format(ngaygiaodich));
        System.out.println("dơn giá : "+dongia);
        System.out.println("điện tích : "+dientich);
    }

    public abstract void inPut();

    public abstract void outPut();
}


class giaodichdat extends giaodich1{
   private char loaidat;

    public char getLoaidat() {
        return loaidat;
    }

    public void setLoaidat(char loaidat) {
        this.loaidat = loaidat;
    }

    public giaodichdat(String magiaodich, Date ngaygiaodich, int dongia, int dientich, char loaidat) {
        super(magiaodich, ngaygiaodich, dongia, dientich);
        this.loaidat = loaidat;
    }
    @Override
    public void inPut(){
        super.input();
        Scanner sc=new Scanner(System.in);
        System.out.println("nhập laoij đất (a,b,c) : ");
        loaidat=sc.nextLine().charAt(0);

    }
    @Override
    public void outPut(){
        super.output();
        System.out.println("loại đất : "+loaidat);
    }
    public double tinhthanhtien() {

           if(loaidat == 'a'){
               return getDientich() * getDongia() * 1.5;
           }else{
               return getDientich() * getDongia();
           }
    }


}

public class bai16 {
    public static void main(String[] args)  {
        Scanner sc=new Scanner(System.in);
        System.out.println("nhâp số lương giao dich ");
        int n=sc.nextInt();

        giaodichdat[] a=new giaodichdat[n];

        for(int i=0;i<n;i++){
            System.out.println("thông tin giao dich thứ"+(i+1)+"");
            a[i] = new giaodichdat("",new Date(),0,0,' ');
            a[i].inPut();
        }

        for(int i=0;i<n;i++){
            System.out.println("giao dich thứ "+(i+1)+"");
            a[i].outPut();
        }

        System.out.println("các giao dich có giá trị hơn 2tyr ");
        for(int i=0;i<n;i++){
            if(a[i].tinhthanhtien() > 2e9){
                a[i].outPut();
            }
        }
    }
}
