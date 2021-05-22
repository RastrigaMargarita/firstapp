package ru.geekbrains.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.ArrayList;


public class BasicServlet implements Servlet {

    private static final Logger logger = LoggerFactory.getLogger(BasicServlet.class);


    private transient ServletConfig config;

    // Метод вызывается контейнером после того как был создан класс сервлета
    @Override
   public void init(ServletConfig config) throws ServletException {
        // Сохраняем полученную от сервера конфигурацию
        this.config = config;
    }


    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    // Метод вызывается для каждого нового HTTP запроса к данному сервлету
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        logger.info("New request");
        for (int i = 0; i < 10; i++) {

            res.getWriter().println("<h1>"+new Product(i, (int) (Math.random() * 10), "product" + i)
                    +"</h1>");
        }

    }

    @Override
    public String getServletInfo() {
        return "BasicServlet";
    }

    // При завершении работы веб приложения, контейнер вызывает этот метод для всех сервлетов из этого приложения
    @Override
    public void destroy() {
        logger.info("Servlet {} destroyed", getServletInfo());
    }
}

