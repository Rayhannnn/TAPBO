
package Model;
import Entity.DaftarPasienEntity;
import Entity.PenangananEntity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DaftarpasienModel implements ModelInterfaces {
    private ArrayList<DaftarPasienEntity> daftarPasienArrayList;
    public DaftarpasienModel(){
        daftarPasienArrayList = new ArrayList<DaftarPasienEntity>();
    }
    public void insertDataDaftarprak(DaftarPasienEntity daftarpasien){
        daftarPasienArrayList.add(daftarpasien);
    }
    public ArrayList<DaftarPasienEntity> getDaftarPasienArrayList(){
        return daftarPasienArrayList;
    }
    public ArrayList<DaftarPasienEntity>alldataprak(){
        return daftarPasienArrayList;
    }
    
    public void view(){
        for(DaftarPasienEntity daftarpasien : daftarPasienArrayList){
            System.out.println("===================================");
            System.out.println(" Nik : "+daftarpasien.getPasien().getNik()+"\n Nama : "+daftarpasien.getPasien().getNama()+"\n Password : "+daftarpasien
                    .getPasien().getPassword()+"\n No.Telp : "+daftarpasien.getPasien().getNo_telp()+"\n Tanggal Lahir : "+new SimpleDateFormat
        ("dd-MM-yyyy").format(daftarpasien.getPasien().getTglLahir())+"\n Praktikum : "+PenangananEntity.nama[daftarpasien.getIndexBerobat()]+"\n isVerified : ");
            if (daftarpasien.isVerified() == false){
                System.out.println("Belum Di Verifikasi Admin");
            }else{
                System.out.println("Telah Di Verifikasi");
            }
            System.out.println("====================================");
        }
    }
    @Override
    public int cekData(String Nik, String password){
        int loop = 0;
        if(daftarPasienArrayList.size()==0){
            loop = -1;
        }else{
        for(int i=0;i<daftarPasienArrayList.size();i++){
            if(daftarPasienArrayList.get(i).getPasien().getNik().equals(Nik)){
                loop = i;
                break;
            }else{
                loop = -2;
            }
            }
        }
        return loop;
    }
    public DaftarPasienEntity showDaftarpasien(int index){
        return daftarPasienArrayList.get(index);
    }
    public void updateIsVerified(int index, DaftarPasienEntity daftarentityEntity){
        daftarPasienArrayList.set(index, daftarentityEntity);
    }
}
