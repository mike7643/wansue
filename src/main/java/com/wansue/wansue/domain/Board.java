package com.wansue.wansue.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {

    @Id
    @GeneratedValue
    @Column(name = "board_id")
    private Long id;

    private String title;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "board")
    private List<Task> tasks = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private BoardStatus boardStatus = BoardStatus.NONE;


    //연관관계 편의 메서드
    public void setMember(Member member) {
        this.member = member;
        member.getBoards().add(this);
    }

    //생성 메서드
    public static Board createBoard(Member member) {
        Board board = new Board();
        board.setMember(member);
        return board;
    }

    //비즈니스 메서드
    public void changeBoardStatus() {
        for (Task task : tasks) {
            if (task.getTaskStatus() == TaskStatus.TODO)
                break;
        }
        boardStatus = BoardStatus.COMPLETE;
    }
}
