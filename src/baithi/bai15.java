package baithi;

import java.util.Scanner;

class khachhang{
    private String makhachhang;
    private String hoten;
    private int sonha;
    private String masocongto;

    public String getMakhachhang() {
        return makhachhang;
    }

    public String getHoten() {
        return hoten;
    }

    public int getSonha() {
        return sonha;
    }

    public String getMasocongto() {
        return masocongto;
    }

    public void setMakhachhang(String makhachhang) {
        this.makhachhang = makhachhang;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public void setSonha(int sonha) {
        this.sonha = sonha;
    }

    public void setMasocongto(String masocongto) {
        this.masocongto = masocongto;
    }

    public khachhang(String makhachhang, String hoten, int sonha, String masocongto) {
        this.makhachhang = makhachhang;
        this.hoten = hoten;
        this.sonha = sonha;
        this.masocongto = masocongto;
    }
    public void input(){
        Scanner sc=new Scanner(System.in);
        System.out.println("nhaapj max khach hang ; ");
        makhachhang=sc.nextLine();
        System.out.println("nhập họ tên : ");
        hoten=sc.nextLine();
        System.out.println("nhập số nha : ");
        sonha=Integer.parseInt(sc.nextLine());
        System.out.println("nhập mã công tơ : ");
        masocongto=sc.nextLine();
    }
    public void output(){
        System.out.println("mã khách hàng : "+makhachhang);
        System.out.println("họ tên : "+hoten);
        System.out.println("số nhà : "+sonha);
        System.out.println("mã công tơ : "+masocongto);

    }

}
class hoadon2 extends Khachhang{
    private int chisomoi;
    private int chisocu;
    private String thangsudung;

    public void setChisomoi(int chisomoi) {
        this.chisomoi = chisomoi;
    }

    public void setChisocu(int chisocu) {
        this.chisocu = chisocu;
    }

    public void setThangsudung(String thangsudung) {
        this.thangsudung = thangsudung;
    }

    public int getChisomoi() {
        return chisomoi;
    }

    public int getChisocu() {
        return chisocu;
    }

    public String getThangsudung() {
        return thangsudung;
    }

    public hoadon2(String makhachhang, String hoten, String sonha, String macongto, int chisomoi, int chisocu, String thangsudung) {
        super(makhachhang, hoten, sonha, macongto);
        this.chisomoi = chisomoi;
        this.chisocu = chisocu;
        this.thangsudung = thangsudung;
    }
    @Override
    public void inPut(){
        super.input();
        Scanner sc= new Scanner(System.in);
//        System.out.println("nhập chỉ số mới : ");
//        chisomoi=Integer.parseInt(sc.nextLine());
//        System.out.println("nhập chỉ số cũ : ");
//        chisocu=Integer.parseInt(sc.nextLine());
//
//
//        if(chisomoi < chisocu){
//            try{
//                throw new loicongto("chỉ số mới phải lớn hơn cũ ");
//            }
//            catch (loicongto e){
//                System.out.println("lỗi : "+e.getMessage());
//                System.out.println("nhập chỉ số cũ : ");
//                chisocu=Integer.parseInt(sc.nextLine());
//            }
//
//        }

        System.out.print("Nhập chỉ số cũ: ");
        chisocu = Integer.parseInt(sc.nextLine());

        do {
            System.out.print("Nhập chỉ số mới: ");
            chisomoi = Integer.parseInt(sc.nextLine());

            if (chisomoi < chisocu) {
                try {
                    throw new loicongto("Chỉ số mới phải lớn hơn chỉ số cũ.");
                } catch (loicongto e) {
                    System.out.println("Lỗi: " + e.getMessage());
                }
            }
        } while (chisomoi < chisocu);

        System.out.println("Chỉ số mới hợp lệ: " + chisomoi);

        System.out.println("nhập tháng sử dụng : ");
        thangsudung=sc.nextLine();

    }
    @Override
    public void outPut(){
        super.output();
        System.out.println("số mới : "+chisomoi);
        System.out.println("chỉ số cũ : "+chisocu);
        System.out.println("tháng sử dung : "+thangsudung);
    }

    public double tinhtiennc(){
        return (chisocu * chisomoi) * 8000;
    }

}
public class bai15 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("danh sách hóa đơn : ");
        int n=sc.nextInt();

        hoadon2[] a=new hoadon2[n];

        for(int i=0;i<n;i++){
            System.out.println("thông tiên hóa đơn thứ "+(i+1)+":");
            a[i] = new hoadon2("","","","",0,0,"");
            a[i].inPut();

        }

        for(int i=0;i<n;i++){
            System.out.println("hóa dơn thứ "+(i+1)+"");
            System.out.println("tính tiền nc ; "+a[i].tinhtiennc());
            a[i].outPut();
        }

        System.out.println("nhập mã khách hàng để tìm kiểm hóa đơn ");
        sc.nextLine();
        String matimkiem =sc.nextLine();
         boolean found = false;
        for(int i=0;i<n;i++){
            if(a[i].getMakhachhang().equals(matimkiem)){
                System.out.println("thông tin mã khahcs hàng có mã "+matimkiem);
                a[i].outPut();
            }
        }


    }
}
