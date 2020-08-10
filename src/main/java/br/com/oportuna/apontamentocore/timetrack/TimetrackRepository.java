package br.com.oportuna.apontamentocore.timetrack;

import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * TimetrackRepository
 */
public interface TimetrackRepository extends PagingAndSortingRepository<Timetrack, String>,
    QuerydslPredicateExecutor<Timetrack>, QuerydslBinderCustomizer<QTimetrack> {

  @Override
  default void customize(QuerydslBindings bindings, QTimetrack timetrack) {

    // Make case-insensitive 'like' filter for all string properties
    bindings.bind(String.class).first((SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
  }
}