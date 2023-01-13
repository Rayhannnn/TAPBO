
package Model;
import Entity.Dokter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DokterModel implements ModelInterfaces {
    private ArrayList<Dokter> DokterEntityArrayList;
    
public DokterModel(){
    DokterEntityArrayList = new ArrayList<Dokter>();
}
    public void insertDokter(Dokter aslab){
        DokterEntityArrayList.add(aslab);
    }
    @Override
public void view(){
    for(Dokter DokterEntity : DokterEntityArrayList){
        System.out.println(DokterEntity.getNik());
        System.out.println(DokterEntity.getNama());
        System.out.println(DokterEntity.getPassword());
        System.out.println(DokterEntity.getNo_telp());
        System.out.println(new SimpleDateFormat("dd-MM-yyyy").format(DokterEntity.getTglLahir()));
        System.out.println();
    }
}
@Override
public int cekData(String Nik, String password){
    int loop = 0;
    for(Dokter DokterEntity : DokterEntityArrayList){
        if(DokterEntity.getNik().equals(Nik) && DokterEntity.getPassword().equals(password)){
            break;
        }else{
            loop++;
        }
    }return loop;
}
public Dokter showDataDokter(int index){
    return DokterEntityArrayList.get(index);
}
}
