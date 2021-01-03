package bean;

public class Applicant  {
    private int Applicant_Id;
    private String Applicant_Name;
    private String Applicant_Email;
    private String Applicant_Psd;
    public Applicant() {
    }

    public Applicant(int applicant_Id, String applicant_Name, String applicant_Email, String applicant_Psd) {
        Applicant_Id = applicant_Id;
        Applicant_Name = applicant_Name;
        Applicant_Email = applicant_Email;
        Applicant_Psd = applicant_Psd;
    }

    public int getApplicant_Id() {
        return Applicant_Id;
    }

    public void setApplicant_Id(int applicant_Id) {
        Applicant_Id = applicant_Id;
    }

    public String getApplicant_Name() {
        return Applicant_Name;
    }

    public void setApplicant_Name(String applicant_Name) {
        Applicant_Name = applicant_Name;
    }

    public String getApplicant_Email() {
        return Applicant_Email;
    }

    public void setApplicant_Email(String applicant_Email) {
        Applicant_Email = applicant_Email;
    }

    public String getApplicant_Psd() {
        return Applicant_Psd;
    }

    public void setApplicant_Psd(String applicant_Psd) {
        Applicant_Psd = applicant_Psd;
    }
}
