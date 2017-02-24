package com.thecookiezen;

import com.thecookiezen.infrastructure.CommandHandler;
import com.thecookiezen.infrastructure.RequestFactory;
import com.thecookiezen.bussiness.control.Request;
import com.thecookiezen.infrastructure.printer.SystemOutPrinter;
import com.thecookiezen.infrastructure.store.InMemoryStorage;

import java.util.Scanner;

public class ApplicationRunner {

    public static void main(String[] args) {
        final RequestFactory requestFactory = new RequestFactory();
        final CommandHandler commandHandler = new CommandHandler(new InMemoryStorage(), new SystemOutPrinter());

        Scanner scanner = new Scanner(System.in);

        System.out.print("> ");
        while (scanner.hasNextLine()) {
            final Request request = requestFactory.createRequestFromString(scanner.nextLine());
            commandHandler.handle(request);
            System.out.print("> ");
        }
    }
}
