import java.util.Scanner;

abstract class loptt{
 //: mã máy, tên máy, số lượng, năm đưa vào sử dụng, năm kiểm kê.
    private int mamay;
    private String tenmay;
    private int soluong;
    private String namduasd;
    private String namkiemke;

    public int getMamay(){
        return mamay;
    }

    public void setMamay(int mamay){
        this.mamay=mamay;
    }

    public void setTenmay(String tenmay) {
        this.tenmay = tenmay;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public void setNamduasd(String namduasd) {
        this.namduasd = namduasd;
    }

    public void setNamkiemke(String namkiemke) {
        this.namkiemke = namkiemke;
    }

    public String getTenmay() {
        return tenmay;
    }

    public int getSoluong() {
        return soluong;
    }

    public String getNamduasd() {
        return namduasd;
    }

    public String getNamkiemke() {
        return namkiemke;
    }

    public loptt(int mamay, String tenmay, int soluong, String namduasd, String namkiemke) {
        this.mamay = mamay;
        this.tenmay = tenmay;
        this.soluong = soluong;
        this.namduasd = namduasd;
        this.namkiemke = namkiemke;
    }

    public void input(){
        Scanner sc=new Scanner(System.in);
        System.out.println("nhập mã máy : ");
        mamay=Integer.parseInt(sc.nextLine());
        System.out.println("nhập tên máy : ");
        tenmay=sc.nextLine();
        System.out.println("nhập số lượng : ");
        soluong=Integer.parseInt(sc.nextLine());
        System.out.println("nhập năm đưa vào sử dung : ");
        namduasd=sc.nextLine();
        System.out.println("nhập năm kiểm kê : ");
        namduasd=sc.nextLine();
    }

    public void output(){
        System.out.println("mã máy : "+mamay);
        System.out.println("tên máy : "+tenmay);
        System.out.println("số lượng : "+soluong);
        System.out.println("dưa vào sử dụng : "+namduasd);
        System.out.printf("năm kiểm kê :  "+namkiemke);
    }

    public abstract void inPut();

    public abstract void outPut();
}
class maychu extends loptt{
    private String loaimaychu;
    private String chucnang;

    public String getLoaimaychu() {
        return loaimaychu;
    }

    public String getChucnang() {
        return chucnang;
    }

    public void setLoaimaychu(String loaimaychu) {
        this.loaimaychu = loaimaychu;
    }

    public void setChucnang(String chucnang) {
        this.chucnang = chucnang;
    }

    public maychu(int mamay, String tenmay, int soluong, String namduasd, String namkiemke, String loaimaychu, String chucnang) {
        super(mamay, tenmay, soluong, namduasd, namkiemke);
        this.loaimaychu = loaimaychu;
        this.chucnang = chucnang;
    }

    @Override
    public void inPut(){
        super.input();
        Scanner sc= new Scanner(System.in);
        System.out.println("nhập loại máy : ");
        loaimaychu=sc.nextLine();
        System.out.println("nhập chức năng: ");
        chucnang=sc.nextLine();
    }

    @Override
    public void outPut(){
        super.output();
        System.out.println("loại máy : "+loaimaychu);
        System.out.println("chức năng ; "+chucnang);

    }
}





public class bai8 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("danh sách máy chủ ");
        int n=sc.nextInt();
        maychu[] a= new maychu[n];

        for(int i=0;i<n;i++){
            System.out.println("thông tin máy chủ ."+(i+1)+" ");
            a[i] = new maychu(0,"",0,"","","","");
            a[i].inPut();
        }
         for(int i=0;i<n;i++)
         {
             System.out.printf("máy thứ "+(i+1)+" ");
             a[i].outPut();
         }
         //Tìm kiếm máy chủ có chức năng là “Application Servers”.
        System.out.println("Tìm kiếm máy chủ có chức năng là “Application Servers”. ");
         for(int i=0;i<n;i++){
             if(a[i].getChucnang().equalsIgnoreCase("Application Servers")){
                 a[i].outPut();
             }

         }
        System.out.println("sắp xếp các máy chủ giảm dần theo số lượng.");
         for(int i=0;i<n;i++) {
             for(int j=i+1;j<n;j++){
                 if(a[j].getSoluong() > a[i].getSoluong()){
                     maychu temp=a[i];
                     a[i]=a[j];
                     a[j]=temp;
                 }

             }
         }
        for(int i=0;i<n;i++){
            a[i].outPut();
        }
    }
}
