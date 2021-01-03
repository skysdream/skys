package bean;

public class Message {
    private int  Worker_Id;
    private int  Applicant_Id;
    private String Worker_Name;
    private String Worker_sex;
    private String Worker_Age;
    private String Worker_Picture;
    private String Session_Id;
    private String Worker_position;
    private String Worker_Site;

    public Message() {
    }

    public Message(int worker_Id, int applicant_Id, String worker_Name, String worker_sex, String worker_Age, String worker_Picture, String session_Id, String worker_position, String worker_Site) {
        Worker_Id = worker_Id;
        Applicant_Id = applicant_Id;
        Worker_Name = worker_Name;
        Worker_sex = worker_sex;
        Worker_Age = worker_Age;
        Worker_Picture = worker_Picture;
        Session_Id = session_Id;
        Worker_position = worker_position;
        Worker_Site = worker_Site;
    }

    public int getWorker_Id() {
        return Worker_Id;
    }

    public void setWorker_Id(int worker_Id) {
        Worker_Id = worker_Id;
    }

    public int getApplicant_Id() {
        return Applicant_Id;
    }

    public void setApplicant_Id(int applicant_Id) {
        Applicant_Id = applicant_Id;
    }

    public String getWorker_Name() {
        return Worker_Name;
    }

    public void setWorker_Name(String worker_Name) {
        Worker_Name = worker_Name;
    }

    public String getWorker_sex() {
        return Worker_sex;
    }

    public void setWorker_sex(String worker_sex) {
        Worker_sex = worker_sex;
    }

    public String getWorker_Age() {
        return Worker_Age;
    }

    public void setWorker_Age(String worker_Age) {
        Worker_Age = worker_Age;
    }

    public String getWorker_Picture() {
        return Worker_Picture;
    }

    public void setWorker_Picture(String worker_Picture) {
        Worker_Picture = worker_Picture;
    }

    public String getSession_Id() {
        return Session_Id;
    }

    public void setSession_Id(String session_Id) {
        Session_Id = session_Id;
    }

    public String getWorker_position() {
        return Worker_position;
    }

    public void setWorker_position(String worker_position) {
        Worker_position = worker_position;
    }

    public String getWorker_Site() {
        return Worker_Site;
    }

    public void setWorker_Site(String worker_Site) {
        Worker_Site = worker_Site;
    }
}
