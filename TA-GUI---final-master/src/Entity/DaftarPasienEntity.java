
package Entity;

public class DaftarPasienEntity {
    private PasienEntity Pasien;
    private boolean isVerified;
    private int IndexBerobat;

    public DaftarPasienEntity(PasienEntity praktikan, boolean isVerified, int IndexBerobat) {
        this.Pasien = praktikan;
        this.isVerified = isVerified;
        this.IndexBerobat = IndexBerobat;
    }

    public PasienEntity getPasien() {
        return Pasien;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setIsVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }

    public int getIndexBerobat() {
        return IndexBerobat;
    }

    public void setIndexBerobat(int IndexBerobat) {
        this.IndexBerobat = IndexBerobat;
    }
}
