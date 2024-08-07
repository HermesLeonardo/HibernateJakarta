package com.example.exerciciojakarta;


import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.produto;

public class AplicaçãoPrincipal {

    public static void main(String[] args) {

        System.out.println("Iniciando APP");

        produto pro = new produto();
        pro.setNomeprod("consolo");
        pro.setValor(150.0);

        EntityManagerFactory entityManFac = Persistence.createEntityManagerFactory("default");

        EntityManager entityManager = entityManFac.createEntityManager();

        // iniciando a transação com o banco de dados
          entityManager.getTransaction().begin();

        //persistindo (gravando) o objeto cli no banco de dados
          //entityManager.persist(pro);

        //fazendo um busca pela chave primaria
         produto probus = entityManager.find(produto.class, 3);
         System.out.println("Produto encontrado: " + probus.getNomeprod() + probus.getValor());

        // alterando os daos do clibusca (clienre de id 3) mudando o nome do produto
          probus.setNomeprod("fone de ouvido");

        //escluir o registo (no caso o cliente de id 1)
        // entityManager.remove((probus));

        //"comitando" (efetivando) a atualização no banco de dados
        entityManager.getTransaction().commit();

        //finalizando a comunicação com o DB
        entityManager.close();
        entityManFac.close();




    }

}
