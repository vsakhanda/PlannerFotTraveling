package com.planner.travel.constant;

public enum Queries {

    USER_INSERT ("INSERT INTO"),
    USER_UPDATE("UPDATE"),
    USER_DELETE("DELETE FROM"),
    USER_FIND_BY("SELECT id"),
    USER_FIND_ALL("SELECT id"),
    //****
    POINT_INSERT("INSERT INTO"),
    POINT_UPDATE("UPDATE"),
    POINT_DELETE("DELETE FROM"),
    POINT_FIND_BY("SELECT id"),
    POINT_FIND_ALL("SELECT id"),

    //****
    ROUTE_INSERT("INSERT INTO"),
    ROUTE_UPDATE("UPDATE"),
    ROUTE_INSERT_POINTS("INSERT INTO"),
    ROUTE_DELETE("DELETE FROM"),
    ROUTE_FIND_BY("SELECT id"),
    ROUTE_FIND_ALL("SELECT id"),

    //****
    TRIP_INSERT("INSERT INTO"),
    TRIP_UPDATE("UPDATE"),
    TRIP_INSERT_POINTS("INSERT INTO"),
    TRIP_ADD_COMPANEIROS("DELETE FROM"),
    TRIP_COMPANEIRO_UPDATE("DELETE FROM"), // Approve your participation
    TRIP_UPDATE_COMPANEIROS("UPDATE"),
    TRIP_DELETE("DELETE FROM"),
    TRIP_FIND_BY("SELECT id"),
    TRIP_FIND_ALL("SELECT id"),
//****

    FRIEND_INSERT("INSERT INTO"),
    FRIEND_UPDATE("UPDATE"), //Approving friends
    FRIEND_DELETE("DELETE FROM"),
    FRIEND_FIND_BY_USER("SELECT id"),

    //****
    SUBSCRIPTION_INSERT("INSERT INTO"),
    SUBSCRIPTION_DELETE("DELETE FROM"),
    SUBSCRIPTION_FIND_BY_USER("SELECT id"),

//****

    POINT_COMMENT_INSERT("INSERT INTO"),
    POINT_COMMENT_DELETE("DELETE FROM"),
    POINT_COMMENT_FIND_BY("SELECT id"),


    ROUTE_COMMENT_INSERT("INSERT INTO"),
    ROUTE_COMMENT_DELETE("DELETE FROM"),
    ROUTE_COMMENT_FIND_BY("SELECT id"),

    // Спочатку видимість подорожей не буде обмежена рольовою моделлю та видімістю.
    TRIP_COMMENT_INSERT("INSERT INTO"),
    TRIP_COMMENT_DELETE("DELETE FROM"),
    TRIP_COMMENT_FIND_BY("SELECT id");

//****

    private String name;

    Queries(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }



}
