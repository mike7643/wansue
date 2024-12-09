package com.wansue.wansue.domain;

import jakarta.persistence.Embeddable;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Embeddable
public class Period {

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private LocalDateTime deletedDate;
}
