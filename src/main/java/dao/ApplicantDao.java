package dao;

import bean.Applicant;
import until.DBUtlis;

public class ApplicantDao {
    public Integer selectCount(String applicantEmail){
        String sql = "select count(*) from applicant a where a.Applicant_Email = ? ";
        return DBUtlis.getcount(sql,applicantEmail);
    }
    public boolean saveApplicant(Applicant applicant){
        String sql = "insert into applicant(Applicant_Name,Applicant_Email,Applicant_Psd)" +
                "value(?,?,?)";
        DBUtlis db = new DBUtlis();
        return db.save(sql,applicant.getApplicant_Name(),applicant.getApplicant_Email(),applicant.getApplicant_Psd());
    }

    public Applicant getApplicantByEmailAndPass(String email, String password) {
        String sql="select Applicant_Id applicant_Id, Applicant_Name applicant_Name,Applicant_Email applicant_Email,Applicant_Psd applicant_Psd"+
        " from applicant where Applicant_Email = ? and Applicant_Psd = ?";
        return DBUtlis.getSingleObj(Applicant.class,sql,email,password);
    }
    public Applicant getApplicantByEmail(String email) {
        String sql="select Applicant_Id applicant_Id, Applicant_Name applicant_Name,Applicant_Email applicant_Email,Applicant_Psd applicant_Psd"+
                " from applicant where Applicant_Email = ?";
        return DBUtlis.getSingleObj(Applicant.class,sql,email);
    }
}
