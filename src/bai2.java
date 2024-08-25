import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

abstract class sanpham{
    private int masanpham;

    private String namesanpham;

    private int soluong;

    private int yearnhap;


    public int getmasanphan(){
        return masanpham;
    }
    public void setMasanpham(int masanpham){
        this.masanpham=masanpham;
    }

    public String getNamesanpham(){
        return namesanpham;
    }
    public void setNamesanpham(String namesanpham){
        this.namesanpham=namesanpham;
    }

    public int getSoluong(){
        return soluong;
    }
    public void setSoluong(int soluong){
        this.soluong=soluong;
    }

    public int getYearnhap(){
        return yearnhap;
    }
    public void setYearnhap(int yearnhap){
        this.yearnhap=yearnhap;
    }
    public sanpham(int masanpham,String namesanpham,int soluong,int yearnhap){
        this.masanpham=masanpham;
        this.namesanpham=namesanpham;
        this.soluong=soluong;
        this.yearnhap=yearnhap;
    }

    public void input(){
        Scanner sc= new Scanner(System.in);
        System.out.println("nhập mã sản phẩm :");
        masanpham=Integer.parseInt(sc.nextLine());
        System.out.println("nhập tên sản phẩm ; ");
        namesanpham=sc.nextLine();
        System.out.println("nhập số lượng : ");
        soluong=Integer.parseInt(sc.nextLine());
        System.out.println("nhập năm ; ");
        yearnhap=Integer.parseInt(sc.nextLine());
    }

    public void output(){
        System.out.println("mã sản phẩm : "+masanpham);
        System.out.println("tên sản phẩm : "+namesanpham);
        System.out.println("số lương : "+soluong);
        System.out.println("năm : "+yearnhap);
    }

    public abstract void inPut();

    public abstract void outPut();
}
    class sp_phammem extends sanpham{
           private String nganhungdung;

           private int makey;

           public sp_phammem(int masanpham, String namesanpham, int soluong, int yearnhap){
               super(masanpham, namesanpham, soluong, yearnhap);
               this.nganhungdung=nganhungdung;
               this.makey=makey;
           }



        public String getNganhungdung(){
               return nganhungdung;
           }
           public void setNganhungdung(String nganhungdung){
               this.nganhungdung=nganhungdung;
           }

        public int getMakey() {
            return makey;
        }

        public void setMakey(int makey) {
            this.makey = makey;
        }
        @Override
        public void inPut(){
               super.input();
               Scanner sc= new Scanner(System.in);
            System.out.println("nhập ngành ứng dụng : ");
            nganhungdung=sc.nextLine();
            System.out.println("nhập mã key : ");
            makey=Integer.parseInt(sc.nextLine());

        }
        @Override
        public void outPut(){
               super.output();
            System.out.println("ngành ứng dụng : "+nganhungdung);
            System.out.println("mã key : "+makey);
        }
    }




public class bai2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        sp_phammem[] phammem=new sp_phammem[100];
        int chon;
        int a=0;
        do{
            System.out.println("1.Nhập vào danh sách n sản phẩm phần mềm.");
            System.out.println("2.. In danh sách các sản phẩm phần mềm vừa nhập ra màn hình.");
            System.out.println("3.Sắp xếp các sản phẩm phần mềm theo thứ tự từ lớn đến nhỏ của số lượng");
            System.out.println("4.Tìm kiếm sản phẩm phần mềm có năm nhập lâu nhất.");
            System.out.println("0.thoát ");
            chon=sc.nextInt();
            switch(chon){
                case 1:
                    System.out.println("số lương ");
                    int n =sc.nextInt();
                    for(int i=0;i<n;i++){
                        System.out.println("thông tin sản phẩm thứ "+(i+1)+" ");
                        phammem[i]=new sp_phammem(0,"",0,0);
                        phammem[i].inPut();
                        phammem[a++]=phammem[i];
                    }
                    break;
                case 2:

                    System.out.println("danh sách sản phẩm ");
                    for(int i=0;i<a;i++){
                        System.out.println("sản phẩm thứ "+(i+1)+" ");
                        phammem[i].outPut();
                    }
                    break;
                case 3:
                    //c. Sắp xếp các sản phẩm phần mềm theo thứ tự từ lớn đến nhỏ của số lượng
                    for (int i = 0; i < a ; i++) {
                        for (int j = i ; j < a; j++) {
                            if (phammem[i].getSoluong() < phammem[j].getSoluong()) {
                                sp_phammem temp = phammem[i];
                                phammem[i] = phammem[j];
                                phammem[j] = temp;
                            }

                        }
                    }
                    System.out.println("vdv sau khi sap xepp  !");
                    System.out.println(' ');
                    for (int i = 0; i < a; i++) {
                        System.out.println("vdv Thu " + (i + 1) + ": ");
                        phammem[i].outPut();
                    }
                    break;
                case 4:
                    //d. Tìm kiếm sản phẩm phần mềm có năm nhập lâu nhất
                    sp_phammem splaudoi=phammem[0];
                    for(int i=1;i<a;i++){
                        if(phammem[i].getYearnhap() < splaudoi.getYearnhap()){
                            splaudoi=phammem[i];
                        }
                    }

                    System.out.println("sản phảm lâu đời ");
                    double hi =splaudoi.getYearnhap();
                    for(int i=0;i<a;i++){
                        if(phammem[i].getYearnhap() == hi ){
                            phammem[i].outPut();
                        }
                    }

                 //  splaudoi.outPut();
                  break;
                case 0:
                    System.out.println("0.kết thức chương ");
                    break;
                default:
                    System.out.println("lõi");
            }

        }while(chon!=0);



    }
}
