package dao;

import bean.Applicant;
import until.DBUtlis;

public class ChatMessageDao {
    public boolean saveChatMessage(Applicant applicant){
        String sql = "insert into message(Message_Context)" +
                "value(?)";
        DBUtlis db = new DBUtlis();
        return db.save(sql,applicant.getApplicant_Name(),applicant.getApplicant_Email(),applicant.getApplicant_Psd());
    }
}
