package com.jan1ooo.microservice.repository;

import com.jan1ooo.microservice.model.CourseModel;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CourseRepository extends PagingAndSortingRepository<CourseModel, Long> {
}
