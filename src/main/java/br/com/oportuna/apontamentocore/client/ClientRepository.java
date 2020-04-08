package br.com.oportuna.apontamentocore.client;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface ClientRepository extends PagingAndSortingRepository<Client, Integer> {

}