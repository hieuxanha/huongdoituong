import java.util.Scanner;

class NhapDuLieu {
    public static int nhapSoNguyen() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static float nhapSoThuc() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextFloat();
    }

    public static String nhapChuoi() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}

class SinhVien {
    private String hoTen;
    private String ngaySinh;
    private String monHoc1;
    private String monHoc2;
    private float diemMon1;
    private float diemMon2;

    public SinhVien() {
    }

    public SinhVien(String hoTen, String ngaySinh, String monHoc1, String monHoc2, float diemMon1, float diemMon2) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.monHoc1 = monHoc1;
        this.monHoc2 = monHoc2;
        this.diemMon1 = diemMon1;
        this.diemMon2 = diemMon2;
    }

    public void nhap() {
        System.out.println("Nhập họ tên: ");
        this.hoTen = NhapDuLieu.nhapChuoi();
        System.out.println("Nhập ngày sinh: ");
        this.ngaySinh = NhapDuLieu.nhapChuoi();
        System.out.println("Nhập môn học 1: ");
        this.monHoc1 = NhapDuLieu.nhapChuoi();
        System.out.println("Nhập môn học 2: ");
        this.monHoc2 = NhapDuLieu.nhapChuoi();
        System.out.println("Nhập điểm môn 1: ");
        this.diemMon1 = NhapDuLieu.nhapSoThuc();
        System.out.println("Nhập điểm môn 2: ");
        this.diemMon2 = NhapDuLieu.nhapSoThuc();
    }

    public void hienThi() {
        System.out.println("Họ tên: " + hoTen);
        System.out.println("Ngày sinh: " + ngaySinh);
        System.out.println("Môn học 1: " + monHoc1);
        System.out.println("Điểm môn 1: " + diemMon1);
        System.out.println("Môn học 2: " + monHoc2);
        System.out.println("Điểm môn 2: " + diemMon2);
    }

    public float tinhDiemTrungBinh() {
        return (diemMon1 + diemMon2) / 2;
    }
}

class KhoaHoc {
    private SinhVien[] danhSachSinhVien;

    public KhoaHoc(int soLuongSinhVien) {
        danhSachSinhVien = new SinhVien[soLuongSinhVien];
    }

    public void nhapDanhSachSinhVien() {
        for (int i = 0; i < danhSachSinhVien.length; i++) {
            System.out.println("Nhập thông tin sinh viên thứ " + (i + 1));
            SinhVien sinhVien = new SinhVien();
            sinhVien.nhap();
            danhSachSinhVien[i] = sinhVien;
        }
    }

    public void hienThiDanhSachSinhVien() {
        for (int i = 0; i < danhSachSinhVien.length; i++) {
            System.out.println("Thông tin sinh viên thứ " + (i + 1));
            danhSachSinhVien[i].hienThi();
            System.out.println("Điểm trung bình: " + danhSachSinhVien[i].tinhDiemTrungBinh());
        }
    }
}





public class vd_2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("nhap so lương sinh vien :");
        int soLuongSinhVien = NhapDuLieu.nhapSoNguyen();

        KhoaHoc khoaHoc = new KhoaHoc(soLuongSinhVien);
        khoaHoc.nhapDanhSachSinhVien();
        System.out.println("Danh sách sinh viên:");
        khoaHoc.hienThiDanhSachSinhVien();

    }
}
