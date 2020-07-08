package br.com.oportuna.apontamentocore.projects;

import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> , QuerydslPredicateExecutor<Project>,
    QuerydslBinderCustomizer<QProject> {

  @Override
  default void customize(QuerydslBindings bindings, QProject client) {

    // Make case-insensitive 'like' filter for all string properties
    bindings.bind(String.class).first((SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
  }

}