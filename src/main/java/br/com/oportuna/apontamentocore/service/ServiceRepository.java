package br.com.oportuna.apontamentocore.service;

import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import org.springframework.data.repository.PagingAndSortingRepository;

interface ServiceRepository extends PagingAndSortingRepository<Service, String>, QuerydslPredicateExecutor<Service>,
    QuerydslBinderCustomizer<QService> {

  @Override
  default void customize(QuerydslBindings bindings, QService client) {

    // Make case-insensitive 'like' filter for all string properties
    bindings.bind(String.class).first((SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
  }

}