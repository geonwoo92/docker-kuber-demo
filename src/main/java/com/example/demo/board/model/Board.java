package com.example.demo.board.model;
import com.example.demo.article.model.Article;
import com.example.demo.common.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@ToString(exclude = "id")
@Entity(name = "boards")
public class Board extends BaseEntity {

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String boardType;

    @OneToMany(mappedBy = "board",fetch = FetchType.LAZY)
    private List<Article> articlesId;
}