package com.gugawag.pdist.servlets;

import jakarta.ejb.EJB;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelos.CalculadoraIF;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/calculadora.do"})
public class CalculadoraServlet extends HttpServlet {

    @EJB(lookup="java:global/calculadoraejb-1.0-SNAPSHOT/calculadoraService")
    private CalculadoraIF calculadoraService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String operacao = request.getParameter("oper");
        PrintWriter resposta = response.getWriter();
        if (operacao.equals("somar")) {
            int num1 = Integer.parseInt(request.getParameter("n1"));
            int num2 = Integer.parseInt(request.getParameter("n2"));
            resposta.println(calculadoraService.somar(num1, num2));
        }
    }
}
