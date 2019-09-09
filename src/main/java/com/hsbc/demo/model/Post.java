package com.hsbc.demo.model;

import io.swagger.annotations.ApiModel;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "post")
@EntityListeners(AuditingEntityListener.class)
@ApiModel("post")
public class Post implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "content", nullable = false, length = 140)
    @Length(max = 140)
    private String content;

    @Column(name = "image_url", nullable = false)
    private String picture;

    @Column(name = "active", nullable = false)
    private boolean status;

    @Column(name = "likes")
    private long likes;

    @Column(name = "dislikes")
    private long dislikes;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdTime;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public long getLikes() {
        return likes;
    }

    public void setLikes(long likes) {
        this.likes = likes;
    }

    public long getDislikes() {
        return dislikes;
    }

    public void setDislikes(long dislikes) {
        this.dislikes = dislikes;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", userId=" + userId +
                ", content='" + content + '\'' +
                ", picture='" + picture + '\'' +
                ", status=" + status +
                ", likes=" + likes +
                ", dislikes=" + dislikes +
                ", createdTime=" + createdTime +
                ", updatedTime=" + updatedTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        Post post = (Post) o;
        return getId() == post.getId() &&
                isStatus() == post.isStatus() &&
                getLikes() == post.getLikes() &&
                getDislikes() == post.getDislikes() &&
                getUserId().equals(post.getUserId()) &&
                getContent().equals(post.getContent()) &&
                getPicture().equals(post.getPicture()) &&
                getCreatedTime().equals(post.getCreatedTime()) &&
                getUpdatedTime().equals(post.getUpdatedTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserId(), getContent(), getPicture(), isStatus(), getLikes(), getDislikes(), getCreatedTime(), getUpdatedTime());
    }
}
