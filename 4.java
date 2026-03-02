package Chuong5;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class Bai4_FindExpensiveProduct {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        try {
            session.beginTransaction();

            String hql = "FROM Product WHERE price > :minPrice";

            List<Product> list = session
                    .createQuery(hql, Product.class)
                    .setParameter("minPrice", 1000.0)
                    .getResultList();

            for (Product p : list) {
                System.out.println(p.getName() + " - " + p.getPrice());
            }

            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }
    }
}