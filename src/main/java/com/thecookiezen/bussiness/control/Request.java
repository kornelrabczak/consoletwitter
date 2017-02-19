package com.thecookiezen.bussiness.control;

import java.util.Optional;

public interface Request {

    String getUserName();

    String getCommand();

    Optional<String> getCommandParameter();
}
