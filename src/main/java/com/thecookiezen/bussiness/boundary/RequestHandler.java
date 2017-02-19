package com.thecookiezen.bussiness.boundary;

import com.thecookiezen.bussiness.control.Request;

public interface RequestHandler {
    void execute(Request request);
}
