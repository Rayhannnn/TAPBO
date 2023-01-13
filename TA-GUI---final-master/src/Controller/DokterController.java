
package Controller;
import Entity.Dokter;
import Entity.DaftarPasienEntity;
import Entity.PasienEntity;
import java.util.Date;
import java.util.ArrayList;
public class DokterController implements ControllerInterface{
    int indexLogin = 0;
    
    public DokterController(){
    
    }
    
    public void dataDokter(){
        String NikDokter[] = {"01","02","03","04","05","06","07"};
        String PasswordDokter[] = {"01","02","03","04","05","06","07"};
        String namaDokter[] = {"Prof Yuni","Doc Dono","Doc Budi","Prof lala","Prof Tono","Prof Alala","Prof Ntah"};
        String notelpDokter[] = {"01","02","03","04","05","06","07"};
        String tglLahirDokter[] = {"04/05/1980","01/12/1998","03/3/1987","23/06/1988","11/3/1992","13/9/1978","22/12/1973"};
        String Spesialis[] = {"Umum", "", "Bedah", "Bedah", "Penyakit Dalam", "THT", "Anastesi"};
        for (int i = 0; i<NikDokter.length; i++){
            AllObjectModel.DokterModel.insertDokter(new Dokter(NikDokter[i],PasswordDokter[i],namaDokter[i],notelpDokter[i],
new Date(tglLahirDokter[i]), Spesialis[i]));
    }
}
    
    public void viewDokter(){
        AllObjectModel.DokterModel.view();
    }
    public void listPendaftarPasien(){
        AllObjectModel.daftarpasienModel.view();
    }
    
    @Override
    public void login(String Nik , String password){
        indexLogin = AllObjectModel.DokterModel.cekData(Nik,password);
    }
    public Dokter DokterEntity() {
        return AllObjectModel.DokterModel.showDataDokter(indexLogin);
    }
    
    public void updateIsVerified(int index, int indexPrak, PasienEntity praktikanEntity) {
        AllObjectModel.daftarpasienModel.updateIsVerified(index, new DaftarPasienEntity(praktikanEntity, true, indexPrak));
    }

    public ArrayList<DaftarPasienEntity>cekDaftarprakModel(){
return AllObjectModel.daftarpasienModel.getDaftarPasienArrayList();
}
    
}


    