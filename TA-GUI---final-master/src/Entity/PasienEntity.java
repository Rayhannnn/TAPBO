
package Entity;
import java.util.Date;
public class PasienEntity extends RumahSakitEntity {
    private String kelas;

    public PasienEntity(String Nik, String password, String nama, String no_telp, Date tglLahir, String kelas) {
        super(Nik, password, nama, no_telp, tglLahir);
        this.kelas = kelas;
    }
    @Override
    public String getNik(){
        return Nik;
    }
    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }
    
}
