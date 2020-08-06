package br.com.oportuna.apontamentocore.timetrack;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * TimetrackRepository
 */
public interface TimetrackRepository extends PagingAndSortingRepository<Timetrack, String>,
    QuerydslPredicateExecutor<Timetrack>, QuerydslBinderCustomizer<QTimetrack> {
{


}