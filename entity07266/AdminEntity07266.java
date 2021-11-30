package entity07266;

public class AdminEntity07266 extends UserEntityAbstract07266{
    private String nip, password;

    public AdminEntity07266(int id, String nama, String alamat,
                            String noTelp, String nip, String password) {
        super(id, nama, alamat, noTelp);
        this.nip = nip;
        this.password = password;
    }

    public String getNip() {
        return nip;
    }
    public String getPassword() {
        return password;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
