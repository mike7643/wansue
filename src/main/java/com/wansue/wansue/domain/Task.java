package com.wansue.wansue.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Task extends DateEntity{

    @Id
    @GeneratedValue
    @Column(name = "task_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    private String title;

    private String subtitle;

    private String description;

    private LocalDateTime deadline;

    private boolean isRequired;

    private Integer priority;

    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus = TaskStatus.TODO;


    //비즈니스 메서드
    public void changeTaskStatusTODO() {
        this.taskStatus=TaskStatus.TODO;
    }

    public void changeTaskStatusCOMPLETE() {
        this.taskStatus=TaskStatus.COMPLETE;
    }

    public Task(Board board, String title, String subtitle, String description, LocalDateTime deadline, boolean isRequired, Integer priority) {
        setBoard(board);
        this.title = title;
        this.subtitle = subtitle;
        this.description = description;
        this.deadline = deadline;
        this.isRequired = isRequired;
        this.priority = priority;
    }

    //연관관계 메서드
    public void setBoard(Board board) {
        this.board = board;
        board.getTasks().add(this);
    }
}