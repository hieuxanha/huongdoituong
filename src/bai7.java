import java.util.Scanner;

abstract class sanpham7{
    //Mã sản phẩm, tên sản phẩm, ngày sản xuất, hạn sử dụng, số lô, tổ
    //sản xuất.
    private int masanpham;

    private String tensanpham;

    private String nsx;
    private String hansd;

    private int solo;
    private int tosansuat;

    public int getMasanpham (){
        return masanpham;
    }
    public void setMasanpham(int masanpham){
        this.masanpham=masanpham;
    }

    public void setNsx(String nsx) {
        this.nsx = nsx;
    }

    public void setHansd(String hansd) {
        this.hansd = hansd;
    }

    public void setSolo(int solo) {
        this.solo = solo;
    }

    public void setTosansuat(int tosansuat) {
        this.tosansuat = tosansuat;
    }

    public String getTensanpham(){
        return tensanpham;
    }
    public void setTensanpham(String tensanpham){
        this.masanpham=masanpham;
    }

    public int getTosansuat() {
        return tosansuat;
    }

    public String getNsx() {
        return nsx;
    }

    public String getHansd() {
        return hansd;
    }

    public int getSolo() {
        return solo;
    }


    public sanpham7(int masanpham, String tensanpham, String nsx, String hansd, int solo, int tosansuat) {
        this.masanpham = masanpham;
        this.tensanpham = tensanpham;
        this.nsx = nsx;
        this.hansd = hansd;
        this.solo = solo;
        this.tosansuat = tosansuat;
    }

    public void input(){
        Scanner sc=new Scanner(System.in);
        System.out.println("nhập mã sản phẩm : ");
        masanpham=Integer.parseInt(sc.nextLine());
        System.out.println("nhâp tên sản phẩm : ");
        tensanpham=sc.nextLine();
        System.out.println("nhập ngày sản xuất : ");
        nsx=sc.nextLine();
        System.out.println("nhập hạn sử dụng : ");
        hansd=sc.nextLine();
        System.out.println("nhập số lô : ");
        solo=Integer.parseInt(sc.nextLine());
        System.out.println("nhập tổ sản xuất : ");
        tosansuat=Integer.parseInt(sc.nextLine());
    }
    public void output(){
        System.out.println("mã sản phẩm : "+masanpham);
        System.out.println("tên sản phẩm : "+tensanpham);
        System.out.println("ngày sản xuất : "+nsx);
        System.out.println("hạn sử dụng : "+hansd);
        System.out.println("số lô" +solo);
        System.out.println("tổ sản xuất : "+tosansuat);
    }

    public abstract void inPut();

    public abstract void outPut();
}
class sanphamcaocap7 extends sanpham7{
    private String loaisanpham;

    private int phuphi;

    public sanphamcaocap7(int masanpham, String tensanpham, String nsx, String hansd, int solo, int tosansuat, String loaisanpham, int phuphi) {
        super(masanpham, tensanpham, nsx, hansd, solo, tosansuat);
        this.loaisanpham = loaisanpham;
        this.phuphi = phuphi;
    }

    public String getLoaisanpham() {
        return loaisanpham;
    }

    public int getPhuphi() {
        return phuphi;
    }

    public void setLoaisanpham(String loaisanpham) {
        this.loaisanpham = loaisanpham;
    }

    public void setPhuphi(int phuphi) {
        this.phuphi = phuphi;
    }
    @Override
    public void inPut(){
        super.input();
        Scanner sc=new Scanner(System.in);
        System.out.println("nhập loại sản phẩm : ");
        loaisanpham=sc.nextLine();
        System.out.println("nhâp phụ phí : ");
        phuphi=Integer.parseInt(sc.nextLine());
    }

    @Override
    public void outPut(){
        super.output();
        System.out.println("loại sản phẩm : "+loaisanpham);
        System.out.println("phụ phí : "+phuphi);


    }
}


public class bai7 {
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       sanphamcaocap7[] dscc=new sanphamcaocap7[100];
       int a=0;
       int chon;
       do{
           System.out.println("1.Nhập vào danh sách n sản phẩm cao cấp");
           System.out.println("2.In danh sách các sản phẩm cao cấp vừa nhập ra màn hình");
           System.out.println("3.Tìm kiếm sản phẩm cao cấp có loại sản phẩm là “đặc biệt”");
           System.out.println("4.Sắp xếp các sản phẩm cao cấp theo thứ tự giảm dần của phụ phí.");
           System.out.println("0.thoát");
           chon=sc.nextInt();
           switch (chon){
               case 1:
                   System.out.println("số lương ");
                   int n=sc.nextInt();
                   for(int i =0;i<n;i++) {
                       System.out.println("thông tin sản phẩm " + (i + 1) + " : ");
                       dscc[i] = new sanphamcaocap7(0, "", "", "", 0, 0, "", 0);
                       dscc[i].inPut();
                       dscc[a++]=dscc[i];
                   }
                   break;
               case 2:
                   for(int i=0;i<a;i++){
                       System.out.println("Thứ "+(i+1)+" ");
                       dscc[i].outPut();
                   }
                   break;
               case 3:
                   //. Tìm kiếm sản phẩm cao cấp có loại sản phẩm là “đặc biệt”
                   System.out.println("Tìm kiếm sản phẩm cao cấp có loại sản phẩm là “đặc biệt");
                   for(int i = 0;i<a;i++){
                       if(dscc[i].getLoaisanpham().equalsIgnoreCase("dac biet")){
                           dscc[i].outPut();
                       }
                   }

                   break;
               case 4:
                   System.out.println(" Sắp xếp các sản phẩm cao cấp theo thứ tự giảm dần của phụ phí.");
                   for(int i=0;i<a;i++){
                       for(int j=i;j<a;j++){
                           if(dscc[i].getPhuphi() < dscc[j].getPhuphi()){
                               sanphamcaocap7 temp = dscc[i];
                               dscc[i]=dscc[j];
                               dscc[j]=temp;
                           }
                       }
                   }
                   for(int i=0;i<a;i++){
                       System.out.println("thông tin sản phẩm "+(i+1)+" ");
                       dscc[i].outPut();
                   }
                   break;
               case 0:
                   System.out.println("0.thoát");
                   break;
           }
       }while(chon!=0);
    }
}
