package com.yourssu.domain;

import org.springframework.data.jpa.domain.Specification;

public class TodoSpecs {

    public static Specification<Todos> containSpec(String keyword) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("content"), "%" + keyword + "%");
    }
}
