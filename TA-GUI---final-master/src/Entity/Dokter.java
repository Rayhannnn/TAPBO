
package Entity;
import java.util.Date;
public class Dokter extends RumahSakitEntity{
    private String Spesialis;

    public Dokter(String Nik, String password, String nama, String no_telp, Date tglLahir, String lab) {
        super(Nik, password, nama, no_telp, tglLahir);
        this.Spesialis = lab;
    }
    @Override
public String getNik(){
    return Nik;
}
public String getSpesialis() {
        return Spesialis;
    }
    public void setSpesialis(String Spesialis) {
        this.Spesialis = Spesialis;
    }
}
