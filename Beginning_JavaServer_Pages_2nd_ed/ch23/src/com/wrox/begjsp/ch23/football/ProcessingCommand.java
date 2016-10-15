package com.wrox.begjsp.ch23.football;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ProcessingCommand
{
    void execute(HttpServletRequest request, HttpServletResponse response, String action)
            throws ServletException, IOException;
}