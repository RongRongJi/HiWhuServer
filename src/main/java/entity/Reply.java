package entity;

/**
 * Created by lenovo on 2018/7/13.
 */
public class Reply {
    private String reply_name;
    private String reply_content;
    private String reply_time;
    public Reply(String reply_name,String reply_content,String reply_time){
        setReply_name(reply_name);
        setReply_content(reply_content);
        setReply_time(reply_time);
    }

    public void setReply_content(String reply_content) {
        this.reply_content = reply_content;
    }

    public String getReply_content() {
        return reply_content;
    }

    public void setReply_name(String reply_name) {
        this.reply_name = reply_name;
    }

    public String getReply_name() {
        return reply_name;
    }

    public void setReply_time(String reply_time) {
        this.reply_time = reply_time;
    }

    public String getReply_time() {
        return reply_time;
    }
}
