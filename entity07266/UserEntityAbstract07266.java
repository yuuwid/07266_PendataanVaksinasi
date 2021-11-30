package entity07266;

public abstract class UserEntityAbstract07266 {
    protected int id;
    protected String nama, alamat, noTelp;

    public UserEntityAbstract07266(int id, String nama, String alamat, String noTelp) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.noTelp = noTelp;
    }

    public int getId() {
        return id;
    }
    public String getNama() {
        return nama;
    }
    public String getAlamat() {
        return alamat;
    }
    public String getNoTelp() {
        return noTelp;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }
}
