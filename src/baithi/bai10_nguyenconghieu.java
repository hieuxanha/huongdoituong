package baithi;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

abstract class sinhvien1{
    private String hoten;
    private String namsinh;
    private String lop;

    public String getHoten() {
        return hoten;
    }

    public String getNamsinh() {
        return namsinh;
    }

    public String getLop() {
        return lop;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public void setNamsinh(String namsinh) {
        this.namsinh = namsinh;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public sinhvien1(String hoten, String namsinh, String lop) {
        this.hoten = hoten;
        this.namsinh = namsinh;
        this.lop = lop;
    }

    public void input(){
        Scanner sc=new Scanner(System.in);
        System.out.println("nhập họ tên : ");
        hoten=sc.nextLine();
        System.out.println("nhập năm sinh : ");
        namsinh=sc.nextLine();
        System.out.println("nhập lớp ; ");
        lop=sc.nextLine();

    }

    public void output(){
        System.out.println("họ tên : "+hoten);
        System.out.println("năm sinh : "+namsinh);
        System.out.println("lớp : "+lop);
    }

    public abstract void inPut();
}

class lopthemuon  extends sinhvien1 {
    private int sophieuthue;
    private String sohieusach;
    private Date ngaythue;
    private Date hantra;

    public void setSophieuthue(int sophieuthue) {
        this.sophieuthue = sophieuthue;
    }

    public void setSohieusach(String sohieusach) {
        this.sohieusach = sohieusach;
    }




    public int getSophieuthue() {
        return sophieuthue;
    }

    public String getSohieusach() {
        return sohieusach;
    }

    public Date getNgaythue() {
        return ngaythue;
    }

    public Date getHantra() {
        return hantra;
    }

    public lopthemuon(String hoten, String namsinh, String lop, int sophieuthue, String sohieusach, Date ngaythue, Date hantra) {
        super(hoten, namsinh, lop);
        this.sophieuthue = sophieuthue;
        this.sohieusach = sohieusach;
        this.ngaythue = ngaythue;
        this.hantra = hantra;
    }

    public void setNgaythue(Date ngaythue) {
        this.ngaythue = ngaythue;
    }

    public void setHantra(Date hantra) {
        this.hantra = hantra;
    }

    @Override
    public void inPut() {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat abc = new SimpleDateFormat("dd/MM/yyyy");
        super.input();
        System.out.println("nhập số phiêu thuê : ");
        sophieuthue = Integer.parseInt(sc.nextLine());
        System.out.println("nhập số hiệu sách : ");
        sohieusach = sc.nextLine();
       try{
           System.out.println("nhập ngày mượn (dd/MM/yyyy) : ");
           String ngaymuonstr = sc.nextLine();
           ngaythue=abc.parse(ngaymuonstr);
           System.out.println("nhập hạn trả (dd/MM/yyyy)");
           String hantrastr = sc.nextLine();
           hantra = abc.parse(hantrastr);
           kiemtrahantra(this.ngaythue,this.hantra);

       }catch (loingay e){
           System.out.println("lỗi "+e.getMessage());
           System.out.println("nhập hạn trả (dd/MM/yyyy)");
           String hantrastr = sc.nextLine();
           System.out.println("lỗi nhập lại thông tin hạn trả ");
       }catch (Exception e ){
           System.out.println("lỗi định dạng ");
       }

    }

    public static void kiemtrahantra(Date ngaythue,Date hantra)throws loingay{
        if(hantra.compareTo(ngaythue) < 0 ){
            throw new loingay("ngày trả không thể nhỏ hơn ngày mượn");
        }
    }

        public void outPut () {
        super.output();
        SimpleDateFormat abc=new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("số phiêu thuê : " + sophieuthue);
        System.out.println("số hiệu sách : " + sohieusach);
        System.out.println("ngày thuê : " +abc.format(ngaythue));
        System.out.println("hạn trả : " +abc.format(hantra));

    }
    }


public class bai10_nguyenconghieu {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        lopthemuon[] dssv=new lopthemuon[100];
        int sosv=0;
        int chon;
        do{
            System.out.println("1.nhập thông tin nguoi muon ");
            System.out.println("2.in ra danh sách thẻ mượn ra màn hình ");
            System.out.println("3.đếm tổng số phiếu mượn tại thư viện ");
            System.out.println("0.thoát");
            chon =sc.nextInt();
            switch (chon){
                case 1:

                        System.out.println("số lượng sinh viên ");
                        int n=sc.nextInt();
                        for(int i=0;i<n;i++){
                            System.out.println("thông tin sinh viên muốn mượn thẻ thứ "+(i+1)+" ");
                            dssv[i]=new lopthemuon("","","",0,"",new Date(), new Date());
                            dssv[i].inPut();
                            dssv[sosv++]=dssv[i];
                        }
                    break;
                case 2:
                    for(int i=0;i<sosv;i++){
                        System.out.println("sinh viên mượn thẻ "+ i +"");
                        dssv[i].outPut();

                    }
                    break;
                case 3:
                    int tongsophieumuon=0;
                   for(int i=0;i<sosv;i++){
                       tongsophieumuon=+dssv[i].getSophieuthue();
                   }
                    System.out.println("tổng số phiếu mượn là : "+tongsophieumuon);
                   break;
                case 0:
                    System.out.println("kết chương trình ");
                    break;
                default:
                    System.out.println("lựa chọn ko hơpj lệ ");
            }
        }while(chon!=0);
    }

}
