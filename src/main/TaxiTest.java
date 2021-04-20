package main;

import model.Taxi;
import service.TaxiService;

import java.util.Scanner;

public class TaxiTest {
    public static void main(String[] args) {
        TaxiService taxiService = new TaxiService();

        Taxi t1 = taxiService.create();
        Taxi t2 = taxiService.create();
        Taxi t3 = taxiService.create();

        Taxi[] taxis = {t1, t2, t3, t3};
        Scanner s = new Scanner(System.in);
        boolean isMenuActive = true;

        while (isMenuActive) {
            System.out.println("1. Print cost and topSpeed if the taxi is sport, otherwise print model and country");
            System.out.println("2. Return the Taxi which one is newer (if they have the same age return first one)");
            System.out.println("3. Print country of the Taxi with smallest seats count (if they have the same - print first)");
            System.out.println("4. Print all not sport Taxis");
            System.out.println("5. Print all sport Taxis which were road more than 50000 km (millage)");
            System.out.println("6. Return the Taxi with minimal weight (if there are some of them return last one)");
            System.out.println("7. Return the Taxi with minimal cost from all sport Taxis (if there are some of them return first one)");
            System.out.println("8. Print Taxi in ascending form order by year");

            int taskNumber = s.nextInt();

            switch (taskNumber) {
                case 1:
                    taxiService.printDependingOnSport(t1);
                    break;
                case 2:
                    taxiService.printAllInfo(taxiService.newerTaxi(t1, t2));
                    break;
                case 3:
                    taxiService.countryOfSmallestSeats(t1, t2, t3);
                    break;
                case 4:
                    taxiService.printNotSports(taxis);
                    break;
                case 5:
                    taxiService.printNotSportsMore50000(taxis);
                    break;
                case 6:
                    taxiService.printAllInfo(taxiService.minWeight(taxis));
                    break;
                case 7:
                    taxiService.printAllInfo(taxiService.minCostFromSport(taxis));
                    break;
                case 8:
                    taxiService.printAscOrderedByYear(taxis);
                    break;
                case 9:
                    isMenuActive = false;
                    break;
                default:
                    System.out.println("Invalid task number!");
            }
        }
    }
}
