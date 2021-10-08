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
import java.io.IOException;

public class ProductController extends HttpServlet {
    public static final String PARAM_ID = "id";
    public static final String ATTRIBUTE_MODEL_TO_VIEW = "product";
    public static final String PAGE_OK = "product.jsp";
    public static final String PAGE_ERROR = "error.jsp";

    private ProductDao productDao = new ProductDaoMock();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter(PARAM_ID);

        if(idStr != null){
            try {
                Integer id = Integer.valueOf(idStr);
                Product model = productDao.selectById(id);
                request.setAttribute(ATTRIBUTE_MODEL_TO_VIEW, model);
                //OK
                request.getRequestDispatcher(PAGE_OK).forward(request,response);
                return;
            } catch (NumberFormatException | DaoSystemException | NoSuchEntityException e){

            }
        }

        //FAIL
        response.sendRedirect(PAGE_ERROR);
    }
}
