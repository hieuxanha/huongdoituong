package baithi;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

abstract class Khachthue{
    private String hoten;
    private String add;
    private String sdt;

    public String getHoten() {
        return hoten;
    }

    public String getAdd() {
        return add;
    }

    public String getSdt() {
        return sdt;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public Khachthue(String hoten, String add, String sdt) {
        this.hoten = hoten;
        this.add = add;
        this.sdt = sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
       public void input(){
           Scanner sc=new Scanner(System.in);
           System.out.println("nhập họ tên : ");
           hoten=sc.nextLine();
           System.out.println("nhập địa chỉ : ");
           add=sc.nextLine();
           System.out.println("nhập số điện thoại : ");
           sdt=sc.nextLine();

       }

       public void output(){
           System.out.println("họ tên : "+hoten);
           System.out.println("địa chỉ : "+add);
           System.out.println("số điện thoại : "+sdt);
       }

    public abstract void inPut();

    public abstract void outPut();
}

class thethue extends Khachthue {
    private String sophieuthue;
    private String sohieutruyen;
    private Date ngaythue;
    private Date hantra;
    private double sotienthue;


    public String getSophieuthue() {
        return sophieuthue;
    }

    public String getSohieutruyen() {
        return sohieutruyen;
    }

    public Date getNgaythue() {
        return ngaythue;
    }

    public Date getHantra() {
        return hantra;
    }

    public void setSophieuthue(String sophieuthue) {
        this.sophieuthue = sophieuthue;
    }

    public void setSohieutruyen(String sohieutruyen) {
        this.sohieutruyen = sohieutruyen;
    }

    public void setNgaythue(Date ngaythue) {
        this.ngaythue = ngaythue;
    }

    public void setHantra(Date hantra) {
        this.hantra = hantra;
    }

    public void setSotienthue(double sotienthue) {
        this.sotienthue = sotienthue;
    }

    public double getSotienthue() {
        return sotienthue;
    }

    public void setTdb(double sotienthue) {
        this.sotienthue = sotienthue;
    }


    public thethue(String hoten, String add, String sdt, String sophieuthue, String sohieutruyen, Date ngaythue, Date hantra, double sotienthue) {
        super(hoten, add, sdt);
        this.sophieuthue = sophieuthue;
        this.sohieutruyen = sohieutruyen;
        this.ngaythue = ngaythue;
        this.hantra = hantra;
        this.sotienthue = sotienthue;
    }

    @Override
    public void inPut() {
        super.input();
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat abb=new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("nhập số phiếu thuê : ");
        sophieuthue = sc.nextLine();
        System.out.println("nhập số hiệu truyện : ");
        sohieutruyen = sc.nextLine();


//  try{
//
//            SimpleDateFormat datee=new SimpleDateFormat("dd/MM/yyyy");
//            ngaynhapvien= datee.parse(sc.nextLine());
//        }catch (ParseException e){
//            e.printStackTrace();
//        }
//        while(true){
//            try{
//                System.out.println("Nhập ngày ra viện (dd/MM/yyyy)");
//                SimpleDateFormat date=new SimpleDateFormat("dd/MM/yyyy");
//                Date ngayravien=date.parse(sc.nextLine());
//                if(ngayravien.before(ngaynhapvien)){
//                    throw new loingay("ngày ra viênj ko thể nhỏ hơn ngày nhập ");
//                }
//                this.ngayravien=ngayravien;
//                break;
//            }catch (ParseException e){
//                e.printStackTrace();
//            }catch (loingay ln){
//                System.out.println(ln.getMessage());
//            }
//        }
   try{
       System.out.println("nhập ngày muon : ");
       ngaythue = abb.parse(sc.nextLine());
   }catch (ParseException e ){
       e.printStackTrace();
   }
   while(true) {
       try {
           System.out.println("nhập hạn trả : ");
           hantra = abb.parse(sc.nextLine());
           if (hantra.before(ngaythue)) {
               throw new loingay("ngày mượn không thể nhỏ hơn ngày trả ");
           }
           this.hantra = hantra;
           break;

       }catch (ParseException e ){
           e.printStackTrace();
       }catch (loingay e1 ){
           System.out.println(e1.getMessage());
       }
   }



//      try{
//          System.out.println("nhập ngày mượn (đ/MM/yyyy) : ");
//          String ngaymuonstr=sc.nextLine();
//          ngaythue=abb.parse(ngaymuonstr);
//          System.out.println("nhập hạn trả (dd/MM/yyyy) : ");
//          String ngayhantrastr=sc.nextLine();
//          hantra=abb.parse(ngayhantrastr);
//          kiemtrahantra(this.ngaythue,this.hantra);
//      }catch (loingay e){
//          System.out.println("lỗi"+e.getMessage());
//          System.out.println("lỗi nhập lại thông tin ");
//          String ngayhantrastr=sc.nextLine();
//      }catch (Exception e){
//          System.out.println("lỗi định danh  ");
//      }
        System.out.println("số tiền thuê nhà :  ");
      sotienthue=sc.nextDouble();

    }
//    public static void kiemtrahantra(Date ngaythue,Date hantra)throws loingay{
//        if(hantra.compareTo(ngaythue) < 0){
//            throw new loingay("ngày trả không thể nhỏ hơn ngày mượn ");
//        }
//    }


    // Kiểm tra tính hợp lệ của ngày



    @Override
    public void outPut() {
       super.output();
       SimpleDateFormat abb=new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("số phiếu thuê : " + sophieuthue);
        System.out.println("số hiệu truyện : " + sohieutruyen);
        System.out.println("ngày mươn(thuê) : " +abb.format(ngaythue));
        System.out.println("hạn trả : " + abb.format(hantra));
        System.out.println("số tiền thuê " + sotienthue);
       }
}

public class bai12_conghieu {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("danh sách người mượn !");
        int n=sc.nextInt();
        thethue[] a=new thethue[n];

        for(int i=0;i<n;i++){
            System.out.println("thông tin người mươn thứ "+(i+1)+"");
            a[i] =new thethue("","","","","",new Date(),new Date(),0);
            a[i].inPut();

        }

        for(int i=0;i<n;i++){
            System.out.println("người mươn thứ :"+(i+1)+" : ");
            a[i].outPut();
        }


        double tongtien=0;
        for(int i=0;i<n;i++){
            tongtien+=a[i].getSotienthue();
        }

        double tbtienthue = tongtien/n;
        System.out.println("trung binhf cuar accs phieeus thuee "+tbtienthue);

    }
}
