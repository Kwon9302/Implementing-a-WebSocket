package org.scoula.sockettest;

public class Message {
    private String senderName;
    private String content;
    private String receiverName; // Add this field if you need for private messaging

    public Message() {}

    public Message(String senderName, String content) {
        this.senderName = senderName;
        this.content = content;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }
}
