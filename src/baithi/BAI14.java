package baithi;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.SimpleTimeZone;

abstract class benhnhan{
    private String hoten;
    private int tuoi;
    private String gioitinh;
    private String add;
    private String cccd;

    public String getHoten() {
        return hoten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public String getAdd() {
        return add;
    }

    public String getCccd() {
        return cccd;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public benhnhan(String hoten, int tuoi, String gioitinh, String add, String cccd) {
        this.hoten = hoten;
        this.tuoi = tuoi;
        this.gioitinh = gioitinh;
        this.add = add;
        this.cccd = cccd;
    }
    public void input(){
        Scanner sc=new Scanner(System.in);
        System.out.println("nhập họ tên : ");
        hoten=sc.nextLine();
        System.out.println("nhập tuổi : ");
        tuoi=Integer.parseInt(sc.nextLine());
        System.out.println("nhập giới tính : ");
        gioitinh=sc.nextLine();
        System.out.println("nhập địa chỉ : ");
        add=sc.nextLine();
        System.out.println("nhập chứng minh thư : ");
        cccd=sc.nextLine();

    }

    public void output(){
        System.out.println("họ tên : "+hoten);
        System.out.println("tuổi : "+tuoi);
        System.out.println("giới tính : "+gioitinh);
        System.out.println("địa chỉ : "+add);
        System.out.println("chứng minh thư : "+cccd);
    }

    public abstract void inPut();

    public abstract void outPut();
}

class hoadon1 extends benhnhan{
    private String mahondon;
    private Date ngaynhapvien;
    private Date ngayravien;
    private String chuandoanbenh;
    private String bacsi;
    private int sotienthanhtoan;

    public hoadon1(String hoten, int tuoi, String gioitinh, String add, String cccd, String mahondon, Date ngaynhapvien, Date ngayravien, String chuandoanbenh, String bacsi, int sotienthanhtoan) {
        super(hoten, tuoi, gioitinh, add, cccd);
        this.mahondon = mahondon;
        this.ngaynhapvien = ngaynhapvien;
        this.ngayravien = ngayravien;
        this.chuandoanbenh = chuandoanbenh;
        this.bacsi = bacsi;
        this.sotienthanhtoan = sotienthanhtoan;
    }

    public void setMahondon(String mahondon) {
        this.mahondon = mahondon;
    }

    public void setChuandoanbenh(String chuandoanbenh) {
        this.chuandoanbenh = chuandoanbenh;
    }

    public void setBacsi(String bacsi) {
        this.bacsi = bacsi;
    }

    public void setSotienthanhtoan(int sotienthanhtoan) {
        this.sotienthanhtoan = sotienthanhtoan;
    }

    public String getMahondon() {
        return mahondon;
    }


    public Date getNgaynhapvien() {
        return ngaynhapvien;
    }

    public void setNgaynhapvien(Date ngaynhapvien) {
        this.ngaynhapvien = ngaynhapvien;
    }

    public void setNgayravien(Date ngayravien) {
        this.ngayravien = ngayravien;
    }

    public Date getNgayravien() {
        return ngayravien;
    }

    public String getChuandoanbenh() {
        return chuandoanbenh;
    }

    public String getBacsi() {
        return bacsi;
    }

    public int getSotienthanhtoan() {
        return sotienthanhtoan;
    }


    @Override
    public void inPut(){
        super.input();
        Scanner sc= new Scanner(System.in);
        System.out.println("nhập mã hóa dơn : ");
        mahondon=sc.nextLine();
        System.out.println("nhập ngày nhập viện : ");
        try{
            SimpleDateFormat datee=new SimpleDateFormat("dd/MM/yyyy");
            ngaynhapvien= datee.parse(sc.nextLine());
        }catch (ParseException e){
            e.printStackTrace();
        }
        while(true){
            try{
                System.out.println("Nhập ngày ra viện (dd/MM/yyyy)");
                SimpleDateFormat date=new SimpleDateFormat("dd/MM/yyyy");
                Date ngayravien=date.parse(sc.nextLine());
                if(ngayravien.before(ngaynhapvien)){
                    throw new loingay("ngày ra viênj ko thể nhỏ hơn ngày nhập ");
                }
                this.ngayravien=ngayravien;
                break;
            }catch (ParseException e){
                e.printStackTrace();
            }catch (loingay ln){
                System.out.println(ln.getMessage());
            }
        }


        System.out.println("nhập chuẩn đoán bệnh : ");
        chuandoanbenh=sc.nextLine();
        System.out.println("nhập bác sỹ điều : ");
        bacsi=sc.nextLine();
        System.out.println("nhập số tiền thanh toán : ");
        sotienthanhtoan=Integer.parseInt(sc.nextLine());

    }

    @Override
    public void outPut(){
        super.output();
        SimpleDateFormat abc = new SimpleDateFormat();
        System.out.println("mã hóa dơn "+mahondon);
        System.out.println("ngày nhập viên "+abc.format(ngaynhapvien));
        System.out.println("ngày ra viên : "+abc.format(ngayravien));
        System.out.println("chuẩn đoán bệnh : "+chuandoanbenh);
        System.out.println("bác sĩ điều trị : "+bacsi);
        System.out.println("số tiền thanh toán : "+sotienthanhtoan);
    }


}

public class BAI14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("số lương bệnh nhnn: ");
        int n = sc.nextInt();

        hoadon1[] a = new hoadon1[n];


        for (int i = 0; i < n; i++) {
            System.out.println("thông tin bênh nhân thứ " + (i + 1) + " ");
            a[i] = new hoadon1("", 0, "", "", "", "", new Date(), new Date(), "", "", 0);
            a[i].inPut();

        }

        for (int i = 0; i < n; i++) {
            System.out.println("bẹnh nhân thứ" + (i + 1) + " ");
            a[i].outPut();
        }


        System.out.println("nhaapj số minh thu :");
        sc.nextLine();
        String matimkiem=sc.nextLine();
        boolean found = false;
        for(int i=0;i<n;i++){
            if(a[i].getCccd().equals(matimkiem)){
                System.out.println("thông tin  gío dich "+matimkiem);
                a[i].outPut();
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println(" khôpng tim thấy ");
        }


    }
}
