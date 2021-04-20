package model;

public class Taxi {
    private String model;
    private String country;
    private int year;
    private int millage;
    private boolean sport;
    private int weight;
    private int topSpeed;
    private int seats;
    private double cost;

    public Taxi(String model, String country, int year, double cost) {
        if (model.length() != 0 && country.length() != 0 && year > 1903 && year < 2020 && cost >= 0) {
            this.model = model;
            this.year = year;
            this.cost = cost;
            this.country = country;
        }
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model.length() != 0)
            this.model = model;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        if (country.length() != 0)
            this.country = country;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year > 1903 && year < 2020)
            this.year = year;
    }

    public int getMillage() {
        return millage;
    }

    public void setMillage(int millage) {
        if (millage > 0 && millage < 999999)
            this.millage = millage;
    }

    public boolean isSport() {
        return sport;
    }

    public void setSport(boolean sport) {
        this.sport = sport;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if (weight > 1000 && weight < 3000)
            this.weight = weight;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        if (topSpeed >= 0)
            this.topSpeed = topSpeed;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        if (seats >= 0)
            this.seats = seats;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        if (cost >= 0)
            this.cost = cost;
    }
}
