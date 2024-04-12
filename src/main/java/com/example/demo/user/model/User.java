package com.example.demo.user.model;

import com.example.demo.article.model.Article;
import com.example.demo.common.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity(name = "users")
@ToString(exclude = "id")
public class User extends BaseEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long addressId;
    private String username;
    private String password;
    private String name;
    private String phone;
    private String job;

    @OneToMany(mappedBy = "writer", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Article> articles;



    @Builder(builderMethodName = "builder")
    public User(Long id, String password, String name, String username, String phone, String job, Long addressId) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.username = username;
        this.phone = phone;
        this.job = job;
        this.addressId = addressId;

    }


}
