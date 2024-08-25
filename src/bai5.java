import java.lang.management.ManagementFactory;
import java.util.Scanner;

//mã sách, tên sách, tác giả, năm xuất bản, số lượng, đơn giá
abstract class Sach{
    private int masach;

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }

    public void setNxb(int nxb) {
        this.nxb = nxb;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }

    public String getTacgia() {
        return tacgia;
    }

    public int getNxb() {
        return nxb;
    }

    public int getSoluong() {
        return soluong;
    }

    public int getDongia() {
        return dongia;
    }

    private String tensach;

    private String tacgia;

    private int nxb;
    private int soluong;
    private int dongia;

    public int getMasach(){
        return masach;
    }

    public void setMasach(int masach){
        this.masach=masach;
    }
    public String getTensach(){
        return tensach;
    }
    public void setTensach(String tensach){
        this.tensach=tensach;
    }

    public Sach(int masach, String tensach, String tacgia, int nxb, int soluong, int dongia) {
        this.masach = masach;
        this.tensach = tensach;
        this.tacgia = tacgia;
        this.nxb = nxb;
        this.soluong = soluong;
        this.dongia = dongia;
    }

    public void input(){
        Scanner sc=new Scanner(System.in);
        System.out.println("nhập mã sách : "+masach);
        masach=Integer.parseInt(sc.nextLine());
        System.out.println("nhập tên sách : ");
        tensach=sc.nextLine();
        System.out.println("nhập tác giả : ");
        tacgia=sc.nextLine();
        System.out.println("nhâp năm xuất bản : ");
        nxb=Integer.parseInt(sc.nextLine());
        System.out.println("nhập dơn giá : ");
        dongia=Integer.parseInt(sc.nextLine());

    }
    public void output(){
        System.out.println("mã sách : "+masach);
        System.out.println("tên sách : "+tensach);
        System.out.println("tác giả : "+tacgia);
        System.out.println("năm xuất bản : "+nxb);
        System.out.println("dơn giá : "+dongia);
    }

    public abstract void inPut();

    public abstract void outPut();
}

class Sachchuyenkk extends Sach{
    private String theloai;
    private String ngonngu;

    public String getTheloai() {
        return theloai;
    }

    public void setTheloai(String theloai) {
        this.theloai = theloai;
    }

    public void setNgonngu(String ngonngu) {
        this.ngonngu = ngonngu;
    }

    public String getNgonngu() {
        return ngonngu;
    }

    public Sachchuyenkk(int masach, String tensach, String tacgia, int nxb, int soluong, int dongia, String theloai, String ngonngu) {
        super(masach, tensach, tacgia, nxb, soluong, dongia);
        this.theloai = theloai;
        this.ngonngu = ngonngu;
    }

    @Override
    public void inPut(){
        Scanner sc= new Scanner(System.in);
        System.out.println("nhập thể loại : "+theloai);
        theloai=sc.nextLine();
        System.out.println("nhập ngôn ngữ : "+ngonngu);
        ngonngu=sc.nextLine();
    }

    @Override
    public void outPut(){
        System.out.println("thể loại : "+theloai);
        System.out.println("ngôn ngữ : "+ngonngu);
    }

}


public class bai5 {
    public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
        Sachchuyenkk[]  ds =new Sachchuyenkk[100];
        int chon;
        int a=0;
        do{
            System.out.println("1.Nhập vào n sách chuyên khảo");
            System.out.println("2.In danh sách các sách chuyên khảo vừa nhập ra màn hình");
            System.out.println("3.In ra màn hình sách chuyên khảo thuộc thể loại công nghệ thông tin.");
            System.out.println("4.Tìm kiếm sách chuyên khảo có tên sách là “Lap trinh huong doi tuong voi Java”");
            System.out.println("0.thoát  ");
            chon=sc.nextInt();
            switch (chon){
                case 1:
                    System.out.println("số lương ");
                    int n=sc.nextInt();
                    for(int i=0;i<n;i++){
                        System.out.println("thong tin quyển thứ "+(i+1)+" ");
                        ds[i]=new Sachchuyenkk(0,"","",0,0,0,"","");
                        ds[i].inPut();
                        ds[a++]=ds[i];
                    }
                    break;
                case 2:
                    for(int i=0;i<a;i++){
                        System.out.println("quyển thứ "+(i+1)+" ");
                        ds[i].outPut();
                    }
                    break;
                case 3:
                    for(int i=0;i<a;i++){
                        if(ds[i].getTensach().equalsIgnoreCase("công nghệ thông tin")){
                            ds[i].outPut();
                        }
                    }
                    break;
                case 4:
                    //Tìm kiếm sách chuyên khảo có tên sách là “Lap trinh huong doi tuong voi
                    //Java”.

                    for(int i=0;i<a;i++){
                        if(ds[i].getTensach().equalsIgnoreCase("Lap trinh huong doi tuong voi Java")){
                            ds[i].outPut();
                        }
                    }
                    break;
            }
        }while(chon!=0);


    }
}
