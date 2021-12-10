package entity07266;

public class PendudukEntity07266 extends UserEntityAbstract07266 {
    private String nik, dosis, jenisVaksin;

    public PendudukEntity07266(int id, String nama, String alamat,
                               String noTelp, String nik, String dosis,
                               String jenisVaksin) {
        super(id, nama, alamat, noTelp);
        this.nik = nik;
        this.dosis = dosis;
        this.jenisVaksin = jenisVaksin;
    }

    public String getNik() {
        return nik;
    }
    public String getDosis() {
        return dosis;
    }
    public String getJenisVaksin() {
        return jenisVaksin;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }
    public void setDosis(String dosis) {
        this.dosis = dosis;
    }
    public void setJenisVaksin(String jenisVaksin) {
        this.jenisVaksin = jenisVaksin;
    }
}
