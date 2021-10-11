package com.solomanin.controller;

import com.solomanin.dao.ProductDao;
import com.solomanin.dao.exception.DaoSystemException;
import com.solomanin.dao.impl.ProductDaoMock;
import com.solomanin.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProductAllController extends HttpServlet {
    public static final String ATTRIBUTE_MODEL_TO_VIEW = "productList";
    public static final String PAGE_OK = "allProduct.jsp";
    public static final String PAGE_ERROR = "error.jsp";
    private ProductDao productDao = new ProductDaoMock();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Product> model = productDao.selectAll();
            req.setAttribute(ATTRIBUTE_MODEL_TO_VIEW, model);

            req.getRequestDispatcher(PAGE_OK).forward(req, resp);
        }  catch (DaoSystemException ignore) {
            /*NOP*/
        }
        resp.sendRedirect(PAGE_ERROR);
    }
}
