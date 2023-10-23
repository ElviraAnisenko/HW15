package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static java.util.Arrays.sort;

public class AviaSoulsTest {
    Ticket ticket1 = new Ticket("Saint Petersburg", "Samara", 3000, 8, 11);
    Ticket ticket2 = new Ticket("Moscow", "Samara", 2500, 10, 12);
    Ticket ticket3 = new Ticket("Moscow", "Novosibirsk", 4000, 9, 13);
    Ticket ticket4 = new Ticket("Moscow", "Novosibirsk", 4000, 13, 15);


    @Test
    public void shouldSortTicketByPrice() {
        Ticket[] tickets = {ticket1, ticket2, ticket3, ticket4};
        Ticket[] expended = {ticket2, ticket1, ticket3, ticket4};
        Arrays.sort(tickets);
        Assertions.assertArrayEquals(expended, tickets);
    }

    @Test
    public void shouldSearchByLocationAndSortTicketByPrice() {
        AviaSouls souls = new AviaSouls();
        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        Ticket[] expended = {ticket2};
        Ticket[] actual = souls.search("Moscow", "Samara");
        Assertions.assertArrayEquals(expended, actual);
    }

    @Test
    public void shouldSearchByLocationAndSortTicketByPriceIfNoVariant() {
        AviaSouls souls = new AviaSouls();
        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        Ticket[] expended = {};
        Ticket[] actual = souls.search("Moscow", "Sochi");
        Assertions.assertArrayEquals(expended, actual);
    }

    @Test
    public void shouldSearchByLocationAndSortTicketByPriceIfSeveralVariant() {
        AviaSouls souls = new AviaSouls();
        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        Ticket[] expended = {ticket3, ticket4};
        Ticket[] actual = souls.search("Moscow", "Novosibirsk");
        Assertions.assertArrayEquals(expended, actual);
    }

    @Test
    public void shouldSortTicketByFlightTime() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        Ticket[] tickets = {ticket1, ticket2, ticket3, ticket4};
        Ticket[] expended = {ticket2, ticket1, ticket3, ticket4};
        Arrays.sort(tickets);
        Assertions.assertArrayEquals(expended, tickets);
    }

    @Test
    public void shouldSearchByLocationAndSortTicketByFlightTime() {
        AviaSouls souls = new AviaSouls();
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        Ticket[] expended = {ticket3};
        Ticket[] actual = souls.searchAndSortBy("Moscow", "Novosibirsk", timeComparator);
        Assertions.assertArrayEquals(expended, actual);
    }

    @Test
    public void shouldSearchByLocationAndSortTicketByFlightTimeIfNoVariant() {
        AviaSouls souls = new AviaSouls();
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        Ticket[] expended = {};
        Ticket[] actual = souls.searchAndSortBy("Moscow", "Sochi", timeComparator);
        Assertions.assertArrayEquals(expended, actual);
    }

    @Test
    public void shouldSearchByLocationAndSortTicketByFlightTimeIfSeveralVariant() {
        AviaSouls souls = new AviaSouls();
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket4);
        souls.add(ticket3);
        Ticket[] expended = {ticket4, ticket3};
        Ticket[] actual = souls.searchAndSortBy("Moscow", "Novosibirsk", timeComparator);
        Assertions.assertArrayEquals(expended, actual);
    }

}
