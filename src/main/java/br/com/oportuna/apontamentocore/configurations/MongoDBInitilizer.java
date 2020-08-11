package br.com.oportuna.apontamentocore.configurations;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.util.ResourceUtils;

import br.com.oportuna.apontamentocore.customer.Customer;
import br.com.oportuna.apontamentocore.projects.Project;
import br.com.oportuna.apontamentocore.service.Service;
import br.com.oportuna.apontamentocore.user.User;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
class MongoDBInitilizer {

  @Autowired
  MongoTemplate template;

  @Autowired
  ObjectMapper mapper;

  TypeReference<List<HashMap<String, Object>>> typeRef = new TypeReference<List<HashMap<String, Object>>>() {
  };

  @PostConstruct
  void populate() throws IOException {
    log.debug("deleting collections ...... ");
    template.dropCollection(Customer.class);
    template.dropCollection(Project.class);
    template.dropCollection(Service.class);
    template.dropCollection(User.class);

    insertClients();
    insertProjects();
    insertServices();
    insertUsers();

  }

  private void insertClients() throws IOException {
    log.info("inserting customers ...... ");
    List<HashMap<String, Object>> clientMapper = mapper.readValue(ResourceUtils.getFile("classpath:data/clientes.json"),
        typeRef);
    template.insert(clientMapper, "clients");
  }

  private void insertProjects() throws IOException {
    log.info("inserting projects ...... ");
    List<HashMap<String, Object>> clientProjects = mapper
        .readValue(ResourceUtils.getFile("classpath:data/projetos.json"), typeRef);

    template.insert(clientProjects, "clients");
  }

  private void insertServices() throws IOException {
    log.info("inserting services ...... ");
    List<HashMap<String, Object>> servicesMapper = mapper
        .readValue(ResourceUtils.getFile("classpath:data/servicos.json"), typeRef);
    template.insert(servicesMapper, "services");
  }

  private void insertUsers() throws IOException {
    log.info("inserting users ...... ");
    List<HashMap<String, Object>> userMapper = mapper.readValue(ResourceUtils.getFile("classpath:data/users.json"),
        typeRef);
    template.insert(userMapper, "users");
  }

}