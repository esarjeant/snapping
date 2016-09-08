package com.micromux.snapping;

import org.apache.commons.cli.*;

/**
 * Console application for SnapPing system monitor. This application allows a user
 * to monitor one or more hosts for either ICMP or a specific port number and TCPv4
 * protocol.
 */
public class Client {

    public static void main(String[] args) throws Exception {
        System.out.println("SnapPing 1.0");

        Options options = createSnapPingOptions();

        try {
            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = parser.parse(options, args);

            if (cmd.hasOption('s')) {
                //ApplicationServerUndertow.start(8080);
                new ApplicationServer().run(args);
//                Undertow server = Undertow.builder().addHttpListener(8080, "localhost")
//                        .setHandler(new HttpHandler() {
//
//                            public void handleRequest(final HttpServerExchange exchange)
//                                    throws Exception {
//                                exchange.getResponseHeaders().put(Headers.CONTENT_TYPE,
//                                        "text/plain");
//                                exchange.getResponseSender().send("Hello World");
//                            }
//                        }).build();
//                server.start();
            } else if (cmd.hasOption('k')) {
                System.out.println("Stopping the server...");
            } else if (cmd.hasOption('l')) {
                System.out.println("LIST");
            } else if (cmd.hasOption('c')) {
                System.out.println("CREATE:" + cmd.getOptionValue('c'));
            } else if (cmd.hasOption('d')) {
                System.out.println("DELETE");
            } else {
                throw new ParseException("Option specified not supported");
            }

        } catch (ParseException px) {
            // show options help
            HelpFormatter formatter = new HelpFormatter();
            String header = "Application to monitor the health of one or more systems. This can use ICMP to " +
                    "confirm the host is up or TCP/UDP and a port number to confirm a specified application is " +
                    "listending on that host.";

            formatter.printHelp("snapping", header, options, null);
        }

    }

    private static Options createSnapPingOptions() {

        Options options = new Options();

        Option start = new Option("s", "start", false, "Start the server.");
        Option stop = new Option("k", "stop", false, "Stop the server.");
        Option list = new Option("l", "list", false, "List the names being monitored.");
        Option create = new Option("c", "create", true, "Create a new monitor with the specified name.");
        Option delete = new Option("d", "delete", true, "Remove the monitor by name.");

        options.addOption(start);
        options.addOption(stop);
        options.addOption(list);
        options.addOption(create);
        options.addOption(delete);

        return options;

    }
}
