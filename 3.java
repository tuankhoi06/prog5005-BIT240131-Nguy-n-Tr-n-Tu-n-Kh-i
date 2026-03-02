package Chuong5;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Bai3_SaveProduct {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        try {
            session.beginTransaction();

            Product p = new Product("Laptop", 1500);
            session.persist(p);

            session.getTransaction().commit();
            System.out.println("Đã lưu sản phẩm!");

        } finally {
            session.close();
            factory.close();
        }
    }
}
