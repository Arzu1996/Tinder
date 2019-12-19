package app.entity;

public class Message {
    private int messageId;
    private int fromUser;
    private int toUser;
    private String content;

    public Message(int fromUser, int toUser, String content) {
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.content = content;
    }

    public Message(int toUser, String content) {
        this.toUser = toUser;
        this.content = content;
    }

    public Message(String content) {
        this.content = content;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public int getFromUser() {
        return fromUser;
    }

    public void setFromUser(int fromUser) {
        this.fromUser = fromUser;
    }

    public int getToUser() {
        return toUser;
    }

    public void setToUser(int toUser) {
        this.toUser = toUser;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", fromUser=" + fromUser +
                ", toUser=" + toUser +
                ", content='" + content + '\'' +
                '}';
    }
}