import java.util.Scanner;

//: Mã sinh viên, họ tên, lớp, chuyên ngành, địa chỉ, số điện thoại.
abstract class Sinhvien1{
    //hieu dz nhất cầ giấygit
    // Chị thâys ngu chết mẹ đi
    private int masinhvien;
    private String hoten;
    private String chuyennganh;
    private int diachi;

    private int sdt;

    public int getMasinhvien(){
        return masinhvien;
    }

    public void setMasinhvien(int masinhvien) {
        this.masinhvien = masinhvien;
    }

    public Sinhvien1(int masinhvien, String hoten, String chuyennganh, int diachi, int sdt) {
        this.masinhvien = masinhvien;
        this.hoten = hoten;
        this.chuyennganh = chuyennganh;
        this.diachi = diachi;
        this.sdt = sdt;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public void setChuyennganh(String chuyennganh) {
        this.chuyennganh = chuyennganh;
    }

    public void setDiachi(int diachi) {
        this.diachi = diachi;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public String getHoten() {
        return hoten;
    }

    public String getChuyennganh() {
        return chuyennganh;
    }

    public int getDiachi() {
        return diachi;
    }

    public int getSdt() {
        return sdt;
    }

    public void input(){
        Scanner sc= new Scanner(System.in);
        System.out.println("nhập mã sinh viên : ");
        masinhvien=Integer.parseInt(sc.nextLine());
        System.out.println("nhập họ tên : "+hoten);
        hoten=sc.nextLine();
        System.out.println("nhập chuyên ngành : ");
        chuyennganh=sc.nextLine();
        System.out.println("nhập địa chỉ : ");
        diachi=Integer.parseInt(sc.nextLine());
        System.out.println("nhập số điện thoại : ");
        sdt=Integer.parseInt(sc.nextLine());
    }

    public void output(){
        System.out.println("mã sinh viên : "+masinhvien);
        System.out.println("họ tên : "+hoten);
        System.out.println("chuyên ngành : "+chuyennganh);
        System.out.println("địa chỉ : "+diachi);
        System.out.println("số điện thoại : "+sdt);


    }

    public abstract void inPut();

    public abstract void outPut();
}
//hieu1237608965
   class hocvien extends Sinhvien1{
    private String hinhthucdaotao;
    private String trinhdongoaingu;
    private Double dtb;

    public double getbtb(){
        return dtb;
    }
    public void setDtb(double dtb){
        this.dtb=dtb;
    }


    public String getHinhthucdaotao() {
        return hinhthucdaotao;
    }

    public String getTrinhdongoaingu() {
        return trinhdongoaingu;
    }

    public hocvien(int masinhvien, String hoten, String chuyennganh, int diachi, int sdt, String hinhthucdaotao, String trinhdongoaingu,double dtb) {
        super(masinhvien, hoten, chuyennganh, diachi, sdt);
        this.hinhthucdaotao = hinhthucdaotao;
        this.trinhdongoaingu = trinhdongoaingu;
        this.dtb=dtb;
    }

    public void setHinhthucdaotao(String hinhthucdaotao) {
        this.hinhthucdaotao = hinhthucdaotao;
    }

    public void setTrinhdongoaingu(String trinhdongoaingu) {
        this.trinhdongoaingu = trinhdongoaingu;
    }

    @Override
    public void inPut() {
        super.input();
        Scanner sc= new Scanner(System.in);
        System.out.println("nhập hình thức đào tạo : "+hinhthucdaotao);
        hinhthucdaotao=sc.nextLine();
        System.out.println("nhập trình độ ngoại ngữ : ");
        trinhdongoaingu=sc.nextLine();
        System.out.println("nhâp điểm trung bình : ");
        dtb=sc.nextDouble();
    }

    @Override
    public void outPut(){
        super.output();
        System.out.println("hình thức đào tạo : "+hinhthucdaotao);
        System.out.println("trình độ ngoại ngũ : "+trinhdongoaingu);
        System.out.println("điểm trung bình : "+dtb);
    }
}



public class bai6 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        hocvien[] dshocvien= new hocvien[100];
        int chon;
        int a=0;
        do{
            System.out.println("1.a. Nhập vào danh sách n học viên.");
            System.out.println("2.In danh sách các Học viên vừa nhập ra màn hình.");
            System.out.println("3.Đếm số học viên có trình độ ngoại ngữ B1");
            System.out.println("4.Sắp xếp các học viên theo thứ tự giảm dần của điểm trung bình.");
            System.out.println("0.thoát");
            chon =sc.nextInt();
            switch (chon){
                case 1:
                    System.out.println("số lương ");
                    int n=sc.nextInt();
                    for(int i=0;i<n;i++){
                        System.out.println("thông tin học viên thứ "+(i+1)+" ");
                        dshocvien[i] = new hocvien(0,"","",0,0,"","",0);
                        dshocvien[i].inPut();
                        dshocvien[a++]=dshocvien[i];
                    }
                    break;
                case 2:
                    for(int i=0;i<a;i++){
                        System.out.println("học viên thứ "+(i+1)+" ");
                        dshocvien[i].outPut();
                    }
                    break;
                case 3:
                    int demb1 = 0;
                    for(int i=0;i<a;i++){
                        if(dshocvien[i].getTrinhdongoaingu().equalsIgnoreCase("b1")){
                            demb1++ ;
                        }
                    }
                    System.out.println("học viên có trình đọo b1 là : "+demb1);
              break;
                case 4:

                    // . Sắp xếp các học viên theo thứ tự giảm dần của điểm trung bình
                    // tu lớn dến bé
//                    for(int i=0;i<a;i++){
//                        for(int j=0;j < a - i- 1;j++){
//                            if(dshocvien[j].getbtb() < dshocvien[j+1].getbtb()){
//                                hocvien temp = dshocvien[j];
//                                dshocvien[j]=dshocvien[j+1];
//                                dshocvien[j+1]=temp;
//                            }
//                        }
//                    }
                    for(int i=0;i<a;i++){
                        for(int j=0;j < a;j++){
                            if(dshocvien[i].getbtb() > dshocvien[j].getbtb()){
                                hocvien temp = dshocvien[i];
                                dshocvien[i]=dshocvien[j];
                                dshocvien[j]=temp;
                            }
                        }
                    }
                    System.out.println("danh sách học viên đã sắp xếp ");
                    for(int i=0;i<a;i++){
                        dshocvien[i].outPut();
                    }
               break;
                case 0:
                    System.out.println("kết chương trình ");
                    break;
            }


        }while(chon!=0);
    }
}
