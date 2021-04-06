package com.cos.dchat;

import java.io.Serializable;

public class ChatData implements Serializable {

    private String msg;// 메세지내용
    private String nickname;// 사용자 이름

    private String profile;// 프로파일 사진
    private String id;// 프로파일 사진
    private String pw;// 메세지내용
    private String username;// 사용자 이름

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ChatData(){}

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }



}
