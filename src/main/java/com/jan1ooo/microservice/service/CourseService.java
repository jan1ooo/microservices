package com.jan1ooo.microservice.service;

import com.jan1ooo.microservice.model.CourseModel;
import com.jan1ooo.microservice.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;


@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CourseService {
    private final CourseRepository repository;

    public Iterable<CourseModel> list(Pageable pageable){
        log.info("Listing all courses");
        return repository.findAll(pageable);
    }

}
