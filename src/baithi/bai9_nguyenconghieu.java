package baithi;

import javax.swing.plaf.SpinnerUI;
import java.util.Scanner;

abstract class nguoi{
    private String hoten;
    private String namsinh;

    public nguoi(String abc) {

    }

    public String getHoten() {
        return hoten;
    }

    public String getNamsinh() {
        return namsinh;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public void setNamsinh(String namsinh) {
        this.namsinh = namsinh;
    }

    public nguoi(String hoten, String namsinh) {
        this.hoten = hoten;
        this.namsinh = namsinh;
    }
    public void input(){
        Scanner sc=new Scanner(System.in);
        System.out.println("nhập họ tên : ");
        hoten=sc.nextLine();
        System.out.println("nhập năm sinh ngày tháng : ");
        namsinh=sc.nextLine();

    }
    public void output(){
        System.out.println("họ tên : "+hoten);
        System.out.println("ngày tháng năm sinh : "+namsinh);

    }


    public abstract void inPut();

    public abstract void outPut();
}
class sinhvien extends nguoi{
    private String masinhvien;
    private String lop;
    private double dtb;

    public String getMasinhvien() {
        return masinhvien;
    }

    public String getLop() {
        return lop;
    }

    public double getDtb() {
        return dtb;
    }

    public void setMasinhvien(String masinhvien) {
        this.masinhvien = masinhvien;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public void setDtb(double dtb) {
        this.dtb = dtb;
    }

    public sinhvien(String hoten, String namsinh, String masinhvien, String lop, double dtb) {
        super(hoten, namsinh);
        this.masinhvien = masinhvien;
        this.lop = lop;
        this.dtb = dtb;
    }
@Override
      public void inPut(){
        super.input();
        Scanner sc=new Scanner(System.in);
          System.out.println("nhập mã sinh viên : ");
          masinhvien=sc.nextLine();
          System.out.println("nhập lớp : ");
          lop=sc.nextLine();
          System.out.println("nhập điểm trung bình : " );
          dtb= sc.nextDouble();
         while(true){
             try{
                 System.out.println(" diểm trung binh :  ");
                 double diem=Double.parseDouble(sc.nextLine());
                 if(diem < 0 || diem > 10){
                     throw new loinhapdiem("điểm trung bình năm khaongr 0-10");
                 }
                 dtb=diem;
                 break;
             } catch (NumberFormatException e) {
                 System.out.println("điểm trung bình phair số ");
             }catch (loinhapdiem e ){
                 System.out.println(e.getMessage());
             }

         }
      }

      @Override
      public void outPut(){
        super.output();
          System.out.println("mã sinh viên : "+masinhvien);
          System.out.println("lớp : "+lop);
          System.out.println("điểm trung bình : "+dtb);
      }


    }


public class bai9_nguyenconghieu {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("nhapậ số lượng ");
        int n = sc.nextInt();
        sinhvien[] a= new sinhvien[n];
        for(int i=0;i<n;i++){
            System.out.println("nhập thông tin sinh viên thứ "+(i+1)+" ");
            a[i]=new sinhvien("","","","",0);
            a[i].inPut();

        }
        System.out.println("danh sách sinh vien ");
        for(sinhvien sv : a){
            sv.outPut();
        }
       //  In bảng điểm của một lớp bất kỳ
                System.out.print("\nNhập tên lớp để in bảng điểm: ");
                String tenLop = sc.nextLine();
                System.out.println("Bảng điểm của lớp " + tenLop + ":");
                boolean found = false;
                for (int i=0;i<n;i++) {
                    if (a[i].getLop().equalsIgnoreCase(tenLop)) {
                        a[i].outPut();
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("Không tìm thấy sinh viên nào trong lớp " + tenLop);
                }

    }
}
