package dao;

import bean.Message;
import until.DBUtlis;

import java.util.List;

public class MessageDao {
    public Message getResumeBasicInfoById(Integer resumeID) {
        String sql="SELECT Worker_Id worker_Id,Applicant_Id applicant_Id,Worker_Name worker_Name,Worker_sex worker_sex,Worker_Age worker_Age,Worker_Picture worker_Picture,Session_Id session_Id,Worker_position worker_position,Worker_Site worker_Site\n" +
                "FROM worker \n" +
                "where Worker_Id=?";
        Message message = DBUtlis.getSingleObj(Message.class,sql,resumeID);
        return message;
    }
    public boolean updateMessage(Message message) {
        String sql="UPDATE worker SET Applicant_Id=? " +
                "where Worker_Id=?";
        boolean flag = DBUtlis.update(sql,message.getApplicant_Id(),message.getWorker_Id());
        return  flag;
    }
    public void updateHeadShot(int WorkerId, String HeadShot) {
        String sql="update worker set Worker_Picture=? where Worker_Id=?";
        DBUtlis.update(sql,HeadShot,WorkerId);
    }
    public List getAllMessage(){
        String sql="SELECT Worker_Id worker_Id,Applicant_Id applicant_Id,Worker_Name worker_Name,Worker_sex worker_sex,Worker_Age worker_Age,Worker_Picture worker_Picture,Session_Id session_Id,Worker_position worker_position,Worker_Site worker_Site\n" +
                "FROM worker";
        return DBUtlis.getList(Message.class,sql);
    }
    public boolean saveSingerMessage(Message message) {
        String sql=  "insert into worker(Worker_Name,Worker_sex,Worker_Age,Session_Id,Worker_position,Worker_Site)\n" +
                "value(?,?,?,?,?,?)";
        boolean flag = DBUtlis.save(sql,message.getWorker_Name(),message.getWorker_sex(),message.getWorker_Age(),message.getSession_Id(),message.getWorker_position(),message.getWorker_Site());
        return  flag;
    }
    public boolean updateSingerMessage(Message message) {
        String sql="UPDATE worker SET Worker_Name = ?,Worker_sex = ?,Worker_Age = ?,Session_Id = ?,Worker_position = ?,Worker_Site = ?\n" +
                "where Worker_Id=?";
        boolean flag = DBUtlis.update(sql,message.getWorker_Name(),message.getWorker_sex(),message.getWorker_Age(),message.getSession_Id(),message.getWorker_position(),message.getWorker_Site(),message.getWorker_Id());
        return  flag;
    }
}
