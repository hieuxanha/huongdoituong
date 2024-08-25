package baithi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

abstract class giaodich{

    private String magiaodich;
   private Date ngagiaodich;

    private int soluong;
    private  int dongia;

    public String getMagiaodich() {
        return magiaodich;
    }




    public int getSoluong() {
        return soluong;
    }

    public int getDongia() {
        return dongia;
    }

    public void setMagiaodich(String magiaodich) {
        this.magiaodich = magiaodich;
    }



    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }

    public Date getNgagiaodich() {
        return ngagiaodich;
    }

    public void setNgagiaodich(Date ngagiaodich) {
        this.ngagiaodich = ngagiaodich;
    }

    public giaodich(String magiaodich, Date ngagiaodich, int soluong, int dongia) {
        this.magiaodich = magiaodich;
        this.ngagiaodich = ngagiaodich;
        this.soluong = soluong;
        this.dongia = dongia;
    }

    //    Calendar cal=Calendar.getInstance();
//        System.out.println(cal);
//
//
//    // get năm ,tháng ngày
//    int nam =cal.get(Calendar.YEAR);
//    int thang =cal.get(Calendar.MONTH);
//    int ngay = cal.get(Calendar.DAY_OF_MONTH);
//        System.out.println("năm hiện tại : "+nam);
//        System.out.println("tháng hiện tại : "+(thang+1));
//    // chú tháng luôn chạy 0-11 (nên phải +thêm 1);
//        System.out.println("ngày hiện tại "+ngay);
    // theo ý muốn
//       cal.set(Calendar.YEAR,2004);
//       cal.set(Calendar.MONTH,9);
//       cal.set(Calendar.DAY_OF_MONTH,7);
//
//
//        int namsinh=cal.get(Calendar.YEAR);
//        int thangsinh=cal.get(Calendar.MONTH);
//        int ngaysinh=cal.get(Calendar.DAY_OF_MONTH);
//        System.out.println("ngày tháng năm sinh "
//        +ngaysinh+"/"+thangsinh+"/"+nam);
//
//        SimpleDateFormat dingdang=new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
//        Date d = cal.getTime();
//        String s=dingdang.format(d);
//        System.out.println(s);

    public void input(){
        Scanner sc=new Scanner(System.in);
//        Calendar cal=Calendar.getInstance();
//        System.out.println(cal);
        System.out.println("nhập mã giao dich : ");
        magiaodich=sc.nextLine();
        System.out.println("nhập ngày giao dich : ");
        try{
            SimpleDateFormat abcc = new SimpleDateFormat("dd/MM/yyyy");
            ngagiaodich= abcc.parse(sc.nextLine());
        } catch (ParseException e) {
            System.out.println("dịnh danh khum hợp lệ ");
        }
        System.out.println("nhập số luonng : ");

        do{
            soluong=Integer.parseInt(sc.nextLine());
            if(soluong <= 0){
                try{
                    throw  new loinhaptien(" chỉ số phải lướng hơn 0");
                }catch (loinhaptien e){
                    System.out.println("lõi "+e.getMessage());

                }
            }
        }while(soluong <=0);

        System.out.println("nhập dơn giá : ");
        dongia=Integer.parseInt(sc.nextLine());


    }

    public void output(){
        SimpleDateFormat abcc= new SimpleDateFormat();
        System.out.println("mã giao dich : "+magiaodich);
        System.out.println("Ngày giao dịch: " +abcc.format(ngagiaodich));
        System.out.println("số lương : "+soluong);
        System.out.println("đơn giá : "+dongia);
    }

    public abstract void inPut();

    public abstract void outPut();
}

class giaodichtiente extends giaodich{
    private int tigia;
    private String loaitiente;



    public int getTigia(){
        return tigia;
    }
    public String getLoaitiente(){
        return loaitiente;
    }

    public void setTigia(int tigia){
        this.tigia=tigia;
    }
    public void setLoaitiente(String loaitiente){
        this.loaitiente=loaitiente;
    }


    public giaodichtiente(String magiaodich, Date ngagiaodich, int soluong, int dongia, int tigia, String loaitiente) {
        super(magiaodich, ngagiaodich, soluong, dongia);
        this.tigia = tigia;
        this.loaitiente = loaitiente;
    }

    @Override
    public void inPut(){
        super.input();
        Scanner sc=new Scanner(System.in);
        System.out.println("nhập tỉ giá : ");
        tigia=Integer.parseInt(sc.nextLine());
        System.out.println("nhập loại tiền tệ ; ");
        loaitiente=sc.nextLine();
    }

    @Override
    public void outPut(){
        super.output();
        System.out.println("tỉ giá : "+tigia);
        System.out.println("loại tiền tệ : "+loaitiente);
    }
    public double thanhtien(){
        if(loaitiente.equalsIgnoreCase("usd") || loaitiente.equalsIgnoreCase("euro")){
            return getSoluong()*getDongia() *tigia;
        }else{
            return getSoluong() * getDongia();
        }
    }

}

public class bai13 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("số lương giao dịch ");
        int n=sc.nextInt();

        giaodichtiente[] a=new giaodichtiente[n];

        for(int i=0;i<n;i++){
            System.out.println("thông tin các giao dich thứ "+(i+1)+" ");
            a[i] =new giaodichtiente("",new Date(),0,0,0,"");
            a[i].inPut();
        }
        System.out.println("danh sach giao dich ");
        for(int i=0;i<n;i++){
            System.out.println("giao dich thu "+(i+1)+" ");
            System.out.println("thành tiền :"+a[i].getLoaitiente());
            a[i].outPut();
        }

        double sumthanhtien =0;
        for(int i=0;i<n;i++){
            sumthanhtien+=a[i].thanhtien();
        }
        System.out.println("tổng thành tiền của các giao dich tiênd tệ : "+sumthanhtien);





    }
}
