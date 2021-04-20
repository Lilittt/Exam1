package service;

import model.Taxi;

import java.util.Scanner;

public class TaxiService {
    public Taxi create() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter model:");
        String model = s.next();

        System.out.println("Enter country:");
        String country = s.next();

        System.out.println("Enter year:");
        int year = s.nextInt();

        System.out.println("Enter millage: ");
        int millage = s.nextInt();

        System.out.println("Is sport?: y/n");
        boolean isSport = s.next().charAt(0) == 'y';

        System.out.println("Enter weight: ");
        int weight = s.nextInt();

        System.out.println("Enter top speed: ");
        int topSpeed = s.nextInt();

        System.out.println("Enter seats: ");
        int seats = s.nextInt();

        System.out.println("Enter cost: ");
        double cost = s.nextDouble();

        Taxi taxi = new Taxi(model, country, year, cost);
        taxi.setMillage(millage);
        taxi.setSeats(seats);
        taxi.setTopSpeed(topSpeed);
        taxi.setWeight(weight);
        taxi.setSport(isSport);

        return taxi;
    }

    public void printAllInfo(Taxi taxi) {
        System.out.println("Model: " + taxi.getModel());
        System.out.println("Country: " + taxi.getCountry());
        System.out.println("Year: " + taxi.getYear());
        System.out.println("Millage: " + taxi.getMillage());
        System.out.println("Is sport: " + (taxi.isSport() ? "Yes" : "No"));
        System.out.println("Weight: " + taxi.getWeight());
        System.out.println("Top speed: " + taxi.getTopSpeed());
        System.out.println("Seats: " + taxi.getSeats());
        System.out.println("Cost: " + taxi.getCost());
    }

    public void printDependingOnSport(Taxi taxi) {
        if (taxi.isSport()) {
            System.out.println(taxi.getCost() + " " + taxi.getTopSpeed());
        } else {
            System.out.println(taxi.getModel() + " " + taxi.getCountry());
        }
    }

    public Taxi newerTaxi(Taxi t1, Taxi t2) {
        return t1.getYear() < t2.getYear() ? t2 : t1;
    }

    public void countryOfSmallestSeats(Taxi t1, Taxi t2, Taxi t3) {
        Taxi smallest = t1.getSeats() <= t2.getSeats() ? t1 : t2;
        if (smallest.getSeats() > t3.getSeats()) {
            smallest = t3;
        }
        System.out.println(smallest.getCountry());
    }

    public void printNotSports(Taxi[] taxis) {
        for (Taxi t : taxis) {
            if (!t.isSport()) {
                printAllInfo(t);
            }
        }
    }

    public void printNotSportsMore50000(Taxi[] taxis) {
        for (Taxi t : taxis) {
            if (t.isSport() && t.getMillage() > 50000) {
                printAllInfo(t);
            }
        }
    }

    public Taxi minWeight(Taxi[] taxis) {
        Taxi t = taxis[0];
        for (Taxi taxi : taxis) {
            if (t.getWeight() >= taxi.getWeight()) {
                t = taxi;
            }
        }
        return t;
    }

    public Taxi minCostFromSport(Taxi[] taxis) {
        Taxi t = null;
        int j = 0;
        for (int i = 0; i < taxis.length; i++) {
            if (taxis[i].isSport()) {
                t = taxis[i];
                j = i;
                break;
            }
        }
        for (; j < taxis.length; j++) {
            if (t != null && t.getCost() > taxis[j].getCost() && taxis[j].isSport()) {
                t = taxis[j];
            }
        }
        return t;
    }

    public void printAscOrderedByYear(Taxi[] taxis) {
        Taxi temp = null;
        for (int i = 0; i < taxis.length; i++) {
            for (int j = 0; j < taxis.length - i - 1; j++) {
                if (taxis[i].getYear() > taxis[i + 1].getYear()) {
                    temp = taxis[i];
                    taxis[i] = taxis[i + 1];
                    taxis[i + 1] = temp;
                }
            }
        }

        for (Taxi taxi : taxis) {
            printAllInfo(taxi);
        }
    }
}
