import java.util.Scanner;

//Mã nhân viên, họ tên, phòng ban, số điện thoại, địa chỉ, hệ số
//        lương
abstract class Nhanvien{
    private int manhanvien;

    private String hoten;

    private int phongban;

    private int sdt;

    private int diachi;

    private double hesoluong;

    public int getManhanvien(){
        return manhanvien;
    }

    public void setManhanvien(int manhanvien){
        this.manhanvien=manhanvien;
    }

    public String getHoten(){
        return hoten;
    }

    public void setHoten(String hoten){
        this.hoten=hoten;
    }

    public int getPhongban(){
        return phongban;
    }
    public void setPhongban(int phongban){
        this.phongban=phongban;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public void setDiachi(int diachi) {
        this.diachi = diachi;
    }

    public void setHesoluong(double hesoluong) {
        this.hesoluong = hesoluong;
    }

    public int getSdt() {
        return sdt;
    }

    public int getDiachi() {
        return diachi;
    }

    public double getHesoluong() {
        return hesoluong;
    }


    public Nhanvien(int manhanvien, String hoten, int phongban, int sdt, int diachi, double hesoluong) {
        this.manhanvien = manhanvien;
        this.hoten = hoten;
        this.phongban = phongban;
        this.sdt = sdt;
        this.diachi = diachi;
        this.hesoluong = hesoluong;
    }

  public void input(){
      Scanner sc= new Scanner(System.in);
      System.out.println("nhập mã nhân viên : ");
      manhanvien=Integer.parseInt(sc.nextLine());
      System.out.println("nhập họ tên : ");
      hoten=sc.nextLine();
      System.out.println("nhập phòng ban : ");
      phongban=Integer.parseInt(sc.nextLine());
      System.out.println("nhập số điện thoaị : ");
      sdt=Integer.parseInt(sc.nextLine());
      System.out.println("nhập địa chỉ : ");
      diachi=Integer.parseInt(sc.nextLine());
      System.out.println("nhập hệ số lương : ");
      hesoluong=sc.nextDouble();

  }

  public void output(){
      System.out.println("mã nhân viên : "+manhanvien);
      System.out.println("họ tên : "+hoten);
      System.out.println("phòng ban : "+phongban);
      System.out.println("số điện thoại : "+sdt);
      System.out.println("địa chỉ  : "+diachi);
      System.out.println("hệ số lương :"+hesoluong);
    }


    public abstract void inPut();

    public abstract void outPut();
}

class canboquanly extends Nhanvien{
    private String chucvu;

    private int phucap;

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }

    public void setPhucap(int phucap) {
        this.phucap = phucap;
    }

    public String getChucvu() {
        return chucvu;
    }

    public int getPhucap() {
        return phucap;
    }

    public canboquanly(int manhanvien, String hoten, int phongban, int sdt, int diachi, double hesoluong, String chucvu, int phucap) {
        super(manhanvien, hoten, phongban, sdt, diachi, hesoluong);
        this.chucvu = chucvu;
        this.phucap = phucap;
    }

    @Override
    public void inPut(){
        super.input();
        Scanner sc=new Scanner(System.in);
        System.out.println("nhập chức vụ : ");
        chucvu=sc.nextLine();
        System.out.println("nhập phụ cấp : ");
        phucap=Integer.parseInt(sc.nextLine());


    }
    @Override
    public void outPut(){
        super.output();
        System.out.println("chức vụ : "+chucvu);
        System.out.println("phụ cấp : "+phucap);
    }
}
public class bai4 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        canboquanly[] dscb =new canboquanly[100];
        int chon;
        int a=0;
        do{
            System.out.println("1.Nhập vào danh sách n cán bộ quản lý");
            System.out.println("2.In danh sách các cán bộ quản lý vừa nhập ra màn hình.");
            System.out.println("3.Tìm kiếm cán bộ quản lý có chức vụ là giám đốc.");
            System.out.println("4.Sắp xếp các cán bộ quản lý theo mức phụ cấp giảm dần");
            System.out.println("0.thoát ");
            chon=sc.nextInt();
            switch(chon) {
                case 1:
                    System.out.println("số lượng ");
                    int n = sc.nextInt();
                    for (int i = 0; i < n; i++) {
                        System.out.println("thông tin cán bộ thứ " + (i + 1) + " : ");
                        dscb[i] = new canboquanly(0, "", 0, 0, 0, 0, "", 0);
                        dscb[i].inPut();
                        dscb[a++] = dscb[i];
                    }
                    break;
                case 2:
                    for (int i = 0; i < a; i++) {
                        System.out.println("quản lý thứ : " + (i + 1) + " ");
                        dscb[i].outPut();
                    }
                    break;
                case 3:

                    System.out.println("Tìm kiếm cán bộ quản lý có chức vụ là giám đốc");
                    // Tìm kiếm cán bộ quản lý có chức vụ là giám đốc
                    boolean fdgiamdoc = false;
                    for (int i = 0; i < a; i++) {
                        if (dscb[i].getChucvu().equalsIgnoreCase("giamdoc")) {
                            dscb[i].outPut();
                            fdgiamdoc = true;
                        }
                    }
                    if(!fdgiamdoc){
                        System.out.println("khoong cos giams doc lam ca ");
                    }


                    //boolean foundGiamDoc = false;
//                    for (int i = 0; i < n; i++) {
//                        var canbo = dsCB[i];
//                        if (canbo.getChucVu().equalsIgnoreCase("giamdoc")) {
//                            System.out.println(" thông tin giám doc ");
//                            canbo.outPut();
//                            System.out.println();
//                            foundGiamDoc = true;
//                        } else {
//                            System.out.println("thằng nhận viên quènnnn !!!!!!!!");
//                            canbo.outPut();
//                        }
//                    }
//
//                    if (!foundGiamDoc) {  // có dc k dc
//                        System.out.println("khong co can bo nao co chuc vu giam doc");
//                    }


                    break;
                case 4:
                    System.out.println("Sắp xếp các cán bộ quản lý theo mức phụ cấp giảm dần");
// Sắp xếp các cán bộ quản lý theo mức phụ cấp giảm dần
                    for(int i=0;i<a-1;i++) {
                        for (int j = i + 1; j < a ; j++) {
                            if (dscb[i].getPhucap() < dscb[j].getPhucap()) {
                                canboquanly temp = dscb[i];
                                dscb[i] = dscb[j];
                                dscb[j] = temp;
                            }
                        }

                    }
                    for(int i=0;i<a;i++){
                        System.out.println("thông tin can bộ quản lí thứ "+(i+1)+" ");
                        dscb[i].outPut();
                    }
                    break;
                case 0:
                    System.out.println("kết thúc chương trình ");
                    break;
                default:
                    System.out.println("Lỗi ");
            }
        }while(chon!=0);
        }
    }

