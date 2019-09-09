package com.hsbc.demo.model;

import io.swagger.annotations.ApiModel;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "follower")
@EntityListeners(AuditingEntityListener.class)
@ApiModel("follower")
public class Follower implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "follower_id", nullable = false)
    private Long followerId;

    @Column(name = "followed_id", nullable = false)
    private Long followedId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getFollowerId() {
        return followerId;
    }

    public void setFollowerId(Long followerId) {
        this.followerId = followerId;
    }

    public Long getFollowedId() {
        return followedId;
    }

    public void setFollowedId(Long followedId) {
        this.followedId = followedId;
    }

    @Override
    public String toString() {
        return "Follower{" +
                "id=" + id +
                ", followerId=" + followerId +
                ", followedId=" + followedId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Follower)) return false;
        Follower follower = (Follower) o;
        return getId() == follower.getId() &&
                getFollowerId().equals(follower.getFollowerId()) &&
                getFollowedId().equals(follower.getFollowedId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFollowerId(), getFollowedId());
    }
}
