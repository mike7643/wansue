package com.wansue.wansue.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Lazy;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Task extends DateEntity{

    @Id
    @GeneratedValue
    @Column(name = "task_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private String title;

    private String subtitle;

    private String description;

    private LocalDateTime deadline;

    private boolean isRequired;

    private Integer priority;

    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;

    @Embedded
    private Period period;
}