package baithi;


import java.util.Scanner;

abstract class Khachhang{
    private String makhachhang;
    private String hoten;
    private String sonha;
    private String macongto;

    public String getMakhachhang() {
        return makhachhang;
    }

    public String getHoten() {
        return hoten;
    }

    public String getSonha() {
        return sonha;
    }

    public String getMacongto() {
        return macongto;
    }

    public void setMakhachhang(String makhachhang) {
        this.makhachhang = makhachhang;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public void setSonha(String sonha) {
        this.sonha = sonha;
    }

    public void setMacongto(String macongto) {
        this.macongto = macongto;
    }

    public Khachhang(String makhachhang, String hoten, String sonha, String macongto) {
        this.makhachhang = makhachhang;
        this.hoten = hoten;
        this.sonha = sonha;
        this.macongto = macongto;
    }


    public void input(){
        Scanner sc= new Scanner(System.in);
        System.out.println("nhập mã kahchs hàng : ");
        makhachhang=sc.nextLine();
        System.out.println("nhập họ tên : ");
        hoten=sc.nextLine();
        System.out.println("nhâp số nhà : ");
        sonha=sc.nextLine();
        System.out.println("nhập mã công tơ : ");
        macongto=sc.nextLine();
    }

    public void output(){
        System.out.println("mã khách hàng : "+makhachhang);
        System.out.println("họ tên : "+hoten);
        System.out.println("số nhà : "+sonha);
        System.out.println("mã công tơ : "+macongto);
    }

    public abstract void inPut();

    public abstract void outPut();
}
class loicongto extends Exception{
    public loicongto(String aa){
        super(aa);
    }
}
class hoadon extends Khachhang{
    private int somoi;
    private  int socu;
    private  int thangsudung;

    public int getSomoi() {
        return somoi;
    }

    public int getSocu() {
        return socu;
    }

    public int getThangsudung() {
        return thangsudung;
    }

    public void setSomoi(int somoi) {
        this.somoi = somoi;
    }

    public void setSocu(int socu) {
        this.socu = socu;
    }

    public void setThangsudung(int thangsudung) {
        this.thangsudung = thangsudung;
    }

    public hoadon(String makhachhang, String hoten, String sonha, String macongto, int somoi, int socu, int thangsudung) {
        super(makhachhang, hoten, sonha, macongto);
        this.somoi = somoi;
        this.socu = socu;
        this.thangsudung = thangsudung;
    }

    @Override
    public void inPut(){
        super.input();
        Scanner sc=new Scanner(System.in);
//        System.out.println("nhâp số mới : ");
//        somoi=Integer.parseInt(sc.nextLine());
//        System.out.println("nhập số cũ : ");
//        socu=Integer.parseInt(sc.nextLine());
//        if(somoi < socu){
//            try{
//                throw new loicongto("chỉ số mới pahir lớn hơn số cũ ");
//            }catch (loicongto e){
//                System.out.println(" lỗi :"+e.getMessage());
//                System.out.println("nhập số cũ : ");
//                socu=Integer.parseInt(sc.nextLine());
//
//            }
//        }
        System.out.print("Nhập chỉ số cũ: ");
        socu = Integer.parseInt(sc.nextLine());

        do {
            System.out.print("Nhập chỉ số mới: ");
            somoi = Integer.parseInt(sc.nextLine());

            if (somoi < socu) {
                try {
                    throw new loicongto("Chỉ số mới phải lớn hơn chỉ số cũ.");
                } catch (loicongto e) {
                    System.out.println("Lỗi: " + e.getMessage());
                }
            }
        } while (somoi < socu);

        System.out.println("Chỉ số mới hợp lệ: " + somoi);


        System.out.println("nhập tháng sử dụng :");
        thangsudung=sc.nextInt();

    }


    @Override
    public void outPut(){
        super.output();
        System.out.println("số mới : "+somoi);
        System.out.println("số cũ : "+socu);
        System.out.println("tháng sử dụng : "+thangsudung);
    }

    public int tinhtiendien(){
        return (somoi - socu)*850;
    }
}

public class bai11hieu {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        hoadon[] dshoadon=new hoadon[100];

        int chon;

        do{
            System.out.println("1.Nhập vào danh sách n thẻ thuê, xuất danh sách thẻ thuê ra màn hình");
            System.out.println("2.Tính trung bình tiền thuê của các phiếu thuê.");
            System.out.println("0.thoát ");
            chon=sc.nextInt();
            switch (chon){
                case 1:
                    System.out.println("sso lương ");
                    int n=sc.nextInt();
                    for(int i=0;i<n;i++){
                        System.out.println("thông tin hóa dơn thứ "+(i+1)+" ");
                        dshoadon[i] = new hoadon("","","","",0,0,0);
                        dshoadon[i].inPut();
                    }

                    System.out.println("danh sách hóa đơn ");
                    for(int i=0;i<n;i++){
                        System.out.println("hóa đơn thứ "+(i+1)+"");
                        dshoadon[i].outPut();
                        System.out.println("Tiền điện phải trả: " + dshoadon[i].tinhtiendien()+ " VND");
                    }
                    break;
                case 2:
                    System.out.println("nhập mã kahch hàng đeer tìm kiếm hóa đơn ");
                    sc.nextLine();
                    String makhtimkiem = sc.nextLine();

                    boolean found = false;
                    for(hoadon hoadonn : dshoadon){
                        if(hoadonn.getMakhachhang().equals(makhtimkiem)){
                            System.out.println("thông tin mã khách hàng có mã "+makhtimkiem+" ");
                            hoadonn.outPut();
                            found=true;
                            break;
                        }
                    }
                    if(!found){
                        System.out.println("ko tìm tháy");
                    }
                    break;
            }
        }while(chon!=0);

    }
}
