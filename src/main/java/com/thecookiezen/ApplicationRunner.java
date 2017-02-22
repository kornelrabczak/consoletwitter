package com.thecookiezen;

import com.thecookiezen.bussiness.boundary.CommandHandler;
import com.thecookiezen.bussiness.boundary.RequestFactory;
import com.thecookiezen.bussiness.control.Request;
import com.thecookiezen.infrastructure.printer.SystemOutPrinter;
import com.thecookiezen.infrastructure.store.InMemoryTweets;

import java.util.Scanner;

public class ApplicationRunner {

    public static void main(String[] args) {

        final RequestFactory requestFactory = new RequestFactory();
        final CommandHandler commandHandler = new CommandHandler(new InMemoryTweets(), new SystemOutPrinter());

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            final Request request = requestFactory.createRequestFromString(scanner.nextLine());
            commandHandler.handle(request);
        }
    }
}
