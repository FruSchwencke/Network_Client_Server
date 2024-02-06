package dk.cphbusiness.demo01_singlerequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/*
 * Purpose of this demo is to show the most basic use of sockets with inspiration
 * from: https://www.baeldung.com/a-guide-to-java-sockets
 * The server only accepts one client and only one message from the client before
 * closing the connection
 * Author: Thomas Hartmann and Jon Bertelsen
 */
public class SimpleServer
{

    private static final int PORT = 9090;

    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public static void main(String[] args)
    {
        SimpleServer server = new SimpleServer();
        server.startConnection(PORT);
    }

    public void startConnection(int port)
    {
        try (ServerSocket serverSocket = new ServerSocket(port))
        {
            clientSocket = serverSocket.accept(); // blocking call
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String greeting = in.readLine();
            System.out.println(greeting);
            out.println(getGreetingWithTime());

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            stopConnection();
        }
    }

    public String getGreetingWithTime(){
        String greeting;
        String timeOfDay = "";
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        String timeformatted = String.format("%s:%s",time.getHour(),time.getMinute());
        if (time.isAfter(LocalTime.of(4,59)) && time.isBefore(LocalTime.of(8,59))) {
            timeOfDay = "Godmorgen, ";
        }
        else if(time.isAfter(LocalTime.of(9,00)) && time.isBefore(LocalTime.of(11,59))) {
            timeOfDay = "God formiddag, ";
        }
        else if(time.isAfter(LocalTime.of(12,00)) && time.isBefore(LocalTime.of(16,59))) {
            timeOfDay = "God eftermiddag, ";
        }
        else if (time.isAfter(LocalTime.of(17,00)) && time.isBefore(LocalTime.of(23,59))) {
            timeOfDay = "Godaften, ";
        }
        else if (time.isAfter(LocalTime.of(23,59)) && time.isBefore(LocalTime.of(04,59))) {
            timeOfDay = "Godnat, ";
        }

        greeting = String.format("%s I dag er det den %s og klokken er %s", timeOfDay, date, timeformatted);
        return greeting;
    }

    public void stopConnection()
    {
        try
        {
            System.out.println("Closing down socket ...");
            in.close();
            out.close();
            clientSocket.close();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
