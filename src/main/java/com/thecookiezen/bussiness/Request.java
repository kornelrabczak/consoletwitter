package com.thecookiezen.bussiness;

import java.util.Optional;

public interface Request {

    String getUserName();

    String getCommand();

    Optional<String> getCommandParameter();
}
