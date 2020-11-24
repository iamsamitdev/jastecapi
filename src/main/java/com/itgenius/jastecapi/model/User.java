package com.itgenius.jastecapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    // Constructure
    public User(){ 
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "userid", nullable = false)
    private int userid;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "firstname", nullable = true)
    private String firstname;

    @Column(name = "lastname", nullable = true)
    private String lastname;

    @Column(name = "imgprofile", nullable = true)
    private String imgprofile;

    @Column(name = "created_at", nullable = true)
    private String created_at;

    @Column(name = "update_at", nullable = true)
    private String update_at;

    @Column(name = "status", nullable = true)
    private int status;

    public int getUserid() {
        return userid;
    }

    public int getId() {
        return id;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getImgprofile() {
        return imgprofile;
    }

    public void setImgprofile(String imgprofile) {
        this.imgprofile = imgprofile;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(String update_at) {
        this.update_at = update_at;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", userid=" + userid + ", username=" + username + ", password=" + password + ", firstname=" + firstname + ", lastname=" + lastname + ", imgprofile=" + imgprofile + ", created_at=" + created_at + ", update_at=" + update_at + ", status=" + status + '}';
    }

}
