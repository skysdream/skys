package bean;

public class ChatMessage {
    private int messageId;
    private int sendId;
    private int receiveId;
    private String chatMessage;

    public ChatMessage(int messageId, int sendId, int receiveId, String chatMessage) {
        this.messageId = messageId;
        this.sendId = sendId;
        this.receiveId = receiveId;
        this.chatMessage = chatMessage;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public int getSendId() {
        return sendId;
    }

    public void setSendId(int sendId) {
        this.sendId = sendId;
    }

    public int getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(int receiveId) {
        this.receiveId = receiveId;
    }

    public String getChatMessage() {
        return chatMessage;
    }

    public void setChatMessage(String chatMessage) {
        this.chatMessage = chatMessage;
    }
}
