import javax.xml.crypto.dom.DOMCryptoContext;
import java.io.InputStream;
import java.util.Scanner;

abstract class vdv {
    private String  mavdv;

    private String hoten;
    private int tuoi;
    private String gioitinh;

    // public String getMaSanPham() {
//        return maSanPham;
//    }
//
//    public void setMaSanPham(String maSanPham) {
//        this.maSanPham = maSanPham;
//    }
    //get set
    public String getMavdv() {
        return mavdv;
    }

    public void setMavdv(String mavdv) {
        this.mavdv=mavdv;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getGioitinh() {
        return gioitinh;
    }
    //

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    //    public vdv(int mavdv, String hoten, int tuoi, String gioitinh) {
//        this.mavdv = mavdv;
//        this.hoten = hoten;
//        this.tuoi = tuoi;
//        this.gioitinh = gioitinh;
//    }
    public vdv(String mavdv, String hoten, int tuoi, String gioitinh) {
        this.mavdv = mavdv;
        this.hoten = hoten;
        this.tuoi = tuoi;
        this.gioitinh = gioitinh;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap ma vdv :");
        mavdv =sc.nextLine();
        System.out.println("nhap ho ten :");
        hoten = sc.nextLine();
        System.out.println("nhap tuooii :");
        tuoi = Integer.parseInt(sc.nextLine());
        System.out.println("gioi tih :");
        gioitinh = sc.nextLine();

    }

    public void output() {
        System.out.println("mã vdv : " + mavdv);
        System.out.println("họ tên : " + hoten);
        System.out.println("tuổi :" + tuoi);
        System.out.println("giới tính : " + gioitinh);

    }

    public abstract void inPut();

    public abstract void outPut();
}
// kế thừa vdv
    class vdvkinhte extends vdv{
        private double culychay;
        private double tocdochay;

        public vdvkinhte(String mavdv,String hoten,int tuoi,String gioitinh,double culychay,double tocdochay){
        super(mavdv,hoten,tuoi,gioitinh);
        this.culychay=culychay;
        this.tocdochay=tocdochay;

    }
    public double getCulychay(){
        return culychay;
    }
    public void setCulychay(int culychay){
            this.culychay=culychay;
        }

        public double getTocdochay(){
            return tocdochay;
        }

        public void setTocdochay(int tocdochay){
            this.tocdochay=tocdochay;
        }





    @Override
    public void inPut() {
        super.input();
        Scanner sc = new Scanner(System.in);
        System.out.println(" nhap cu ly chạy :");
        culychay = sc.nextDouble();
        System.out.println("toc do chay : ");
        tocdochay =sc.nextDouble();
    }

    @Override
    public void outPut() {
        super.output();
        System.out.println("cu ly chay : "+culychay);
        System.out.println("toc do chay : "+tocdochay);
    }

}

public class bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        vdvkinhte[] run = new vdvkinhte[100];
        int chon;
        int sovandongvan=0;
        do {
            System.out.println("1. Nhập vào danh sách n vận động viên điền kinh.");
            System.out.println("2.In danh sách các vận động viên điền kinh vừa nhập ra màn hình.");
            System.out.println("3.Sắp xếp các vận động viên điền kinh trong danh sách theo cự ly chạy từ nhỏ đến lớn ");
            System.out.println("4.Tìm kiếm vận động viên điền kinh nhiều tuổi nhất");
            System.out.println("0.thoát");
            chon = sc.nextInt();
            switch (chon) {

                case 1:


                    System.out.println("số lương vạn dộng viên ");
                    int n = sc.nextInt();
                    for (int i = 0; i < n; i++) {
                        System.out.println("nhap thong tin vdv thứ " + (i + 1) + " ");
                        run[i] = new vdvkinhte("", "", 0, "", 0.0, 0.0);
                        run[i].inPut();
                        run[sovandongvan++] = run[i];
                    }

                    break;
                case 2:
                    System.out.println("in danh sách vdv !");
                    for (int i = 0; i < sovandongvan; i++) {
                        System.out.println("vdv Thu " + (i + 1) + ": ");
                        run[i].outPut();
                    }
                    break;
                    // nhở đến lớn
                case 3:
                    for (int i = 0; i < sovandongvan - 1; i++) {
                        for (int j = i + 1; j < sovandongvan; j++) {
                            if (run[i].getCulychay() > run[j].getCulychay()) {
                                vdvkinhte temp = run[i];
                                run[i] = run[j];
                                run[j] = temp;
                            }

                        }
                    }
                    System.out.println("vdv sau khi sap xepp  !");
                    System.out.println(' ');
                    for (int i = 0; i < sovandongvan; i++) {
                        System.out.println("vdv Thu " + (i + 1) + ": ");
                        run[i].outPut();
                    }
                    break;
                case 4:
                    vdvkinhte vdvcaotuoi  = run[0];
                    for(int i=1;i<sovandongvan;i++){
                        if(run[i].getTuoi()>vdvcaotuoi.getTuoi()){
                            vdvcaotuoi=run[i];
                        }
                    }
                    System.out.println("vdv nhiều tuổi");
                    System.out.println();

                    double hi = vdvcaotuoi.getTuoi();
                    for(int i=0;i<sovandongvan;i++){
                        if(run[i].getTuoi() == hi ){
                            run[i].outPut();
                        }
                    }
                    break;

                case 0:
                    System.out.println("kết thúc chương trình");
                    break;
                default:
                    System.out.println("lỗi");
            }
        }while(chon!=0);



    }
}
