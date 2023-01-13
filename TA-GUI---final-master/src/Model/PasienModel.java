
package Model;
import Entity.PasienEntity;
import java.util.ArrayList;
public class PasienModel implements ModelInterfaces {
    private ArrayList<PasienEntity> PasienEntityArrayList;
    
    public PasienModel(){
        PasienEntityArrayList = new ArrayList<PasienEntity>();
    }
    public void insert(PasienEntity praktikanEntity){
        PasienEntityArrayList.add(praktikanEntity);
    }
    @Override
    public void view(){
        for(PasienEntity PasienEntity : PasienEntityArrayList){
            System.out.println("===========================================");
            System.out.println(" Nik : "+PasienEntity.getNik()+"\n Nama : "+PasienEntity.getNama()+"\n Password"+PasienEntity.getPassword()+"\n no.telp"
            +PasienEntity.getNo_telp()+"\n Tanggal Lahir"+PasienEntity.getTglLahir());
            System.out.println("===========================================");
        }
    }
    @Override
    public int cekData(String Nik, String password){
        int loop = 0;
        while(!PasienEntityArrayList.get(loop).getNik().equals(Nik)&&!PasienEntityArrayList.get(loop).getPassword().equals(password)){
            loop++;
        }
        return loop;
    }
    public PasienEntity getPasienEntityArrayList(int index){
        return PasienEntityArrayList.get(index);
    }
}
