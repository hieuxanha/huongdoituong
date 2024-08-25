import java.util.Scanner;

 abstract class Khachhang {
    //Mã khách hàng, họ tên, địa chỉ, số điện thoại.
    private int makhachhang;

    private String hoten;

    private String diachi;

    private int sdt;

    private double abc;

     public Khachhang(int makhachhang, String hoten, String diachi, int sdt, double abc) {
         this.makhachhang = makhachhang;
         this.hoten = hoten;
         this.diachi = diachi;
         this.sdt = sdt;
         this.abc = abc;
     }

     public int getMakhachhang() {
        return makhachhang;
    }

    public void setMakhachhang(int makhachhang) {
        this.makhachhang = makhachhang;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.diachi = diachi;
    }


    public void Khachhang(int makhachhang, String hoten, String diachi, int sdt) {
        this.makhachhang = makhachhang;
        this.hoten = hoten;
        this.diachi = diachi;
        this.sdt = sdt;

    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã khách hàng : ");
        makhachhang = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập họ tên :  ");
        hoten = sc.nextLine();
        System.out.println("Nhâp địa chỉ : ");
        diachi = sc.nextLine();
        System.out.println("Nhập số điện thoại : ");
        sdt = Integer.parseInt(sc.nextLine());

    }

    public void output() {
        System.out.println("Mã khách hàng : " + makhachhang);
        System.out.println("Họ tên : " + hoten);
        System.out.println("địa chỉ : " + diachi);
        System.out.println("Số địện thoại : " + sdt);

    }

    public void inPut() {

    }

    public void outPut() {

    }
}
//: loại khách hàng và khuyến mại.
    class Khachhanhtt extends Khachhang {

    private String loaikh;

    private int khuyenmai;

    public String getLoaikh() {
        return loaikh;
    }

    public int getKhuyenmai() {
        return khuyenmai;
    }

    public void setLoaikh(String loaikh) {
        this.loaikh = loaikh;
    }

    public void setKhuyenmai(int khuyenmai) {
        this.khuyenmai = khuyenmai;
    }

    public Khachhanhtt(int makhachhang, String hoten, String diachi, int sdt, String loaikh, int khuyenmai) {
        super(makhachhang,hoten,diachi,sdt,khuyenmai);
        this.loaikh = loaikh;
        this.khuyenmai = khuyenmai;
    }

@Override
    public void inPut() {
        super.input();
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập loai Khcash hàng : ");
        loaikh = sc.nextLine();
        System.out.println("nhập khuyến mại : ");
        khuyenmai = Integer.parseInt(sc.nextLine());
    }
    @Override
    public void outPut(){
        super.output();
        System.out.println("loại khách hàng : "+loaikh);
        System.out.println("khuyến mại : "+khuyenmai);

    }
}
    public class bai3 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            Khachhanhtt[] dskh= new Khachhanhtt[100];
            int a=0;
            int chon;
            do{
                System.out.println("1.Nhập vào danh sách n khách hàng thân thiết");
                System.out.println("2.In danh sách các khách hàng thân thiết vừa nhập ra màn hình.");
                System.out.println("3.Tìm kiếm khách hàng thân thiết có mức khuyến mại cao nhất.");
                System.out.println("4.Đếm số khách hàng thân thiết thuộc loại khách hàng kim cương.");
                System.out.println("0.thoát ");
                chon=sc.nextInt();
                switch(chon){
                    case 1:
                    System.out.println("số lương khasnh hàng ");
                    int n=sc.nextInt();
                        for (int i = 0; i < n; i++) {
                            System.out.println("thông tin khách hàng thứ " + (i + 1) + " ");
                            dskh[i] = new Khachhanhtt(0, "", "", 0, "", 0);
                            dskh[i].inPut();
                            dskh[a++]=dskh[i];
                        }
                        break;

                    case 2:
                        for (int i = 0; i < a; i++) {
                            System.out.println("khách thứ " + (i + 1) + " ");
                            dskh[i].outPut();
                        }
                    break;
                    case 3:
                        //c. Tìm kiếm khách hàng thân thiết có mức khuyến mại cao nhất.
//                        Khachhanhtt KH_KM_CAONHAT = dskh[0];
//                        for (int i = 1; i < a; i++) {
//                            if (dskh[i].getKhuyenmai() > KH_KM_CAONHAT.getKhuyenmai()) {
//                                KH_KM_CAONHAT = dskh[i];
//                            }
//                            System.out.println(" Khách hàng có khuyến mại cao nhất ");
//                            KH_KM_CAONHAT.outPut();


                       // }

                        Khachhanhtt KH_KM_CAONHAT = dskh[0];
                        for (int i = 1; i < a; i++) {
                            if (dskh[i].getKhuyenmai() > KH_KM_CAONHAT.getKhuyenmai()) {
                                KH_KM_CAONHAT = dskh[i];
                            }
//                            System.out.println(" Khách hàng có khuyến mại cao nhất ");
//                            KH_KM_CAONHAT.outPut();
                        }
                        double hieudz = KH_KM_CAONHAT.getKhuyenmai();


                        System.out.println("Khách hàng có khuyến mại cao nhất:");
                        for (int i = 0; i < a; i++) {
                            if (dskh[i].getKhuyenmai() == hieudz ) {
                                dskh[i].outPut();
                            }
                        }
                        break;

                        case 4:
                            //  dd. Đếm số khách hàng thân thiết thuộc loại khách hàng kim cương.
                           int demkh=0;
                            for(int i=0;i<a;i++){
                                if(dskh[i].getLoaikh().equalsIgnoreCase("kimcuong")){
                                    demkh++;
                                }
                            }
                            System.out.println("số khahcs hàng : "+demkh);
                              break;
                    case 0:
                        System.out.println("kết thức chương trình ");
                     break;
                    default:
                        System.out.println("lỗi ");
                }
            }while(chon!=0);

        }
    }

