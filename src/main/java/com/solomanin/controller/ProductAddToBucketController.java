package com.solomanin.controller;

import com.solomanin.dao.ProductDao;
import com.solomanin.dao.exception.DaoSystemException;
import com.solomanin.dao.exception.NoSuchEntityException;
import com.solomanin.dao.impl.ProductDaoMock;
import com.solomanin.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.solomanin.controller.SessionAttributes.PRODUCTS_IN_BUCKET;
import static java.util.Collections.singletonMap;
import static java.util.Collections.unmodifiableMap;

public class ProductAddToBucketController extends HttpServlet {
    public static final String PARAM_ID = "id";
    public static final String PAGE_ERROR = "productAll.do";

    private ProductDao productDao = new ProductDaoMock();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter(PARAM_ID);

        if(idStr!=null){
            try {
                Integer id = Integer.valueOf(idStr);
                Product product = productDao.selectById(id);

                HttpSession session = req.getSession(true);
                Map<Product, Integer> oldBucket = (Map<Product, Integer>) session.getAttribute(PRODUCTS_IN_BUCKET);
                if(oldBucket == null){
                    session.setAttribute(PRODUCTS_IN_BUCKET, singletonMap(product, 1));
                } else {
                    Map<Product, Integer> newBucket = new LinkedHashMap<>(oldBucket);
                    if(!newBucket.containsKey(product)){
                        newBucket.put(product, 1);
                    } else {
                        newBucket.put(product, newBucket.get(product)+1);
                    }
                    session.setAttribute(PRODUCTS_IN_BUCKET, unmodifiableMap(newBucket));
                }
                String newLocation = "product.do?id="+id;
                resp.sendRedirect(newLocation);
                return;
            } catch (NoSuchEntityException | DaoSystemException | NumberFormatException e) {
                /*NOP*/
            }

        }
        resp.sendRedirect(PAGE_ERROR);
    }
}
