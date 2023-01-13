
package Controller;
import Entity.DaftarPasienEntity;
import Entity.PasienEntity;
import Entity.PenangananEntity;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
public class PasienController implements ControllerInterface{
    int indexLogin = 0;
    public PasienController(){
        
    }
    public PasienEntity getData(){
        return AllObjectModel.PasienModel.getPasienEntityArrayList(indexLogin);
    }
    public void daftarPraktikum(int IndexBerobat , PasienEntity praktikanEntity , boolean isVerified){
        AllObjectModel.daftarpasienModel.insertDataDaftarprak(new DaftarPasienEntity(praktikanEntity, isVerified,IndexBerobat));
    }
    
    @Override
    public void login(String Nik , String password){
        indexLogin = AllObjectModel.PasienModel.cekData(Nik,password);
    }
    
    public void insert(String Nik , String password , String nama , String no_telp , Date tglLahir , String kelas){
        AllObjectModel.PasienModel.insert(new PasienEntity(Nik,password,nama,no_telp,tglLahir,kelas));
    }
    public PasienEntity PasienEntity(){
        return AllObjectModel.PasienModel.getPasienEntityArrayList(indexLogin);
    }
    public int cekDaftarprak(String Nik){
        int cek = AllObjectModel.daftarpasienModel.cekData(Nik, null);
        return cek;
    }
    public DaftarPasienEntity showDaftarprak(int index){
        return AllObjectModel.daftarpasienModel.showDaftarpasien(index);
    }
    public DefaultTableModel daftarpasien(){
        DefaultTableModel dtmdaftarprak = new DefaultTableModel();
        Object[] kolom ={"Nik","Nama","Password","No Telp","Tgl Lahir","Praktikum","Verified","Kelas"};
        dtmdaftarprak.setColumnIdentifiers(kolom);
        int size = AllObjectModel.daftarpasienModel.alldataprak().size();
        String verif = null;
        for (int i=0;i<size;i++){
            if(AllObjectModel.daftarpasienModel.alldataprak().get(i).isVerified()==false){
        verif = "no";
    }else{
        verif = "yes";
            }
    Object [] data = new Object[8];
    data[0] = AllObjectModel.daftarpasienModel.alldataprak().get(i).getPasien().getNik();
    data[1] = AllObjectModel.daftarpasienModel.alldataprak().get(i).getPasien().getNama();
    data[2] = AllObjectModel.daftarpasienModel.alldataprak().get(i).getPasien().getPassword();
    data[3] = AllObjectModel.daftarpasienModel.alldataprak().get(i).getPasien().getTglLahir();
    data[4] = new SimpleDateFormat("dd-MM-yyyy").format(AllObjectModel.daftarpasienModel.alldataprak().get(i).getPasien().getTglLahir());
    data[5] = PenangananEntity.nama[AllObjectModel.daftarpasienModel.alldataprak().get(i).getIndexBerobat()];
    data[6] = verif;
    data[7] = AllObjectModel.daftarpasienModel.alldataprak().get(i).getPasien().getKelas();
    dtmdaftarprak.addRow(data);
        }
    return dtmdaftarprak;
    }
}

