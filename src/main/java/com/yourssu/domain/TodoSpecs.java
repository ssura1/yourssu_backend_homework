package com.yourssu.domain;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;

public class TodoSpecs {

    public static Specification<Todos> containSpec(String keyword) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("content"), "%" + keyword + "%");
    }

    public static Specification<Todos> emailSpec(String email) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("email"), email);
    }
}
