package controller;

import entities.Automovel;
import entities.Marca;
import entities.Modelo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Program {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("atividade7");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Marca marca = new Marca();
            marca.setNome("Kia");
            System.out.println("Marca: " + marca.getNome());

            Modelo modelo = new Modelo();
            modelo.setDescricao("Soul");
            modelo.setPotencia(100);
            modelo.setMarca(marca);
            System.out.println("Modelo: " + modelo.getDescricao());

            Automovel automovel = new Automovel();
            automovel.setAnoFabricacao(2010);
            automovel.setAnoModelo(2010);
            automovel.setObservacao("Branco");
            automovel.setPreco(100000.0f);
            automovel.setKilometragem(0000);
            automovel.setModelo(modelo);
            System.out.println("Ano de Fabricação: " + automovel.getAnoFabricacao());
            System.out.println("Ano do Modelo: " + automovel.getAnoModelo());
            System.out.println("Observação: " + automovel.getObservacao());
            System.out.println("Preço: " + automovel.getPreco());
            System.out.println("Quilometragem: " + automovel.getKilometragem());

            em.persist(marca);
            em.persist(modelo);
            em.persist(automovel);

            em.getTransaction().commit();
            System.out.println("Dados salvos no banco de dados com sucesso!");
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
