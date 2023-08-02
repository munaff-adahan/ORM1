package com.jiat.orm.servlet;

import com.jiat.orm.entity.Admin;
import com.jiat.orm.entity.User;
import com.jiat.orm.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Test", urlPatterns = "/test")
public class Test extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();

            User user = new User();
            user.setFirstName("ABC");
            user.setLastName("Lakshan");
            user.setEmail("achintha@javainstitute.edu.lk");
            user.setContact("0764160872");
            user.setAddress("Colombo");

            em.persist(user);

            Admin admin = new Admin();
            admin.setEmail("admin@admin.com");

            em.persist(admin);

            User user1 = new User();
            user1.setFirstName("Achintha");
            user1.setLastName("Lakshan");
            user1.setEmail("achintha@javainstitute.edu.lk");
            user1.setContact("0764160872");
            user1.setAddress("Colombo");

            em.persist(user1);

            tr.commit();
        } catch (Exception ex) {
            tr.rollback();
        }

    }
}
