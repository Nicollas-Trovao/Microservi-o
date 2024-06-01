package com.ntrovao.vendas.online.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@Configuration
@EnableMongoRepositories(basePackages = "br.com.rpires.ProdutoServiceProfessor.repository")
public class MongoConfig {

}