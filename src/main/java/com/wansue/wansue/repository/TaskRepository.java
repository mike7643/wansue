package com.wansue.wansue.repository;

import com.wansue.wansue.domain.Task;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TaskRepository {

    private EntityManager em;

    public void save(Task task) {
        em.persist(task);
    }

    public Task findOne(Long id) {
        return em.find(Task.class, id);
    }

    //우선순위 오름차순으로 나열하여 task 가져오기
}
